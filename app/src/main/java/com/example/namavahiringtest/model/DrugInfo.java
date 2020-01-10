package com.example.namavahiringtest.model;

public class DrugInfo {
    private String mDrugName;
    private String mDetailDrug;
    private String mDrugPrice;

    public DrugInfo(String drugName, String detailDrug, String drugPrice) {
        mDrugName = drugName;
        mDetailDrug = detailDrug;
        mDrugPrice = drugPrice;
    }

    public String getDrugName() {
        return mDrugName;
    }

    public void setDrugName(String drugName) {
        mDrugName = drugName;
    }

    public String getDetailDrug() {
        return mDetailDrug;
    }

    public void setDetailDrug(String detailDrug) {
        mDetailDrug = detailDrug;
    }

    public String getDrugPrice() {
        return mDrugPrice;
    }

    public void setDrugPrice(String drugPrice) {
        mDrugPrice = drugPrice;
    }
}
