package ru.geekbrains.lesson6;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class NoteChildFragment extends Fragment {

    public static final String ARG_MENU = "menu";

    private Menu menu;

    public static NoteChildFragment newInstance(Menu menu) {
        NoteChildFragment fragment = new NoteChildFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(ARG_MENU, menu);
        fragment.setArguments(bundle);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_note_child, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        menu = getArguments().getParcelable(ARG_MENU);
        TextView textView = view.findViewById(R.id.notes);
        TypedArray note = getResources().obtainTypedArray(R.array.note);
        textView.setText(note.getResourceId(menu.getIndex(), R.id.note));
        textView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                PopupMenu popupMenu = new PopupMenu(requireContext(),view);
                requireActivity().getMenuInflater().inflate(R.menu.popup,popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case (R.id.action_popup_clear): {
                                textView.setTextColor(0);
                                return true;
                            }
                            case (R.id.action_popup_exit): {
                                requireActivity().finish();
                                return true;
                            }
                        }
                        return false;
                    }
                });
                popupMenu.show();
                return false;
            }
        });


        view.findViewById(R.id.but_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getParentFragmentManager().popBackStack();
            }
        });

    }
}
