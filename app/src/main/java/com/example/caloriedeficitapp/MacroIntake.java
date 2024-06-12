package com.example.caloriedeficitapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

public class MacroIntake extends Fragment {

    int adjCalReq;
    EditText protein;
    EditText carbs;
    EditText fats;
    Button calculate;
    int calDef;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        adjCalReq = 2400;

        Bundle args3 = getArguments();
        if (args3 != null) {
            adjCalReq = args3.getInt("getAdjCalReq");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_macro_intake, container, false);

        protein = (EditText) rootView.findViewById(R.id.editTextProtein);
        carbs = (EditText) rootView.findViewById(R.id.editTextCarbs);
        fats = (EditText) rootView.findViewById(R.id.editTextFats);
        calculate = (Button) rootView.findViewById(R.id.calculateCalorieDef);
        calculate.setOnClickListener(buttonView -> {
            calDef = (adjCalReq - ((4 * Integer.parseInt(String.valueOf(protein.getText()))) + (4 * Integer.parseInt(String.valueOf(carbs.getText()))) + (9 * Integer.parseInt(String.valueOf(fats.getText())))));
            Bundle args4 = new Bundle();
            args4.putInt("getCalDef", calDef);
            Navigation.findNavController(buttonView).navigate(R.id.show_calorieDef, args4);
        });

        return rootView;
    }
}