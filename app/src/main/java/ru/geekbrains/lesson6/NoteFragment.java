package ru.geekbrains.lesson6;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class NoteFragment extends Fragment {

    public static final String ARG_MENU = "menu";

    private Menu menu;

    public static NoteFragment newInstance(Menu menu) {
        NoteFragment fragment = new NoteFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(ARG_MENU, menu);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreateOptionsMenu(@NonNull android.view.Menu menu, @NonNull MenuInflater inflater) { //данный метод вызывает меню
        inflater.inflate(R.menu.menu_note, menu);
        menu.findItem(R.id.action_about).setVisible(false); //ищем меню action_about и задаем ему видимость false
        super.onCreateOptionsMenu(menu, inflater);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case (R.id.action_toast): {
                Toast.makeText(requireContext(), "Toast", Toast.LENGTH_LONG).show();
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_note, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setHasOptionsMenu(true); //Не забываем сказать, что работаем с меню
        menu = getArguments().getParcelable(ARG_MENU);


        getChildFragmentManager().beginTransaction().replace(R.id.container_clild, NoteChildFragment.newInstance(menu)).addToBackStack("").commit();


        view.findViewById(R.id.but_back).setOnClickListener(new View.OnClickListener(){



                    @Override
                    public void onClick(View view) {
                        requireActivity().getSupportFragmentManager().popBackStack();
                    }
                });
        view.findViewById(R.id.but_back2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getParentFragmentManager().popBackStack();
            }
        });
    }
}
