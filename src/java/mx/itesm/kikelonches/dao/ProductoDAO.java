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
import mx.itesm.kikelonches.vo.ProductoVO;

/**
 *
 * @author Morales
 */
public class ProductoDAO {
    
    private DBConnection db;
    
    public ProductoDAO(DBConnection db){
        this.db = db;
    }
    
    public void insertProducto(String Nombre, String Descripcion, double Precio, int Cantidad_Inventario) throws SQLException{
        PreparedStatement stmnt = db.conn.prepareStatement("INSERT INTO Productos (Nombre, Descripcion, Precio, Cantidad_Inventario) VALUES (?,?,?,?);");
        stmnt.setString(1, Nombre);
        stmnt.setString(2, Descripcion);
        stmnt.setDouble(3, Precio);
        stmnt.setInt(4, Cantidad_Inventario);
        stmnt.executeUpdate();
        stmnt.close();
    }
    
    public void insertProducto(ProductoVO producto) throws SQLException{
        PreparedStatement stmnt = db.conn.prepareStatement("INSERT INTO Productos (Nombre, Descripcion, Precio, Cantidad_Inventario) VALUES (?,?,?,?);");
        stmnt.setString(1, producto.getNombre());
        stmnt.setString(2, producto.getDescripcion());
        stmnt.setDouble(3, producto.getPrecio());
        stmnt.setInt(4, producto.getCantidad_Inventario());
        stmnt.executeUpdate();
        stmnt.close();
    }
    
    public ProductoVO getProductoByID(int ID) throws SQLException{
        PreparedStatement ps = db.conn.prepareStatement("SELECT * FROM Productos where ProductoID = ?;");
        ps.setInt(1, ID);
        ResultSet rs = ps.executeQuery();
        ProductoVO producto;
        if(rs.next())
            producto = new ProductoVO(ID, rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getInt(5));
        else
            producto = null;
        ps.close();
        rs.close();
        return producto;
    }
    
    public void deleteProductoByID(int ID) throws SQLException{
        PreparedStatement preparedStmt = db.conn.prepareStatement("delete from Productos where ProductoID = ?;");
        preparedStmt.setInt(1, ID);
        preparedStmt.executeUpdate();
        preparedStmt.close();
    }
    
    public void updateProductoByID(int ID, String Nombre, String Descripcion, double Precio, int Cantidad_Inventario) throws SQLException{
        PreparedStatement preparedStmt = db.conn.prepareStatement("UPDATE Productos "
                                                                + "SET Nombre = ?, Descripcion = ?, Precio = ?, Cantidad_Inventario = ?"
                                                                + "WHERE ProductoID = ?;");
        preparedStmt.setString(1, Nombre);
        preparedStmt.setString(2, Descripcion);
        preparedStmt.setDouble(3, Precio);
        preparedStmt.setInt(4, Cantidad_Inventario);
        preparedStmt.setInt(5, ID);
        preparedStmt.executeUpdate();
        preparedStmt.close();
    }
    
    public List getProductosOfOrdenByOrdenID(int OrdenID) throws SQLException{
        List<ProductoVO> list = new ArrayList<ProductoVO>();
        PreparedStatement ps = db.conn.prepareStatement("select Productos.ProductoID, Productos.Nombre, Productos.Descripcion, Productos.Precio, Productos.Cantidad_Inventario from Carrito join Productos on Carrito.ProductoID = Productos.ProductoID where OrdenID = ?;");
        ps.setInt(1, OrdenID);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) 
            list.add(new ProductoVO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getInt(5)));
        rs.close();
        ps.close();
        return list;
    }
    
    public List getAllProductos() throws SQLException{
        List<ProductoVO> list = new ArrayList<ProductoVO>();
        PreparedStatement ps = db.conn.prepareStatement("select * from Productos;");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) 
            list.add(new ProductoVO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getInt(5)));
        rs.close();
        ps.close();
        return list;
    }
}
