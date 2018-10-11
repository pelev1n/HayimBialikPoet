package com.andrewxa.hayimbialikpoet.poetry.menu;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.andrewxa.hayimbialikpoet.R;
import com.andrewxa.hayimbialikpoet.poetry.types.PoetryTypeFragment;

import java.util.ArrayList;
import java.util.List;

public class PoetryMenuFragment extends Fragment{

    List<String> poetryType;

    public static PoetryMenuFragment newInstance() {
        return new PoetryMenuFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.poetry_menu, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        System.out.println("CREATED NEW POETRY FRAGMENT!!!!!!!!!!");


        RecyclerView recyclerView =  view.findViewById(R.id.poetry_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        PoetryMenuAdapter poetryMenuAdapter = new PoetryMenuAdapter(getAllPoetryTypes());
        recyclerView.setAdapter(poetryMenuAdapter);

        poetryMenuAdapter.setPoetryOnItemClickListener( position -> {
            Toast.makeText(getActivity(), "usenet", Toast.LENGTH_SHORT).show();
            String pType = poetryType.get(position);
            getActivity().getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.poetry_fragment_container,
                            PoetryTypeFragment.newInstance(pType))
                    .commit();
        });

    }

    public List<String> getAllPoetryTypes() {
        poetryType = new ArrayList<>();
        poetryType.add("שירים");
        poetryType.add("יתמות");
        poetryType.add("מזמורים ופזמונות");
        poetryType.add("שירות");
        poetryType.add("שירים ופזמונות לילדים");
        poetryType.add("שירים מן העזבון");

        return poetryType;
    }
}
