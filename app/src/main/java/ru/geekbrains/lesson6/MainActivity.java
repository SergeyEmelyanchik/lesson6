package ru.geekbrains.lesson6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.res.Configuration;
import android.os.Bundle;

import java.util.concurrent.locks.Condition;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            MenuFragment menuFragment = MenuFragment.newInstance();
            getSupportFragmentManager().beginTransaction().replace(R.id.menu, menuFragment).commit();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        Fragment backStackFragment = (Fragment) getSupportFragmentManager()
                .findFragmentById(R.id.menu);
        if (backStackFragment != null && backStackFragment instanceof NoteFragment) {
            onBackPressed();
        }
    }
}