import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DrawTriangle extends JPanel {

	public void paintComponent(Graphics g) {
		setBackground(Color.BLACK); //set Background to BLACK
		super.paintComponent(g); // call itself to rebuild the panel after background
		Color osuOrange = new Color(217,89,0); //RGB value for OSU orange
		g.setColor(osuOrange);
		int shortSide;
		int width = getWidth();
		int height = getHeight();
		
		if(height > width) {
			shortSide = width;
		} else {
			shortSide = height;
		}
		drawTriangle(g,shortSide, 0, 0);	
	}

	public void drawTriangle(Graphics g, int shortSide, int x, int y) {
		
		if(shortSide == 1) {
			g.drawRect(x, y, 1, 1);
		} else {
			
			int centerX = x + (shortSide / 4);
			drawTriangle(g, shortSide / 2, centerX, y);
			
			int leftY = y + (shortSide / 2);
			drawTriangle(g, shortSide / 2, x, leftY);
			
			int rightX = x + (shortSide / 2);
			int rightY = y + (shortSide / 2);
			drawTriangle(g, shortSide / 2, rightX, rightY);	
		}			
	}
}
