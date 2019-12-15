
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class pos_action {
    
    connt cons  = new connt();
    
    
    public void getProduct(String id, JTable table){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = (Connection) DriverManager.getConnection(cons.url,cons.username,cons.password);

            String sql = "select * from product where prod_id =?;";
            PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);

            pstmt.setString(1,id);
            
            ResultSet rs = pstmt.executeQuery();
            
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            
            while (rs.next()) {
                int qty = 1;
                float subTotal = qty * rs.getFloat("Prod_price");
                model.addRow(new Object[]{rs.getString("Prod_id"),  qty, rs.getString("prod_name"), rs.getString("Prod_price"), subTotal});
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(pos_action.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(pos_action.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
}
