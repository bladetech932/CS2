import java.awt.event.*;
import java.awt.*;
import java.net.URL;
import javax.swing.*;

public class JButtonTest extends JPanel implements ActionListener {

	public JButtonTest() {
		ImageIcon jbtnIcon =createImageIcon("TestIMG.JPG");
		JButton jbtn = new JButton("Test Button", jbtnIcon);
		jbtn.setVerticalTextPosition(AbstractButton.BOTTOM);
		jbtn.setHorizontalTextPosition(AbstractButton.CENTER);

	}
	public static void createGui() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		frame = new JFrame("JButtonTest");
		JFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JButtonTest buttonContentPane = new JButtonTest();
		buttonContentPane.setOpaque(true); //content panes must be opaque
		frame.setContentPane(buttonContentPane);
		frame.pack();
		frame.setVisible(true);
	}
	public static void main(String[] s) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {

			public void run() {
				createGUI();
			}
		});
	}
}