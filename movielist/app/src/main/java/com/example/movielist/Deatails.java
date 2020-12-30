package com.example.movielist;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Movie;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.time.Year;

public class Deatails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deatails);
        Bundle b=getIntent().getExtras();
        Moive m = (Moive) b.getSerializable("movie");
        ImageView img= findViewById(R.id.img2);
        TextView name=findViewById(R.id.name);
        TextView genre=findViewById(R.id.genre);
        TextView year=findViewById(R.id.year);
        ImageView isanimationImg=findViewById(R.id.imageView2);

        img.setImageResource(m.getImg());
        name.setText(m.getName());
        genre.setText(m.getGenre());
        year.setText(m.getYear()+"");
        if(m.isAnimation())
            isanimationImg.setImageResource(R.drawable.ic_baseline_check_24);
            else
            isanimationImg.setImageResource(R.drawable.ic_baseline_close_24);






    }
}