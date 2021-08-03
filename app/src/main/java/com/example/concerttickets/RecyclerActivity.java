package com.example.concerttickets;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

public class RecyclerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

//        //define data source for recyclerview
//        DataSource dataSource = new DataSource();
//        List<DataSource.Concerts> concertsList = dataSource.getConcerts();
//
//        RecyclerView concertListRecycler = findViewById(R.id.rvConcertList);
//
//        //definelayoutManager for recycler
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
//        concertListRecycler.setLayoutManager(linearLayoutManager);
//
//        //now the last step: create the Adapter
//        //define photo list
//        ConcertsAdapter concertsAdapter = new ConcertsAdapter(concertsList);
//        concertListRecycler.setAdapter(concertsAdapter);
    }
}