package com.example.softwaricaapplication.ui.home;

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

import com.example.softwaricaapplication.R;

public class HomeFragment extends Fragment {

    private TextView txtname, txtage, txtgender, txtaddress;
    private ImageView imggender, imgdelete;

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        txtname TextView textView = root.findViewById(R.id.txtname);
        txtage TextView textView = root.findViewById(R.id.txtage);
        txtaddress TextView textView = root.findViewById(R.id.txtaddress);
        txtgender TextView textView = root.findViewById(R.id.txtgender);


        homeViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}