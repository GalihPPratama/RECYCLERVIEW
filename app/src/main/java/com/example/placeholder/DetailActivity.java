package com.example.placeholder;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    private TextView textViewTitle, textViewGenre, textViewDescription;
    private ImageView imageViewPoster;
    private Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        textViewTitle = findViewById(R.id.textViewTitle);
        textViewGenre = findViewById(R.id.textViewGenre);
        textViewDescription = findViewById(R.id.textViewDescription);
        imageViewPoster = findViewById(R.id.imageViewPoster);
        btnBack = findViewById(R.id.buttonBack);

        Intent intent = getIntent();
        if (intent != null) {
            String title = intent.getStringExtra("FILM_TITLE");
            String genre = intent.getStringExtra("FILM_GENRE");
            String description = intent.getStringExtra("FILM_DESC");
            int imageRes = intent.getIntExtra("FILM_IMAGE", R.drawable.koyuk);

            textViewTitle.setText(title);
            textViewGenre.setText(genre);
            textViewDescription.setText(description);
            imageViewPoster.setImageResource(imageRes);
        }
        btnBack.setOnClickListener(v -> finish());
    }
}