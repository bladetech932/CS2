import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

class MineViewer extends JFrame {
  private MineModel model;
  private ImageIcon mine = new ImageIcon("mine.png");
	private ImageIcon flag = new ImageIcon("flag.png");
  private Object[] gameModes = {"Custom","Easy","Medium","Hard"};
  Color purple = new Color(255,255,255);
  private JPanel panel;
  private Container pane;
  JButton[][] btn;

  public MineViewer() { //Init Call
    super("Insert Title Here"); // super must be first in the constructor

    int selected = JOptionPane.showOptionDialog(null,"Select Difficulty below", //showInputDialog
    "Difficulty Settings",JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,null ,gameModes, gameModes[1]);

    if (selected==1) { model = new MineModel(MineModel.EASY); }
    if (selected==2) { model = new MineModel(MineModel.MEDIUM); }
    if (selected==3) { model = new MineModel(MineModel.HARD); }
    if (selected==0) { model = new MineModel(initCustomGame()); }

    MineController controller = new MineController(model);
    //Frame Init
    setSize(1000,1000);
		setResizable(true);//set to false on deployment
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // menubar init
    Container contentpane = getContentPane();
    JMenuBar menuBar = new JMenuBar();
    menuBar.add(getFileMenu(this));
    contentpane.add(menuBar, BorderLayout.NORTH);

    panel = new JPanel();
    panel.setLayout(new GridLayout(model.getRows(),model.getColumns()));

    buildButtonArray(model.getRows(), model.getColumns());  //init grid buttons

    //pane = this.getContentPane(); pane. if contentpane is needed
    add(panel);
  }

  private void buildButtonArray(int rows, int columns){
    btn = new JButton[rows][columns];
		for (int i = 0; i < rows; i++) {
			for (int j = 0;j < columns; j++) {
				btn[i][j] = new JButton();
				btn[i][j].setBackground(purple);
        btn[i][j].setName(i+","+j);
				btn[i][j].addMouseListener(new MineController());
        panel.add(btn[i][j]);
			}
		}
  }

  private int[] initCustomGame(){
    JPanel customPanel = new JPanel();
    int[] customSettings = {10,10,10};
    JTextField rowNum = new JTextField(5);
    rowNum.setText(Integer.toString(customSettings[0]));
		JTextField columnNum = new JTextField(5);
    columnNum.setText(Integer.toString(customSettings[1]));
		JTextField mineNum = new JTextField(5);
    mineNum.setText(Integer.toString(customSettings[2]));

		customPanel.setLayout(new GridLayout(5, 2));
		customPanel.add(new JLabel("Rows: "));
		customPanel.add(rowNum);
		customPanel.add(new JLabel("Columns: "));
		customPanel.add(columnNum);
		customPanel.add(new JLabel("Mines: "));
		customPanel.add(mineNum);

    JOptionPane.showConfirmDialog(this, customPanel, "Game Selection",
				JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null);
    try {
      customSettings[0] = Integer.parseInt(rowNum.getText());
      customSettings[1] = Integer.parseInt(columnNum.getText());
      customSettings[2] = Integer.parseInt(mineNum.getText());
    }
    catch(NumberFormatException ex) {}
    return customSettings;
  }

  public JMenu getFileMenu(MineViewer viewer) {

		JMenu file = new JMenu("File");
		JMenuItem save = new JMenuItem("Save");
		JMenuItem load = new JMenuItem("Load");
		JMenuItem quit = new JMenuItem("Quit");

		//load.addActionListener(new MenuListener(MineModel.LOAD, viewer));
		//save.addActionListener(new MenuListener(MineModel.SAVE, viewer));
		//quit.addActionListener(new MenuListener(MineModel.QUIT));

		file.add(load);
		file.add(save);
		file.add(quit);
		return file;
	}

}
