package com.eatanapple.musicplayerapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;

import com.eatanapple.musicplayerapp.dto.Song;
import com.squareup.picasso.Picasso;

import java.util.List;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.SongViewHolder> {


    public List<Song> songs;
    private SongAdapterOnClickListener listener;
    private Context context;

    public SongAdapter(Context context, SongAdapterOnClickListener listener, List<Song> songs) {
        this.context = context;
        this.listener = listener;
        this.songs = songs;
    }

    public class SongViewHolder extends RecyclerView.ViewHolder implements
            View.OnClickListener {

        public final ImageView moviePosterView;

        public MovieViewHolder(View view) {
            super(view);

            moviePosterView = (ImageView) view.findViewById(R.id.movie_poster_iv);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Song selectedSong = songs.get(getAdapterPosition());
            listener.onClick(selectedSong);
        }
    }


    @Override
    public SongViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        Context context = viewGroup.getContext();
        int layoutIdForListItem = R.layout.grid_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutIdForListItem, viewGroup, shouldAttachToParentImmediately);
        return new SongViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SongViewHolder holder, int position) {
        String posterURL = songs.get(position).getPosterURL();
        Picasso.get().load(posterURL).into(holder.moviePosterView);
    }


    @Override
    public int getItemCount() {
        return songs.size();
    }

    public interface SongAdapterOnClickListener {
        void onClick(Song song);
    }

}