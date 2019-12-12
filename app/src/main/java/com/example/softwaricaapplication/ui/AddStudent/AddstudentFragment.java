package com.example.softwaricaapplication.ui.AddStudent;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.softwaricaapplication.R;

public class AddstudentFragment extends Fragment {

    private EditText etfullname, etage, etaddress, etgender;
    private RadioButton rdomale, rdofemale,rdoothers;
    private Button btnsave;

    private AddstudentViewModel dashboardViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                ViewModelProviders.of(this).get(AddstudentViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        final TextView textView = root.findViewById(R.id.text_dashboard);
        dashboardViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }

        });

        etfullname = root.findViewById(R.id.etusername);
        etage = root.findViewById(R.id.etage);
        etaddress = root.findViewById(R.id.etaddress);





        return root;
    }


}