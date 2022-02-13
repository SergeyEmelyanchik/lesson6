package ru.geekbrains.lesson6;

import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;


public class MenuFragment extends Fragment {

    public static final String CURRENT_MENU = "menu_current";
    private Menu currentMenu;
    public static MenuFragment newInstance() {
        MenuFragment fragment = new MenuFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_menu, container, false);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(CURRENT_MENU,currentMenu);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (savedInstanceState != null) {
            currentMenu = savedInstanceState.getParcelable(CURRENT_MENU);
        }else{
            currentMenu = new Menu(0);
        }
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            showLand();
        }
        initView(view);
    }

    private void initView(View view) {
        String[] menu = getResources().getStringArray(R.array.menu);
        for (int i = 0; i < menu.length; i++) {
            String menuName = menu[i];
            TextView textView = new TextView(getContext());
            textView.setTextSize(30f);
            textView.setText(menuName);
            ((LinearLayout) view).addView(textView);
            final int finalI = i;
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    currentMenu = new Menu(finalI);
                    if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
                        showLand();
                    } else {
                        showPort();

                    }
                }
            });

        }
    }

    private void showLand() {
        NoteFragment noteFragment = NoteFragment.newInstance(currentMenu);
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.note, noteFragment).commit();
    }

    private void showPort() {
        NoteFragment noteFragment = NoteFragment.newInstance(currentMenu);
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.menu, noteFragment).addToBackStack("").commit();
    }
}
