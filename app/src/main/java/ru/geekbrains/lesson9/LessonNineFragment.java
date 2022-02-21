package ru.geekbrains.lesson9;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.google.android.material.snackbar.Snackbar;

import ru.geekbrains.lesson6.R;

public class LessonNineFragment extends Fragment {

    public static LessonNineFragment newInstance() {
        LessonNineFragment fragment = new LessonNineFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_lesson_nine, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);

    }

    void initView(View view) {
        view.findViewById(R.id.but_toast).setOnClickListener(v -> showToast());
        view.findViewById(R.id.but_snack).setOnClickListener(v -> showSnackBar(view));
        view.findViewById(R.id.but_snackWithAction).setOnClickListener(v -> showSnackBarWithAction(view));
        view.findViewById(R.id.but_dialog).setOnClickListener(v -> showDialog());
        view.findViewById(R.id.but_bottomsheet).setOnClickListener(v -> showBottomSheetDialog());
        view.findViewById(R.id.but_exit).setOnClickListener(v -> showDialogExit());
    }

    void showToast() {
        Toast.makeText(requireContext(), "Реклама Toast", Toast.LENGTH_LONG).show();
    }

    void showToast(String message) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_LONG).show();
    }

    void showSnackBar(View view) {
        Snackbar.make(view, "Реклама SnackBar", Snackbar.LENGTH_LONG).show();
    }

    void showSnackBarWithAction(View view) {
        Snackbar.make(view, "Реклама SnackBarWithAction", Snackbar.LENGTH_LONG).setAction("Повторить", v -> {
            showToast();
        }).show();
    }

    void showDialogExit() {
        new MyDialogExitFragment().show(getActivity().getSupportFragmentManager(), "");

    }

    void showBottomSheetDialog() {
        new MyBottomSheetDialogFragment().show(getActivity().getSupportFragmentManager(),"");

    }

    void showDialog() {
        new MyDialogFragment().show(getActivity().getSupportFragmentManager(), "");


    }
}