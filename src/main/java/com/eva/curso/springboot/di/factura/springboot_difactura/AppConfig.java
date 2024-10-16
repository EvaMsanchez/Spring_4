package com.eva.curso.springboot.di.factura.springboot_difactura;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

import com.eva.curso.springboot.di.factura.springboot_difactura.models.Item;
import com.eva.curso.springboot.di.factura.springboot_difactura.models.Product;

@Configuration
@PropertySource(value = "classpath:data.properties", encoding = "UTF-8")
public class AppConfig 
{
    // Utilizar cuando se trabaja con componentes o librerías que no puedes modificar directamente 
    // Como una API externa o clases de una librería
    @Bean
    //@Primary
    List<Item> itemsInvoice()
    {
        // Se crean los productos
        Product p1 = new Product("Cámara Sony", 800);
        Product p2 = new Product("Bicicleta Bianchi 26", 1200);

        // Se crean los item con los productos creados y la cantidad
        List<Item> items = Arrays.asList(new Item(p1, 2), new Item(p2, 4));

        return items;
    }


    @Bean("default")
    List<Item> itemsInvoiceOffice()
    {
        // Se crean los productos
        Product p1 = new Product("Monitor Asus 24", 700);
        Product p2 = new Product("Notebook Razer", 2400);
        Product p3 = new Product("Impresora HP", 800);
        Product p4 = new Product("Escritorio Oficina", 900);

        // Se crean los item con los productos creados y la cantidad
        List<Item> items = Arrays.asList(new Item(p1, 4), new Item(p2, 6), new Item(p3, 1), new Item(p4, 4));

        return items;
    }
}
