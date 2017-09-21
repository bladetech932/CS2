import java.io.*;
import java.net.*;
import javax.swing.*;

public class RobotModel 
{
    private String ipAddress = "lear.cs.okstate.edu";
    private int port = 9095;
    private String handshake = "bonjour robot";
    private Socket socket;
    
    public RobotModel() throws UnknownHostException, IOException
    {
        createSocket();
    }
    
    public void createSocket() throws UnknownHostException, IOException
    {
           socket = new Socket(ipAddress, port);  
           sendHandshake();
    }
    
    public void sendHandshake() throws IOException
    {
        PrintWriter out = new PrintWriter(socket.getOutputStream());
        out.print(handshake);
        out.flush();
    }
    
    public void sendMovementCommand(String text) throws IOException
    {
        String buttonText = text;
        PrintWriter out = new PrintWriter(socket.getOutputStream());

        switch (buttonText)
        {
            case "Takeoff": {out.print(takeOff()); break;}
            case "Land": {out.print(land()); break;}
            case "Forward": {out.print(forward()); break;}
            case "Turn Left": {out.print(turnLeft());break;}
            case "Turn Right": {out.print(turnRight()); break;}
            case "Reverse": {out.print(reverse()); break;}
            case "Climb": {out.print(climb()); break;}
            case "Strafe Left": {out.print(strafeLeft()); break;}
            case "Strafe Right": {out.print(strafeRight());break;}
            case "Descend": {out.print(descend());break;}
            case "stop": {out.print(stop()); break;}    
            default: {break;}
        }
        out.flush();
    }
    
    public String takeOff()
    {
        String command = "{\"op\":\"publish\",\"topic\":\"/ardrone/takeoff\",\"msg\":{}}";
        return command;
    }
    
    public String land()
    {
        return "{\"op\":\"publish\",\"topic\":\"/ardrone/land\",\"msg\":{}}";
    }
    
    public String forward()
    {
        return "{\"op\":\"publish\",\n" +
        "\"topic\":\"/cmd_vel\",\n" +
        "\"msg\":{\"linear\":{\"x\":-0.15,\n" +
        "\"y\":0,\n" +
        "\"z\":0},\n" +
        "\"angular\":{\"x\":0,\n" +
        "\"y\":0,\n" +
        "\"z\":0}}}";
    }
    public String turnLeft()
    {
        return "{\"op\":\"publish\",\n" +
        "\"topic\":\"/cmd_vel\",\n" +
        "\"msg\":{\"linear\":{\"x\":0,\n" +
        "\"y\":0,\n" +
        "\"z\":0},\n" +
        "\"angular\":{\"x\":0,\n" +
        "\"y\":0,\n" +
        "\"z\":0.5}}}";
    }
    public String turnRight()
    {
        return "{\"op\":\"publish\",\n" +
        "\"topic\":\"/cmd_vel\",\n" +
        "\"msg\":{\"linear\":{\"x\":0,\n" +
        "\"y\":0,\n" +
        "\"z\":0},\n" +
        "\"angular\":{\"x\":0,\n" +
        "\"y\":0,\n" +
        "\"z\":-0.5}}}";
    }
    public String reverse()
    {
        return "{\"op\":\"publish\",\n" +
        "\"topic\":\"/cmd_vel\",\n" +
        "\"msg\":{\"linear\":{\"x\":0.15,\n" +
        "\"y\":0,\n" +
        "\"z\":0},\n" +
        "\"angular\":{\"x\":0,\n" +
        "\"y\":0,\n" +
        "\"z\":0}}}";
    }
    public String climb()
    {
        return "{\"op\":\"publish\",\n" +
        "\"topic\":\"/cmd_vel\",\n" +
        "\"msg\":{\"linear\":{\"x\":0,\n" +
        "\"y\":0,\n" +
        "\"z\":0.15},\n" +
        "\"angular\":{\"x\":0,\n" +
        "\"y\":0,\n" +
        "\"z\":0}}}";
    }
    public String strafeLeft()
    {
        return "{\"op\":\"publish\",\n" +
        "\"topic\":\"/cmd_vel\",\n" +
        "\"msg\":{\"linear\":{\"x\":0,\n" +
        "\"y\":-0.15,\n" +
        "\"z\":0},\n" +
        "\"angular\":{\"x\":0,\n" +
        "\"y\":0,\n" +
        "\"z\":0}}}";
    }
    public String strafeRight()
    {
        return "{\"op\":\"publish\",\n" +
        "\"topic\":\"/cmd_vel\",\n" +
        "\"msg\":{\"linear\":{\"x\":0,\n" +
        "\"y\":0.15,\n" +
        "\"z\":0},\n" +
        "\"angular\":{\"x\":0,\n" +
        "\"y\":0,\n" +
        "\"z\":0}}}";
    }
    public String descend()
    {
        return "{\"op\":\"publish\",\n" +
        "\"topic\":\"/cmd_vel\",\n" +
        "\"msg\":{\"linear\":{\"x\":0,\n" +
        "\"y\":0,\n" +
        "\"z\":-0.15},\n" +
        "\"angular\":{\"x\":0,\n" +
        "\"y\":0,\n" +
        "\"z\":0}}}";
    }
    public String stop()
    {
        return "{\"op\":\"publish\",\n" +
        "\"topic\":\"/cmd_vel\",\n" +
        "\"msg\":{\"linear\":{\"x\":0,\n" +
        "\"y\":0,\n" +
        "\"z\":0},\n" +
        "\"angular\":{\"x\":0,\n" +
        "\"y\":0,\n" +
        "\"z\":0}}}";
    }
}