import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class MineSweeper extends JFrame implements MouseListener {

	private int easyFlagCount = 10;
	private int easyBoardSizeX = 9;
	private int easyBoardSizeY = 9;

	private int medFlagCount = 40;
	private int medBoardSizeX = 16;
	private int medBoardSizeY = 16;

	private int hardFlagCount = 99;
	private int hardBoardSizeX = 30;
	private int hardBoardSizeY = 16;

	private JPanel navPanel;
	private Container navPane;
	private JPanel minePanel;
	private Container minePane;

	private ImageIcon mine = new ImageIcon("mine.png");
	private ImageIcon flag = new ImageIcon("flag.png");

	private JButton newGame;
	private JButton exit;
	private JButton easybtn;
	private JButton medbtn;
	private JButton hardbtn;
	private JButton btn[][] = new JButton[medBoardSizeY][medBoardSizeX];


	public MineSweeper() {
		super("MineSweeper");
		setSize(500,500);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//init Panels
		navPanel = new JPanel();
		navPanel.setLayout(new GridLayout(1,5));
		minePanel = new JPanel();
		minePanel.setLayout(new GridLayout(medBoardSizeY,medBoardSizeX));
		//int nav Buttons
		newGame = new JButton("New Game");
		newGame.addMouseListener(this);
		navPanel.add(newGame);
		exit = new JButton("Exit");
		exit.addMouseListener(this);
		navPanel.add(exit);

		easybtn = new JButton("Easy");
		easybtn.addMouseListener(this);
		navPanel.add(easybtn);
		medbtn = new JButton("Medium");
		medbtn.addMouseListener(this);
		navPanel.add(medbtn);
		hardbtn = new JButton("Hard");
		hardbtn.addMouseListener(this);
		navPanel.add(hardbtn);

		//int mine buttons
		for (int i = 0; i < medBoardSizeX; i++) {
			for (int j = 0;j < medBoardSizeY; j++) {
				btn[i][j] = new JButton();
				btn[i][j].setBackground(Color.white);
				btn[i][j].addMouseListener(this);
				minePanel.add(btn[i][j]);
			}
		}
		//add to containers
		navPane = this.getContentPane();
		navPane.add(navPanel,BorderLayout.NORTH);
		minePane = this.getContentPane();
		minePane.add(minePanel,BorderLayout.CENTER);

		initMines();
	}
	public void initMines() {
		Random randomGenerator = new Random();
		int randomI = randomGenerator.nextInt(100);
		int randomJ = randomGenerator.nextInt(100);
		System.out.println(randomI+","+randomJ);
	}
	public void check4Mine(Object source) {
		for (int i = 0; i < medBoardSizeX; i++) {
    		for (int j = 0; j < medBoardSizeY; j++) {
				if(source == btn[i][j]) {
		    			btn[i][j].setIcon(mine);
		    	}
     		}
  		}

	}
	public void plantFlag(Object source) {
		for (int i = 0; i < medBoardSizeX; i++) {
    		for (int j = 0; j < medBoardSizeY; j++) {
				if(source == btn[i][j]) {
		    			btn[i][j].setIcon(flag);

		    	}
     		}
  		}
	}
	public void check4Zeros() {

	}
	public void updateMineCount(){

	}
	public void mouseExited(MouseEvent event){} //Necessary for @Overide
	public void mouseEntered(MouseEvent event){} //Necessary for @Overide
	public void mouseClicked(MouseEvent event){} //Necessary for @Overide
	public void mousePressed(MouseEvent event){} //Necessary for @Overide
	public void mouseReleased(MouseEvent event) { //Necessary for @Overide
	Object source = event.getSource();

		if (SwingUtilities.isRightMouseButton(event) == true) {
			System.out.print("Right ");
			plantFlag(source);
		}
		if (SwingUtilities.isLeftMouseButton(event) == true) {
			System.out.print("Left ");
			check4Mine(source);
			if(source == exit) {System.exit(0);}
			if(source == newGame) {System.out.println("New Game");}
			if(source == easybtn) {System.out.println("Easy");}
			if(source == medbtn) {System.out.println("Medium");}
			if(source == hardbtn) {System.out.println("Hard");}
		}
	}
	public static void main(String[] s) {
		MineSweeper window = new MineSweeper();
		window.setVisible(true);
	}
}
