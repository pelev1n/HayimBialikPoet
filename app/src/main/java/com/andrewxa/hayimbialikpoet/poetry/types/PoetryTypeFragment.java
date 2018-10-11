package com.andrewxa.hayimbialikpoet.poetry.types;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.andrewxa.hayimbialikpoet.R;

public class PoetryTypeFragment extends Fragment {

    public static PoetryTypeFragment newInstance(String poetryType) {
        Bundle args = new Bundle();
        args.putString("POETRY_TYPE", poetryType);

        PoetryTypeFragment fragment = new PoetryTypeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.poetry_item, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        System.out.println("CREATED NEW POETRY FRAGMENT!!!!!!!!!!");

    }
}