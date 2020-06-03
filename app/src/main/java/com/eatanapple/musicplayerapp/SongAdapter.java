package com.eatanapple.musicplayerapp;

import android.content.Context;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.eatanapple.musicplayerapp.dto.Song;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.SongViewHolder> {


    public List<Song> songs;
    private Context context;

    public SongAdapter(Context context, List<Song> songs) {
        this.context = context;
        this.songs = songs;
    }

    public class SongViewHolder extends RecyclerView.ViewHolder  {

        @BindView(R.id.artist_tv)
        TextView artistTextView;

        @BindView(R.id.song_tv)
        TextView songTextView;

        @BindView(R.id.album_tv)
        TextView albumTextView;

        @BindView(R.id.album_art_iv)
        ImageView albumArtImageView;

        @BindView(R.id.item_layout)
        ConstraintLayout item;

        public SongViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, itemView);
        }
    }


    @Override
    public SongViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        Context context = viewGroup.getContext();
        int layoutIdForListItem = R.layout.music_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutIdForListItem, viewGroup, shouldAttachToParentImmediately);
        return new SongViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SongViewHolder holder, int position) {
        System.out.println(songs.get(position).getAlbum());
        final String song = songs.get(position).getTitle();
        final String albumName = songs.get(position).getAlbum();
        final String artist = songs.get(position).getArtist();
        final int albumResource = songs.get(position).getAlbumArt();
        holder.artistTextView.setText(artist);
        holder.songTextView.setText(song);
        holder.albumTextView.setText(albumName);
        Picasso.get().load(albumResource).into(holder.albumArtImageView);
        holder.item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, MusicPlayer.class);
                intent.putExtra("albumName",albumName);
                intent.putExtra("song",song);
                intent.putExtra("artist",artist);
                intent.putExtra("albumResource",albumResource);
                context.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return songs.size();
    }

}