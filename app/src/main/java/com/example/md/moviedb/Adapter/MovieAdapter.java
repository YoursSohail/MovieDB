package com.example.md.moviedb.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.md.moviedb.Model.Result;
import com.example.md.moviedb.R;

import java.util.List;

/**
 * Created by MD on 15-05-2018.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {

    List<Result> resultList;
    Context context;

    public MovieAdapter(List<Result> resultList, Context context) {
        this.resultList = resultList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_item,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Result result = resultList.get(position);

        holder.tvTitle.setText(result.getTitle());
        holder.tvContent.setText(result.getOverview());
        holder.tvRelease.setText(result.getReleaseDate());

    }

    @Override
    public int getItemCount() {
        return resultList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvTitle,tvContent,tvRelease;

        public ViewHolder(View itemView) {
            super(itemView);

            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvContent = itemView.findViewById(R.id.tvContent);
            tvRelease = itemView.findViewById(R.id.tvRelease);
        }
    }
}
