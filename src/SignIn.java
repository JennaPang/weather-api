import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class SignIn extends JFrame {
	
	public SignIn() {
		getContentPane().setBackground(new Color(224, 255, 255));
		getContentPane().setLayout(null);
		
		JLabel title = new JLabel("회원가입");
		title.setFont(new Font("HY그래픽M", Font.BOLD, 30));
		title.setBounds(130, 30, 126, 35);
		getContentPane().add(title);
		
		JLabel id = new JLabel("Id:");
		id.setFont(new Font("HY그래픽M", Font.PLAIN, 13));
		id.setBounds(92, 92, 17, 16);
		getContentPane().add(id);
		
		JLabel pswd = new JLabel("Password:");
		pswd.setFont(new Font("HY그래픽M", Font.PLAIN, 13));
		pswd.setBounds(45, 123, 64, 16);
		getContentPane().add(pswd);
		
		JLabel cp = new JLabel("Check password:");
		cp.setFont(new Font("HY그래픽M", Font.PLAIN, 11));
		cp.setBounds(20, 153, 89, 14);
		getContentPane().add(cp);
		
		JTextField idIn= new JTextField();
		idIn.setBounds(121, 90, 184, 21);
		getContentPane().add(idIn);
		idIn.setColumns(10);
		
		JPasswordField pswdIn = new JPasswordField();
		pswdIn.setBounds(119, 149, 184, 21);
		getContentPane().add(pswdIn);
		pswdIn.setColumns(10);
		
		JPasswordField checkPswd = new JPasswordField();
		checkPswd.setBounds(119, 121, 184, 21);
		getContentPane().add(checkPswd);
		checkPswd.setColumns(10);
		
		JButton log = new JButton("가입!");
		log.setFont(new Font("굴림", Font.BOLD, 16));
		log.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		log.setBackground(Color.WHITE);
		log.setBounds(130, 185, 143, 35);
		getContentPane().add(log);
		
		
		
		setTitle("회원가입");
		setSize(388,304);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new SignIn();
	}
}
