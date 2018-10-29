package com.billing.controller;

import com.billing.service.ShoppingService;
import com.billing.shopping.model.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ShoppingController
{
    @Autowired
    private ShoppingService shoppingService;

    @GetMapping("/shopping/invoice")
    public Invoice getInvoice()
    {
        return shoppingService.generateInvoice();
    }

    @GetMapping("/shopping/locale")
    public String getInvoiceWithLocale(@RequestHeader("Accept-Language") String locale)
    {
        return shoppingService.generateInvoiceWithLocale(locale);
    }

    @GetMapping("/shopping")
    public Invoice getInvoice(@RequestParam(value="items") List<String> items) throws Exception
    {
        return shoppingService.generateInvoice(items);
    }

    @GetMapping("/shopping/jsoninput")
    public Invoice getInvoice(@RequestParam(value="items") String items) throws Exception
    {
        return shoppingService.generateInvoice(items);
    }
}
