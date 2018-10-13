package com.andrewxa.hayimbialikpoet.poetrytypes.list;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.andrewxa.hayimbialikpoet.R;
import com.andrewxa.hayimbialikpoet.model.Poetry;
import com.andrewxa.hayimbialikpoet.poetrytypes.poetry.PoetryFragment;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class PoetryListFragment extends Fragment {

    Realm realm;
    RealmResults<Poetry> poetries;

    public static PoetryListFragment newInstance(String poetryType) {
        Bundle args = new Bundle();
        args.putString("POETRY_TYPE", poetryType);

        PoetryListFragment fragment = new PoetryListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.poetry_menu, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        System.out.println("INSIDE POETRY LIST FRAGMENT!!!!!!!!!!");
        realm = Realm.getDefaultInstance();
        String poetryType = (String) getArguments().getSerializable("POETRY_TYPE");

        TextView mainPoetryTitle = getActivity().findViewById(R.id.shirim_text_inside);
        mainPoetryTitle.setText(poetryType);

        RecyclerView recyclerView = view.findViewById(R.id.poetry_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        String poetryJsonType = getJsonPoetryType(poetryType);
        PoetryListAdapter poetryAdapter = new PoetryListAdapter(getAllPoetry(poetryJsonType));
        recyclerView.setAdapter(poetryAdapter);

        poetryAdapter.setPoetryOnItemClickListener(position -> {
            Toast.makeText(getActivity(), "PoetryFragment", Toast.LENGTH_SHORT).show();
            Poetry poetry = poetries.get(position);
            getActivity().getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.poetry_fragment_container,
                            PoetryFragment.newInstance(poetry))
                    .addToBackStack(null)
                    .commit();
        });
    }

    public String getJsonPoetryType(String poetryType) {
        String jsonPoetryType = null;
        switch (poetryType) {
            case "שירים":
                jsonPoetryType = "shirim";
                break;
            case "יתמות":
                jsonPoetryType = "yatmot";
                break;

            case "מזמורים ופזמונות":
                jsonPoetryType = "mzmpzm";
                break;

            case "שירות":
                jsonPoetryType = "shirot";
                break;

            case "שירים ופזמונות לילדים":
                jsonPoetryType = "eladim";
                break;

            case "שירים מן העזבון":
                jsonPoetryType = "hazvon";
                break;

        }
        return jsonPoetryType;
    }

    public List<Poetry> getAllPoetry(String poetryJsonType) {
        System.out.println("INSIDE POETRY SPECIFIC TYPE FRAGMENT >>>>> getAllPoetry !!!!!!!!!!");
        System.out.println("INSIDE POETRY SPECIFIC TYPE FRAGMENT >>>>> poetryJsonType" + poetryJsonType) ;
        realm.beginTransaction();
        poetries = realm.where(Poetry.class).equalTo("type",poetryJsonType).findAll();
        realm.commitTransaction();

        for(Poetry p : poetries) {
            System.out.println("!!!!!!!!! + " + p.getTitle());
        }

        System.out.println("INSIDE POETRY SPECIFIC TYPE FRAGMENT >>>>> poetries.size(): " + poetries.size());
        return poetries;
    }
}