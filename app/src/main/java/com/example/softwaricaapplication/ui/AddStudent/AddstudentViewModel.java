package com.example.softwaricaapplication.ui.AddStudent;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AddstudentViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public AddstudentViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("");
    }

    public LiveData<String> getText() {
        return mText;
    }
}