import java.awt.*;
import java.io.IOException;
import java.net.UnknownHostException;
import javax.swing.*;


public class RobotFrame extends JFrame
{
    public RobotModel model; 
    
    public RobotFrame()
    {
        setTitle("Robot Controller");
        try
        {
            model = new RobotModel();
        }
        catch (UnknownHostException ex)
        {
            JOptionPane.showMessageDialog(this, "UnknownHostException occurred.");
            System.exit(0);
        }
        catch (IOException ex)
        {
            JOptionPane.showMessageDialog(this, "IOException occurred.");
            System.exit(0);
        }
        
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new RobotPanel(model, this));
        setVisible(true);
    }
}
