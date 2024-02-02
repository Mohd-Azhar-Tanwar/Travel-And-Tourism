package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
public class UpdateCustomer extends JFrame implements ActionListener {
    
    JLabel labelusername, labelname;
    
    JTextField tfnumber, tfcountry, tfaddress, tfemail, tfphone, tfid, tfgender;
    JRadioButton rmale, rfemale;
    JButton add, back;
    UpdateCustomer(String username){
        setBounds(350, 140, 800, 500);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel text = new JLabel("UPDATE CUSTOMER DETAILS");
        text.setBounds(40, 0, 300, 25);
        text.setFont(new Font("Tahoma", Font.PLAIN,16));
        add(text);
        
        JLabel lblusername = new JLabel("username");
        lblusername.setBounds(30, 25, 150, 25);
        add(lblusername);
        
         labelusername = new JLabel();
        labelusername.setBounds(200, 30, 150, 25);
        add(labelusername);
        
        JLabel lblid = new JLabel("id");
        lblid.setBounds(30, 70, 150, 25);
        add(lblid);
        
         tfid = new JTextField();
        tfid.setBounds(200, 70, 150, 20);
        add(tfid);
        
        JLabel lblnumber = new JLabel("Number");
        lblnumber.setBounds(30, 110, 150, 25);
        add(lblnumber);
        
        tfnumber = new JTextField();
        tfnumber.setBounds(200, 110, 150, 20);
        add(tfnumber);
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(30, 150, 150, 25);
        add(lblname);
        
        
         labelname = new JLabel();
        labelname.setBounds(200, 150, 150, 25);
        add(labelname);
        
        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(30, 190, 150, 25);
        add(lblgender);
        
        tfgender = new JTextField();
        tfgender.setBounds(200, 190, 150, 20);
        add(tfgender);
        
        JLabel lblcountry = new JLabel("Country");
        lblcountry.setBounds(30, 230, 150, 25);
        add(lblcountry);
        
        tfcountry = new JTextField();
        tfcountry.setBounds(200, 230, 150, 20);
        add(tfcountry);
        
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(30, 270, 150, 25);
        add(lbladdress);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(200, 270, 150, 20);
        add(tfaddress);
        
        JLabel lblemail = new JLabel("Email");
        lblemail.setBounds(30, 310, 150, 25);
        add(lblemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(200, 310, 150, 20);
        add(tfemail);
        
        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(30, 350, 150, 25);
        add(lblphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(200, 350, 150, 20);
        add(tfphone);
        
        add = new JButton("Update");
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.setBounds(50, 400, 100, 25);
        add.addActionListener(this);
        add(add);
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(200, 400, 100, 25);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/update.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(380, 20, 400, 400);
        add(image);
        
        try{
            Conn c = new Conn();
           ResultSet rs = c.s.executeQuery("select * from customer where username = '"+username+"'");
           while(rs.next()){
               labelusername.setText(rs.getString("username"));
               labelname.setText(rs.getString("name"));
               tfid.setText(rs.getString("id"));
               tfnumber.setText(rs.getString("number"));
               tfgender.setText(rs.getString("gender"));
               tfcountry.setText(rs.getString("country"));
               tfaddress.setText(rs.getString("address"));
               tfphone.setText(rs.getString("phone"));
               tfemail.setText(rs.getString("email"));
           }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == add){
            String username = labelusername.getText();
            String id = tfid.getText();
            String number = tfnumber.getText();
            String name = labelname.getText();
            String gender =tfgender.getText();
            String country = tfcountry.getText();
            String address = tfaddress.getText();
            String phone  =  tfphone.getText();
            String email  =  tfemail.getText();
            
            try{
                Conn c = new Conn();
                String query = "update customer set username= '"+username+"',  id='"+id+"', number= '"+number+"', name ='"+name+"', gender = '"+gender+"', country = '"+country+"', address= '"+address+"',phone = '"+phone+"', email= '"+email+"'";
                c.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Customer Details Updated Successfully");
                setVisible(false);
            } catch(Exception e){
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }
    
    public static void main(String[] args){
        new UpdateCustomer("azhartanwar");
    }
    
}
