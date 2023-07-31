package com.example.ostoslista2.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ostoslista2.PurchaseList;
import com.example.ostoslista2.PurchaseListAdapter;
import com.example.ostoslista2.R;
import com.google.android.material.tabs.TabItem;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class FragmentRCList extends Fragment {
    private PurchaseList purchaseList;
    private RecyclerView recyclerView;
    private View view;
    private Context context;
    private Fragment frame;

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
        view = inflater.inflate(R.layout.fragment_r_c_list, container, false);
        context = view.getContext();
        purchaseList = PurchaseList.getInstance();
        recyclerView = view.findViewById(R.id.rvPurchaseList);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(new PurchaseListAdapter(context,purchaseList.getPurchases()));

        Fragment fragment;
        fragment = new ImportantFragment();
        getParentFragmentManager().beginTransaction().replace(R.id.frameImportant,fragment).commit();
        return view;
    }

    @Override
    public void onResume() { //Learned this from https://stackoverflow.com/questions/11326155/fragment-onresume-onpause-is-not-called-on-backstack
        purchaseList = PurchaseList.getInstance();
        recyclerView = view.findViewById(R.id.rvPurchaseList);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(new PurchaseListAdapter(context,purchaseList.getPurchases()));
        Fragment fragment;
        fragment = new ImportantFragment();
        getParentFragmentManager().beginTransaction().replace(R.id.frameImportant,fragment).commit();
        super.onResume();
    }

    public void updateRecycleView(View view){
        purchaseList = PurchaseList.getInstance();
        recyclerView = view.findViewById(R.id.rvPurchaseList);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(new PurchaseListAdapter(context,purchaseList.getPurchases()));
    }






}