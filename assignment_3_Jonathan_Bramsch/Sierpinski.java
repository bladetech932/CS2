import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


class Sierpinski extends JFrame {
	public Sierpinski() {
		JFrame frame = new JFrame("Triangle Frame");
		DrawTriangle trianglePanel = new DrawTriangle();
		frame.add(trianglePanel);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) screenSize.getWidth();
		int height = (int) screenSize.getHeight();
		//System.out.println(width+" X "+height);
		frame.setPreferredSize(new Dimension(width/2, height/2)); //(width, height)
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //kill program on exit
		frame.pack();
		frame.setResizable(true);
		frame.setVisible(true);
	}
	public static void main(String[] s) {
		Sierpinski main = new Sierpinski();
	}
}