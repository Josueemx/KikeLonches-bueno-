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
public class CarritoVO {
    
    private int OrdenID;
    private int ProductoID;
    private int Cantidad;
    private double Precio;

    public CarritoVO() {}
    
    public CarritoVO(int OrdenID, int ProductoID, int Cantidad, double Precio) {
        this.OrdenID = OrdenID;
        this.ProductoID = ProductoID;
        this.Cantidad = Cantidad;
        this.Precio = Precio;
    }
    
    public int getOrdenID() {
        return OrdenID;
    }

    public void setOrdenID(int OrdenID) {
        this.OrdenID = OrdenID;
    }

    public int getProductoID() {
        return ProductoID;
    }

    public void setProductoID(int ProductoID) {
        this.ProductoID = ProductoID;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(double Precio) {
        this.Precio = Precio;
    }
}
