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
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;


public class MyBillsFragment extends Fragment implements NavigationView.OnNavigationItemSelectedListener{

    private FragmentPagerAdapter adapterViewPager;

    private TabLayout tabLayout;

    private Button backBtn;
    private Button menuBtn;

    private DrawerLayout drawer2;

    public static class MyPagerAdapter extends FragmentPagerAdapter {

        private static int NUM_ITEMS = 4;

        MyPagerAdapter(FragmentManager supportFragmentManager) {
            super(supportFragmentManager);
        }

        @Override
        public int getCount() { return NUM_ITEMS; }

        @Override
        public Fragment getItem(int position) {

            switch (position) {
                case 0:
                case 1:
                case 2:
                case 3:
                    return ViewPagerFragments.newInstance(3, "الجميع");

                default:
                    break;
            }
            return null;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position){
                case 0:
                    return "غير مسددة جزئيا";
                case 1:
                    return "غير مدفوعة";
                case 2:
                    return "المدفوعة";
                case 3:
                    return "الحميع";
            }
            return "Page " + position;
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        final ViewPager vpPager = view.findViewById(R.id.pager_header);
        tabLayout = view.findViewById(R.id.tabLayout);
        adapterViewPager = new MyPagerAdapter(getFragmentManager());
        vpPager.setAdapter(adapterViewPager);
        tabLayout.setupWithViewPager(vpPager);
        vpPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {}

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

            @Override
            public void onPageScrollStateChanged(int state) {}
        });

        backBtn = view.findViewById(R.id.back_button);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProfileFragment fragment = new ProfileFragment();
                getFragmentManager().beginTransaction().replace(R.id.container1 , fragment).commit();
            }
        });

        drawer2 = view.findViewById(R.id.drawerLayout2);
        final NavigationView navigationView = view.findViewById(R.id.nav_view2);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(MyBillsFragment.this.getActivity(), drawer2,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer2.addDrawerListener(toggle);
        toggle.syncState();

        menuBtn = (Button) view.findViewById(R.id.menuBtn2);
        menuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawer2.openDrawer(Gravity.LEFT);
            }
        });
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull final MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.itemA2) {
            Toast.makeText(MyBillsFragment.this.getActivity(), "Share this Application to support us", Toast.LENGTH_SHORT).show();
        }
        drawer2.closeDrawer(GravityCompat.START);
        return true;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return  inflater.inflate(R.layout.personal_bills_fragment, container , false);
    }
}