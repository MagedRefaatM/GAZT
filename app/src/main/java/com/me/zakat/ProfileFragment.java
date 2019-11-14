package com.me.zakat;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.google.android.material.navigation.NavigationView;


public class ProfileFragment extends Fragment implements NavigationView.OnNavigationItemSelectedListener {

    private Button myBillBtn;
    private Button menuBtn;

    private DrawerLayout drawer;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.profile_fragment , container , false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        myBillBtn = view.findViewById(R.id.bills_button);
        myBillBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyBillsFragment fragment = new MyBillsFragment();
                ((getActivity())).getSupportFragmentManager().beginTransaction().replace(R.id.container1 , fragment).addToBackStack(null).commit();
            }
        });

        drawer = view.findViewById(R.id.drawerLayout);
        final NavigationView navigationView = view.findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(ProfileFragment.this.getActivity(), drawer,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        menuBtn = (Button) view.findViewById(R.id.menuBtn);
        menuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawer.openDrawer(Gravity.LEFT);
            }
        });
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull final MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.itemA:
                Toast.makeText(ProfileFragment.this.getActivity() , "Share this Application to support us" , Toast.LENGTH_SHORT).show();
                break;
            case R.id.itemB:
                ProfileFragment.this.getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container1,
                        new RateFragment()).commit();
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}