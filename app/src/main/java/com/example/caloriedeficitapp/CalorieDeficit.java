package com.example.caloriedeficitapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class CalorieDeficit extends Fragment {

    int calDef;
    TextView result;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        calDef = 400;

        Bundle args4 = getArguments();
        if (args4 != null) {
            calDef = args4.getInt("getCalDef");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_calorie_deficit, container, false);

        result = (TextView) rootView.findViewById(R.id.deficitTextView);
        result.setText(String.valueOf(calDef) + " kcal");

        return rootView;
    }
}