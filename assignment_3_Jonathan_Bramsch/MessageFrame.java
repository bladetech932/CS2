import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MessageFrame extends JFrame {
	public MessageFrame() {
		JFrame frame = new JFrame("Bottle Frame");
		MessagePanel panel = new MessagePanel();
		frame.add(panel);

		frame.setPreferredSize(new Dimension(620, 480)); //set Size
		frame.pack();
		//frame.setExtendedState(JFrame.MAXIMIZED_BOTH); //set FullScreen
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //kill program on exit
		frame.setResizable(false);
		frame.setVisible(true);
		//frame.pack();
		panel.repaint();
	}
	public static void main(String s[]) {
		MessageFrame messageFrame = new MessageFrame();
	}
}
