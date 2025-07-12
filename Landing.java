
import javax.swing.*;
        import java.awt.*;

class Landing extends JFrame {
    Landing() {
        Font f = new Font("futura", Font.BOLD, 40);
        Font f2 = new Font("Calibri", Font.PLAIN, 22);

        JLabel l1 = new JLabel("Virtual Banking System", JLabel.CENTER);
        JButton b1 = new JButton("Admin");
        JButton b2 = new JButton("Existing Customer");
        JButton b3 = new JButton("New Customer");

        ImageIcon image=new ImageIcon("C:/myprojects/VBS/landingbg.JPG");
        Image imageIcon = image.getImage().getScaledInstance(90, 70, Image.SCALE_SMOOTH);
        image = new ImageIcon(imageIcon);

        JLabel label=new JLabel(image);

        l1.setFont(f);

        b1.setFont(f2);
        b2.setFont(f2);
        b3.setFont(f2);

        b1.addActionListener(
                a->{
                    new Alogin();
                    dispose();
                }
        );

        b2.addActionListener(
                a->{
                    new Elogin();
                    dispose();
                }
        );

        b3.addActionListener(
                a->{
                    new Nlogin();
                    dispose();
                }
        );

        Container c = getContentPane();
        c.setLayout(null);
        Color r=new Color(111, 168, 172);
        c.setBackground(r);

        l1.setBounds(150, 50, 500, 50);
        b1.setBounds(300, 150, 200, 50);
        b2.setBounds(300, 230, 200, 50);
        b3.setBounds(300, 310, 200, 50);

        c.add(l1);
        c.add(b1);
        c.add(label);
        c.add(b2);
        c.add(b3);

        setVisible(true);
        setSize(800, 550);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Landing Page");
    }

    public static void main(String[] args) {
        Landing a = new Landing();
    }
}
