package com.finalproject.flavourfeed.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.finalproject.flavourfeed.R;
import com.google.android.material.tabs.TabLayout;


public class AdminOrdersFragment extends Fragment {
    AdminPendingFragment adminPendingFragment = new AdminPendingFragment();
    AdminInProgressFragment adminInProgressFragment = new AdminInProgressFragment();
    AdminCompletedFragment adminCompletedFragment = new AdminCompletedFragment();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.admin_orders_fragment, container, false);
        TabLayout adminOrderTabLayout = view.findViewById(R.id.adminOrderTabLayout);

        changeFragment(adminPendingFragment);

        adminOrderTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                switch (position) {
                    case 0:
                        changeFragment(adminPendingFragment);
                        break;
                    case 1:
                        changeFragment(adminInProgressFragment);
                        break;
                    case 2:
                        changeFragment(adminCompletedFragment);
                        break;
                }
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {}

            @Override
            public void onTabReselected(TabLayout.Tab tab) {}
        });

        return view;
    }

    public void changeFragment(Fragment fragment) {
        getChildFragmentManager().beginTransaction().replace(R.id.tabContainer,fragment).commit();
    }
}