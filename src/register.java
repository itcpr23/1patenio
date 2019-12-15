
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class register {
    connt con = new connt();
    
    public int register(String firstname,String lastname,String username ,String password){
        int r=0;
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = (Connection) DriverManager.getConnection(con.url,con.username,con.password);
            
            String sql="INSERT INTO `registerlogin`.`user` (`fname`, `lname`, `uname`, `upass`) VALUES (?, ?, ?, md5(?),0);";
            PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
            
            pstmt.setString(1,firstname );
             pstmt.setString(2,lastname );
             pstmt.setString(3,username );
              pstmt.setString(4,password );
              
             r=pstmt.executeUpdate();
             
             
             
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(register.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
           Logger.getLogger(register.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }
    
    public int confirmpass(String password,String confirmpassword){
       int x;
       if(password.equals(confirmpassword)){
           x=1;
       }else{
           x=0;
           
       }
        return x;
    }
    public int checkuser(String username){
        int x=0;
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = (Connection) DriverManager.getConnection(con.url,con.username,con.password);
            
            String sql="select uname from user where uname=?";
            
            PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
            
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            
            if(rs.next()){
                x=1;
            }else{
                x=0;
            }
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(register.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(register.class.getName()).log(Level.SEVERE, null, ex);
        }
        return x;
    }
    
}
