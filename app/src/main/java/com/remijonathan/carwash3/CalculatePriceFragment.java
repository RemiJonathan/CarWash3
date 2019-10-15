package com.remijonathan.carwash3;

import android.content.Intent;
import android.content.res.Configuration;
import android.icu.text.NumberFormat;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class CalculatePriceFragment extends Fragment {

    private EditText washAmount;
    private RadioGroup washGroup;
    private Button calculatePrice;
    private Wash wash;

    public CalculatePriceFragment() {
        // Required empty public constructor


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_calculate_price, container, false);

        washAmount = view.findViewById(R.id.washes_wanted);
        washGroup = view.findViewById(R.id.wash_group);
        calculatePrice = view.findViewById(R.id.calculate_price);

        wash = new Wash();

        calculatePrice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculatePrice();
            }
        });

        washGroup.setOnCheckedChangeListener(washTypeListener);
        return view;
    }
    private RadioGroup.OnCheckedChangeListener washTypeListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            switch (i) {
                case R.id.inside_out_wash:
                    wash.setPrice(wash.INWASH);
                    break;
                case R.id.outside_wash:
                    wash.setPrice(wash.OUTWASH);
                    break;
            }
        }
    };

    /**
     * Calculate the price of the packages being
     */
    private void calculatePrice() {

        final int REQUEST_CODE = 0x160;

        //Validate that a value is in amount
        if (washAmount.getText().toString().length() != 0) {

            int amount = Integer.parseInt(washAmount.getText().toString());
            wash.setAmount(amount);

            String price = NumberFormat.getCurrencyInstance().format(wash.getTotalPrice());

            int orientation = getActivity().getResources().getConfiguration().orientation;

            //if the device is in Portrait
            //Send the User to the Wash Price Activity
            //if the device is in Landscape
            //Send the Price to the Display fragment
            //Send the User to the Wash Price Activity

            switch (orientation){
                case Configuration.ORIENTATION_PORTRAIT:
                        Intent intent = new Intent(getActivity(),WashPrice.class);
                        intent.putExtra("Price", price);
                        getActivity().startActivityForResult(intent, REQUEST_CODE);
                    break;
                case Configuration.ORIENTATION_LANDSCAPE:
                    Bundle bundle = new Bundle();
                    bundle.putString("Price", price);

                    FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                    DisplayPriceFragment displayPriceFragment = new DisplayPriceFragment();

                    displayPriceFragment.setArguments(bundle);

                    fragmentTransaction.replace(R.id.DisplayPriceFragment, displayPriceFragment);
                    fragmentTransaction.commit();
                    break;
            }

        } else emptyNumberException();
    }

    private void emptyNumberException() {
        Toast.makeText(getContext(), "Amount field cannot be empty", Toast.LENGTH_LONG).show();
    }
}
