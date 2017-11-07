import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

class MineController extends MouseAdapter {
  MineModel model;
  public MineController(MineModel model){
    this.model = model;
  }
  public void  mouseReleased(MouseEvent e) {
    Object source = e.getSource();
    JButton tempBtn = (JButton) e.getComponent();

    if (SwingUtilities.isLeftMouseButton(e) == true) {
      System.out.println("Left ");
      System.out.println(tempBtn.getName());
      model.mineCheck(x,y);
    }
    if (SwingUtilities.isRightMouseButton(e) == true) {
      System.out.println("Right ");
      System.out.println(tempBtn.getName());
      model.setFlag(x, y);
    }
  }
}
