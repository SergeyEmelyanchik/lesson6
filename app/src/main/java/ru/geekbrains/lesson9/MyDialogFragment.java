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

import ru.geekbrains.lesson6.MainActivity;
import ru.geekbrains.lesson6.R;

public class MyDialogFragment extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        View view = getLayoutInflater().inflate(R.layout.dialog_exit, null);
        AlertDialog alertDialog = new AlertDialog.Builder(requireContext())
                .setTitle("Как вас зовут?")
                .setMessage("В поле ниже введите ваше имя")
                .setView(view)
                .show();
        view.findViewById(R.id.but_DialogView).setOnClickListener(v -> {
            EditText editText = view.findViewById(R.id.editTextDialogView);
            ((MainActivity) getActivity()).onDialogResult(editText.getText().toString());
            alertDialog.dismiss();
        });
        return alertDialog;
    }
}