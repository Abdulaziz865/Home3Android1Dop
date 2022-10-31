package com.example.home3android1dop;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class FirstFragment extends Fragment {

    ListOfNameAdapter1 adapter;
    List<String> itemList = new ArrayList<>();
    RecyclerView recyclerView;
    EditText editText;
    Button buttonAdd;
    Button buttonClear;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        editText = view.findViewById(R.id.et_text);
        buttonAdd = view.findViewById(R.id.button_save);
        buttonClear = view.findViewById(R.id.button_clear);
        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new ListOfNameAdapter1(itemList);
        recyclerView.setAdapter(adapter);

        buttonAdd.setOnClickListener(view1 -> {

            String text = editText.getText().toString().trim();
            if (text.isEmpty()) {
                Toast.makeText(getContext(), "Введите текст", Toast.LENGTH_SHORT).show();
            } else {
                String string = editText.getText().toString().trim();
                itemList.add(string);
                editText.setText("");
                adapter.notifyItemInserted(itemList.size() - 1);
            }
        });

        buttonClear.setOnClickListener(view1 -> {

            if (itemList.isEmpty()) {
                Toast.makeText(getContext(), "Пусто!!!", Toast.LENGTH_SHORT).show();
            } else {
                itemList.clear();
                adapter.notifyDataSetChanged();
            }

        });
    }
}