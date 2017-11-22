/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.kikelonches.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Morales
 */
public class DBConnection {
    
    private String Username = "root";
    private String Password = "admin";
    private String Port = "3306";
    private final String DBName = "kikelonches";
    public Connection conn;
    
    public DBConnection() throws SQLException, ClassNotFoundException{
        startConnection();
    }
    
    public DBConnection(String Username, String Password, String Port) throws SQLException, ClassNotFoundException {
        this.Username = Username;
        this.Password = Password;
        this.Port = Port;
        startConnection();
    }
    
    public void startConnection() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        //conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+DBName, "root", "root");
        conn = DriverManager.getConnection("jdbc:mysql://localhost/"+DBName+"?user="+Username+"&password="+Password);
    }
    
    public void endConnection() throws SQLException{
        conn.close();
    }
}
