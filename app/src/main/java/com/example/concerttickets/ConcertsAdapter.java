package com.example.concerttickets;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ConcertsAdapter extends RecyclerView.Adapter<ConcertsAdapter.ConcertsViewHolder>{
    private static final String TAG = DataSource.Concerts.class.getSimpleName();
    private List<DataSource.Concerts> concertsList;

    //constructor
    ConcertsAdapter(List<DataSource.Concerts> concertsList){
        this.concertsList = concertsList;
    }


    @NonNull
    @Override
    public ConcertsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //layoutInflater ne ajuta sa ne definim view-ul
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View recyclerView = layoutInflater.inflate(R.layout.item_concert, parent, false );

        return new ConcertsViewHolder(recyclerView);
    }

    @Override
    public void onBindViewHolder(@NonNull ConcertsAdapter.ConcertsViewHolder holder, int position) {
        // seteaza informatia pe view
        // seteaza datele pe item-ul respectiv, functioneaza ca un for
        // adica pt fieacre item din lista se apeleaza si se seteaza datele
//        String photo = photoList.get(position);
//        String photoNr = String.valueOf(position);
//        holder.photo.setText(photo);
//        holder.photoNr.setText(photoNr);

        String artistName = concertsList.get(position).getArtistName();
        String location = concertsList.get(position).getLocation();
        String date = concertsList.get(position).getDate();
        String time = concertsList.get(position).getTime();
        holder.artistName.setText(artistName);
        holder.location.setText(location);
        holder.date.setText(date);
        holder.time.setText(time);


        if(position == 1) {
            holder.image.setImageResource(R.drawable.ic_launcher_foreground);
        }else{
            holder.image.setVisibility(View.GONE);
        }

        /*
        holder.photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Log.d(TAG, "POSITION CLICK: text= " + photo + " position " + position);
                Log.d(TAG, "POSITION CLICK: text= " + name + " position " + position);
            }
        }); */
    }

    @Override
    public int getItemCount() {
        //returneaza count-ul listei in cazul nostru 6 elemente
        //daca vrem de ex la elem 10 sa adaugam altceva
        //return photoList.size();
        return concertsList.size(); //must return the list that we use
    }
    //ViewHolder -> tine datele despre un item din lista


    static class ConcertsViewHolder extends RecyclerView.ViewHolder{
        //define info from our item
        ImageView image;
        TextView artistName;
        TextView location;
        TextView date;
        TextView time;

        public ConcertsViewHolder(View itemView){
            super(itemView);
            image = itemView.findViewById(R.id.image);
            artistName = itemView.findViewById(R.id.tvArtistName);
            location = itemView.findViewById(R.id.tvLocation);
            date = itemView.findViewById(R.id.tvDate);
            time = itemView.findViewById(R.id.tvTime);
        }
    }

}
