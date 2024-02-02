package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



public class Signup extends JFrame implements ActionListener{
    
    JButton create, back;
    JTextField tfname, tfusername, tfpassword, tfanswer;
    Choice security;
    Signup() {
        setBounds(300, 200, 750,290);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JPanel p1 = new JPanel();
        p1.setBackground(new Color(133, 193, 233));
        p1.setBounds(0, 0, 400, 270);
        p1.setLayout(null);
        add(p1);
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setFont(new Font("Tahoma", Font.BOLD,12));
        lblusername.setBounds(20, 14, 125, 25);
        p1.add(lblusername);
        
        tfusername = new JTextField();
        tfusername.setBounds(160, 18, 140, 16);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfusername);
        
        JLabel lblname = new JLabel("Name");
        lblname.setFont(new Font("Tahoma", Font.BOLD,12));
        lblname.setBounds(20, 34, 125, 25);
        p1.add(lblname);
        
         tfname = new JTextField();
        tfname .setBounds(160, 40, 140, 16);
        tfname .setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfname );
        
         JLabel lblpassowrd = new JLabel("Password");
        lblpassowrd.setFont(new Font("Tahoma", Font.BOLD,12));
        lblpassowrd.setBounds(20, 56, 125, 25);
        p1.add(lblpassowrd);
        
         tfpassword = new JTextField();
        tfpassword .setBounds(160, 62, 140, 14);
        tfpassword .setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfpassword);
        
        JLabel lblsecurity = new JLabel("Security Question");
        lblsecurity.setFont(new Font("Tahoma", Font.BOLD,12));
        lblsecurity.setBounds(20, 78, 125, 25);
        p1.add(lblsecurity);
        
         security = new Choice();
        security.add("Fav Character From The Boys");
        security.add("Fav Marvel Superhero");
        security.add("Your Lucky Number");
        security.add("Your Childhood superhero");
        security.setBounds(160, 82, 140,14);
        p1.add(security);
        
        JLabel lblanswer = new JLabel("Answer");
        lblanswer.setFont(new Font("Tahoma", Font.BOLD,12));
        lblanswer.setBounds(20, 103, 125, 25);
        p1.add(lblanswer);
        
         tfanswer = new JTextField();
        tfanswer.setBounds(160, 110, 140, 14);
        tfanswer.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfanswer);
        
         create = new JButton("Create");
        create.setBackground(Color.WHITE );
        create.setForeground(new Color(133, 193, 233));
        create.setFont(new Font("Tahoma", Font.BOLD,12));
        create.setBounds(50, 160, 80, 25);
        create.addActionListener(this);
        p1.add(create);
        
         back = new JButton("Back");
         back.setBackground(Color.WHITE);
         back.setForeground(new Color(133, 193, 233));
         back.setFont(new Font("Tahoma", Font.BOLD,12));
         back.setBounds(200, 160, 80, 25);
        back.addActionListener(this);
        p1.add( back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/signup.png"));
        Image i2 = i1.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(500, 30, 150, 180);
        add(image);
        
        setVisible(true);
            
    }
    
   public void actionPerformed(ActionEvent ae){
       if(ae.getSource() == create) {
           String username = tfusername.getText();
           String name = tfname.getText();
           String password = tfpassword.getText();
           String question = security.getSelectedItem();
           String answer = tfanswer.getText();
           
           String query = "insert into account values('"+username+"', '"+name+"', '"+password+"', '"+question+"', '"+answer+"')";
           try{
               Conn c = new Conn();
               c.s.executeUpdate(query);
               
               JOptionPane.showMessageDialog(null, "Account Created Successfully");
               
               setVisible(false);
               new Login();
           }catch (Exception e){
               e.printStackTrace();
           }
       } else if (ae.getSource() == back) {
           setVisible(false);
           new Login();
       }
   }
    
    
    public static void main(String[] args){
        new Signup();
    }
            
          
}
