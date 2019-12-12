package com.example.softwaricaapplication.ui.AddStudent;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.softwaricaapplication.MainActivity;
import com.example.softwaricaapplication.R;
import com.example.softwaricaapplication.Students;

public class AddstudentFragment extends Fragment implements RadioGroup.OnCheckedChangeListener, View.OnClickListener {

     EditText etfullname, etage, etaddress, etgender;
     RadioButton rdomale, rdofemale,rdoothers;
     Button btnsave;
     RadioGroup rdogroup;

    private AddstudentViewModel dashboardViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                ViewModelProviders.of(this).get(AddstudentViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
//        final TextView textView = root.findViewById(R.id.text_dashboard);
//        dashboardViewModel.getText().observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//
//        });

        rdogroup = root.findViewById(R.id.rdoGroup);
        etfullname = root.findViewById(R.id.etusername);
        etage = root.findViewById(R.id.etage);
        etaddress = root.findViewById(R.id.etaddress);
        btnsave=root.findViewById(R.id.btnsave);

        rdogroup.setOnCheckedChangeListener( this);
        btnsave.setOnClickListener(this);

        final TextView textView = root.findViewById(R.id.text_dashboard);
        dashboardViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                textView.setText(s);
            }
        });

        return root;
    }

    String fullname,address,age,gender;
    @Override
    public void onClick(View v) {

        if(v.getId()==R.id.btnsave){
            Toast.makeText(getActivity(),"save",Toast.LENGTH_SHORT).show();
            fullname = etfullname.getText().toString();
             age=etage.getText().toString();
            address=etaddress.getText().toString();

            if(validate())
            {
                MainActivity.students.add(new Students(fullname,Integer.parseInt(age),address,gender));
                Toast.makeText(getContext(),"Student added",Toast.LENGTH_SHORT).show();
            }
        }
    }
    private  boolean validate(){
        if(TextUtils.isEmpty(etfullname.getText())){
            etfullname.setError("please enter full name");
            etfullname.requestFocus();
            return false;
        }
        else if(TextUtils.isEmpty(etaddress.getText())){
            etaddress.setError("please enter address");
            etaddress.requestFocus();
            return false;
        }
        else if(TextUtils.isEmpty(etage.getText())){
            etage.setError("please enter age");
            etage.requestFocus();
            return false;
        }

        else if(TextUtils.isEmpty(gender)){
            Toast.makeText(getContext(),"please select gender",Toast.LENGTH_SHORT).show();
            return  false;
        }
        return true;
    }
    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i)
    {
        if (i == R.id.rdofemale )
        {
            gender="female";
        }
        if (i == R.id.rdomale )
        {
            gender="male";
        }
        if (i == R.id.rdoothers )
        {
            gender="others";
        }

    }


}