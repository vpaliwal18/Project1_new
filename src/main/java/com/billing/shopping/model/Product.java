package com.billing.shopping.model;

import java.util.Objects;

public class Product
{
    private long productId;
    private String productName;
    private TaxCategory productCategory;
    private double price;
    private double discount;
    public Product (String name)
    {
        this.productName=name;
    }
    public Product (String name, double price, TaxCategory tax)
    {
        this.productName=name;
        this.price=price;
        this.productCategory=tax;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public TaxCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(TaxCategory productCategory) {
        this.productCategory = productCategory;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscount() {
        if (discount<=0)
        {
            discount=1;
        }
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount/100;
    }

    /*
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.price, price) == 0 &&
                Objects.equals(productName, product.productName) &&
                Objects.equals(productCategory, product.productCategory);
    }

    @Override
    public int hashCode() {

        return Objects.hash(productName, productCategory, price);
    }
    */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(productName, product.productName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(productName);
    }
}
