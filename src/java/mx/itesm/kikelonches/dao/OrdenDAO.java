/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.kikelonches.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import mx.itesm.kikelonches.util.DBConnection;
import mx.itesm.kikelonches.vo.OrdenVO;

/**
 *
 * @author Morales
 */
public class OrdenDAO {
    
    private DBConnection db;
    
    public OrdenDAO(DBConnection db){
        this.db = db;
    }
    
    public void insertOrden(int UsuarioID, String Fecha, double PrecioFinal) throws SQLException{
        PreparedStatement stmnt = db.conn.prepareStatement("INSERT INTO Orden (UsuarioID, Fecha, PrecioFinal) VALUES (?,?,?);");
        stmnt.setInt(1, UsuarioID);
        stmnt.setString(2, Fecha);
        stmnt.setDouble(3, PrecioFinal);
        stmnt.executeUpdate();
        stmnt.close();
    }
    
    public void insertOrden(OrdenVO orden) throws SQLException{
        PreparedStatement stmnt = db.conn.prepareStatement("INSERT INTO Orden (UsuarioID, Fecha, PrecioFinal) VALUES (?,?,?);");
        stmnt.setInt(1, orden.getUsuarioID());
        stmnt.setString(2, orden.getFecha());
        stmnt.setDouble(3, orden.getPrecioFinal());
        stmnt.executeUpdate();
        stmnt.close();
    }
    
    public OrdenVO getOrdenByID(int ID) throws SQLException{
        PreparedStatement ps = db.conn.prepareStatement("SELECT * FROM Orden where OrdenID = ?;");
        ps.setInt(1, ID);
        ResultSet rs = ps.executeQuery();
        OrdenVO orden;
        if(rs.next())
            orden = new OrdenVO(ID, rs.getInt(2), rs.getString(3), rs.getDouble(4));
        else
            orden = null;
        ps.close();
        rs.close();
        return orden;
    }
    
    public void deleteOrdenByID(int ID) throws SQLException{
        PreparedStatement preparedStmt = db.conn.prepareStatement("delete from Orden where OrdenID = ?;");
        preparedStmt.setInt(1, ID);
        preparedStmt.executeUpdate();
        preparedStmt.close();
    }
    
    public void updateOrdenByID(int ID, int UsuarioID, String Fecha, double PrecioFinal) throws SQLException{
        PreparedStatement preparedStmt = db.conn.prepareStatement("UPDATE Orden "
                                                                + "SET UsuarioID = ?, Fecha = ?, PrecioFinal = ?"
                                                                + "WHERE OrdenID = ?;");
        preparedStmt.setInt(1, UsuarioID);
        preparedStmt.setString(2, Fecha);
        preparedStmt.setDouble(3, PrecioFinal);
        preparedStmt.setInt(4, ID);
        preparedStmt.executeUpdate();
        preparedStmt.close();
    }
    
    public List getOrdenesFromUsuarioByUsuarioID(int UsuarioID) throws SQLException{
        List<OrdenVO> list = new ArrayList<OrdenVO>();
        PreparedStatement ps = db.conn.prepareStatement("select * from Orden where UsuarioID = ?;");
        ps.setInt(1, UsuarioID);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) 
            list.add(new OrdenVO(rs.getInt(1), UsuarioID, rs.getString(3), rs.getDouble(4)));
        rs.close();
        ps.close();
        return list;
    }
    
    public List getAllOrdenes() throws SQLException{
        List<OrdenVO> list = new ArrayList<OrdenVO>();
        PreparedStatement ps = db.conn.prepareStatement("select * from Orden;");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) 
            list.add(new OrdenVO(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getDouble(4)));
        rs.close();
        ps.close();
        return list;
    }

    public List getOrdenByDate(String Fecha) throws SQLException{
        List<OrdenVO> list = new ArrayList<OrdenVO>();
        PreparedStatement ps = db.conn.prepareStatement("select * from Orden where Fecha = ?;");
        ps.setString(1, Fecha);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) 
            list.add(new OrdenVO(rs.getInt(1), rs.getInt(2), Fecha, rs.getDouble(4)));
        rs.close();
        ps.close();
        return list;
    }
}
