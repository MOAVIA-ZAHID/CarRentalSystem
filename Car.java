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
public class Car {
    private int id;
    private int brand;
    private String model;
    private String fuel;
    private String color;
    private String _class_;
    private int passengers;
    private String gearbox;
    private int price;
    private String air_cond;
    private String airbag;
    private String sunroof;
    private String heated_seats;
    private String nav_system;
    private String bluetooth;
    private String elec_window;
    private String gps;

    public Car() {
    }

    public Car(int _id, int _brand, String _model, String _fuel, String _color, String _class, int _passengers, String _gearbox, int _price, String _air_cond, String _airbag, String _sunroof, String _heated_seats, String _nav_system, String _bluetooth, String _elec_window, String _gps) {
        this.id = _id;
        this.brand = _brand;
        this.model = _model;
        this.fuel = _fuel;
        this.color = _color;
        this._class_ = _class;
        this.passengers = _passengers;
        this.gearbox = _gearbox;
        this.price = _price;
        this.air_cond = _air_cond;
        this.airbag = _airbag;
        this.sunroof = _sunroof;
        this.heated_seats = _heated_seats;
        this.nav_system = _nav_system;
        this.bluetooth = _bluetooth;
        this.elec_window = _elec_window;
        this.gps = _gps;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBrand() {
        return brand;
    }

    public void setBrand(int brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getClass_() {
        return _class_;
    }

    public void setClass_(String _class_) {
        this._class_ = _class_;
    }

    public int getPassengers() {
        return passengers;
    }

    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }

    public String getGearbox() {
        return gearbox;
    }

    public void setGearbox(String gearbox) {
        this.gearbox = gearbox;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getAir_cond() {
        return air_cond;
    }

    public void setAir_cond(String air_cond) {
        this.air_cond = air_cond;
    }

    public String getAirbag() {
        return airbag;
    }

    public void setAirbag(String airbag) {
        this.airbag = airbag;
    }

    public String getSunroof() {
        return sunroof;
    }

    public void setSunroof(String sunroof) {
        this.sunroof = sunroof;
    }

    public String getHeated_seats() {
        return heated_seats;
    }

    public void setHeated_seats(String heated_seats) {
        this.heated_seats = heated_seats;
    }

    public String getNav_system() {
        return nav_system;
    }

    public void setNav_system(String nav_system) {
        this.nav_system = nav_system;
    }

    public String getBluetooth() {
        return bluetooth;
    }

    public void setBluetooth(String bluetooth) {
        this.bluetooth = bluetooth;
    }

    public String getElec_window() {
        return elec_window;
    }

    public void setElec_window(String elec_window) {
        this.elec_window = elec_window;
    }

    public String getGps() {
        return gps;
    }

    public void setGps(String gps) {
        this.gps = gps;
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
      public ArrayList<Car> carslist()
      {
          ArrayList<Car> carList = new ArrayList<>();
          ResultSet rs = getData("SELECT * FROM `cars` ");
        try {
            while(rs.next())
            {
                System.out.println(rs.getInt(1));
                System.out.println(rs.getString(2));

                Car car = new Car(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),
                rs.getInt(7),rs.getString(8),rs.getInt(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13),
                rs.getString(14),rs.getString(15),rs.getString(16),rs.getString(17));
                carList.add(car);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Car.class.getName()).log(Level.SEVERE, null, ex);
        }
        return carList;
      }
     //funtion to add new cars
    public void addCar(int _id,int _brand,String _model,String _fuel,String _color,String _class,int _passengers,String _gearbox,int _price,
            String _air_cond,String _airbag,String _sunroof,String _heated_seats,String _nav_system,String _bluetooth,String _elec_window,
            String _gps)
    {
        String insertQuery = "INSERT INTO `cars`(`id`,`brand`, `model`, `fuel`, `color`, `class`, `passengers`, `gearbox`, `price`, `air_conditioning`, `air_bag`, `sunroof`, `heated_seats`, `nav_system`, `bluetooth`, `electric_windows`, `gps`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps;
        
        
        try {
            ps=DataBase.getConnection().prepareStatement(insertQuery);
              
               ps.setInt(1, _id);
               ps.setInt(2, _brand);
               ps.setString(3, _model);
               ps.setString(4, _fuel);
               ps.setString(5, _color);
               ps.setString(6, _class);
               ps.setInt(7, _passengers);
               ps.setString(8, _gearbox);
               ps.setInt(9, _price);
               ps.setString(10, _air_cond);
               ps.setString(11, _airbag);
               ps.setString(12, _sunroof);
               ps.setString(13, _heated_seats);
               ps.setString(14, _nav_system);
               ps.setString(15, _bluetooth);
               ps.setString(16, _elec_window);
               ps.setString(17, _gps);
          
               
               if(ps.executeUpdate() != 0)
               {
                     JOptionPane.showMessageDialog(null, "Car Added  Successfully");
               }
               else
               {
                   JOptionPane.showMessageDialog(null, "Location Not Added");
               }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
        public void editCar(int _id,int _brand,String _model,String _fuel,String _color,String _class,int _passengers,String _gearbox,int _price,
            String _air_cond,String _airbag,String _sunroof,String _heated_seats,String _nav_system,String _bluetooth,String _elec_window,
            String _gps)
    {
        String editQuery = "UPDATE `cars` SET `brand`=?,`model`=?,`fuel`=?,`color`=?,`class`=?,`passengers`=?,`gearbox`=?,`price`=?,`air_conditioning`=?,`air_bag`=?,`sunroof`=?,`heated_seats`=?,`nav_system`=?,`bluetooth`=?,`electric_windows`=?,`gps`=? WHERE `id`=?";
        PreparedStatement ps;
    
        
        try {
            ps=DataBase.getConnection().prepareStatement(editQuery);
               
               
               ps.setInt(1, _brand);
               ps.setString(2, _model);
               ps.setString(3, _fuel);
               ps.setString(4, _color);
               ps.setString(5, _class);
               ps.setInt(6, _passengers);
               ps.setString(7,_gearbox);
               ps.setInt(8, _price);
               ps.setString(9, _air_cond);
               ps.setString(10, _airbag);
               ps.setString(11, _sunroof);
               ps.setString(12, _heated_seats);
               ps.setString(13, _nav_system);
               ps.setString(14, _bluetooth);
               ps.setString(15, _elec_window);
               ps.setString(16, _gps);
               ps.setInt(17, _id);
               
               
               
               if(ps.executeUpdate() != 0)
               {
                     JOptionPane.showMessageDialog(null, "Car Edited  Successfully");
               }
               else
               {
                   JOptionPane.showMessageDialog(null, "Car Not Edited");
               }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
      
        
    }
      public void removeCar(int _id)
    {
        String removeQuery = "DELETE FROM `cars` WHERE `id`=?";
        PreparedStatement ps;
        
        
        try {
               ps=DataBase.getConnection().prepareStatement(removeQuery);
           
               ps.setInt(1, _id);
               
               if(ps.executeUpdate() != 0)
               {
                     JOptionPane.showMessageDialog(null, "Car Removed  Successfully");
               }
               else
               {
                     JOptionPane.showMessageDialog(null, "Car not Removed");
               }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
      
    }

      public void addCarImage(int id,int car_id,byte[] car_image)
    {
        String insertQuery = "INSERT INTO `car_images`(`id`, `car_id`, `car_image`) VALUES (?,?,?)";
        PreparedStatement ps;
        
        
        try {
            ps=DataBase.getConnection().prepareStatement(insertQuery);
             
            ps.setInt(1, id);
            ps.setInt(2, car_id);
            ps.setBytes(3, car_image);
               //ps.setBytes(3, _logo);
               
               if(ps.executeUpdate() != 0)
               {
                     JOptionPane.showMessageDialog(null, "Image Added  Successfully");
               }
               else
               {
                   JOptionPane.showMessageDialog(null, "Image Not Added");
               }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }  
    }
      //create class for images
      public class Carimage{
          private int img_id;
          private int car_id;
          private byte[] car_img;

        public Carimage() {
        }

        public Carimage(int img_id, int car_id, byte[] car_img) {
            this.img_id = img_id;
            this.car_id = car_id;
            this.car_img = car_img;
        }

        public int getImg_id() {
            return img_id;
        }

        public void setImg_id(int img_id) {
            this.img_id = img_id;
        }

        public int getCar_id() {
            return car_id;
        }

        public void setCar_id(int car_id) {
            this.car_id = car_id;
        }

        public byte[] getCar_img() {
            return car_img;
        }

        public void setCar_img(byte[] car_img) {
            this.car_img = car_img;
        }
      }
      // function to get car images and return arraylist
       public ArrayList<Carimage> carimagelist(int car_id )
      {
          ArrayList<Carimage> images = new ArrayList<>();
          ResultSet rs = getData("SELECT `car_id`, `car_image` FROM `car_images` WHERE `id` = ?");
          Carimage car_image;
          try {
            
            while(rs.next())
            {
               car_image = new Carimage();
               car_image.setCar_id(rs.getInt(1));
               car_image.setImg_id(rs.getInt(2));
               car_image.setCar_img(rs.getBytes(3));
               images.add(car_image);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Car.class.getName()).log(Level.SEVERE, null, ex);
        }
        return images;
      }
      //function to  get brand by id
    public Car getCarById(int car_id)
    {
        
        String query1 = "SELECT * FROM `cars` WHERE `id` = "+car_id;
         ResultSet rs = getData(query1);
         Car car=null;
        try {
            if(rs.next())
          {     
            car = new Car(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),
                rs.getInt(7),rs.getString(8),rs.getInt(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13),
                rs.getString(14),rs.getString(15),rs.getString(16),rs.getString(17));
          }
            else
            {
                 JOptionPane.showMessageDialog(null," Car Not Available "," Invalid info ",2);
            }
          } catch (SQLException ex) {
            Logger.getLogger(Car.class.getName()).log(Level.SEVERE, null, ex);
        }
        return car;
    }
    
}


