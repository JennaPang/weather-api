import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class LogIn extends JFrame {
	private JTextField idIn;
	private JPasswordField pswdIn;

	public LogIn() {
		getContentPane().setBackground(new Color(224, 255, 255));
		getContentPane().setLayout(null);
		
		JLabel title = new JLabel("로그인");
		title.setFont(new Font("HY그래픽M", Font.BOLD, 30));
		title.setBounds(145, 30, 95, 35);
		getContentPane().add(title);
		
		JLabel id = new JLabel("Id:");
		id.setFont(new Font("HY그래픽M", Font.PLAIN, 13));
		id.setBounds(92, 92, 17, 16);
		getContentPane().add(id);
		
		JLabel pswd = new JLabel("Password:");
		pswd.setFont(new Font("HY그래픽M", Font.PLAIN, 13));
		pswd.setBounds(45, 123, 64, 16);
		getContentPane().add(pswd);
		
		idIn= new JTextField();
		idIn.setBounds(121, 90, 184, 21);
		getContentPane().add(idIn);
		idIn.setColumns(10);
		
		pswdIn = new JPasswordField();
		pswdIn.setBounds(119, 121, 184, 21);
		getContentPane().add(pswdIn);
		pswdIn.setColumns(10);
		
		JButton log = new JButton("로그인");
		log.setFont(new Font("굴림", Font.BOLD, 16));
		log.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
        		String i = idIn.getText();
        		String p = new String(pswdIn.getPassword());
        		String fileName = "C:\\Users\\wndud\\eclipse-workspace\\IndividualProject\\res\\accounts.txt" ; 
        		if(findWord(fileName,"id:"+i)&&findWord(fileName,"password:"+p)) {
        			Weather w = new Weather();
        		}
        		else {
        			JOptionPane.showMessageDialog(null, "아이디와 비밀번호를 다시 확인하세요.");
        		}
            }
        });
		log.setBackground(Color.WHITE);
		log.setBounds(121, 162, 143, 35);
		getContentPane().add(log);
		
		JButton newUser = new JButton("회원가입");
		newUser.setBackground(Color.WHITE);
		newUser.setFont(new Font("굴림", Font.PLAIN, 9));
		newUser.setBounds(212, 209, 77, 19);
		newUser.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
        		setVisible(false);
        		SignIn signin = new SignIn();
            }
        });
		getContentPane().add(newUser);
		
		JLabel label = new JLabel("회원이 아니세요?");
		label.setBounds(94, 210, 108, 15);
		getContentPane().add(label);
		
		setTitle("로그인");
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
