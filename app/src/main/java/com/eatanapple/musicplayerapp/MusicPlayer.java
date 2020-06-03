package com.eatanapple.musicplayerapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MusicPlayer extends AppCompatActivity {
    @BindView(R.id.album_tv)
    TextView albumTextView;

    @BindView(R.id.song_tv)
    TextView songTextView;

    @BindView(R.id.artist_tv)
    TextView artistTextView;

    @BindView(R.id.album_art_iv)
    ImageView albumArtImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_player);
        ButterKnife.bind(this);
        ActionBar bar = getSupportActionBar();
        if (bar != null) {
            bar.setDisplayHomeAsUpEnabled(true);
        }
        Intent intent = getIntent();
        albumTextView.setText(intent.getStringExtra("albumName"));
        artistTextView.setText(intent.getStringExtra("artist"));
        songTextView.setText(intent.getStringExtra("song"));
        Picasso.get().load(intent.getIntExtra("albumResource",0)).into(albumArtImageView);

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

}
