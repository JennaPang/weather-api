import java.awt.*;
import javax.swing.*;

public class Log extends JFrame {
	
	public Log(){
		getContentPane().setBackground(new Color(224, 255, 255));
		getContentPane().setLayout(null);
		
		JLabel img = new JLabel(new ImageIcon("C:\\Users\\wndud\\eclipse-workspace\\IndividualProject\\res\\proj.png"));
		img.setBounds(10, 10, 225, 300);
		getContentPane().add(img);
		
		JLabel title = new JLabel("사용자 맞춤 설정");
		title.setFont(new Font("HY그래픽M", Font.BOLD, 17));
		title.setBounds(245, 10, 139, 20);
		getContentPane().add(title);
		
		JLabel info = new JLabel("각 패널에 표시할 날씨정보를 선택해주세요");
		info.setFont(new Font("HY그래픽M", Font.PLAIN, 11));
		info.setBounds(245, 35, 229, 15);
		getContentPane().add(info);
				
		JLabel no1 = new JLabel("1:");
		no1.setBounds(245, 60, 50, 15);
		getContentPane().add(no1);
		
		JComboBox list1 = new JComboBox();
		list1.setModel(new DefaultComboBoxModel(new String[] {" ","기온", "강수확률", "미세먼지", "일출/일몰 시간"}));
		list1.setBounds(245, 78, 186, 23);
		getContentPane().add(list1);

		JLabel no2 = new JLabel("2:");
		no2.setBounds(245, 110, 50, 15);
		getContentPane().add(no2);
		
		JComboBox list2 = new JComboBox();
		list2.setModel(new DefaultComboBoxModel(new String[] {" ","기온", "강수확률", "미세먼지", "일출/일몰 시간"}));
		list2.setBounds(245, 128, 186, 23);
		getContentPane().add(list2);
		
		JLabel no3 = new JLabel("3:");
		no3.setBounds(245, 160, 50, 15);
		getContentPane().add(no3);
		
		JComboBox list3 = new JComboBox();
		list3.setModel(new DefaultComboBoxModel(new String[] {" ","기온", "강수확률", "미세먼지", "일출/일몰 시간"}));
		list3.setBounds(245, 178, 186, 23);
		getContentPane().add(list3);
		
		JLabel no4 = new JLabel("4:");
		no4.setBounds(245, 210, 50, 15);
		getContentPane().add(no4);
		
		JComboBox list4 = new JComboBox();
		list4.setModel(new DefaultComboBoxModel(new String[] {" ","기온", "강수확률", "미세먼지", "일출/일몰 시간"}));
		list4.setBounds(245, 228, 186, 23);
		getContentPane().add(list4);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setBounds(375, 273, 99, 30);
		getContentPane().add(btnNewButton);
				
		setTitle("초기 세팅");
		setSize(496,351);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		Log initFrame = new Log();
	}
}
