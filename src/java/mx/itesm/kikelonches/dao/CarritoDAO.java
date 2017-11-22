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
import mx.itesm.kikelonches.vo.CarritoVO;

/**
 *
 * @author Morales
 */
public class CarritoDAO {
    
    private DBConnection db;
    
    public CarritoDAO(DBConnection db){
        this.db = db;
    }
    
    public void insertCarrito(int OrdenID, int ProductoID, int Cantidad, double Precio) throws SQLException{
        PreparedStatement stmnt = db.conn.prepareStatement("INSERT INTO Carrito (OrdenID, ProductoID, Cantidad, Precio) VALUES (?,?,?,?);");
        stmnt.setInt(1, OrdenID);
        stmnt.setInt(2, ProductoID);
        stmnt.setInt(3, Cantidad);
        stmnt.setDouble(4, Precio);
        stmnt.executeUpdate();
        stmnt.close();
    }
    
    public void insertCarrito(CarritoVO carrito) throws SQLException{
        PreparedStatement stmnt = db.conn.prepareStatement("INSERT INTO Carrito (OrdenID, ProductoID, Cantidad, Precio) VALUES (?,?,?,?);");
        stmnt.setInt(1, carrito.getOrdenID());
        stmnt.setInt(2, carrito.getProductoID());
        stmnt.setInt(3, carrito.getCantidad());
        stmnt.setDouble(4, carrito.getPrecio());
        stmnt.executeUpdate();
        stmnt.close();
    }
    
    public void deleteCarritoByOrdenID(int OrdenID) throws SQLException{
        PreparedStatement preparedStmt = db.conn.prepareStatement("delete from Carrito where OrdenID = ?;");
        preparedStmt.setInt(1, OrdenID);
        preparedStmt.executeUpdate();
        preparedStmt.close();
    }
    
    public void deleteCarritoByOrdenIDAndProductoID(int OrdenID, int ProductoID) throws SQLException{
        PreparedStatement preparedStmt = db.conn.prepareStatement("delete from Carrito where OrdenID = ? and ProductoID = ?;");
        preparedStmt.setInt(1, OrdenID);
        preparedStmt.setInt(2, ProductoID);
        preparedStmt.executeUpdate();
        preparedStmt.close();
    }
    
    public void updateCarritoByOrdenIDAndProductoID(int OrdenID, int ProductoID, int Cantidad, double Precio) throws SQLException{
        PreparedStatement preparedStmt = db.conn.prepareStatement("UPDATE Carrito "
                                                                + "SET Cantidad = ?, Precio = ?"
                                                                + "WHERE OrdenID = ? and ProductoID = ?;");
        preparedStmt.setInt(1, Cantidad);
        preparedStmt.setDouble(2, Precio);
        preparedStmt.setInt(3, OrdenID);
        preparedStmt.setInt(4, ProductoID);
        preparedStmt.executeUpdate();
        preparedStmt.close();
    }
    
    public List getFullCarritoByOrdenID(int OrdenID) throws SQLException{
        List<CarritoVO> list = new ArrayList<CarritoVO>();
        PreparedStatement ps = db.conn.prepareStatement("select * from Carrito where OrdenID = ?;");
        ps.setInt(1, OrdenID);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) 
            list.add(new CarritoVO(OrdenID, rs.getInt(2), rs.getInt(3), rs.getDouble(4)));
        rs.close();
        ps.close();
        return list;
    }
}
