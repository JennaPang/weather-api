import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Weather extends JFrame{

	private JFrame frame;

	public static void main(String[] args) {
		Weather window = new Weather();
	}

	public Weather() {
		setBounds(100, 100, 350, 416);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("오늘의 날씨");
		getContentPane().setLayout(null);
		
		JPanel p1 = new JPanel();
		p1.setBounds(0, 0, 338, 154);
		getContentPane().add(p1);
		p1.setLayout(new BorderLayout(0, 0));
		
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
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		p2.add(separator_1, BorderLayout.EAST);
		
		JPanel p3 = new JPanel();
		p3.setBounds(162, 153, 176, 140);
		getContentPane().add(p3);
		p3.setLayout(new BorderLayout(0, 0));
		
		JSeparator separator_2 = new JSeparator();
		p3.add(separator_2, BorderLayout.SOUTH);
		
		JPanel p4 = new JPanel();
		p4.setBounds(162, 293, 176, 88);
		getContentPane().add(p4);
		p4.setLayout(new BorderLayout(0, 0));
		setVisible(true);
	}
}
