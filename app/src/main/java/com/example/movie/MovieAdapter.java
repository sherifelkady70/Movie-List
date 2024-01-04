package com.example.movie;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.movie.databinding.RvItemBinding;

import java.util.ArrayList;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {

    SetOnMovieClickListener movieClickListener;
    ArrayList<Result> movieList;
    public void setList(ArrayList<Result> movielist ){
        this.movieList= movielist;
        notifyDataSetChanged();
    }



    static class ViewHolder extends RecyclerView.ViewHolder  {
        private final RvItemBinding rvItemBinding;
        public ViewHolder(RvItemBinding rvItemBinding) {
            super(rvItemBinding.getRoot());
            this.rvItemBinding=rvItemBinding;
        }
        public RvItemBinding getRvItemBinding(){
            return rvItemBinding;
        }
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(RvItemBinding.inflate(LayoutInflater.from(parent.getContext())));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Result result = movieList.get(position);
        Glide.with(holder.itemView)
                .load("https://image.tmdb.org/t/p/w500"+ result.getPoster_path())
                .into(holder.rvItemBinding.imageItem);
                holder.rvItemBinding.textItem.setText(result.getOriginal_title());

                holder.rvItemBinding.imageItem.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        movieClickListener.setOnClickListener(result,position);
                    }
                });
    }

    @Override
    public int getItemCount() {
        if(movieList!=null) {
            return movieList.size();
        }
        else {
            return 0;
        }
    }


    //to be listenterable
    public interface SetOnMovieClickListener {
        void setOnClickListener(Result result,int position);
    }

}
