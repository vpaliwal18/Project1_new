package com.billing.shopping.model;

import com.billing.util.Formatter;

import java.util.Date;
import java.util.HashMap;

public class Invoice
{
    private long invoiceNumber;
    private HashMap<Product,Integer> productList;
    Date invoiceDate;
    double invoiceTotal;
    double taxTotal;

    public long getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(long invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public HashMap<Product, Integer> getProductList() {
        return productList;
    }

    public void setProductList(HashMap<Product, Integer> productList) {
        this.productList = productList;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public double getInvoiceTotal() {
        return Formatter.getDecimalFormat(invoiceTotal);
    }

    public void setInvoiceTotal(double invoiceTotal) {
        this.invoiceTotal = invoiceTotal;
    }

    public double getTaxTotal() {
        return Formatter.getDecimalFormat(taxTotal);
    }

    public void setTaxTotal(double taxTotal) {
        this.taxTotal = taxTotal;
    }

    public void addItem(Product p, int qty)
    {
        if (getProductList()==null)
        {
            HashMap<Product, Integer> m = new HashMap();
            setProductList(m);
        }
        if (getProductList().containsKey(p))
        {
            int totalQty= getProductList().get(p) + qty;
            getProductList().put(p,qty+totalQty);
            updateInvoiceAmount(p,totalQty);
        }
        else
        {
            getProductList().put(p,qty);
            updateInvoiceAmount(p,qty);
        }
    }
    private void updateInvoiceAmount (Product p, int totalQty)
    {
        setInvoiceTotal(getInvoiceTotal() + (p.getPrice() * p.getDiscount() * totalQty));
        setTaxTotal(getTaxTotal() + (p.getPrice() * totalQty * (p.getProductCategory().getTaxPercentage())));
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "Invoice Number=" + invoiceNumber +
                ", productList=" + productList +
                ", invoiceDate=" + invoiceDate +
                ", invoiceTotal=" + invoiceTotal +
                ", taxTotal=" + taxTotal +
                '}';
    }
}
