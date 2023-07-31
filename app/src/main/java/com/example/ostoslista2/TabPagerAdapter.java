package com.example.ostoslista2;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.ostoslista2.fragments.FragmentAddPurchase;
import com.example.ostoslista2.fragments.FragmentRCList;

public class TabPagerAdapter extends FragmentStateAdapter {
    public TabPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    public TabPagerAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    public TabPagerAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if(position == 0){
            return new FragmentRCList();
        } else if(position == 1){
            return new FragmentAddPurchase();
        } else{
            return new FragmentRCList();
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
