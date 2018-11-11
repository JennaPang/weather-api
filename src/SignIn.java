import java.awt.*;
import java.awt.event.*;
import java.io.*;

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
		id.setBounds(105, 92, 17, 16);
		getContentPane().add(id);
		
		JLabel pswd = new JLabel("Password:");
		pswd.setFont(new Font("HY그래픽M", Font.PLAIN, 13));
		pswd.setBounds(58, 123, 64, 16);
		getContentPane().add(pswd);
		
		JLabel cpswd = new JLabel("Check password:");
		cpswd.setFont(new Font("HY그래픽M", Font.PLAIN, 11));
		cpswd.setBounds(33, 153, 89, 14);
		getContentPane().add(cpswd);
		
		JTextField idIn= new JTextField();
		idIn.setBounds(134, 90, 184, 21);
		getContentPane().add(idIn);
		idIn.setColumns(10);
		
		JPasswordField pswdIn = new JPasswordField();
		pswdIn.setBounds(132, 149, 184, 21);
		getContentPane().add(pswdIn);
		pswdIn.setColumns(10);
		
		JPasswordField checkPswd = new JPasswordField();
		checkPswd.setBounds(132, 121, 184, 21);
		getContentPane().add(checkPswd);
		checkPswd.setColumns(10);
		
		JButton sign = new JButton("가입!");
		sign.setFont(new Font("굴림", Font.BOLD, 16));
		sign.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
        		String i = idIn.getText();
        		String p = new String(pswdIn.getPassword());
        		String cp = new String(checkPswd.getPassword());
                String fileName = "C:\\Users\\wndud\\eclipse-workspace\\IndividualProject\\res\\accounts.txt" ; 
                try{             
                    BufferedWriter fw = new BufferedWriter(new FileWriter(fileName, true));
                    fw.write(i+"/"+cp+"/");
                    fw.flush();
                    fw.close();
                }catch(Exception ex){
                    ex.printStackTrace();
                }
            }
        });
		sign.setBackground(Color.WHITE);
		sign.setBounds(130, 185, 143, 35);
		getContentPane().add(sign);
				
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
