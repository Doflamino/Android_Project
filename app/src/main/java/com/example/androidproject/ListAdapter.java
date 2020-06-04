package com.example.androidproject;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import static androidx.core.content.ContextCompat.startActivity;


public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    private ArrayList<Player> playerList;
    private  int color;
    Intent details;
    private TextView textView;
    public static Player p;


      public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        private TextView name;
        private TextView height;
        private TextView team;
        private TextView position;
        private ImageView image;

        public ViewHolder(View v) {
            super(v);
            name = v.findViewById(R.id.name);
            height = v.findViewById(R.id.height);
            team = v.findViewById(R.id.team);
            position = v.findViewById(R.id.position);
            image = v.findViewById(R.id.image1);
        }
    }





    // Provide a suitable constructor (depends on the kind of dataset)
    public ListAdapter(List<Player> myDataset) {
        playerList = (ArrayList<Player>) myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {
        // create a new view
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.row_layout, parent, false);
        // set the view's size, margins, paddings and layout parameters

        details = new Intent(parent.getContext(),PlayerDetails.class);
        color++;
        switch (color % 6) {
            case 1:
                v.findViewById(R.id.layoutCard).setBackground(v.getResources().getDrawable(R.drawable.refs2));
                break;
            case 2:
                v.findViewById(R.id.layoutCard).setBackground(v.getResources().getDrawable(R.drawable.refs));
                break;
            case 3:
                v.findViewById(R.id.layoutCard).setBackground(v.getResources().getDrawable(R.drawable.refs4));
                break;
            case 4:
                v.findViewById(R.id.layoutCard).setBackground(v.getResources().getDrawable(R.drawable.refs3));
                break;
            case 5:
                v.findViewById(R.id.layoutCard).setBackground(v.getResources().getDrawable(R.drawable.refs5));

                break;
        }

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        Player currentPlayer = playerList.get(position);
        holder.name.setText("Name: "+currentPlayer.getName());
        holder.height.setText("height: "+currentPlayer.getHeight());
        holder.team.setText("Plays at "+currentPlayer.getTeam());
        holder.position.setText("he is a "+currentPlayer.getPosition());
        Picasso.with(MainActivity.CONTEXT).load(currentPlayer.getImage()).resize(481, 454).into(holder.image);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.CONTEXT,PlayerDetails.class);
                p = MainActivity.playerDetailsList.get(position);

                startActivity(MainActivity.CONTEXT,details,null);
            }
        });


    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return playerList.size();
    }

}
