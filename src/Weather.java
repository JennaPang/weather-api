import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Weather extends JFrame{

	private JFrame frame;

	public Weather() {
		setSize(350, 416);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("오늘의 날씨");
		getContentPane().setLayout(null);
		
		JPanel p1 = new JPanel();
		p1.setBounds(0, 0, 338, 154);
		getContentPane().add(p1);
		p1.setLayout(new BorderLayout(0, 0));
		p1.setBackground(new Color(224, 255, 255));
		
		JLabel lb1 = new JLabel("No.1");
		lb1.setFont(new Font("함초롬돋움", Font.PLAIN, 27));
		p1.add(lb1, BorderLayout.NORTH);
		
		JLabel lb101 = new JLabel("No.1 info");
		lb101.setForeground(Color.ORANGE);
		lb101.setHorizontalAlignment(SwingConstants.CENTER);
		lb101.setFont(new Font("함초롬돋움", Font.BOLD, 40));
		p1.add(lb101, BorderLayout.CENTER);
		
		JSeparator separator = new JSeparator();
		p1.add(separator, BorderLayout.SOUTH);
		
		JPanel p2 = new JPanel();
		p2.setBounds(0, 153, 162, 228);
		getContentPane().add(p2);
		p2.setLayout(new BorderLayout(0, 0));
		p2.setBackground(new Color(224, 255, 255));
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		p2.add(separator_1, BorderLayout.EAST);
		
		JLabel lb2 = new JLabel("No.2");
		lb2.setFont(new Font("함초롬돋움", Font.PLAIN, 22));
		p2.add(lb2, BorderLayout.NORTH);
		
		JLabel lb201 = new JLabel("No.2 info");
		lb201.setFont(new Font("함초롬돋움", Font.BOLD, 31));
		lb201.setHorizontalAlignment(SwingConstants.CENTER);
		lb201.setForeground(Color.ORANGE);
		p2.add(lb201, BorderLayout.CENTER);
		
		JPanel p3 = new JPanel();
		p3.setBounds(162, 153, 176, 140);
		getContentPane().add(p3);
		p3.setLayout(new BorderLayout(0, 0));
		p3.setBackground(new Color(224, 255, 255));
		
		JSeparator separator_2 = new JSeparator();
		p3.add(separator_2, BorderLayout.SOUTH);
		
		JLabel lb3 = new JLabel("No.3");
		lb3.setFont(new Font("함초롬돋움", Font.PLAIN, 17));
		p3.add(lb3, BorderLayout.NORTH);
		
		JLabel lb301 = new JLabel("No.3 info");
		lb301.setFont(new Font("함초롬돋움", Font.BOLD, 28));
		lb301.setForeground(Color.ORANGE);
		lb301.setHorizontalAlignment(SwingConstants.CENTER);
		p3.add(lb301, BorderLayout.CENTER);
		
		JPanel p4 = new JPanel();
		p4.setBounds(162, 293, 176, 88);
		getContentPane().add(p4);
		p4.setLayout(new BorderLayout(0, 0));
		p4.setBackground(new Color(224, 255, 255));
		
		JLabel lb4 = new JLabel("No.4");
		lb4.setFont(new Font("함초롬돋움", Font.PLAIN, 15));
		p4.add(lb4, BorderLayout.NORTH);
		
		JLabel lb401 = new JLabel("No.4 info");
		lb401.setHorizontalAlignment(SwingConstants.CENTER);
		lb401.setForeground(Color.ORANGE);
		lb401.setFont(new Font("함초롬돋움", Font.BOLD, 25));
		p4.add(lb401, BorderLayout.CENTER);
		setVisible(true);
		
		URLConn infoClass = new URLConn();
		lb101.setText(Double.toString(infoClass.getTemp()));
		lb201.setText(Double.toString(infoClass.getWind()));
		lb301.setText(Double.toString(infoClass.getHum()));
		lb401.setText(Double.toString(infoClass.getSunset()));
	}
}
