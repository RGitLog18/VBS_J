import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

class Transfer extends JFrame {
    Transfer(String username) {
        Font f = new Font("Futura", Font.BOLD, 30);
        Font f2 = new Font("Calibri", Font.PLAIN, 18);

        JLabel title = new JLabel("Transfer Funds", JLabel.CENTER);
        JLabel l1 = new JLabel("Receiver:");
        JTextField t1 = new JTextField(10);

        JLabel l2 = new JLabel("Amount:");
        JTextField t2 = new JTextField(10);

        JButton b1 = new JButton("Transfer");
        JButton b2 = new JButton("Back");

        title.setFont(f);
        l1.setFont(f2);
        t1.setFont(f2);
        l2.setFont(f2);
        t2.setFont(f2);
        b1.setFont(f2);
        b2.setFont(f2);

        Container c = getContentPane();
        c.setLayout(null);
        Color r=new Color(111, 188, 172);
        c.setBackground(r);

        int labelX = 200, fieldX = 400, yStart = 80, width = 150, height = 30, gap = 40;

        title.setBounds(250, 20, 300, 40);

        l1.setBounds(labelX, yStart, width, height);
        t1.setBounds(fieldX, yStart, width, height);

        l2.setBounds(labelX, yStart + gap, width, height);
        t2.setBounds(fieldX, yStart + gap, width, height);

        b1.setBounds(250, yStart + 2 * gap, 120, 40);
        b2.setBounds(400, yStart + 2 * gap, 120, 40);

        c.add(title);
        c.add(l1);
        c.add(t1);
        c.add(l2);
        c.add(t2);
        c.add(b1);
        c.add(b2);

        b1.addActionListener(
                a->{
                    double balance=0.0;
                    double balance1=0.0;

                    String s=t1.getText();
                    String s1=t1.getText();
                    String s2=t2.getText();

                    if(s1.isEmpty()||s2.isEmpty())
                    {
                        JOptionPane.showMessageDialog(null, "Please enter details.");
                        return;
                    }
                    double transfamt=Double.parseDouble(t2.getText());
                    String url= "jdbc:mysql://localhost:3306/3dec";
                    try(Connection con= DriverManager.getConnection(url,"root","R1a2j3#*")) {
                        String sql = "Select balance from users where username =?";
                        try (PreparedStatement pst = con.prepareStatement(sql))
                        {
                                pst.setString(1, username);
                                ResultSet rs = pst.executeQuery();
                                if (rs.next())
                                {
                                    balance = rs.getDouble("balance");
                                }
                        }
                    }
                    catch(Exception e)
                    {
                        JOptionPane.showMessageDialog(null,e.getMessage());
                    }
                    try(Connection con=DriverManager.getConnection(url,"root","R1a2j3#*"))
                    {
                        String sql="select balance from users where username=?";
                        try(PreparedStatement pst= con.prepareStatement(sql))
                        {
                            pst.setString(1,t1.getText());
                            ResultSet rs=pst.executeQuery();
                            if(rs.next())
                            {
                                balance1=rs.getDouble("balance");
                            }
                            else {
                                JOptionPane.showMessageDialog(null,"Receiver doesnt exist.");
                                return;
                            }
                        }
                    }
                    catch (Exception e)
                    {
                        JOptionPane.showMessageDialog(null,e.getMessage());
                    }
                     if(transfamt>balance)
                    {
                        JOptionPane.showMessageDialog(null,"You can't Transfer.");
                    }

                    else
                    {
                        double result=balance-transfamt;
                        double amt=balance1+transfamt;
                        try(Connection con= DriverManager.getConnection(url,"root","R1a2j3#*"))
                        {
                            String sql = "Update users set balance=? where username=?";
                            try (PreparedStatement pst =con.prepareStatement(sql))
                            {
                                pst.setDouble(1,result);
                                pst.setString(2,username);
                                pst.executeUpdate();
                                Passbook(username,"Transferring to "+t1.getText(),-transfamt,result);
                            }
                        }
                        catch(Exception e)
                        {
                            JOptionPane.showMessageDialog(null,e.getMessage());
                        }



                        try(Connection con=DriverManager.getConnection(url,"root","R1a2j3#*"))
                        {
                            String sql="Update users set balance =? where username=?";
                            try(PreparedStatement pst=con.prepareStatement(sql))
                            {
                                pst.setDouble(1,amt);
                                pst.setString(2,t1.getText());
                                pst.executeUpdate();
                                JOptionPane.showMessageDialog(null,"Transferred Succefully.");
                                t1.setText("");
                                t2.setText("");
                                Passbook(t1.getText(),"Transferring from "+username,transfamt,amt);
                            }
                        }
                        catch (Exception e)
                        {
                            JOptionPane.showMessageDialog(null,e.getMessage());
                        }
                    }
                }
        );

        b2.addActionListener(
                a->{
                    new Home(username);
                    dispose();
                }
        );

        setVisible(true);
        setSize(800, 550);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Transfer Funds");
    }
    void Passbook(String username,String desc,double amount, double balance ) {
        String url = "jdbc:mysql://localhost:3306/3dec";
        try (Connection con = DriverManager.getConnection(url, "root", "R1a2j3#*")) {
            String sql = "insert into transactions(username,description,amount,balance) values(?,?,?,?)";
            try (PreparedStatement pst = con.prepareStatement(sql)) {
                pst.setString(1, username);
                pst.setString(2, desc);
                pst.setDouble(3, amount);
                pst.setDouble(4, balance);
                pst.executeUpdate();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    public static void main(String[] args) {
        new Transfer(" Rajshree");
    }
}
