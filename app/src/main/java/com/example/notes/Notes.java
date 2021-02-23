package com.example.notes;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Notes extends Fragment {
    private List<SimpleNote> notes = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_notes, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initArrayList();
        initList(view);

    }

    private void initList(View view) {

        LinearLayout layoutView = (LinearLayout) view;
        String note = "";
        for (int i = 0; i < notes.size(); i++) {
            note = String.valueOf(notes.get(i));
            TextView tv = new TextView(getContext());
            tv.setText(note);
            tv.setTextSize(30f);
            layoutView.addView(tv);
            final int fi = i;
            tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showDescriptionNotes(fi);
                }
            });
        }
    }

    private void showDescriptionNotes(int index) {

        Intent intent = new Intent();
        intent.setClass(getActivity(), NoteDescription.class);
        Bundle args = new Bundle();
        args.putSerializable("Array", (Serializable) notes);
        intent.putExtra("BUNDLE", args);
        startActivity(intent);
    }


    private void initArrayList() {
        notes.add(new SimpleNote("Заметка 1", "Описание заметки", "04.03.1994"));
        notes.add(new SimpleNote("Заметка 2", "Описание заметки", "07.03.1994"));
        notes.add(new SimpleNote("Заметка 3", "Описание заметки", "09.03.1994"));
        notes.add(new SimpleNote("Заметка 4", "Описание заметки", "22.03.1994"));
        notes.add(new SimpleNote("Заметка 5", "Описание заметки", "30.03.1994"));


    }
}

