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
import mx.itesm.kikelonches.vo.UsuarioVO;

/**
 *
 * @author Morales
 */
public class UsuarioDAO {
    
    private DBConnection db;
    
    public UsuarioDAO(DBConnection db){
        this.db = db;
    }
    
    public void insertUsuario(String Username, String Password, String Correo) throws SQLException{
        PreparedStatement stmnt = db.conn.prepareStatement("INSERT INTO Usuarios (Username, Password, Correo) VALUES (?,?,?);");
        stmnt.setString(1, Username);
        stmnt.setString(2, Password);
        stmnt.setString(3, Correo);
        stmnt.executeUpdate();
        stmnt.close();
    }
    
    public void insertUsuario(UsuarioVO usuario) throws SQLException{
        PreparedStatement stmnt = db.conn.prepareStatement("INSERT INTO Usuarios (Username, Password, Correo) VALUES (?,?,?);");
        stmnt.setString(1, usuario.getUsername());
        stmnt.setString(2, usuario.getPassword());
        stmnt.setString(3, usuario.getCorreo());
        stmnt.executeUpdate();
        stmnt.close();
    }
    
    public UsuarioVO getUsuarioByID(int ID) throws SQLException{
        PreparedStatement ps = db.conn.prepareStatement("SELECT * FROM Usuarios where UsuarioID = ?;");
        ps.setInt(1, ID);
        ResultSet rs = ps.executeQuery();
        UsuarioVO usuario;
        if(rs.next())
            usuario = new UsuarioVO(ID, rs.getString(2), rs.getString(3), rs.getString(4));
        else
            usuario = null;
        ps.close();
        rs.close();
        return usuario;
    }
    
    public UsuarioVO getUsuarioByCorreo(String Correo) throws SQLException{
        PreparedStatement ps = db.conn.prepareStatement("SELECT * FROM Usuarios where Correo = ?;");
        ps.setString(1, Correo);
        ResultSet rs = ps.executeQuery();
        UsuarioVO usuario;
        if(rs.next())
            usuario = new UsuarioVO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
        else
            usuario = null;
        ps.close();
        rs.close();
        return usuario;
    }
    
    public UsuarioVO getUsuarioByUsernameAndPassword(String Username, String Password) throws SQLException{
        PreparedStatement ps = db.conn.prepareStatement("SELECT * FROM Usuarios where Username = ? and Password = ?;");
        ps.setString(1, Username);
        ps.setString(2, Password);
        ResultSet rs = ps.executeQuery();
        UsuarioVO usuario;
        if(rs.next())
            usuario = new UsuarioVO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
        else
            usuario = null;
        ps.close();
        rs.close();
        return usuario;
    }
    
    public void deleteUsuarioByID(int ID) throws SQLException{
        PreparedStatement preparedStmt = db.conn.prepareStatement("delete from Usuarios where UsuarioID = ?;");
        preparedStmt.setInt(1, ID);
        preparedStmt.executeUpdate();
        preparedStmt.close();
    }
            
    public void updateUsuarioById(int ID, String Username, String Password, String Correo) throws SQLException{
        PreparedStatement preparedStmt = db.conn.prepareStatement("UPDATE Usuarios "
                                                            +     "SET Username = ?, Password = ?, Correo = ?"
                                                            +     "WHERE UsuarioID = ?;");
        preparedStmt.setString(1, Username);
        preparedStmt.setString(2, Password);
        preparedStmt.setString(3, Correo);
        preparedStmt.setInt(4, ID);
        preparedStmt.executeUpdate();
        preparedStmt.close();
    }
    
    public void setRoltoUsuarioByID(int UsuarioID, int RolID) throws SQLException{
        PreparedStatement stmnt = db.conn.prepareStatement("INSERT INTO RolUsuario (UsuarioID, RolID) VALUES (?,?);");
        stmnt.setInt(1, UsuarioID);
        stmnt.setInt(2, RolID);
        stmnt.executeUpdate();
        stmnt.close();
    }
    
    public void deleteRolFromUsuarioByID(int UsuarioID, int RolID) throws SQLException{
        PreparedStatement stmnt = db.conn.prepareStatement("delete from RolUsuario where UsuarioID = ? and RolID = ?;");
        stmnt.setInt(1, UsuarioID);
        stmnt.setInt(2, RolID);
        stmnt.executeUpdate();
        stmnt.close();
    }
    
    public List getUsuariosByRolID(int RolID) throws SQLException{
        List<UsuarioVO> list = new ArrayList<UsuarioVO>();
        PreparedStatement ps = db.conn.prepareStatement("select Usuarios.UsuarioID, Usuarios.Username, Usuarios.Password, Usuarios.Correo from Usuarios join RolUsuario on Usuarios.UsuarioID = RolUsuario.UsuarioID where RolID = ?;");
        ps.setInt(1, RolID);
        ResultSet rs = ps.executeQuery();
        while (rs.next())     
            list.add(new UsuarioVO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
        rs.close();
        ps.close();
        return list;
    }
    
    public List getAllUsuarios() throws SQLException{
        List<UsuarioVO> list = new ArrayList<UsuarioVO>();
        PreparedStatement ps = db.conn.prepareStatement("select * from Usuarios;");
        ResultSet rs = ps.executeQuery();
        while (rs.next())     
            list.add(new UsuarioVO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
        rs.close();
        ps.close();
        return list;
    }
    
    public int getIdByEmail(String Correo) throws SQLException{
        PreparedStatement stmnt = db.conn.prepareStatement("select Usuarios.UsuarioID FROM Usuarios where Correo = ?;");
        stmnt.setString(1, Correo);
        ResultSet rs = stmnt.executeQuery();
        UsuarioVO usuario;
        if(rs.next())
            usuario = new UsuarioVO(rs.getInt(1), rs.getString(2), rs.getString(3), Correo);
        else
            usuario = null;
        stmnt.close();
        rs.close();
        return usuario.getUsuarioID();
    }
}
