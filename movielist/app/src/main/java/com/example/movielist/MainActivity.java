package com.example.movielist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ArrayList<Moive> movielibrary= new ArrayList<>();
        Moive a= new Moive("spiderman",1.35,4.3,"Adventure",2017,false,R.drawable.spidermanhc);
        Moive b= new Moive("badboys3",2,4.8,"Action",2019,false,R.drawable.badboys3);
        Moive c= new Moive("lionking",1.5,4,"kids",1994,true,R.drawable.lionking1994);

        movielibrary.add(b);//
        movielibrary.add(a);//
        movielibrary.add(c);//

        RecyclerView movies=findViewById(R.id.rv);

        movies.setHasFixedSize(true);
        RecyclerView.LayoutManager lm= new LinearLayoutManager(this);
        movies.setLayoutManager(lm);


        ma MA=new ma(movielibrary,MainActivity.this);
        movies.setAdapter(MA);


    }
}