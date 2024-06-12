package com.example.caloriedeficitapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

public class ActivityLevels extends Fragment {

    int calReqInt;
    int adjCalReq;
    Button sedentary;
    Button min;
    Button mod;
    Button very;
    Button extra;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        calReqInt = 2000;

        Bundle args2 = getArguments();
        if (args2 != null) {
            calReqInt = args2.getInt("getCalReq");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_activity_levels, container, false);

        sedentary = (Button) rootView.findViewById(R.id.sedentaryButton);
        sedentary.setOnClickListener(buttonView -> {
            adjCalReq = (int) Math.ceil(calReqInt * 1.2);
            Bundle args3 = new Bundle();
            args3.putInt("getAdjCalReq", adjCalReq);
            Navigation.findNavController(buttonView).navigate(R.id.show_microIntake, args3);
        });

        min = (Button) rootView.findViewById(R.id.minimalButton);
        min.setOnClickListener(buttonView -> {
            adjCalReq = (int) Math.ceil(calReqInt * 1.375);
            Bundle args3 = new Bundle();
            args3.putInt("getAdjCalReq", adjCalReq);
            Navigation.findNavController(buttonView).navigate(R.id.show_microIntake, args3);
        });

        mod = (Button) rootView.findViewById(R.id.moderateButton);
        mod.setOnClickListener(buttonView -> {
            adjCalReq = (int) Math.ceil(calReqInt * 1.55);
            Bundle args3 = new Bundle();
            args3.putInt("getAdjCalReq", adjCalReq);
            Navigation.findNavController(buttonView).navigate(R.id.show_microIntake, args3);
        });

        very = (Button) rootView.findViewById(R.id.veryActiveButton);
        very.setOnClickListener(buttonView -> {
            adjCalReq = (int) Math.ceil(calReqInt * 1.725);
            Bundle args3 = new Bundle();
            args3.putInt("getAdjCalReq", adjCalReq);
            Navigation.findNavController(buttonView).navigate(R.id.show_microIntake, args3);
        });

        extra = (Button) rootView.findViewById(R.id.extraActiveButton);
        extra.setOnClickListener(buttonView -> {
            adjCalReq = (int) Math.ceil(calReqInt * 1.9);
            Bundle args3 = new Bundle();
            args3.putInt("getAdjCalReq", adjCalReq);
            Navigation.findNavController(buttonView).navigate(R.id.show_microIntake, args3);
        });

        return rootView;
    }
}