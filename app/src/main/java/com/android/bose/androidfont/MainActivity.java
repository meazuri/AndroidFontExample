package com.android.bose.androidfont;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        SharedPreferences pref = getApplicationContext().getSharedPreferences("BOSE", MODE_PRIVATE);
        int themeID = pref.getInt("Theme",R.style.AppTheme);
        getTheme().applyStyle(themeID,true);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        findViewById(R.id.thin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                 getTheme().applyStyle(R.style.AppThemeTwo,true);

                 saveTheme(R.style.AppThemeTwo);

                 Intent intent = getIntent();
                 finish();
                 startActivity(intent);
                 overridePendingTransition(1000, 0);
            }
        });

        findViewById(R.id.italic).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setTheme(R.style.AppTheme);

                saveTheme(R.style.AppTheme);

                Intent intent = getIntent();
                finish();
                startActivity(intent);
                overridePendingTransition(0, 1000);
            }
        });
    }

    private void saveTheme(int id){
        SharedPreferences pref = getApplicationContext().getSharedPreferences("BOSE", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt("Theme",id);
        editor.commit();

    }

}
