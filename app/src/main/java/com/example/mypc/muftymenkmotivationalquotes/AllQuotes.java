package com.example.mypc.muftymenkmotivationalquotes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;

public class AllQuotes extends AppCompatActivity {
    private RecyclerView recyclerView;
    private AllQuotesAdapter allQuotesAdapter;
    private ArrayList<AllQuotesModel> allquotes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_quotes);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("All Quotes");
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

        for (int i=0; i<20; i++){
            allquotes.add(new AllQuotesModel("Message #"+i+1, "fgkghruitgfdhgghrieuwthirggreujkmhnhkhkjmnnnnnnnnfkfjkhhhlnjkklnkhnklghjjjjjjjjjjjjjjlcfvghghglhjgggfvhjhhhgfhjg"));
        }

        Recyclerview();
    }

    private void Recyclerview() {
        recyclerView = (RecyclerView)findViewById(R.id.irecyclerview);
        //recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        allQuotesAdapter=new AllQuotesAdapter(AllQuotes.this, allquotes);
        recyclerView.setAdapter(allQuotesAdapter);
    }


}
