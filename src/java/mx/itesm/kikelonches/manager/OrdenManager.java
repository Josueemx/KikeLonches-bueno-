/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.kikelonches.manager;
import java.sql.SQLException;
import java.util.List;
import mx.itesm.kikelonches.dao.OrdenDAO;
import mx.itesm.kikelonches.util.DBConnection;
import mx.itesm.kikelonches.vo.OrdenVO;
/**
 *
 * @author Dell
 */
public class OrdenManager {
    
    private OrdenDAO ordenDAO;
    
    public OrdenManager() throws SQLException, ClassNotFoundException{
        ordenDAO = new OrdenDAO(new DBConnection());
    }
    
    public OrdenManager(DBConnection dBConnection) throws SQLException, ClassNotFoundException{
        ordenDAO = new OrdenDAO(dBConnection);
    }
    
    public void newOrden(int UsuarioID, String Fecha, double PrecioFinal) throws SQLException{
        ordenDAO.insertOrden(UsuarioID, Fecha, PrecioFinal);
    }
    
    public List<OrdenVO> ordenByDate(String Fecha) throws SQLException{
        return ordenDAO.getOrdenByDate(Fecha);
    }
    
    public void updateOrden(int ID, int UsuarioID, String Fecha, double PrecioFinal) throws SQLException{
        ordenDAO.updateOrdenByID(ID, UsuarioID, Fecha, PrecioFinal);
    }
}
