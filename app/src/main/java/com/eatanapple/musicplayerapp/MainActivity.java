package com.eatanapple.musicplayerapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.eatanapple.musicplayerapp.dto.Song;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
        @BindView(R.id.rv_songs)
        RecyclerView songsRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Song trackOne = new Song("Take Me Somewhere Nice", "Mogwai", "Rock Action",
                R.drawable.rock_action);

        Song trackTwo = new Song("The Only Moment We Were Alone", "Explosions In The Sky", "The Earth Is Not a Cold Dead Place",
                R.drawable.the_earth_is_not_a_cold_dead_place);

        Song trackThree = new Song("You, You're Awesome", "Do Make Say Think", "You, You're a History in Rust",
                R.drawable.history);

        Song trackFour = new Song("Antennas to Heaven...", "Godspeed You! Black Emperor", "Lift Your Skinny Fists Like Antennas to Heaven",
                R.drawable.skinny_fists);

        Song trackFive = new Song("But We'll All Sleep Better Tonight", "...Of Sinking Ships", "...Of Sinking Ships",
                R.drawable.of_sinking_ships);

        Song trackSix = new Song("The World Is Our ___", "This Will Destroy You", "Young Mountain",
                R.drawable.young_mountain);

        List<Song> songList = new ArrayList<>();

        songList.add(trackOne);
        songList.add(trackTwo);
        songList.add(trackThree);
        songList.add(trackFour);
        songList.add(trackFive);
        songList.add(trackSix);

        SongAdapter adapter = new SongAdapter(getApplicationContext(), songList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        songsRecyclerView.setLayoutManager(linearLayoutManager);
        songsRecyclerView.setAdapter(adapter);

    }
}
