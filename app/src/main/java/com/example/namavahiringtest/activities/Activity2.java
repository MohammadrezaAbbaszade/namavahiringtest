package com.example.namavahiringtest.activities;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.namavahiringtest.R;

public class Activity2 extends AppCompatActivity {
    private static final String DRUG_DETAILS = "com.example.namavahiringtest.activities.drugDetails";
    public static final String POSITION = "com.example.namavahiringtest.activities.position";
    private TextView mTextView;
    private ImageView mBackArrow;
    private TextView mCounterTextView;
    private TextView mDrugNameTextView;
    private TextView mDrugDetailTextView;
    private ImageView mImageView;
    private Animation mAnimation;
    private ImageButton mAddImageButton;
    private ImageButton mDecImageButton;
    private String[] mDrugsDetails;
    private int counter = 0;
    private int position = 0;

    public static Intent newIntent(Context context, String[] drugDetails, int position) {
        Intent intent = new Intent(context, Activity2.class);
        intent.putExtra(DRUG_DETAILS, drugDetails);
        intent.putExtra(POSITION, position);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        init();

        position = getIntent().getIntExtra(POSITION, 0);
        if (position % 3 == 0)
            mImageView.setImageResource(R.drawable.trending_gradient_shape_00);
        else if (position % 3 == 1)
            mImageView.setImageResource(R.drawable.trending_gradient_shape_01);
        else
            mImageView.setImageResource(R.drawable.trending_gradient_shape_02);

        mDrugsDetails = getIntent().getStringArrayExtra(DRUG_DETAILS);
        mDrugNameTextView.setText(mDrugsDetails[0]);
        mDrugDetailTextView.setText(mDrugsDetails[1]);
        mTextView.setText(mDrugsDetails[2]);
        mAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_out);
        mAddImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;
                mCounterTextView.setText(counter + "");
            }
        });
        mDecImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (counter != 0) {
                    counter--;
                    mCounterTextView.setText(counter + "");
                }
            }
        });
        mBackArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Activity2.super.onBackPressed();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        mTextView.startAnimation(mAnimation);
        supportFinishAfterTransition();
    }

    private void init() {
        mImageView = findViewById(R.id.imageView);
        mDrugDetailTextView = findViewById(R.id.drug_detail_text_view);
        mAddImageButton = findViewById(R.id.add_imageButton2);
        mDecImageButton = findViewById(R.id.dec_imageButton);
        mTextView = findViewById(R.id.price);
        mCounterTextView = findViewById(R.id.counter_textView);
        mDrugNameTextView = findViewById(R.id.drug_name_textView);
        mBackArrow=findViewById(R.id.back_arrow_image_view);
    }
}
