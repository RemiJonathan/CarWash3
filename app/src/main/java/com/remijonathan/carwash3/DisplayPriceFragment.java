package com.remijonathan.carwash3;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.zip.Inflater;


/**
 * A simple {@link Fragment} subclass.
 */
public class DisplayPriceFragment extends Fragment {

    private TextView price;

    public DisplayPriceFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_display_price,container,false);
        price = view.findViewById(R.id.total_price);

        price.setText(getArguments().getString("Price"));


        // Inflate the layout for this fragment
        return view;
    }
}
