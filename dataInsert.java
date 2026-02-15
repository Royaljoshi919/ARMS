import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

class FDemo extends JFrame implements ActionListener{

JTextField tx1,tx2;
JButton b1;

FDemo(){
setLayout(new FlowLayout());
tx1 = new JTextField(10);
add(tx1);
tx2 = new JTextField(20);
add(tx2);
b1 = new JButton("click Me");
add(b1);
b1.addActionListener(this);

}

public void actionPerformed(ActionEvent e){

String s1 = tx1.getText();
String s2 = tx2.getText();

try{


Class.forName("com.mysql.jdbc.Driver");

Connection con = DriverManager.getConnection("jdbc:mysql:///sumitdb","root","root");

Statement st = con.createStatement();

st.executeUpdate("insert into login value('"+s1+"','"+s2+"')");

con.close();

System.out.println("data insert");

}
catch(Exception e1){

System.out.println(e1);
}

}

}
 
 class dataInsert{
 
 public static void main(String[] ar){
 
 FDemo f1 = new FDemo();
 
 f1.setVisible(true);
 f1.setBounds(100,200,500,500);
 //f1.setCloseOpretion(f1.EXIT_ON_CLOSE);
 }
 }