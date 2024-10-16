package com.eva.curso.springboot.di.factura.springboot_difactura.models;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
@RequestScope
//@JsonIgnoreProperties({"targetSource", "advisors"})
public class Invoice 
{
    @Autowired
    private Client client; // no importar porque está dentro del mismo package

    @Value("${invoice.description.office}")
    private String description;

    @Autowired
    @Qualifier("default")
    private List<Item> items;

    // client y description son null porque todavia no se han inyectado los componentes(no tienen valor) hasta después de instanciarse o llamar al constructor
    public Invoice()
    {
        System.out.println("Creando el componente de la factura");
        System.out.println(client);
        System.out.println(description);
    }

    // Para hacer algo después de llamar al constructor, con esta anotación ya se han inyectado los objetos y se pueden utilizar
    @PostConstruct
    public void init()
    {
        System.out.println("Creando el componente de la factura");
        client.setName(client.getName().concat(" María"));
    }

    // Para hacer una tarea antes de destruir el componente bean. Comprobar parando la aplicación pero no desde el botón, sino Ctrl+C
    @PreDestroy
    public void destroy()
    {
        System.out.println("Destruyendo el componente o bean invoice!");
    }


    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public List<Item> getItems() {
        return items;
    }
    public void setItems(List<Item> items) {
        this.items = items;
    }    


    // Total de la factura con for-each, sumando cada fila del total de cada producto*cantidad
    public int getTotal()
    {
        int total = 0;
        for (Item item : items) {
            total += item.getImporte();
        }
        
        return total;

        /* Otra forma con el for
        Iterar a través de los índices de la lista 'items'
        for (int i = 0; i < items.size(); i++) 
        {
            // Sumar el importe de cada item al total
            total = total + items.get(i).getImporte();
        } */

        /* Otra forma utilizado el api stream
        int total = items.stream()
        .map(item -> item.getImporte())
        .reduce(0, (sum, importe) -> sum + importe);
        */
    }

}
