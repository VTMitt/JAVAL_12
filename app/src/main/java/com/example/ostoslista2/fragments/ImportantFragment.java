package com.example.ostoslista2.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ostoslista2.Purchase;
import com.example.ostoslista2.PurchaseList;
import com.example.ostoslista2.R;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class ImportantFragment extends Fragment {

    TextView txtImportant;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_important, container, false);
        txtImportant = view.findViewById(R.id.txtImportant);
        for (Purchase purchase: PurchaseList.getInstance().getPurchases()) {
            if(purchase.isImportant()){
                txtImportant.append(purchase.getName() + "\n");
            }

        }
        return view;
    }
}