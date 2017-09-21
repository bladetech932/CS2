import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class MessagePanel extends JPanel {
	public void paintComponent(Graphics g) {
		setBackground(Color.BLACK); //set Background to BLACK
		super.paintComponent(g); // call itself to rebuild the panel after background
		Color osuOrange = new Color(217,89,0); //RGB value for OSU orange
		//g.setColor(Color.ORANGE); //not OSU enough
		g.setColor(osuOrange);

		g.fillOval(175, 190, 250, 20); //Shoulder (x,y,width,height);
		g.fillOval(200, 405, 200, 20); //Bottom (x,y,width,height);
		g.fillOval(275, 118,  50, 10); //BottomNeck (x,y,width,height);
		g.fillOval(275,  45,  50, 10); //TopNeck (x,y,width,height);

		g.drawLine(200, 415, 175, 200);  //DrumLeft  (x,y,x,y) pt2pt
		g.drawLine(400, 415, 425, 200);  //DrumRight (x,y,x,y) pt2pt
		g.drawLine(275, 125, 275,  50);  //NeckLeft (x,y,x,y) pt2pt
		g.drawLine(325, 125, 325,  50);  //NeckRight (x,y,x,y) pt2pt

		g.drawArc(175,125,200,150,90, 90); // LeftShoulder (x,y,width,height,startangle,arcangle)
		g.drawArc(225,125,200,150,90,-90); // RightShoulder (x,y,width,height,startangle,arcangle)

		g.drawString("Neither Half Full", 260, 250);
		g.drawString("Nor Half Empty", 260, 300);
		g.drawString("Just Twice as Big as it Needs to be", 205, 350);
	}
}
