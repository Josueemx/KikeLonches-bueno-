/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.kikelonches.manager;
import java.sql.SQLException;
import java.util.List;
import mx.itesm.kikelonches.util.DBConnection;
import mx.itesm.kikelonches.dao.CarritoDAO;
import mx.itesm.kikelonches.vo.CarritoVO;
/**
 *
 * @author Dell
 */
public class CarritoManager {
    
    private CarritoDAO carritoDAO;
    
    public CarritoManager() throws SQLException, ClassNotFoundException{
        carritoDAO = new CarritoDAO(new DBConnection());
    }
    
    public CarritoManager(DBConnection dBConnection) throws SQLException, ClassNotFoundException{
        carritoDAO = new CarritoDAO(dBConnection);
    }
    
    public void insertCarrito(int OrdenID, int ProductoID, int Cantidad, double Precio) throws SQLException{
        carritoDAO.insertCarrito(OrdenID, ProductoID, Cantidad, Precio);
    }
    
    public List<CarritoVO> getFullCarrito(int OrdenID) throws SQLException{
        return carritoDAO.getFullCarritoByOrdenID(OrdenID);
    }
    
    public void deletItem(int OrdenID, int ItemID) throws SQLException{
        carritoDAO.deleteCarritoByOrdenIDAndProductoID(OrdenID, OrdenID);
    }
    
    public void updateItem(int OrdenID, int ProductoID, int Cantidad, double Precio) throws SQLException{
        carritoDAO.updateCarritoByOrdenIDAndProductoID(OrdenID, ProductoID, Cantidad, Precio);
    }
}
