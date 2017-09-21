import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class RobotHandler extends MouseAdapter
{
    private RobotModel model;
    private RobotFrame frame;
    private JButton currentButton;
    
    public RobotHandler(RobotModel m, RobotFrame f)
    {
        model = m;
        frame = f;
    }
    
    public void mousePressed(MouseEvent e)
    {
        currentButton = (JButton)e.getSource();
        try
        {
            model.sendMovementCommand(currentButton.getText());
        }
        catch(IOException ex)
        {
            JOptionPane.showMessageDialog(frame, "IOException occurred.");
        }
    }
    
    public void mouseReleased(MouseEvent e)
    {
        try
        {
            model.sendMovementCommand("stop");
        }
        catch(IOException ex)
        {
            JOptionPane.showMessageDialog(frame, "IOException occurred.");
        }
    }
}
