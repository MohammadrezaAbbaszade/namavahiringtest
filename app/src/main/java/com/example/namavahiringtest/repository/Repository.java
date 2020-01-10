package com.example.namavahiringtest.repository;

import com.example.namavahiringtest.model.DrugInfo;

import java.util.ArrayList;
import java.util.List;

public class Repository {
    private List<String> mTitlesLists = new ArrayList<>();
    private List<String> mPricesLists = new ArrayList<>();
    private List<DrugInfo> mDrugDetails = new ArrayList<>();
    private static Repository mRepository;

    public static Repository getInstance() {
        if (mRepository == null) {
            mRepository = new Repository();
        }
        return mRepository;
    }

    {

        mTitlesLists.add("HOME");
        mTitlesLists.add("OFFICE");
        mTitlesLists.add("HOLIDAY");
        mTitlesLists.add("ACTIVITIES");
        mTitlesLists.add("TASKS");
        mTitlesLists.add("DUTIES");
    }

    {
        mDrugDetails.add(new DrugInfo("Humira", "(Adalimumab)", "70.60 $"));
        mDrugDetails.add(new DrugInfo("Enbrel", "(Etanercept)", "35.80 $"));
        mDrugDetails.add(new DrugInfo("Remicade", "(Infliximab)", "42.10 $"));
        mDrugDetails.add(new DrugInfo("Avastin", "(Bevacizumab)", "10.50 $"));
        mDrugDetails.add(new DrugInfo("Lantus", "(Ilustriden)", "37.50 $"));
        mDrugDetails.add(new DrugInfo("Ativan", "(Etanercept)", "55.00 $"));
        mDrugDetails.add(new DrugInfo("Adderall", "(Adalimumab)", "60.50 $"));
    }

    public List<String> getTitlesLists() {
        return mTitlesLists;
    }

    public List<String> getPricesLists() {
        return mPricesLists;
    }

    public List<DrugInfo> getDrugDetails() {
        return mDrugDetails;
    }
}
