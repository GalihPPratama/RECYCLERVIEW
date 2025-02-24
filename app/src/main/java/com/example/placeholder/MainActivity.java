package com.example.placeholder;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private FilmAdapter filmAdapter;
    private List<FilmModel> musicList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        musicList = new ArrayList<>();
        musicList.add(new FilmModel("Everything's Alright", "DJ OKAWARI feat. Kaori Sawada",  "Everything's Alright is an Arknights song by DJ Okawari (who previously produced Speed of Light) and performed by the Japanese singer Kaori Sawada. It is released around the same time as the 2020 Gaokao concludes, and from its lyrics, Everything's Alright is meant as a soothing gift for the examinees' hard work.", R.drawable.everythingsalright));
        musicList.add(new FilmModel("Speed Of Light", "DJ OKAWARI feat. 二宮愛", "Speed of Light is an Arknights song by the Japanese musician DJ Okawari and performed by the Japanese singer Ai Ninomiya, made as part of the Code of Brawl event and dedicated to Penguin Logistics.", R.drawable.speedoflight));
        musicList.add(new FilmModel("Bedroom Community", "Glass Beach", "The second song on the album is about a bedroom community, which is known as a place where many people live but do not work, commonly suburban areas outside of major cities.", R.drawable.glassbeach));
        musicList.add(new FilmModel("Mystic Light Quest", " 塞壬唱片-MSR, KOTONOHOUSE, RANASOL ", "Mystic Light Quest is an Arknights music track and the Operator EP of Pepe, performed by Japanese singer and voice actress Machico, with lyrics by Japanese singer RANASOL and composed by dance music producer KOTONOHOUSE.", R.drawable.mysticlight));
        musicList.add(new FilmModel("Misty Memory", "塞壬唱片-MSR · Erik Castro · David Lin · 左乙", "Misty Memory is an Arknights song part of So Long, Adele OST, performed by ZOEE (who previously covered Be Me in Chinese and performed Miss You) and notably has three versions:", R.drawable.mistymemory));


        filmAdapter = new FilmAdapter(musicList, film -> {
            Intent intent = new Intent(MainActivity.this, DetailActivity.class);
            intent.putExtra("FILM_TITLE", film.getTitle());
            intent.putExtra("FILM_GENRE", film.getGenre());
            intent.putExtra("FILM_DESC", film.getDescription());
            intent.putExtra("FILM_IMAGE", film.getImageRes());
            startActivity(intent);
        });

        recyclerView.setAdapter(filmAdapter);
    }
}