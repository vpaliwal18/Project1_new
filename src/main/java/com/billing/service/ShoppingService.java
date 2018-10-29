package com.billing.service;

import com.billing.dao.ProductDao;
import com.billing.dao.TaxCategoryDao;
import com.billing.shopping.model.Invoice;
import com.billing.shopping.model.Product;
import com.billing.shopping.model.TaxCategory;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class ShoppingService
{
    @Autowired
    TaxCategoryDao taxCategoryDao;

    @Autowired
    ProductDao productDao;

    public Invoice generateInvoice()
    {
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

        Invoice inv = new Invoice();
        inv.setInvoiceDate(new Date());
        inv.setInvoiceNumber(1);
        inv.addItem(p3,10);
        inv.addItem(p2,2);
        inv.addItem(p9,7);
        inv.addItem(p8,99);

        return inv;
    }

    public String generateInvoiceWithLocale(String locale)
    {
        Locale l = new Locale(locale);
        ResourceBundle bundle = ResourceBundle.getBundle("Messages", l);
        return generateInvoice().toString().replaceAll("Invoice",bundle.getString("Invoice"));
    }
    public Invoice generateInvoice(List<String> inputs) throws Exception
    {
        Invoice inv = new Invoice();
        inv.setInvoiceDate(new Date());
        for (String products : inputs)
        {
            int qty =0;
            if (products.indexOf(":")>0)
            {
                Product p =productDao.getProductByName(products.split(":")[0]);
                if (p==null)
                {
                    throw new Exception();
                }
                qty= Integer.parseInt(products.split(":")[1]);
                inv.addItem(p,qty);
            }
            else
            {
                System.out.println("product does not exist");
            }

        }
        return inv;
    }


    public Invoice generateInvoice(String inputItems) throws Exception
    {
        Invoice inv = new Invoice();
        inv.setInvoiceDate(new Date());
        Map<String,Integer> map= readJsonWithObjectMapper(inputItems);
        Set teamSet= map.keySet();
        Iterator<String> iter = teamSet.iterator();
        while (iter.hasNext())
        {
            String pName = iter.next();
            Product p =productDao.getProductByName(pName);
            if (p==null)
            {
                throw new Exception();
            }
            inv.addItem(p,map.get(pName));
        }
        return inv;
    }
    public Map<String,Integer> readJsonWithObjectMapper(String inputs) throws Exception
    {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(inputs, Map.class);
    }
}
