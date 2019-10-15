package com.remijonathan.carwash3;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class CalculatePriceFragment extends Fragment {

    private EditText washAmount;
    private RadioGroup washGroup;
    private RadioButton outWash;
    private RadioButton inWash;
    private Button calculatePrice;

    public CalculatePriceFragment() {
        // Required empty public constructor

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_calculate_price, container, false);
    }
}
