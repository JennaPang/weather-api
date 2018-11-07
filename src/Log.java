import java.awt.*;
import javax.swing.*;

public class Log extends JFrame {
	
	public Log(){
		super("초기 세팅");
		setSize(450,600);
		setLocation(450,180);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		Log initFrame = new Log();
	}

}
