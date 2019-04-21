package com.example.mypc.muftymenkmotivationalquotes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;

public class Favorites extends AppCompatActivity {
    private RecyclerView recyclerView;
    private FavoriteAdapter favoriteAdapter;
    public static ArrayList<FavoriteModel> favorite = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Favorites");
        //toolbar.setSubtitle("welcome");
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.nav_back);
        toolbar.setNavigationOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        finish();
                    }
                }

        );

        //FavoriteList favoriteList = new FavoriteList();

        for (int i=0; i<10; i++){
            FavoriteList.favorite.add(new FavoriteModel("Message #"+i+1, "fgkghruitgfdhggkfnfjffjfhrjkfhrjfheihy4uuiofffjnuikopjcvkdfmikgdmdjgwlregkjbrkjghbrmffmbrjfmfjkgnjrjkrfmrknbhgbglkhjkkhjjkigsejkhlfjkgjkhrieuwthirggreug"));
        }
        Recyclerview();
    }

    private void Recyclerview() {
        recyclerView = (RecyclerView)findViewById(R.id.irecyclerview);
        //recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        favoriteAdapter=new FavoriteAdapter(Favorites.this, FavoriteList.favorite);
        recyclerView.setAdapter(favoriteAdapter);
    }
}
