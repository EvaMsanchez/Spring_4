package com.eva.curso.springboot.di.factura.springboot_difactura.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eva.curso.springboot.di.factura.springboot_difactura.models.Client;
import com.eva.curso.springboot.di.factura.springboot_difactura.models.Invoice;

@RestController
@RequestMapping("/invoices")
public class InvoiceController 
{
    @Autowired
    private Invoice invoice;

    @GetMapping("/show")
    public Invoice show()
    {
        // Esto se hace para evitar el proxy al poner la anotación @RequestScope (para el tema de la inmutabilidad)
        Invoice i = new Invoice();
        
        Client c = new Client();
        c.setName(invoice.getClient().getName());
        c.setLastname(invoice.getClient().getLastname());

        i.setClient(c);
        i.setDescription(invoice.getDescription());
        i.setItems(invoice.getItems());

        return i;
    }
}
