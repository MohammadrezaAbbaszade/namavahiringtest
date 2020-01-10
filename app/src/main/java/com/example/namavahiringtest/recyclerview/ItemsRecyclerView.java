package com.example.namavahiringtest.recyclerview;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.util.Pair;

import com.example.namavahiringtest.R;
import com.example.namavahiringtest.repository.Repository;
import com.example.namavahiringtest.activities.Activity2;
import com.example.namavahiringtest.model.DrugInfo;

import java.util.List;

public class ItemsRecyclerView extends androidx.recyclerview.widget.RecyclerView.Adapter {
    private Activity mContext;
    private View view;
    private List<DrugInfo> mDrugInfoLists;

    public ItemsRecyclerView(Activity context) {
        mDrugInfoLists = Repository.getInstance().getDrugDetails();
        mContext = context;
    }

    @NonNull
    @Override
    public ProductHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(mContext).inflate(R.layout.items, parent, false);
        ProductHolder productHolder = new ProductHolder(view);
        return productHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull androidx.recyclerview.widget.RecyclerView.ViewHolder holder, int position) {
        ProductHolder productHolder = (ProductHolder) holder;
        productHolder.bind(mDrugInfoLists.get(position));
    }


    @Override
    public int getItemCount() {
        return mDrugInfoLists.size();
    }

    public class ProductHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private ImageView mImageView;
        private TextView mPriceTextView;
        private DrugInfo mDrugInfo;
        private TextView mDrugNameTextView;
        private TextView mDrugDetailTextView;

        public ProductHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.image_item);
            mPriceTextView = itemView.findViewById(R.id.items_textview);
            mDrugNameTextView = itemView.findViewById(R.id.drug_name);
            mDrugDetailTextView = itemView.findViewById(R.id.detail_drug);
            itemView.setOnClickListener(new View.OnClickListener() {
                @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
                @Override
                public void onClick(View view) {
                    String[] mDrugDetailsForExtra = {
                            mDrugInfo.getDrugName(),
                            mDrugInfo.getDetailDrug(),
                            mDrugInfo.getDrugPrice()
                    };
                    Intent intent = Activity2.newIntent(mContext, mDrugDetailsForExtra,getAdapterPosition());
                    Pair<View, String> p1 = Pair.create((View) mImageView, "example_transition");
                    Pair<View, String> p2 = Pair.create((View) mPriceTextView, "example_textview");
                    ActivityOptionsCompat options = ActivityOptionsCompat.
                            makeSceneTransitionAnimation(mContext, p1, p2);
                    mContext.startActivity(intent, options.toBundle());
                }
            });
        }

        void bind(DrugInfo drugInfo) {
            if (getAdapterPosition() % 3 == 0)
                mImageView.setImageResource(R.drawable.trending_gradient_shape_00);
            else if(getAdapterPosition() % 3 == 1)
                mImageView.setImageResource(R.drawable.trending_gradient_shape_01);
            else
                mImageView.setImageResource(R.drawable.trending_gradient_shape_02);
            mPriceTextView.setText(drugInfo.getDrugPrice());
            mDrugDetailTextView.setText(drugInfo.getDetailDrug());
            mDrugNameTextView.setText(drugInfo.getDrugName());
            mDrugInfo = drugInfo;
        }

    }
}
