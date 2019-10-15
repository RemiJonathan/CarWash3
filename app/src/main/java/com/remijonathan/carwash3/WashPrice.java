package com.remijonathan.carwash3;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.TextView;

import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;

public class WashPrice extends AppCompatActivity {
    private TextView totalPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wash_price);

        String price = getIntent().getStringExtra("Price");
        Bundle bundle = new Bundle();

        bundle.putString("Price", price);


        FragmentTransaction fragmentManager = getSupportFragmentManager().beginTransaction();
        DisplayPriceFragment displayPriceFragment = new DisplayPriceFragment();

        displayPriceFragment.setArguments(bundle);

        fragmentManager.add(R.id.total_price,displayPriceFragment);
        fragmentManager.commit();

//        totalPrice = findViewById(R.id.total_price);
//
//        totalPrice.setText(getIntent().getStringExtra("Price"));
    }
}
