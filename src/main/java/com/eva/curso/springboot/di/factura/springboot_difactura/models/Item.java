package com.eva.curso.springboot.di.factura.springboot_difactura.models;

public class Item 
{
    private Product product;
    private Integer quantity;

    public Item() {}

    public Item(Product product, Integer quantity) {
        this.product = product;
        this.quantity = quantity;
    }


    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }


    /* Jackson detecta automáticamente este método porque sigue la convención de los "getters" (métodos que empiezan con get). 
    tratando cualquier método que siga esta convención como un campo que debería ser serializado en el JSON resultante.
    Interpretándolo como un campo adicional. */
    public int getImporte()
    {
        return quantity*product.getPrice();
    }

}
