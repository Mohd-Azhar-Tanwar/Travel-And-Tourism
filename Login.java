package travel.management.system;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener{
    
    JButton login, signup, password;
    JTextField tfusername,tfpassword;
    
    Login(){
        setSize(700,300);
        setLocation(280,180);
        setLayout(null);
        
        getContentPane().setBackground(Color.WHITE);
        
        JPanel p1 = new JPanel();
        p1.setBackground(new Color (131, 193,233));
        p1.setBounds(0, 0, 300, 300);
        p1.setLayout(null);
        add(p1);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
        Image i2 = i1.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(70, 50, 150, 180);
        p1.add(image);
        
        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBounds(350, 20, 400, 200);
        add(p2);
        
        
        JLabel lblusername = new JLabel ("Username");
        lblusername.setBounds (30,15,90,30);
        lblusername.setFont(new Font("SAN_SERIF",Font.PLAIN,15));
        p2.add(lblusername);
        
         JLabel lbusername = new JLabel ("Travel and Tourism");
        lbusername.setBounds (55,15,200,30);
         lbusername.setForeground(Color.RED);
        lbusername.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        p1.add(lbusername);
        
         tfusername = new JTextField();
        tfusername.setBounds(30,45,200,20);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tfusername);
        
        
        JLabel lblpassword = new JLabel ("Password");
        lblpassword.setBounds (30,70,90,30);
        lblpassword.setFont(new Font("SAN_SERIF",Font.PLAIN,15));
        p2.add(lblpassword);
        
         tfpassword = new JTextField();
        tfpassword.setBounds(30,100,200,20);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tfpassword);
        
         login = new JButton("Login");
        login.setBounds(30,135,80,20);
        login.setBackground(new Color (133, 193, 233));
        login.setForeground(Color.WHITE);
        login.setBorder(new LineBorder(new Color(133, 193, 233)));
        login.addActionListener(this);
        p2.add(login);
        
         signup = new JButton("Signup");
        signup.setBounds(150,135,80,20);
        signup.setBackground(new Color (133, 193, 233));
        signup.setForeground(Color.WHITE);
        signup.setBorder(new LineBorder(new Color(133, 193, 233)));
        signup.addActionListener(this);
        p2.add(signup);
        
         password = new JButton("Forget Password");
        password.setBounds(30,170,120,20);
        password.setBackground(new Color (133, 193, 233));
        password.setForeground(Color.WHITE);
        password.setBorder(new LineBorder(new Color(133, 193, 233)));
        password.addActionListener(this);
        p2.add(password);
        
        JLabel text = new JLabel("Trouble in login...");
        text.setBounds(170, 170, 120, 20);
        text.setForeground(Color.RED);
        p2.add(text);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == login){
            try{
               String username = tfusername.getText();
               String pass = tfpassword.getText();
               
               String query = "select * from account where username = '"+username+"' AND password = '"+pass+"'";
               Conn c = new Conn();
               ResultSet rs = c.s.executeQuery(query);
               if(rs.next()) {
                   setVisible(false);
                   new Loading(username);
               } else {
                   JOptionPane.showMessageDialog(null, "Incorrect username or password");
               }
            } catch(Exception e){
                e.printStackTrace();
            }
        } else if(ae.getSource() == signup){
            setVisible(false);
            new Signup();
                              
        }else{
            setVisible(false);
            new ForgetPassword();
        }
}
    
    public static void main(String[] args){
        new Login();
    }
    
}
