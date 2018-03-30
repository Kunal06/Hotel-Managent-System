/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanagementsystem;

import static hotelmanagementsystem.Fieldsdata.onlyint;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author User
 */
public class AssignRooms extends javax.swing.JPanel {
Connection conn = new DBconnect().connect();

    /**
     * Creates new form AssignRooms
     */
    public AssignRooms() {
        initComponents();
        load();
        loadCustomer();
    }
    private void load(){
        customer.removeAllItems();
        roomno1.removeAllItems();
        type.removeAllItems();
        type.addItem("Select Room Type");
        type.addItem("Single");
        type.addItem("Double");
        type.addItem("Studio");
        
        
        from1.setCalendar(null);
        to1.setCalendar(null);
        
        cc1.setText("");
        exp1.setText("");
        cost1.setText("");
        cost1.setEnabled(false);
        custid1.setText("");
        ppn1.setText("");
        custid1.setVisible(false);
        ppn1.setVisible(false);
    }
    
    private void loadRoomNumber(String type){
        roomno1.removeAllItems();
        roomno1.addItem("Select Room Number");
        String Number="";
        int ppn;
        String getroomnumber = "select Room_No, PricePerNight from Room where Type = ? order by Room_No";
        try {
            PreparedStatement pa = conn.prepareStatement(getroomnumber);
            pa.setString(1,type);
            ResultSet rs = pa.executeQuery();
            while (rs.next()) {
                Number = rs.getString("Room_No");
                ppn = rs.getInt("PricePerNight");
                roomno1.addItem(Number);
                ppn1.setText(""+ppn);
            }
        } catch (Exception c) {
        }
    }
    private void loadCustomer(){
        String first ="";
        String last =""; 
        int id= 0;
        customer.removeAllItems();
        customer.addItem("Select Customer");

        String getcustomer = "select ID, First_Name, Last_Name from Customer order by last_Name";
        try {
            PreparedStatement pa = conn.prepareStatement(getcustomer);
            ResultSet rs = pa.executeQuery();
            while (rs.next()) {
                first = rs.getString("First_Name");
                last = rs.getString("Last_Name");
                    customer.addItem(first+" "+last);
                    id= rs.getInt("ID");
                    custid1.setText(""+id);
            }
        } catch (Exception c) {
        }
    }
    public int daysBetween(Date d1, Date d2){
             return (int)( (d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
     }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        customer = new javax.swing.JComboBox();
        type = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        roomno1 = new javax.swing.JComboBox();
        from1 = new com.toedter.calendar.JDateChooser();
        to1 = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        exp1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cc1 = new javax.swing.JTextField();
        custid1 = new javax.swing.JLabel();
        ppn1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cost1 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        jLabel1.setText("Customer");

        jLabel2.setText("Room Type");

        jLabel3.setText("Date From");

        jLabel4.setText("Date To");

        customer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerActionPerformed(evt);
            }
        });

        type.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typeActionPerformed(evt);
            }
        });

        jButton1.setText("Assign");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        roomno1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roomno1ActionPerformed(evt);
            }
        });

        jLabel5.setText("Credit Card No.");

        jLabel6.setText("Expiry");

        cc1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cc1KeyTyped(evt);
            }
        });

        custid1.setText("ID");

        ppn1.setText("ppn");

        jLabel7.setText("Cost");

        jLabel8.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel8.setText("Assign Room");

        jLabel9.setText("Room Number");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(20, 20, 20))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cc1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(exp1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(customer, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(custid1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(from1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 227, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(to1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel4))))
                .addGap(100, 100, 100))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(271, 271, 271)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cost1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(roomno1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(227, 227, 227))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(type, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(233, 233, 233)
                        .addComponent(ppn1)
                        .addGap(66, 66, 66))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(customer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(custid1))
                .addGap(18, 19, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ppn1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(from1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(to1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(roomno1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cost1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cc1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(exp1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        //Get all values from fields
        String Customer= ""+customer.getSelectedItem();
        String Roomno= ""+roomno1.getSelectedItem();
        String Roomtype= ""+type.getSelectedItem();
        
        String cc= cc1.getText();
        String exp= exp1.getText();
        java.util.Date utilfrom= from1.getDate();
        java.util.Date utilto= to1.getDate();
        java.sql.Date from= new java.sql.Date(utilfrom.getTime());
        java.sql.Date to= new java.sql.Date(utilto.getTime());
        
        // Calculate Total Cost
        int cost= Integer.parseInt(cost1.getText());
        
        
        if(Customer.equals("Select Customer") || Customer.equals("")){
            showMessageDialog(null, "Select Customer");
        } else if(Roomno.equalsIgnoreCase("Select Room Number") || Roomno.equals("")){
            showMessageDialog(null, "Room number is required");
        } else if(Roomtype.equalsIgnoreCase("Select Room Type") || Roomtype.equals("")){
            showMessageDialog(null, "Room number is required");
        } else if(cc.equals("")){
            showMessageDialog(null, "Credit Card no. required");
        } else if(exp.equals("")){
            showMessageDialog(null, "Expiry for Credit Card is required");
        } else if(from == null){
            showMessageDialog(null, "Dates required");
        } else if(to == null){
            showMessageDialog(null, "Dates required");
        } else if(from.after(to)){
            showMessageDialog(null, "Dates required");
        } else {
            try {
                PreparedStatement pa = conn.prepareStatement("insert into Reservation(Customer,Room_Type,Room_Number,CreditCard_Number,Expiry,Date_From,Date_to, Cost) values (?,?,?,?,?,?,?,?)");

                pa.setInt(1, Integer.parseInt(custid1.getText()));
                pa.setString(2, Roomtype);
                pa.setString(3, Roomno);
                pa.setString(4, cc);
                pa.setString(5, exp);
                pa.setDate(6, from);
                pa.setDate(7, to);
                pa.setInt(8, cost);

                int i = pa.executeUpdate();

                if (i > 0) {
                    JOptionPane.showMessageDialog((null), "saved");
                } else {
                    JOptionPane.showMessageDialog((null), "notsaved");

                }
            } catch (SQLException se) {
                //Handle errors for JDBC
                se.printStackTrace();
            } catch (Exception e) {
                //Handle errors for Class.forName
                e.printStackTrace();
            }
            //Reload Panel
            load();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void typeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typeActionPerformed
        String Roomtype= ""+type.getSelectedItem();
        loadRoomNumber(Roomtype);

// TODO add your handling code here:
    }//GEN-LAST:event_typeActionPerformed

    private void customerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerActionPerformed
       int id=0 ;
        String Customer = ""+ customer.getSelectedItem();
        String[] name = Customer.split(" ");

        String getcustomer = "select ID from Customer where First_Name= ? AND Last_Name= ? ";
        try {
            PreparedStatement pa = conn.prepareStatement(getcustomer);
            pa.setString(1, name[0]);
            pa.setString(2, name[1]);
            ResultSet rs = pa.executeQuery();
            while (rs.next()) {
                id = rs.getInt("ID");
                
            }
            custid1.setText(""+id);
            
        } catch (Exception c) {
        }
        

// TODO add your handling code here:
    }//GEN-LAST:event_customerActionPerformed

    private void cc1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cc1KeyTyped
        onlyint(evt);
    }//GEN-LAST:event_cc1KeyTyped

    private void roomno1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roomno1ActionPerformed
        java.util.Date utilfrom= from1.getDate();
        java.util.Date utilto= to1.getDate();
        
        if(utilfrom == null){
            
        } else if(utilto == null){
        } else if(utilfrom.after(utilto)){
        } else {
            java.sql.Date from= new java.sql.Date(utilfrom.getTime());
        java.sql.Date to= new java.sql.Date(utilto.getTime());
        // Calculate Total Cost
        // int cost= Integer.parseInt(cost1.getText());
        int ppn= Integer.parseInt(ppn1.getText());
        int days= daysBetween(from,to);
        cost1.setText("" + ppn*days);
        }
        
        
// TODO add your handling code here:
    }//GEN-LAST:event_roomno1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cc1;
    private javax.swing.JTextField cost1;
    private javax.swing.JLabel custid1;
    private javax.swing.JComboBox customer;
    private javax.swing.JTextField exp1;
    private com.toedter.calendar.JDateChooser from1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel ppn1;
    private javax.swing.JComboBox roomno1;
    private com.toedter.calendar.JDateChooser to1;
    private javax.swing.JComboBox type;
    // End of variables declaration//GEN-END:variables
}
