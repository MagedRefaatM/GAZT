package com.me.zakat;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MainFragment extends Fragment {

    private Button entryBtn;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_fragment , container ,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        entryBtn = view.findViewById(R.id.enter_btn);
        entryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IdentityCodeFragment fragment = new IdentityCodeFragment();
                ((getActivity())).getSupportFragmentManager().beginTransaction().replace(R.id.container1 , fragment).addToBackStack(null).commit();;
            }
        });
    }
}