/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.kikelonches.manager;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.List;
import javax.xml.bind.DatatypeConverter;
import mx.itesm.kikelonches.dao.ProductoDAO;
import mx.itesm.kikelonches.dao.UsuarioDAO;
import mx.itesm.kikelonches.util.DBConnection;
import mx.itesm.kikelonches.util.Security;
import mx.itesm.kikelonches.vo.UsuarioVO;


/**
 *
 * @author Dell
 */
public class UserManager {
    
    private UsuarioDAO usuarioDAO;
    
    public UserManager() throws SQLException, ClassNotFoundException{
        usuarioDAO = new UsuarioDAO(new DBConnection());
    }
    
    public UserManager(DBConnection dBConnection) throws SQLException, ClassNotFoundException{
        usuarioDAO = new UsuarioDAO(dBConnection);
    }
    
    public void addUser(String Username, String Password, String Correo) throws SQLException, NoSuchAlgorithmException, UnsupportedEncodingException{
        usuarioDAO.insertUsuario(Username, Security.MD5Encode(Password), Correo); 
    }
    
    public void deleteUser(int id) throws SQLException{
        usuarioDAO.deleteUsuarioByID(id);
    }
    
    public void updateUser(int id, String Username, String Password, String Correo) throws SQLException, NoSuchAlgorithmException, UnsupportedEncodingException{
        usuarioDAO.updateUsuarioById(id, Username, Security.MD5Encode(Password), Correo);
    }
    
    public List getAllUsers() throws SQLException{
        return usuarioDAO.getAllUsuarios();
    }
    
    public UsuarioVO authenticate(String Username, String Password) throws SQLException, NoSuchAlgorithmException, UnsupportedEncodingException{
        String hashedpassword = Security.MD5Encode(Password);
        return usuarioDAO.getUsuarioByUsernameAndPassword(Username, hashedpassword);
    }
}
