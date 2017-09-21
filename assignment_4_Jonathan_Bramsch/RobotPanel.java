import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;


public class RobotPanel extends JPanel
{
    private RobotModel model;
    private RobotFrame frame;
    
    private JButton takeoffButton = new JButton("Takeoff");
    private JButton landButton = new JButton("Land");
    private JButton forwardButton = new JButton("Forward");
    private JButton turnLeftButton = new JButton("Turn Left");
    private JButton turnRightButton = new JButton("Turn Right");
    private JButton reverseButton = new JButton("Reverse");
    private JButton climbButton = new JButton("Climb");
    private JButton strafeLeftButton = new JButton("Strafe Left");
    private JButton strafeRightButton = new JButton("Strafe Right");
    private JButton descendButton = new JButton("Descend");
    
    GridLayout grid = new GridLayout(8, 3);
    
    public RobotPanel(RobotModel m, RobotFrame f)
    {
        model = m;
        frame = f;
        
        this.setLayout(grid);
        
        takeoffButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e)
            {
                JButton takeoff = (JButton)e.getSource();
                try
                {
                    model.sendMovementCommand(takeoff.getText()); 
                }
                catch (IOException ex)
                {
                    JOptionPane.showMessageDialog(frame, "IOException occurred."); 
                }
            }
        }
        );
        landButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e)
            {
                JButton land = (JButton)e.getSource();
                try
                {
                    model.sendMovementCommand(land.getText()); 
                }
                catch (IOException ex)
                {
                    JOptionPane.showMessageDialog(frame, "IOException occurred."); 
                }
            }
        }
        );
        
        forwardButton.addMouseListener(new RobotHandler(model, frame));
        turnLeftButton.addMouseListener(new RobotHandler(model, frame));
        turnRightButton.addMouseListener(new RobotHandler(model, frame));
        reverseButton.addMouseListener(new RobotHandler(model, frame));
        climbButton.addMouseListener(new RobotHandler(model, frame));
        strafeLeftButton.addMouseListener(new RobotHandler(model, frame));
        strafeRightButton.addMouseListener(new RobotHandler(model, frame));
        descendButton.addMouseListener(new RobotHandler(model, frame));
        
        add(new JLabel()); add(takeoffButton); add(new JLabel()); 
        add(new JLabel()); add(forwardButton); add(new JLabel());
        add(turnLeftButton); add(new JLabel()); add(turnRightButton);
        add(new JLabel()); add(reverseButton); add(new JLabel());
        add(new JLabel()); add(climbButton); add(new JLabel());
        add(strafeLeftButton); add(new JLabel()); add(strafeRightButton);
        add(new JLabel()); add(descendButton); add(new JLabel());
        add(new JLabel()); add(landButton); add(new JLabel());
        
    }
}
