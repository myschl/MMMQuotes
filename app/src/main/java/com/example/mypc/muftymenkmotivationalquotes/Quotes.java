package com.example.mypc.muftymenkmotivationalquotes;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.DynamicLayout;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Quotes extends AppCompatActivity {
    private ImageButton mprevious, mnext, mshare, mfavorite;
    private TextView mbody;
    private ViewPager mpager;
    private PagerAdapter adapter;
    private List<PagerModel> pagerModels;
    private String body;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quotes);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Quotes");
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

        mbody = mpager.findViewById(R.id.ibody);



        pager();



    }


    private void pager() {
        pagerModels = new ArrayList<>();
        for (int i=0; i<10; i++){
            pagerModels.add(new PagerModel("Message #" + i+1, "the object being returned by instantiateItem() method is also used later on, as the second parameter in the isViewFromObject method, in that way this method checks whether a particular object belongs to a given position, which is made simple."));
        }

        adapter = new PagerAdapter(pagerModels, this);
        mpager = findViewById(R.id.ipager);
        mpager.setAdapter(adapter);
        //mpager.setPadding(130,0,0,130);

        initializations();

    }


    private void initializations() {

        mprevious = findViewById(R.id.iprevious);
        mnext = findViewById(R.id.inext);
        mshare = findViewById(R.id.ishare);
        mfavorite = findViewById(R.id.ifavorites);


        mshare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String body = mbody.getText().toString();
                String body = "My Quotes goes here";
                String shareBody = body;
                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(sharingIntent, "Share the Quote Via"));
            }
        });

        mfavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Quotes.this, "favorite", Toast.LENGTH_SHORT).show();
            }
        });

        mprevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Quotes.this, "previous", Toast.LENGTH_SHORT).show();
            }
        });

        mnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Quotes.this, "next", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
