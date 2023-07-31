package com.example.ostoslista2.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.ostoslista2.MainActivity;
import com.example.ostoslista2.Purchase;
import com.example.ostoslista2.PurchaseList;
import com.example.ostoslista2.R;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class FragmentAddPurchase extends Fragment {
    private View view;
    private EditText name;
    private EditText description;

    private CheckBox cbImportant;

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
        view = inflater.inflate(R.layout.fragment_add_purchase, container, false);
        name = view.findViewById(R.id.editNameOption);
        description = view.findViewById(R.id.editDescriptionOption);
        cbImportant = view.findViewById(R.id.cbImp);

        Button addPurchase = view.findViewById(R.id.btnPurchaseAdd);
        addPurchase.setOnClickListener(listener);
        return view;
    }

    public View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
                String stringName = name.getText().toString();
                String stringDescription = description.getText().toString();
                Purchase purchase = new Purchase(stringName,stringDescription);
                if(cbImportant.isChecked()){
                    purchase.setImportant(true);
                }
                PurchaseList.getInstance().addPurchase(purchase);
        }
    };

}