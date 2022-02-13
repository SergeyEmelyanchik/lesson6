package ru.geekbrains.lesson6;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_note, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        menu = getArguments().getParcelable(ARG_MENU);
        TextView textView = view.findViewById(R.id.notes);
        TypedArray note = getResources().obtainTypedArray(R.array.note);
        textView.setText (note.getResourceId(menu.getIndex(),R.id.note));
    }
}
