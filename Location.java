/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carrentalsystem;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class Location {
    private int id;
    private String city;
    private String address;

    public Location() {
    }

    public Location(int _id, String _city, String _address) {
        this.id = _id;
        this.city = _city;
        this.address = _address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    //funtion to add new location
    public void addLocation(int _id,String _city,String _address)
    {
        String insertQuery = "INSERT INTO `locations`(`id`,`city`, `location`) VALUES (?,?,?)";
        PreparedStatement ps;
        
        
        try {
            ps=DataBase.getConnection().prepareStatement(insertQuery);
              
            ps.setInt(1, _id);
            ps.setString(2, _city);
               ps.setString(3, _address);
               
               if(ps.executeUpdate() != 0)
               {
                     JOptionPane.showMessageDialog(null, "Locaton  Added  Successfully");
               }
               else
               {
                   JOptionPane.showMessageDialog(null, "Location Not Added");
               }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public void editLocation(int _id,String _city,String _address)
    {
        String editQuery = "UPDATE `locations` SET `city`=?,`location`=? WHERE `id`=?";
        PreparedStatement ps;
    
        
        try {
            ps=DataBase.getConnection().prepareStatement(editQuery);
            
            
            ps.setString(1, _city);
               ps.setString(2, _address);
               ps.setInt(3, _id);
               
               
               
               if(ps.executeUpdate() != 0)
               {
                     JOptionPane.showMessageDialog(null, "Location Edited  Successfully");
               }
               else
               {
                   JOptionPane.showMessageDialog(null, "Location Not Edited");
               }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    public void removeLocation(int _id)
    {
         String removeQuery = "DELETE FROM `locations` WHERE `id`=?";
        PreparedStatement ps;
        
        
        try {
            ps=DataBase.getConnection().prepareStatement(removeQuery);
            
            
               ps.setInt(1, _id);
               
               if(ps.executeUpdate() != 0)
               {
                     JOptionPane.showMessageDialog(null, "Location Removed  Successfully");
               }
               else
               {
                  JOptionPane.showMessageDialog(null, "Location not Removed");
               }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public ResultSet getData(String query)
      {
           PreparedStatement ps;
            ResultSet rs = null;
        try {  
            ps = DataBase.getConnection().prepareStatement(query);
            rs = ps.executeQuery();
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(brand_cls.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
      }
    //funtion to get all locations and return  an arraylist
      public ArrayList<Location> locationslist()
      {
          ArrayList<Location> locList = new ArrayList<>();
          ResultSet rs = getData("SELECT * FROM `locations` ");
        try {
            while(rs.next())
            {
                System.out.println(rs.getInt(1));
                System.out.println(rs.getString(2));

                Location location = new Location(rs.getInt(1),rs.getString(2),rs.getString(3));
                locList.add(location);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(brand_cls.class.getName()).log(Level.SEVERE, null, ex);
        }
        return locList;
      }
      public Location getLocationsById(int id)
    {
        
        String query1 = "SELECT * FROM `locations` WHERE `id` = "+id;
         ResultSet rs = getData(query1);
         Location location=null;
        try {
            rs.next();
            location = new Location(rs.getInt(1),rs.getString(2),rs.getString(3));
        } catch (SQLException ex) {
            Logger.getLogger(Location.class.getName()).log(Level.SEVERE, null, ex);
        }
        return location;
    }
}
