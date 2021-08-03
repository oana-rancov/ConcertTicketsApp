package com.example.concerttickets.ui.share;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.concerttickets.R;
import com.example.concerttickets.databinding.FragmentHomeBinding;
import com.example.concerttickets.databinding.FragmentShareBinding;
import com.example.concerttickets.ui.home.HomeViewModel;

public class ShareFragment extends Fragment {
    private ShareViewModel shareViewModel;
    private FragmentShareBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        shareViewModel =
                new ViewModelProvider(this).get(ShareViewModel.class);

        binding = FragmentShareBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textShare;
        shareViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        Button buttonShare = (Button)root.findViewById(R.id.btShare);
        buttonShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                String shareBody = "Your body here";
                String shareSub = "Your subject here";
                intent.putExtra(Intent.EXTRA_SUBJECT, shareSub);
                intent.putExtra(Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(intent, "Share using"));
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