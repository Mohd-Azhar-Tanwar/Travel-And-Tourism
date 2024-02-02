package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
public class AddCustomer extends JFrame implements ActionListener {
    
    JLabel labelusername, labelname;
    Choice id;
    JTextField tfnumber, tfcountry, tfaddress, tfemail, tfphone;
    JRadioButton rmale, rfemale;
    JButton add, back;
    AddCustomer(String username){
        setBounds(270, 120, 800, 500);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel lblusername = new JLabel("username");
        lblusername.setBounds(30, 25, 150, 25);
        add(lblusername);
        
         labelusername = new JLabel();
        labelusername.setBounds(200, 30, 150, 25);
        add(labelusername);
        
        JLabel lblid = new JLabel("id");
        lblid.setBounds(30, 70, 150, 25);
        add(lblid);
        
         id = new Choice();
        id.add("Passport");
        id.add("Aadhar Card");
        id.add("Pan Card");
        id.add("Ration Card");
        id.setBounds(200, 70, 150,25);
        id.setBackground(Color.WHITE);
        add(id);
        
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
        
        rmale = new JRadioButton("Male");
        rmale.setBounds(200, 190, 70, 25);
        rmale.setBackground(Color.WHITE);
        add(rmale);
        
         rfemale = new JRadioButton("Female");
         rfemale.setBounds(280, 190, 70, 25);
         rfemale.setBackground(Color.WHITE);
        add( rfemale);
        
        ButtonGroup bg = new ButtonGroup();
        bg.add(rmale);
        bg.add(rfemale);
        
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
        
        add = new JButton("Add");
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
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/newcustomer.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(380, 20, 400, 500);
        add(image);
        
        try{
            Conn c = new Conn();
           ResultSet rs = c.s.executeQuery("select * from account where username = '"+username+"'");
           while(rs.next()){
               labelusername.setText(rs.getString("username"));
               labelname.setText(rs.getString("name"));
           }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == add){
            String username = labelusername.getText();
            String question = (String)id.getSelectedItem();
            String number = tfnumber.getText();
            String name = labelname.getText();
            String gender = null;
            if (rmale.isSelected()){
                gender = "Male";
            } else {
                gender = "Female";
            }
            String country = tfcountry.getText();
            String address = tfaddress.getText();
            String phone  =  tfphone.getText();
            String email  =  tfemail.getText();
            
            try{
                Conn c = new Conn();
                String query = "insert into customer values('"+username+"', '"+question+"', '"+number+"', '"+name+"', '"+gender+"', '"+country+"', '"+address+"', '"+phone+"', '"+email+"')";
                c.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Customer Details Added Successfully");
                setVisible(false);
            } catch(Exception e){
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }
    
    public static void main(String[] args){
        new AddCustomer("azhartanwar");
    }
    
}
