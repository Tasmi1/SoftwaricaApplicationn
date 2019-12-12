package com.example.softwaricaapplication.ui.home;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.softwaricaapplication.R;
import com.example.softwaricaapplication.StudentAdapter;
import com.example.softwaricaapplication.Students;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {


    private HomeViewModel homeViewModel;

    private RecyclerView recyclerView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
//        final TextView textView = root.findViewById(R.id.text_home);
//
//        homeViewModel.getText().observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });

        recyclerView = root.findViewById(R.id.recyclerView);

        // Creating a list of students to display in recycler view

        List<Students> studentsList = new ArrayList<>();
        studentsList.add(new Students("Tasmiya Fatema", 21,"Kathmandu", "Female", R.drawable.aa, R.drawable.ddd));
        studentsList.add(new Students("Tanish S",25,"Japan","Male", R.drawable.bb, R.drawable.ddd));
        studentsList.add(new Students("John T",30,"USA","Others", R.drawable.oo, R.drawable.ddd));

        StudentAdapter studentAdapter = new StudentAdapter(studentsList);
        recyclerView.setAdapter(studentAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        return root;
    }



}