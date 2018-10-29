package com.billing.project1;

import com.billing.controller.ShoppingController;
import com.billing.service.ShoppingService;
import com.billing.shopping.model.Invoice;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)

@WebMvcTest(value = ShoppingController.class, secure = false)

public class ShoppingControllerTest
{
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ShoppingService shoppingService;

    private Invoice mockInvoice()
    {
        Invoice inv = new Invoice();
        inv.setInvoiceDate(new Date());
        // add some product with qty
        //
        //
        //
        //
        return inv;
    }

    @Test
    public void getInvoice() throws Exception
    {
        Mockito.when(
                shoppingService.generateInvoice()
        ).thenReturn(mockInvoice());

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/shopping/invoice").accept(
                MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        System.out.println(result.getResponse());
        String expected = "{ expected JSON string will come here based }";

        JSONAssert.assertEquals(expected, result.getResponse()
                .getContentAsString(), false);

    }
}
