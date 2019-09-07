
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.DriverManager;
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
public class log_in {
    connt con = new connt();
    sess ses = new sess();
    
    public int log_in(String username, String password){
      int x =0;
      
      try{
          Class.forName("com.mysql.jdbc.Driver");
          Connection conn=(Connection) DriverManager.getConnection(con.url,con.username,con.password);
          
          String sql="select * from user where uname =? and upass= md5(?);";
          
          PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
          
          pstmt.setString(1, username);
            pstmt.setString(2, password);
          
            ResultSet rs=pstmt.executeQuery();
            
            if(rs.next()){
                x=1;
                ses.id = rs.getString("ID");
            ses.username = rs.getString("uname");
            ses.firstname = rs.getString("fname");
            ses.lastname = rs.getString("lname");
            }
            else{
                
                x=0;
                
            }
            
            
            
          
          
      } catch (ClassNotFoundException ex) {
        Logger.getLogger(log_in.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
         Logger.getLogger(log_in.class.getName()).log(Level.SEVERE, null, ex);
            
            
    
        }
         return x;
    }
}
