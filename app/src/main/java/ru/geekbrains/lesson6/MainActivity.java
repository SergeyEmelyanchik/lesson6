package ru.geekbrains.lesson6;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            MenuFragment menuFragment = MenuFragment.newInstance();
            getSupportFragmentManager().beginTransaction().replace(R.id.menu, menuFragment).commit();
        }
        Toolbar toolbar = findViewById(R.id.toolbar); // добавляем свой тул бар в качестве тул бара андройд
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case (R.id.action_about):{
                getSupportFragmentManager().beginTransaction().replace(R.id.menu,new AboutFragment()).addToBackStack("").commit();
                return true;
            }
            case (R.id.action_exit): {
                finish();
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Fragment backStackFragment = (Fragment) getSupportFragmentManager()
                .findFragmentById(R.id.menu);
        if (backStackFragment != null && backStackFragment instanceof NoteFragment) {
            getSupportFragmentManager().popBackStack();
        }
    }
}