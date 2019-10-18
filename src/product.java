
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
public class product {
     connt con = new connt();
     
     
     public int editprod(int id,String prodname,float price){
       int f=0;
       
       String sql="Update product set prod_name = ? ,prod_price = ? where Prod_ID = ?";
         
         try{
             
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = (Connection) DriverManager.getConnection(con.url,con.username,con.password);
            PreparedStatement pstmt=(PreparedStatement)conn.prepareStatement(sql);
            
            pstmt.setString(1, prodname);
            pstmt.setFloat(2, price);
            pstmt.setInt(3, id);
            
          f = pstmt.executeUpdate();
            
            
       
         
         
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(product.class.getName()).log(Level.SEVERE, null, ex);
         } catch (SQLException ex) {
             Logger.getLogger(product.class.getName()).log(Level.SEVERE, null, ex);
         }
         return f;
     }
     
     
     public int Deleteproduct(Object id){
         int x=0;
         
         String sql="Delete from product where Prod_ID=?;";
         
         try{
             
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = (Connection) DriverManager.getConnection(con.url,con.username,con.password);
            PreparedStatement pstmt=(PreparedStatement)conn.prepareStatement(sql);
            
            int nwid=Integer.parseInt(id.toString());
            pstmt.setInt(1, nwid);
            
           x= pstmt.executeUpdate();
            
            //System.out.println(pstmt);
            
            
            
            
            
            
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(product.class.getName()).log(Level.SEVERE, null, ex);
         } catch (SQLException ex) {
             Logger.getLogger(product.class.getName()).log(Level.SEVERE, null, ex);
         }
         
         return x;
     }
     
     
     public int addproduct1(String product,int quantity,Float price){
         int i=0;
         
         String sql="INSERT INTO product VALUES (null,?,?,?);";
         
         
         try{
             
             
       Class.forName("com.mysql.jdbc.Driver");
            Connection conn = (Connection) DriverManager.getConnection(con.url,con.username,con.password);
            
         //PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement("select * from product where prod_name=? and prod_price=?");
           PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql); 
         pstmt.setString(1,product);
        pstmt.setInt(2,quantity);
         pstmt.setFloat(3, price);
         pstmt.executeUpdate();
         
        /* if(rs.next()){
             i=2;
             int pr=Integer.parseInt(rs.getString("prod_ID"));
             PreparedStatement pstmt1=conn.prepareStatement("update product set prod_quantity=prod_quantity+? where prod_ID=?");
             pstmt1.setInt(1,quantity);
             pstmt1.setInt(1,pr);
             pstmt1.executeUpdate();
         }
         
         else{
             i=1;
             PreparedStatement pstmt1=conn.prepareStatement("insert into product values(null,?,?,?)");
             pstmt1.setString(1, product);
             pstmt1.setInt(2,quantity);
             pstmt1.setFloat(3,price);
             pstmt1.executeUpdate();
         }
         //ps.executeUpdate();
         
         //ps.executeUpdate();
        // System.out.println(rs);
         
         
         */
         
     }   catch (ClassNotFoundException ex) {
             Logger.getLogger(product.class.getName()).log(Level.SEVERE, null, ex);
         } catch (SQLException ex) {
            Logger.getLogger(product.class.getName()).log(Level.SEVERE, null, ex);
         }
      return i;
    }

    
   
}
     


