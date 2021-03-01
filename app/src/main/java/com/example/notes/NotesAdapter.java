package com.example.notes;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.textview.MaterialTextView;

import java.util.ArrayList;
import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.SimpleNoteViewHolder> {

    private static final String TAG = "NotesAdapter";

    private final List<SimpleNote> notes = new ArrayList<>();
    private final NotesAdapterCallback callback;

    public NotesAdapter(NotesAdapterCallback callback) {
        this.callback = callback;
    }

    public void setItems(List<SimpleNote> items) {
        notes.clear();
        notes.addAll(items);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public SimpleNoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_notes, parent, false);
        return new SimpleNoteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SimpleNoteViewHolder holder, int position) {
        holder.onBind(notes.get(position), position);
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    class SimpleNoteViewHolder extends RecyclerView.ViewHolder {

        private final MaterialTextView textView;

        public SimpleNoteViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_item_title);
        }

        public void onBind(SimpleNote model, int position) {
            Log.d(TAG, String.valueOf(position));
            textView.setText(model.getTitle());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (getAdapterPosition() != RecyclerView.NO_POSITION) {
                        callback.onOnItemClicked(getAdapterPosition());
                    }
                }
            });
        }
    }
}