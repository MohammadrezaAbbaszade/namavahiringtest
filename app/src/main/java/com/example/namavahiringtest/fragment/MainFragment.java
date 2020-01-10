package com.example.namavahiringtest.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;


import com.example.namavahiringtest.recyclerview.ItemsRecyclerView;
import com.example.namavahiringtest.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {
private RecyclerView mRecyclerView;


    public static MainFragment newInstance() {

        Bundle args = new Bundle();

        MainFragment fragment = new MainFragment();
        fragment.setArguments(args);
        return fragment;
    }
    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_main, container, false);
        mRecyclerView=view.findViewById(R.id.main_fragment_recycler_view);
        ItemsRecyclerView itemsRecyclerView=new ItemsRecyclerView(getActivity());
        mRecyclerView.setAdapter(itemsRecyclerView);
        return view;
    }


}
