package com.billing.dao;

import com.billing.shopping.model.TaxCategory;
import org.springframework.stereotype.Component;

@Component
public class TaxCategoryDao
{
    // this would come from database, keeping static as of now
    public TaxCategory getTaxCategoryByTaxRate(int i) {
        if (i==20)
        {
            return new TaxCategory(20);
        }
        else if (i==10)
        {
            return new TaxCategory(10);
        }
        else if (i==0)
        {
            return new TaxCategory(0);
        }
        else
        {
            return new TaxCategory(0);
        }
    }
}
