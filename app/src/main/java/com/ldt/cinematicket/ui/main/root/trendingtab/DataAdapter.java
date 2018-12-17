package com.ldt.cinematicket.ui.main.root.trendingtab;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ldt.cinematicket.R;
import com.ldt.cinematicket.data.DataFilm;
import com.ldt.cinematicket.ui.main.MainActivity;
import com.ldt.cinematicket.ui.main.book.MovieDetail;

import java.util.ArrayList;
import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.RecyclerViewHolder> {
    private List<DataFilm> data = new ArrayList<>();
    Context context;

    public DataAdapter(List<DataFilm> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_movie_nowshowing_tab, parent, false);

        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        holder.image.setImageResource(data.get(position).getImage());
        holder.txtName.setText(data.get(position).getName());
        holder.txtRating.setText(data.get(position).getRating().toString());
        holder.txtDimenType.setText(data.get(position).getDimenType());
        holder.txtShowingType.setText(data.get(position).getShowingType());
        holder.txtDirector.setText(data.get(position).getDirector());
        holder.txtActors.setText(data.get(position).getActors());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView txtName;
        TextView txtRating;
        TextView txtDimenType;
        TextView txtShowingType;
        TextView txtDirector;
        TextView txtActors;
        ImageView image;
        View panel;

        public RecyclerViewHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.img);
            txtName = (TextView) itemView.findViewById(R.id.txt_name);
            txtRating = (TextView) itemView.findViewById(R.id.txt_rating);
            txtDimenType = (TextView) itemView.findViewById(R.id.txt_dimenType);
            txtShowingType = (TextView) itemView.findViewById(R.id.txt_showingType);
            txtDirector = (TextView) itemView.findViewById(R.id.txt_director);
            txtActors = (TextView) itemView.findViewById(R.id.txt_actors);
            panel = itemView.findViewById(R.id.panel);
            panel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ((MainActivity)context).presentFragment(MovieDetail.newInstance(data.get(getAdapterPosition())));
                }
            });
        }
    }
}
