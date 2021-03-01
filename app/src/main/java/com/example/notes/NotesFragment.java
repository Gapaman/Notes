package com.example.notes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class NotesFragment extends Fragment implements NotesAdapterCallback{
    private final List<SimpleNote> notes = new ArrayList<>();
    private final NotesAdapter notesAdapter = new NotesAdapter(this);
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initArrayList();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_notes, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        notesAdapter.setItems(notes);
    }

    @Override
    public void onOnItemClicked(int position) {
       SimpleNote note = notes.get(position);
        Toast.makeText(requireContext(), note.getTitle(), Toast.LENGTH_SHORT).show();
    }

    private void initView(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.notes_rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), RecyclerView.VERTICAL));
        recyclerView.addItemDecoration(new SpaceDecorator(getResources().getDimensionPixelSize(R.dimen.default_margin)));
        recyclerView.setAdapter(notesAdapter);
    }



    private void initArrayList() {
        notes.add(new SimpleNote("Заметка 1", "Описание заметки", "04.03.1994"));
        notes.add(new SimpleNote("Заметка 2", "Описание заметки", "07.03.1994"));
        notes.add(new SimpleNote("Заметка 3", "Описание заметки", "09.03.1994"));
        notes.add(new SimpleNote("Заметка 4", "Описание заметки", "22.03.1994"));
        notes.add(new SimpleNote("Заметка 5", "Описание заметки", "30.03.1994"));


    }
}

