package ru.geekbrains.lesson9;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

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
}