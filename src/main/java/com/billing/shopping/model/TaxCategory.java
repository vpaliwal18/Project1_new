package com.billing.shopping.model;

public class TaxCategory
{

    public TaxCategory(double tax)
    {
        this.basisPoint=tax;
    }

    private int id;
    private double basisPoint;

    public double getBasisPoint() {
        return basisPoint;
    }

    public void setBasisPoint(double basisPoint) {
        this.basisPoint = basisPoint;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTaxPercentage()
    {
        if (basisPoint<=0)
        {
            return 0;
        }
        else
        {
            return basisPoint / 100;
        }

    }

    public void setTaxPercentage(double taxPercentage) {
        this.basisPoint = taxPercentage;
    }
}
