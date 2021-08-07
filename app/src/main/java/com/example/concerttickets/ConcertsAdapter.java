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

    //for clicking on cardview
    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClcikListener(OnItemClickListener listener) {
        mListener = listener;
    } //clicking cardview



    //constructor
    public ConcertsAdapter(List<DataSource.Concerts> concertsList){ this.concertsList = concertsList; }


    @NonNull
    @Override
    public ConcertsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //layoutInflater ne ajuta sa ne definim view-ul
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View recyclerView = layoutInflater.inflate(R.layout.item_concert, parent, false );

        return new ConcertsViewHolder(recyclerView, mListener); //mListener for clicking cardview
    }

    @Override
    public void onBindViewHolder(@NonNull ConcertsAdapter.ConcertsViewHolder holder, int position) {

        int image = concertsList.get(position).getImage();
        String artistName = concertsList.get(position).getArtistName();
        String location = concertsList.get(position).getLocation();
        String date = concertsList.get(position).getDate();
        String time = concertsList.get(position).getTime();
        holder.image.setImageResource(image);
        holder.artistName.setText(artistName);
        holder.location.setText(location);
        holder.date.setText(date);
        holder.time.setText(time);


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

        public ConcertsViewHolder(View itemView, final OnItemClickListener listener){
            super(itemView);
            image = itemView.findViewById(R.id.image);
            artistName = itemView.findViewById(R.id.tvArtistName);
            location = itemView.findViewById(R.id.tvLocation);
            date = itemView.findViewById(R.id.tvDate);
            time = itemView.findViewById(R.id.tvTime);

            //for clicking cardview, and so is listener(parameter)
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            listener.onItemClick(position);
                        }
                    }
                }
            });

        }
    }

}
