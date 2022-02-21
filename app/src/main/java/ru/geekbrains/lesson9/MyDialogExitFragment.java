package ru.geekbrains.lesson9;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import ru.geekbrains.lesson6.R;

public class MyDialogExitFragment extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        return new AlertDialog.Builder(requireContext())
                .setTitle("Выход")
                .setMessage("Вы уверены что хотите выйти?")
                .setPositiveButton("Да", (dialog, which) -> {
                    showToast("Да");
                    System.exit(0);
                })
                .setNegativeButton("Нет", (dialog, which) -> {
                    showToast("Нет");
                })
                .show();
    }

    void showToast(String message) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_LONG).show();
    }
}