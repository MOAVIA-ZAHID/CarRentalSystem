/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carrentalsystem;

import carrentalsystem.DataBase;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class brand_cls {
    private int id;
    private String name;
    private byte[] logo;
    
     public brand_cls(){}
    public brand_cls(int _id,String _name,byte[] _logo)
    {
        this.id=_id;
        this.name=_name;
        this.logo=_logo;
    }

  
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getLogo() {
        return logo;
    }

    public void setLogo(byte[] logo) {
        this.logo = logo;
    }
    
    public void addBrand(int _id,String _name,byte[] _logo)
    {
        String insertQuery = "INSERT INTO `brands`(`id`, `name`, `logo`) VALUES (?,?,?)";
        PreparedStatement ps;
        
        
        try {
            ps=DataBase.getConnection().prepareStatement(insertQuery);
              
            ps.setInt(1, _id);
            ps.setString(2, _name);
               ps.setBytes(3, _logo);
               
               if(ps.executeUpdate() != 0)
               {
                     JOptionPane.showMessageDialog(null, "Brand Added  Successfully");
               }
               else
               {
                   JOptionPane.showMessageDialog(null, "Brand Not Added");
               }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
      
        
    }
    public void editBrand(int _id,String _name,byte[] _logo)
    {
        String editQuery = "UPDATE `brands` SET `name`=?,`logo`=? WHERE `id`=?";
        PreparedStatement ps;
    
        
        try {
            ps=DataBase.getConnection().prepareStatement(editQuery);
            
            
            ps.setString(1, _name);
               ps.setBytes(2, _logo);
               ps.setInt(3, _id);
               
               
               
               if(ps.executeUpdate() != 0)
               {
                     JOptionPane.showMessageDialog(null, "Brand Edited  Successfully");
               }
               else
               {
                   JOptionPane.showMessageDialog(null, "Brand Not Edited");
               }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
      
        
    }
      public void removeBrand(int _id)
    {
        String removeQuery = "DELETE FROM `brands` WHERE `id`=?";
        PreparedStatement ps;
        
        
        try {
            ps=DataBase.getConnection().prepareStatement(removeQuery);
            
            
               ps.setInt(1, _id);
               
               if(ps.executeUpdate() != 0)
               {
                     JOptionPane.showMessageDialog(null, "Brand Removed  Successfully");
               }
               else
               {
                  JOptionPane.showMessageDialog(null, "Brand not Removed");
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
      public ArrayList<brand_cls> brandslist()
      {
          ArrayList<brand_cls> brdList = new ArrayList<>();
          ResultSet rs = getData("SELECT * FROM `brands` ");
        try {
            while(rs.next())
            {
                System.out.println(rs.getInt(1));
                System.out.println(rs.getString(2));

                brand_cls brand = new brand_cls(rs.getInt(1),rs.getString(2),rs.getBytes(3));
                brdList.add(brand);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(brand_cls.class.getName()).log(Level.SEVERE, null, ex);
        }
        return brdList;
      }
      //function to  get brand by id
    public brand_cls getBrandById(int id)
    {
        
        String query1 = "SELECT * FROM `brands` WHERE `id` = "+id;
         ResultSet rs = getData(query1);
         brand_cls brand=null;
        try {
            rs.next();
            brand = new brand_cls(rs.getInt(1),rs.getString(2),rs.getBytes(3));
        } catch (SQLException ex) {
            Logger.getLogger(brand_cls.class.getName()).log(Level.SEVERE, null, ex);
        }
        return brand;
    }
    //create a function to populate a hashmap with brands id,name
    public HashMap<Integer,String> brandsHashMap()
    {
        HashMap<Integer,String> brands_map =new HashMap<Integer,String>();
        ResultSet rs = getData("SELECT * FROM `brands` ");
        try {
            while(rs.next())
            {
                brands_map.put(rs.getInt(1),rs.getString(2));
                        }
        } catch (SQLException ex) {
            Logger.getLogger(brand_cls.class.getName()).log(Level.SEVERE, null, ex);
        }
        return brands_map;
    }
}
