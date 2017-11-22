/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.kikelonches.vo;

/**
 *
 * @author Morales
 */
public class ProductoVO {
    
    private int ProductoID;
    private String Nombre;
    private String Descripcion;
    private double Precio;
    private int Cantidad_Inventario;
    
    public ProductoVO(){}
    
    public ProductoVO(int ProductoID, String Nombre, String Descripcion, double Precio, int Cantidad_Inventario) {
        this.ProductoID = ProductoID;
        this.Nombre = Nombre;
        this.Descripcion = Descripcion;
        this.Precio = Precio;
        this.Cantidad_Inventario = Cantidad_Inventario;
    }

    public int getProductoID() {
        return ProductoID;
    }

    public void setProductoID(int ProductoID) {
        this.ProductoID = ProductoID;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(double Precio) {
        this.Precio = Precio;
    }

    public int getCantidad_Inventario() {
        return Cantidad_Inventario;
    }

    public void setCantidad_Inventario(int Cantidad_Inventario) {
        this.Cantidad_Inventario = Cantidad_Inventario;
    }
}
