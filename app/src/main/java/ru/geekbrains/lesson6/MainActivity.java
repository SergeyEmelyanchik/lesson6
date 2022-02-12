package ru.geekbrains.lesson6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;

import java.util.concurrent.locks.Condition;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState==null){
            MenuFragment menuFragment = new MenuFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.menu, menuFragment).commit();
            if (getResources().getConfiguration().orientation== Configuration.ORIENTATION_LANDSCAPE){
                MenuFragment noteFragment = new MenuFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.note, noteFragment).commit();

            }
        }
    }
}