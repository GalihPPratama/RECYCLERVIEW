package com.example.placeholder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class FilmAdapter extends RecyclerView.Adapter<FilmAdapter.ViewHolder> {

    private List<FilmModel> filmList;
    private OnItemClickListener onItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(FilmModel film);
    }

    public FilmAdapter(List<FilmModel> filmList, OnItemClickListener listener) {
        this.filmList = filmList;
        this.onItemClickListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_film, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        FilmModel film = filmList.get(position);
        holder.textViewFilmTitle.setText(film.getTitle());
        holder.textViewGenre.setText(film.getGenre());

        holder.itemView.setOnClickListener(v -> onItemClickListener.onItemClick(film));
    }

    @Override
    public int getItemCount() {
        return filmList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewFilmTitle, textViewGenre;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewFilmTitle = itemView.findViewById(R.id.textViewFilmTitle);
            textViewGenre = itemView.findViewById(R.id.textViewGenre);
        }
    }
}