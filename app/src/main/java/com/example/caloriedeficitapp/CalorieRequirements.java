package com.example.caloriedeficitapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

public class CalorieRequirements extends Fragment {

    String gender;
    EditText age;
    EditText height;
    EditText weight;
    int ageText;
    int heightText;
    int weightText;
    Button next;
    Double calReq;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        gender = "Male";

        Bundle args1 = getArguments();
        if (args1 != null) {
            gender = args1.getString("getGender");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_calorie_requirements, container, false);

        age = (EditText) rootView.findViewById(R.id.editTextNumberAge);
        height = (EditText) rootView.findViewById(R.id.editTextNumberHeight);
        weight = (EditText) rootView.findViewById(R.id.editTextNumberWeight);
        next = (Button) rootView.findViewById(R.id.nextButton);

        next.setOnClickListener(buttonView -> {
            ageText = Integer.parseInt(String.valueOf(age.getText()));
            heightText = Integer.parseInt(String.valueOf(height.getText()));
            weightText = Integer.parseInt(String.valueOf(weight.getText()));

            if (gender == "Male") {
                calReq = (66 + (6.3 * weightText) + (12.9 * heightText) - (6.8 * ageText));
            } else {
                calReq = (655 + (4.3 * weightText) + (4.7 * heightText) - (4.7 * ageText));
            }
            int calReqInt = (int) Math.ceil(calReq);
            Bundle args2 = new Bundle();
            args2.putInt("getCalReq", calReqInt);
            Navigation.findNavController(buttonView).navigate(R.id.show_activityLevel, args2);
        });

        return rootView;
    }

}