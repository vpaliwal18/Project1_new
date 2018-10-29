package com.billing.dao;

import com.billing.shopping.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class ProductDao
{
    // this would come from database, keeping static as of now

    //TaxCategoryDao would not required when data would come from database
    


    static Map<String,Product> pList;
    static {
        TaxCategoryDao taxCategoryDao=new TaxCategoryDao();
        Product p1= new Product("Item1",10.00,taxCategoryDao.getTaxCategoryByTaxRate(20));
        Product p2= new Product("Item2",99.99,taxCategoryDao.getTaxCategoryByTaxRate(10));
        Product p3= new Product("Item3",55.50,taxCategoryDao.getTaxCategoryByTaxRate(0));
        Product p4= new Product("Item4",200.00,taxCategoryDao.getTaxCategoryByTaxRate(20));
        Product p5= new Product("Item5",999.00,taxCategoryDao.getTaxCategoryByTaxRate(10));
        Product p6= new Product("Item6",49.99,taxCategoryDao.getTaxCategoryByTaxRate(0));
        Product p7= new Product("Item7",100.00,taxCategoryDao.getTaxCategoryByTaxRate(20));
        Product p8= new Product("Item8",0.99,taxCategoryDao.getTaxCategoryByTaxRate(10));
        Product p9= new Product("Item9",155.00,taxCategoryDao.getTaxCategoryByTaxRate(0));
        Product p10= new Product("Item10",10.75,taxCategoryDao.getTaxCategoryByTaxRate(0));

        pList = new HashMap<>();
        pList.put("Item1",p1);
        pList.put("Item2",p2);
        pList.put("Item3",p3);
        pList.put("Item4",p4);
        pList.put("Item5",p5);
        pList.put("Item6",p6);
        pList.put("Item7",p7);
        pList.put("Item8",p8);
        pList.put("Item9",p9);
        pList.put("Item10",p10);
    }

    public List<Product> getProductList()
    {
        //dummy return
        return null;
    }
    public Product getProductByCode(int i)
    {
        //dummy return
        return pList.get("Item1");
    }
    public Product getProductByName(String name)
    {
        return pList.containsKey(name)?pList.get(name):null;
    }
    public boolean isProductExist(String name)
    {
        if (pList.containsKey(name))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
