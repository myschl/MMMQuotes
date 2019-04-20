package com.example.mypc.muftymenkmotivationalquotes;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

public class Setting extends AppCompatActivity {

    String[] language ={"English"};
    Spinner lspinner;
    ArrayAdapter gspinnerAdapter;
    String[] currency ={"Dallas"};
    Spinner cspinner;

    String[] Informations = {"Terms and conditions","Rate us in the App store","Abour Mufty Menk","About us"};
    ListView Linformation;
    ArrayAdapter spinnerAdapter,listadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Setting");
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

        Myfun();
    }

    private void Myfun() {
        lspinner=(Spinner)findViewById(R.id.language_spinner);
        Linformation=(ListView)findViewById(R.id.information);


        spinnerAdapter=new ArrayAdapter(this,android.R.layout.simple_spinner_item,language);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        lspinner.setAdapter(spinnerAdapter);

        lspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //spinnerAdapter=new ArrayAdapter(this,android.R.layout.simple_spinner_item,currency);
        /*spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cspinner.setAdapter(spinnerAdapter);

        cspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
*/
        listadapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,Informations);
        Linformation.setAdapter(listadapter);
        Linformation.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        //terms and conditions
                        startActivity(new Intent(Setting.this, Terms_and_conditions.class));
                        break;
                    case 1:
                        // rate us in the app store
                        rateinappstore();
                        break;

                    case 2:
                    //About mufty
                    startActivity(new Intent(Setting.this, About_Mufty_Menk.class));
                    break;

                    case 3:
                        // about us
                        startActivity(new Intent(Setting.this, About.class));
                        break;
                }
            }
        });


    }

    private void rateinappstore() {
        try {
            Uri uri = Uri.parse("market://details?id="+getPackageName());
            Intent gotoAppstore = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(gotoAppstore);

        }catch (ActivityNotFoundException e){
            Uri uri = Uri.parse("http://play.google.com/store/apps/details?id="+getPackageName());
            Intent gotoAppstore = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(gotoAppstore);
        }
    }
}
