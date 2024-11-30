/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carrentalsystem;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class DataBase {

  

  public static Connection getConnection(){
         Connection connection =null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/project_acp?zeroDateTimeBehavior=convertToNull","root","admin1080@admin");
           // System.out.println("successes");
        } catch (Exception ex) {
            
            JOptionPane.showMessageDialog(null, "not connected");
        }
        return connection;
    }   
 
    
}
