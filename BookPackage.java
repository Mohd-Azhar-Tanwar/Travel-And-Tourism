package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class BookPackage extends JFrame implements ActionListener {
    
    Choice cpackage;
    JTextField tfpersons;
    String username;
    JLabel labelusername, labelid ,labelnumber,labelphone,labelprice;
    JButton checkprice,bookpackage,back;
           BookPackage(String username){
        this.username = username;
        setBounds(340,180,800, 470);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel text = new JLabel("BOOK PACKAGE");
        text.setBounds(100, 5, 200, 30);
        text.setFont(new Font("Tahoma", Font.BOLD,18));
        add(text);
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setFont(new Font("Tahoma", Font.PLAIN,12));
        lblusername.setBounds(30, 40, 100, 20);
        add(lblusername);
        
        labelusername = new JLabel();
        labelusername.setFont(new Font("Tahoma", Font.PLAIN,12));
        labelusername.setBounds(180, 40, 80, 20);
        add(labelusername);
        
        JLabel lblpackage = new JLabel("Select Package");
        lblpackage.setFont(new Font("Tahoma", Font.PLAIN,12));
        lblpackage.setBounds(30, 80, 150, 20);
        add(lblpackage);
        
        cpackage = new Choice();
        cpackage.add("Gold Package");
        cpackage.add("Silver Package");
        cpackage.add("Bronze Package");
        cpackage.setBounds(180, 80, 150, 20);
        add(cpackage);
        
        JLabel lblpersons = new JLabel("Total Persons");
        lblpersons.setFont(new Font("Tahoma", Font.PLAIN,12));
        lblpersons.setBounds(30, 120, 150, 25);
        add(lblpersons);
        
        tfpersons = new JTextField("1");
        tfpersons.setBounds(180,120,150,25);
        add(tfpersons);
        
        
        
        JLabel lblid = new JLabel("id");
        lblid.setFont(new Font("Tahoma", Font.PLAIN,12));
        lblid.setBounds(30, 160, 150, 25);
        add(lblid);
        
         labelid = new JLabel();
        labelid.setBounds(180, 160, 150, 25);
        add(labelid);
        
        JLabel lblnumber = new JLabel("Number");
        lblnumber.setFont(new Font("Tahoma", Font.PLAIN,12));
        lblnumber.setBounds(30, 200, 150, 25);
        add(lblnumber);
        
         labelnumber = new JLabel();
        labelnumber.setBounds(180, 200, 150, 25);
        add(labelnumber);
        
        JLabel lblphone = new JLabel("phone");
        lblphone.setFont(new Font("Tahoma", Font.PLAIN,12));
        lblphone.setBounds(30, 240, 150, 25);
        add(lblphone);
        
         labelphone = new JLabel();
        labelphone.setBounds(180, 240, 150, 25);
        add(labelphone);
        
        JLabel lbltotal = new JLabel("Total Price");
        lbltotal.setFont(new Font("Tahoma", Font.PLAIN,12));
        lbltotal.setBounds(30, 280, 150, 25);
        add(lbltotal);
        
        labelprice = new JLabel();
        labelprice.setBounds(180, 280, 150, 25);
        add(labelprice);
        
        try {
            Conn conn = new Conn();
            String query = "select * from customer where username = '"+username+"'";
            ResultSet rs = conn.s.executeQuery(query);
            while(rs.next()){
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelphone.setText(rs.getString("phone"));
                
            }
        } catch(Exception e){
        e.printStackTrace();
        }
        
        checkprice = new JButton("Check Price");
        checkprice.setBackground(Color.BLACK);
        checkprice.setForeground(Color.WHITE);
        checkprice.setBounds(40, 380, 120, 25);
        checkprice.addActionListener(this);
        add(checkprice);
        
        bookpackage = new JButton("Book Package");
        bookpackage.setBackground(Color.BLACK);
        bookpackage.setForeground(Color.WHITE);
        bookpackage.setBounds(200, 380, 120, 25);
        bookpackage.addActionListener(this);
        add(bookpackage);
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(360, 380, 80, 25);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookpackage.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l12 = new JLabel(i3);
        l12.setBounds(300, 40, 500, 250);
        add(l12);

        
        setVisible(true);
        
    }
    
      public void actionPerformed(ActionEvent ae){
          if (ae.getSource() == checkprice ){
              String pack = cpackage.getSelectedItem();
              int cost = 0;
              if(pack.equals("Gold Package")){
                  cost += 12000;
              } else if(pack.equals("Silver Package")){
                  cost += 25000;
              } else {
                  cost += 32000;
              }
              
              int persons = Integer.parseInt(tfpersons.getText());
              cost *= persons;
              labelprice.setText("Rs " + cost);
          } else if (ae.getSource() == bookpackage ){
              try {
                  Conn c = new Conn();
                  c.s.executeUpdate("insert into bookpackage values('"+labelusername.getText()+"', '"+cpackage.getSelectedItem()+"', '"+tfpersons.getText()+"', '"+labelid.getText()+"', '"+labelnumber.getText()+"', '"+labelphone.getText()+"', '"+labelprice.getText()+"')");
                  
                  JOptionPane.showMessageDialog(null, "Package Booked Successfully");
                 setVisible(false);
              } catch(Exception e){
                  e.printStackTrace();
              }
          } else {
              setVisible(false);
          }
          
          
      }  
    
    public static void main(String[] args){
        new BookPackage("azhartanwar");
    }
}
