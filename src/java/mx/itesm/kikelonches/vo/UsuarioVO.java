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
public class UsuarioVO {
    
    private int UsuarioID;
    private String Username;
    private String Password;
    private String Correo;
    
    public UsuarioVO(){}
    
    public UsuarioVO(int UsuarioID, String Username, String Password, String Correo) {
        this.UsuarioID = UsuarioID;
        this.Username = Username;
        this.Password = Password;
        this.Correo = Correo;
    }
    
    public int getUsuarioID() {
        return UsuarioID;
    }

    public void setUsuarioID(int UsuarioID) {
        this.UsuarioID = UsuarioID;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }
}
