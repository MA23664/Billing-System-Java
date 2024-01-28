/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my_billing_system;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Mehmoob Ahmad
 */
public class conec {
    Connection con;
    
    public Connection conection()
    {
       String dbdir = "c:/db";
         
         File f = new File(dbdir);
         
         if(!f.exists())
         {
           f.mkdir();
         }
         
         
         String dbName = "myfirstdatabase.sql";
         
         String dbpath = dbdir + "/" + dbName;
         
         File f2 = new File(dbpath);
         
         if(!f2.exists())
         {
           InputStream iStream = Login.class.getResourceAsStream("database" + dbName);
           
            try {
                Files.copy(iStream, f2.toPath(), StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
         }
         
         
         
         String dburl = "jdbc:mysql://" + dbpath;
         
         
        
         //...coneCting TO Database .............
          try {
              
//              Class.forName("org.apache.derby.jdbc.ClientDriver");
//              
//              con = DriverManager.getConnection("jdbc:derby:"+currentdir+"/Database" , "MA" , "23664");
//              
              //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
              //...yahan dekho changes krni shahid ya NETBEANS WALA JDBC USE KRO.....................
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            con = DriverManager.getConnection(dburl);
           
            
             
              
          }catch (Exception ex) {
              ex.printStackTrace();
          }
          
          return con;
    }
    
}
