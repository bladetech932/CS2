import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FrameTest extends JFrame {
	public FrameTest() {
		JFrame frame = new JFrame("Test Window");
		//frame.setPreferredSize(new Dimension(800, 800)); //set Size
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); //set FullScreen
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //kill program on exit
		frame.pack();
		frame.setResizable(false);
		frame.setVisible(true);
	}
	public static void main(String s[]) {
		FrameTest main = new FrameTest();
	}

}
