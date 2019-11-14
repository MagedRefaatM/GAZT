package com.me.zakat;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ViewPagerFragments extends Fragment {

    private String[] texts = {"مدفوعة" , "غير مدفوعة" , "مسددة جزئيا"};

    private RecyclerView recyclerView;
    private RecyclerView.Adapter recyclerViewAdapter;
    private RecyclerView.LayoutManager recyclerViewLayoutManager;

    static ViewPagerFragments newInstance(int page, String title) {
        ViewPagerFragments fragmentOne = new ViewPagerFragments();
        Bundle args = new Bundle();
        args.putInt("someInt", page);
        args.putString("someTitle", title);
        fragmentOne.setArguments(args);
        return fragmentOne;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        return inflater.inflate(R.layout.view_pager_fragment , container , false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerViewAdapter = new MyBillRecyclerAdapter(texts);
        recyclerViewLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(recyclerViewLayoutManager);
        recyclerView.setAdapter(recyclerViewAdapter);
    }
}