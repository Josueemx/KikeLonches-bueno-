/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.kikelonches.manager;
import java.sql.SQLException;
import java.util.List;
import mx.itesm.kikelonches.dao.ProductoDAO;
import mx.itesm.kikelonches.util.DBConnection;
import mx.itesm.kikelonches.vo.ProductoVO;
/**
 *
 * @author Dell
 */
public class ProductManager {
    
    private ProductoDAO producoDAO;
    
    public ProductManager() throws SQLException, ClassNotFoundException{
        producoDAO = new ProductoDAO(new DBConnection());
    }
    
    public ProductManager(DBConnection dBConnection) throws SQLException, ClassNotFoundException{
        producoDAO = new ProductoDAO(dBConnection);
    }
    
    public void addProducto(String Nombre, String Descripcion, double Precio, int Cantidad_Inventario) throws SQLException{
        producoDAO.insertProducto(Nombre, Descripcion, Precio, Cantidad_Inventario);
    }
   
    public void updateProducto(int ID, String Nombre, String Descripcion, double Precio, int Cantidad_Inventario) throws SQLException{
        producoDAO.updateProductoByID(ID, Nombre, Descripcion, Precio, Cantidad_Inventario);
    }
    
    public List<ProductoVO> getAllProductos() throws SQLException{
        return producoDAO.getAllProductos();
    }
    
}
