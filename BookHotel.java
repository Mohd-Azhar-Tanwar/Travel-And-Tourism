package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class BookHotel extends JFrame implements ActionListener {
    
    Choice chotel, cac, cfood;
    JTextField tfpersons, tfdays;
    String username;
    JLabel labelusername, labelid ,labelnumber,labelphone,labelprice;
    JButton checkprice,bookpackage,back;
    BookHotel(String username){
        this.username = username;
        setBounds(340,120,800, 550);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel text = new JLabel("BOOK HOTEL");
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
        
        JLabel lblpackage = new JLabel("Select Hotel");
        lblpackage.setFont(new Font("Tahoma", Font.PLAIN,12));
        lblpackage.setBounds(30, 80, 150, 20);
        add(lblpackage);
        
        chotel = new Choice();
        chotel.setBounds(180, 80, 150, 20);
        add(chotel);
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from hotel");
            while(rs.next()){
                chotel.add(rs.getString("name"));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        
        JLabel lblpersons = new JLabel("Total Persons");
        lblpersons.setFont(new Font("Tahoma", Font.PLAIN,12));
        lblpersons.setBounds(30, 120, 150, 25);
        add(lblpersons);
        
        tfpersons = new JTextField("1");
        tfpersons.setBounds(180,120,150,25);
        add(tfpersons);
        
        JLabel lbldays = new JLabel("No. of Days");
        lbldays.setFont(new Font("Tahoma", Font.PLAIN,12));
        lbldays.setBounds(30, 160, 150, 25);
        add(lbldays);
        
        tfdays = new JTextField("1");
        tfdays.setBounds(180,160,150,25);
        add(tfdays);
        
        JLabel lblac = new JLabel("AC / Non-AC");
        lblac.setFont(new Font("Tahoma", Font.PLAIN,12));
        lblac.setBounds(30, 200, 150, 25);
        add(lblac);
        
        cac = new Choice();
        cac.add("AC");
        cac.add("Non- AC");
        cac.setBounds(180, 200, 150, 20);
        add(cac);
        
        JLabel lblfood = new JLabel("Food Included");
        lblfood.setFont(new Font("Tahoma", Font.PLAIN,12));
        lblfood.setBounds(30, 240, 150, 25);
        add(lblfood);
        
        cfood = new Choice();
        cfood.add("Yes");
        cfood.add("No");
        cfood.setBounds(180, 240, 150, 20);
        add(cfood);
        
        JLabel lblid = new JLabel("id");
        lblid.setFont(new Font("Tahoma", Font.PLAIN,12));
        lblid.setBounds(30, 280, 150, 25);
        add(lblid);
        
         labelid = new JLabel();
        labelid.setBounds(180, 280, 150, 25);
        add(labelid);
        
        JLabel lblnumber = new JLabel("Number");
        lblnumber.setFont(new Font("Tahoma", Font.PLAIN,12));
        lblnumber.setBounds(30, 320, 150, 25);
        add(lblnumber);
        
         labelnumber = new JLabel();
        labelnumber.setBounds(180, 320, 150, 25);
        add(labelnumber);
        
        JLabel lblphone = new JLabel("phone");
        lblphone.setFont(new Font("Tahoma", Font.PLAIN,12));
        lblphone.setBounds(30, 360, 150, 25);
        add(lblphone);
        
         labelphone = new JLabel();
        labelphone.setBounds(180, 360, 150, 25);
        add(labelphone);
        
        JLabel lbltotal = new JLabel("Total Price");
        lbltotal.setFont(new Font("Tahoma", Font.PLAIN,12));
        lbltotal.setBounds(30, 400, 150, 25);
        add(lbltotal);
        
        labelprice = new JLabel();
        labelprice.setBounds(180, 400, 150, 25);
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
        checkprice.setBounds(40, 450, 120, 25);
        checkprice.addActionListener(this);
        add(checkprice);
        
        bookpackage = new JButton("Book Hotel");
        bookpackage.setBackground(Color.BLACK);
        bookpackage.setForeground(Color.WHITE);
        bookpackage.setBounds(200, 450, 120, 25);
        bookpackage.addActionListener(this);
        add(bookpackage);
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(360, 450, 80, 25);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/book.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l12 = new JLabel(i3);
        l12.setBounds(320, 40, 500, 250);
        add(l12);

        
        setVisible(true);
        
    }
    
      public void actionPerformed(ActionEvent ae){
          if (ae.getSource() == checkprice ){
              try {
              Conn c = new Conn();
              ResultSet rs = c.s.executeQuery("select * from hotel where name='"+chotel.getSelectedItem()+"'");
              while(rs.next()){
                  int cost =Integer.parseInt(rs.getString("costperperson"));
                  int food =Integer.parseInt(rs.getString("foodincluded"));
                  int ac =Integer.parseInt(rs.getString("acroom"));
                  
                  int persons = Integer.parseInt(tfpersons.getText());
                  int days = Integer.parseInt(tfdays.getText());
                  
                  String acselected = cac.getSelectedItem();
                  String foodselected = cfood.getSelectedItem();
                  
                  if(persons * days > 0) {
                      int total = 0;
                      total += acselected.equals("AC") ? ac :0;
                      total += foodselected.equals("Yes" ) ? food :0;
                      total += cost;
                      total = total * persons * days;
                      labelprice.setText("Rs " + total);
                  } else {
                      JOptionPane.showMessageDialog(null, "Please enter a valid number");
                  }
              }
              
              }catch (Exception e){
                  e.printStackTrace();
              }
          } else if (ae.getSource() == bookpackage ){
              try {
                  Conn c = new Conn();
                  c.s.executeUpdate("insert into bookhotel values('"+labelusername.getText()+"', '"+chotel.getSelectedItem()+"', '"+tfpersons.getText()+"', '"+tfdays.getText()+"', '"+cac.getSelectedItem()+"', '"+cfood.getSelectedItem()+"', '"+labelid.getText()+"', '"+labelnumber.getText()+"', '"+labelphone.getText()+"', '"+labelprice.getText()+"')");
                  
                  JOptionPane.showMessageDialog(null, "Hotel Booked Successfully");
                 setVisible(false);
              } catch(Exception e){
                  e.printStackTrace();
              }
          } else {
              setVisible(false);
          }
          
          
      }  
    
    public static void main(String[] args){
        new BookHotel("azhartanwar");
    }
}

