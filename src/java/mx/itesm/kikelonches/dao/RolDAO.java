/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.kikelonches.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mx.itesm.kikelonches.util.DBConnection;
import mx.itesm.kikelonches.vo.RolVO;

/**
 *
 * @author Morales
 */
public class RolDAO {
    
    private DBConnection db;
    
    public RolDAO(DBConnection db){
        this.db = db;
    }
    
    public void insertRol(String Nombre, String Descripcion) throws SQLException{
        PreparedStatement stmnt = db.conn.prepareStatement("INSERT INTO Roles (Nombre, Descripcion) VALUES (?,?);");
        stmnt.setString(1, Nombre);
        stmnt.setString(2, Descripcion);
        stmnt.executeUpdate();
        stmnt.close();
    }
    
    public void insertRol(RolVO rol) throws SQLException{
        PreparedStatement stmnt = db.conn.prepareStatement("INSERT INTO Roles (Nombre, Descripcion) VALUES (?,?);");
        stmnt.setString(1, rol.getNombre());
        stmnt.setString(2, rol.getDescripcion());
        stmnt.executeUpdate();
        stmnt.close();
    }
    
    public RolVO getRolByID(int ID) throws SQLException{
        PreparedStatement ps = db.conn.prepareStatement("SELECT * FROM Roles where RolID = ?;");
        ps.setInt(1, ID);
        ResultSet rs = ps.executeQuery();
        RolVO rol;
        if(rs.next())
            rol = new RolVO(ID, rs.getString(2), rs.getString(3));
        else
            rol = null;
        ps.close();
        rs.close();
        return rol;
    }
    
    public RolVO getRolByNombre(String Nombre) throws SQLException{
        PreparedStatement ps = db.conn.prepareStatement("SELECT * FROM Roles where Nombre = ?;");
        ps.setString(1, Nombre);
        ResultSet rs = ps.executeQuery();
        RolVO rol;
        if(rs.next())
            rol = new RolVO(rs.getInt(1), Nombre, rs.getString(3));
        else
            rol = null;
        ps.close();
        rs.close();
        return rol;
    }
    
    public void deleteRolByID(int ID) throws SQLException{
        PreparedStatement preparedStmt = db.conn.prepareStatement("delete from Roles where RolID = ?;");
        preparedStmt.setInt(1, ID);
        preparedStmt.executeUpdate();
        preparedStmt.close();
    }
    
    public void updateRolByID(int ID, String Nombre, String Descripcion) throws SQLException{
        PreparedStatement preparedStmt = db.conn.prepareStatement("UPDATE Roles "
                                                                + "SET Nombre = ?, Descripcion = ?"
                                                                + "WHERE RolID = ?;");
        preparedStmt.setString(1, Nombre);
        preparedStmt.setString(2, Descripcion);
        preparedStmt.setInt(3, ID);
        preparedStmt.executeUpdate();
        preparedStmt.close();
    }
    
    public List getRolesFromUsuarioByID(int UsuarioID) throws SQLException{
        List<RolVO> list = new ArrayList<RolVO>();
        PreparedStatement ps = db.conn.prepareStatement("select Roles.RolID, Roles.Nombre, Roles.Descripcion from Roles join RolUsuario on Roles.RolID = RolUsuario.RolID where UsuarioID = ?;");
        ps.setInt(1, UsuarioID);
        ResultSet rs = ps.executeQuery();
        while (rs.next())     
            list.add(new RolVO(rs.getInt(1), rs.getString(2), rs.getString(3)));
        rs.close();
        ps.close();
        return list;
    }
    
    public List getAllRoles() throws SQLException{
        List<RolVO> list = new ArrayList<RolVO>();
        PreparedStatement ps = db.conn.prepareStatement("select * form Roles;");
        ResultSet rs = ps.executeQuery();
        while (rs.next())     
            list.add(new RolVO(rs.getInt(1), rs.getString(2), rs.getString(3)));
        rs.close();
        ps.close();
        return list;
    }
}
