package com.andrewxa.hayimbialikpoet.poetry.fragment;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.andrewxa.hayimbialikpoet.R;
import com.andrewxa.hayimbialikpoet.model.poetry.Poetry;

public class PoetryFragment extends Fragment{

    public static PoetryFragment newInstance(Poetry poetry) {
        Bundle args = new Bundle();
        args.putSerializable("POETRY", poetry);

        PoetryFragment fragment = new PoetryFragment();
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
        System.out.println("INSIDE POETRY FRAGMENT!!!!!!!!!!");
        Poetry poetry = (Poetry) getArguments().getSerializable("POETRY");

        Typeface myFont = Typeface.createFromAsset(getActivity().getAssets(), "fonts/shmulikclm.ttf");

        TextView mainPoetryTitle = getActivity().findViewById(R.id.poetry_fragment_txt);
        mainPoetryTitle.setText(poetry.getTitle());

        TextView textView = view.findViewById(R.id.final_poetry_item);

        int paragraphSize = poetry.getPoem().size();


        //textView.append(Integer.toString(poetry.getPoem().get(i).getParagraph())+"\n");

        textView.setTypeface(myFont);
        textView.setText("");
        for(int i=0; i<paragraphSize; i++) {
            System.out.println(poetry.getPoem().get(i).getParagraph());
            textView.append("Paragraph " + Integer.toString(poetry.getPoem().get(i).getParagraph())+"\n");

            for(int k=0; k<poetry.getPoem().get(i).getText().size(); k++) {
                textView.append(poetry.getPoem().get(i).getText().get(k)+"\n");
                if(k == poetry.getPoem().get(i).getText().size() - 1) {
                    textView.append("\n");
                }
            }
        }




    }
}
