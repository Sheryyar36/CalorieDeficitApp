package com.example.caloriedeficitapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

public class GenderSelection extends Fragment {

    Button maleButton;
    Button femaleButton;
    String gender;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_gender_selection, container, false);

        maleButton = (Button) rootView.findViewById(R.id.maleButton);
        maleButton.setOnClickListener(buttonView -> {
            gender = "Male";
            Bundle args1 = new Bundle();
            args1.putString("getGender", gender);
            Navigation.findNavController(buttonView).navigate(R.id.show_calorieReq, args1);
        });

        femaleButton = (Button) rootView.findViewById(R.id.femaleButton);
        femaleButton.setOnClickListener(buttonView -> {
            gender = "Female";
            Bundle args1 = new Bundle();
            args1.putString("getGender", gender);
            Navigation.findNavController(buttonView).navigate(R.id.show_calorieReq, args1);
        });


        return rootView;
    }

}