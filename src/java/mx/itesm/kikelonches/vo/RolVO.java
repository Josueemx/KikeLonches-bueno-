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
public class RolVO {

    private int RolID;
    private String Nombre;
    private String Descripcion;
    
    public RolVO() {}
    
    public RolVO(int RolID, String Nombre, String Descripcion) {
        this.RolID = RolID;
        this.Nombre = Nombre;
        this.Descripcion = Descripcion;
    }

    public int getRolID() {
        return RolID;
    }

    public void setRolID(int RolID) {
        this.RolID = RolID;
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
}
