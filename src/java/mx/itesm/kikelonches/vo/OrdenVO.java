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
public class OrdenVO {
    
    private int OrdenID;
    private int UsuarioID;
    private String Fecha;
    private double PrecioFinal;

    public OrdenVO(){}
    
    public OrdenVO(int OrdenID, int UsuarioID, String Fecha, double PrecioFinal) {
        this.OrdenID = OrdenID;
        this.UsuarioID = UsuarioID;
        this.Fecha = Fecha;
        this.PrecioFinal = PrecioFinal;
    }

    public int getOrdenID() {
        return OrdenID;
    }

    public void setOrdenID(int OrdenID) {
        this.OrdenID = OrdenID;
    }

    public int getUsuarioID() {
        return UsuarioID;
    }

    public void setUsuarioID(int UsuarioID) {
        this.UsuarioID = UsuarioID;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public double getPrecioFinal() {
        return PrecioFinal;
    }

    public void setPrecioFinal(double PrecioFinal) {
        this.PrecioFinal = PrecioFinal;
    }
}
