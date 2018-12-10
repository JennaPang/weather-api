import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.swing.*;

public class SignIn extends JFrame {
	
	public SignIn() {
		getContentPane().setBackground(new Color(224, 255, 255));
		getContentPane().setLayout(null);

		setResizable(false);
		
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
		sign.setBackground(Color.WHITE);
		sign.setBounds(130, 185, 143, 35);
		sign.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
        		String i = idIn.getText();
        		String p = new String(pswdIn.getPassword());
        		String cp = new String(checkPswd.getPassword());
                String fileName = "C:\\Users\\wndud\\eclipse-workspace\\IndividualProject\\res\\accounts.txt" ; 
               try {
	                BufferedWriter fw = new BufferedWriter(new FileWriter(fileName, true));
	                if (!findWord(fileName,"id:"+i)&&p.equals(cp)&&!i.equals("")&&!p.equals("")&&!cp.equals("")) {
	                    fw.write("id:"+i+"\npassword:"+cp+"\n");
	                    fw.flush();
	                    fw.close();
	                    setVisible(false);
	                   	Log l = new Log();
	                }
	                else{
		               	if(findWord(fileName,"id:"+i)) {
		                	JOptionPane.showMessageDialog(null, "이미 존재하는 아이디 입니다.");
		                	idIn.setText("");
		               	}
		                if(!p.equals(cp)) {
		                	JOptionPane.showMessageDialog(null, "비밀번호와 비밀번호 확인이 일치하지 않습니다.");
		                	pswdIn.setText("");
		                	checkPswd.setText("");
		                }
		                if(i.equals("")||p.equals("")||cp.equals("")) {
		                	JOptionPane.showMessageDialog(null, "모든 칸을 채워주세요.");		                	
		                }
	               	}
	                 
				} catch (IOException e1) {
					e1.printStackTrace();
				}
               
            }
        });
		getContentPane().add(sign);
				
		setTitle("회원가입");
		setSize(388,304);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public boolean findWord(String file, String word) {
		String s;
		try {
			BufferedReader fr = new BufferedReader(new FileReader(file));
			while((s=fr.readLine())!=null) {
				if(s.equals(word)) {
					return true;
				}
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return false;
	}
}
