import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.swing.*;

public class Log extends JFrame {

	String fileName = "C:\\Users\\wndud\\eclipse-workspace\\IndividualProject\\res\\accounts.txt" ; 
	public Log(){
		
		getContentPane().setBackground(new Color(224, 255, 255));
		getContentPane().setLayout(null);

		setResizable(false);
		
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
		list1.setModel(new DefaultComboBoxModel(new String[] {" ","기온", "습도", "최고/최저 기온", "일출/일몰 시간", "풍속"}));
		list1.setBounds(245, 78, 186, 23);
		getContentPane().add(list1);

		JLabel no2 = new JLabel("2:");
		no2.setBounds(245, 110, 50, 15);
		getContentPane().add(no2);
		
		JComboBox list2 = new JComboBox();
		list2.setModel(new DefaultComboBoxModel(new String[] {" ","기온", "습도", "최고/최저 기온", "일출/일몰 시간", "풍속"}));
		list2.setBounds(245, 128, 186, 23);
		getContentPane().add(list2);
		
		JLabel no3 = new JLabel("3:");
		no3.setBounds(245, 160, 50, 15);
		getContentPane().add(no3);
		
		JComboBox list3 = new JComboBox();
		list3.setModel(new DefaultComboBoxModel(new String[] {" ","기온", "습도", "최고/최저 기온", "일출/일몰 시간", "풍속"}));
		list3.setBounds(245, 178, 186, 23);
		getContentPane().add(list3);
		
		JLabel no4 = new JLabel("4:");
		no4.setBounds(245, 210, 50, 15);
		getContentPane().add(no4);
		
		JComboBox list4 = new JComboBox();
		list4.setModel(new DefaultComboBoxModel(new String[] {" ","기온", "습도", "최고/최저 기온", "일출/일몰 시간", "풍속"}));
		list4.setBounds(245, 228, 186, 23);
		getContentPane().add(list4);
		
		JButton submit = new JButton("Submit");
		submit.setBounds(375, 273, 99, 30);
		submit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	int one = list1.getSelectedIndex();
            	int two = list2.getSelectedIndex();
            	int three = list3.getSelectedIndex();
            	int four = list4.getSelectedIndex();
            	if(one==0||two==0||three==0||four==0) {
            		JOptionPane.showMessageDialog(null, "모든 칸을 선택 해 주세요.");
            	}
            	else {
	        		try {
	        			BufferedWriter fw = new BufferedWriter(new FileWriter(fileName,true));
	        			fw.write(one+" "+two+" "+three+" "+four+"\n");
	                    fw.flush();
	                    fw.close();
	        			setVisible(false);
	        			JOptionPane.showMessageDialog(null, "환영합니다!");
	        			LogIn login = new LogIn();
	        		} catch(IOException e1) {
	        			e1.printStackTrace();
	        		}
            	}
            }
        });
		submit.setBackground(Color.WHITE);
		getContentPane().add(submit);
				
		setTitle("초기 세팅");
		setSize(496,351);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			  @Override
			  public void windowClosing(WindowEvent we)
			  { 
			    String ObjButtons[] = {"Yes","No"};
			    int PromptResult = JOptionPane.showOptionDialog(null, 
			        "지금 창을 종료하면 모든 결과를 잃게 됩니다. 종료하시겠습니까?", "종료", 
			        JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, 
			        ObjButtons,ObjButtons[1]);
			    if(PromptResult==0)
			    {
			    	try {
						RandomAccessFile randomAccessFile = new RandomAccessFile(fileName, "rw");
						byte b;
				    	long length;
						length = randomAccessFile.length()-1;
				    	if (length >= 3) {
				    	    do {
				    	        length -= 3;
				    	        randomAccessFile.seek(length);
				    	        b = randomAccessFile.readByte();
				    	    } while (b != 10 && length > 0);
				    	    randomAccessFile.setLength((length==0)?length:length+1);
				    	}
					} catch (IOException e) {
						e.printStackTrace();
					}
			    	
			    	
			    	System.exit(0);          
			    }
			  }
			});
		setVisible(true);
	}
}
