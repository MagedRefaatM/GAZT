package com.me.zakat;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import androidx.fragment.app.Fragment;

import android.content.Intent;

import android.graphics.Color;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.TextView;
import android.widget.CheckBox;

public class RateFragment extends Fragment {

    private ImageView Star1;
    private ImageView Star2;
    private ImageView Star3;
    private ImageView Star4;
    private ImageView Star5;
    private ImageView ExpressionIV;

    private TextView WarnTv;
    private TextView starFiveTv;

    private CheckBox DevilCheck;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        Star1 = (ImageView) view.findViewById(R.id.oneStarIV);
        Star1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Star1.setImageResource(R.drawable.img7);
                ExpressionIV.setBackground(null);
                ExpressionIV.setImageResource(R.drawable.img11);
                DevilCheck.setChecked(true);
            }
        });

        Star2 = (ImageView) view.findViewById(R.id.twoStarsIV);
        Star2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Star1.setImageResource(R.drawable.img7);
                Star2.setImageResource(R.drawable.img7);
                ExpressionIV.setBackground(null);
                ExpressionIV.setImageResource(R.drawable.img12);
                DevilCheck.setChecked(true);
            }
        });

        Star3 = (ImageView) view.findViewById(R.id.threeStarsIV);
        Star3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Star1.setImageResource(R.drawable.img7);
                Star2.setImageResource(R.drawable.img7);
                Star3.setImageResource(R.drawable.img7);
                ExpressionIV.setBackground(null);
                ExpressionIV.setImageResource(R.drawable.img13);
                DevilCheck.setChecked(true);
            }
        });

        Star4 = (ImageView) view.findViewById(R.id.fourStarsIV);
        Star4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Star1.setImageResource(R.drawable.img7);
                Star2.setImageResource(R.drawable.img7);
                Star3.setImageResource(R.drawable.img7);
                Star4.setImageResource(R.drawable.img7);
                ExpressionIV.setBackground(null);
                ExpressionIV.setImageResource(R.drawable.img14);
                DevilCheck.setChecked(true);
            }
        });

        Star5 = (ImageView) view.findViewById(R.id.fiveStarsIV);
        Star5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Star1.setImageResource(R.drawable.img7);
                Star2.setImageResource(R.drawable.img7);
                Star3.setImageResource(R.drawable.img7);
                Star4.setImageResource(R.drawable.img7);
                Star5.setImageResource(R.drawable.img7);
                ExpressionIV.setBackground(null);
                ExpressionIV.setImageResource(R.drawable.img15);
                DevilCheck.setChecked(true);
            }
        });

        ExpressionIV = (ImageView) view.findViewById(R.id.faceExpressionIV);

        TextView logoutTV = (TextView) view.findViewById(R.id.logoutTv);
        logoutTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (DevilCheck.isChecked()){
                    Intent e = new Intent(RateFragment.this.getActivity() , MainActivity.class);
                    startActivity(e);
                }
                else if (!DevilCheck.isChecked())
                {
                    WarnTv.setVisibility(View.VISIBLE);
                    WarnTv.setTextColor(Color.RED);
                    WarnTv.setText("Give us a feedBack first");
                }
            }
        });

        WarnTv = (TextView) view.findViewById(R.id.warningTv);

        starFiveTv = (TextView) view.findViewById(R.id.fiveTv);
        starFiveTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Star1.setImageResource(R.drawable.img7);
                Star2.setImageResource(R.drawable.img7);
                Star3.setImageResource(R.drawable.img7);
                Star4.setImageResource(R.drawable.img7);
                Star5.setImageResource(R.drawable.img7);
                ExpressionIV.setBackground(null);
                ExpressionIV.setImageResource(R.drawable.img15);
                DevilCheck.setChecked(true);
            }
        });

        DevilCheck = (CheckBox) view.findViewById(R.id.demon);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.rate_fragment,container,false);
    }
}