package com.me.zakat;

import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class IdentityCodeFragment extends Fragment {

    private EditText editText1;
    private EditText editText2;
    private EditText editText3;
    private EditText editText4;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.identitiy_code_fragment ,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        editText1 = view.findViewById(R.id.edit_text1);
        editText1.setTransformationMethod(new AsteriskNumberClass());
        editText1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (editText1.getText().toString().trim().length() == 1)
                {
                    editText2.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        editText2 = view.findViewById(R.id.edit_text2);
        editText2.setTransformationMethod(new AsteriskNumberClass());
        editText2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (editText2.getText().toString().trim().length() == 1)
                {
                    editText3.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        editText3 = view.findViewById(R.id.edit_text3);
        editText3.setTransformationMethod(new AsteriskNumberClass());
        editText3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (editText3.getText().toString().trim().length() == 1)
                {
                    editText4.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        editText4 = view.findViewById(R.id.edit_text4);
        editText4.setTransformationMethod(new AsteriskNumberClass());
        editText4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (editText1.length()!=0 && editText2.length()!=0 && editText3.length()!=0){
                            ProfileFragment fragment = new ProfileFragment();
                            getFragmentManager().beginTransaction().replace(R.id.container1 , fragment).addToBackStack(null).commit();
                        }
                    }
                }, 1000);
            }
        });
    }
}