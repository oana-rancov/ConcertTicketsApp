package com.example.concerttickets.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.concerttickets.ConcertsAdapter;
import com.example.concerttickets.DataSource;
import com.example.concerttickets.R;
import com.example.concerttickets.databinding.FragmentHomeBinding;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class HomeFragment extends Fragment {
    private final static String TAG = HomeFragment.class.getSimpleName();

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textHome;
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        //define data source for recyclerview
        DataSource dataSource = new DataSource();
        List<DataSource.Concerts> concertsList = dataSource.getConcerts();

        RecyclerView concertListRecycler = (RecyclerView) root.findViewById(R.id.rvConcertList);

        //definelayoutManager for recycler
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        concertListRecycler.setLayoutManager(linearLayoutManager);

        //now the last step: create the Adapter
        //define photo list
        ConcertsAdapter concertsAdapter = new ConcertsAdapter(concertsList);
        concertListRecycler.setAdapter(concertsAdapter);

        //clciking on cardview
        concertsAdapter.setOnItemClcikListener(new ConcertsAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Log.d(TAG, "CLICKED !!!");
            }
        });

        
        return root;

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}