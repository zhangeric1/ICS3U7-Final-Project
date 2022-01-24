/**
 * This screen displays the user's game scores. It reads all scores from 3 different text files (1 for each difficulty level) into 3 ArrayLists,
 * sorts them, then displays them in 3 different tables. The scores remain in the text files until they are cleared by the user.
 */

//import necessary packages
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class ScoreScreen extends ScreenFrame implements ActionListener{
	private static String easyFile, mediumFile, hardFile; //names of each text file
	private ArrayList<Integer> easyScores, mediumScores, hardScores; //lists of scores from each text file
	private JTable easyTable, mediumTable, hardTable; //tables to display scores
	private JScrollPane easyScrollPane, mediumScrollPane, hardScrollPane; //Scroll panes allow each table to be scrolled through
	private JPanel easyTablePanel, mediumTablePanel, hardTablePanel, tablePanel, infoPanel; //panels to hold tables and information
	private JButton jbtEasyClr, jbtMediumClr, jbtHardClr, jbtMenu; //buttons to clear scores and return to menu
	private static final Font TEXT_FONT = new Font("Comic Sans MS", Font.BOLD, 30), BTN_FONT = new Font("Comic Sans MS", Font.PLAIN, 25); //default fonts for text and buttons
	private static final Color DEFAULT_COLOR = Color.cyan; //default text color

	//Constructor for ScoreScreen
	public ScoreScreen(){
		//File names
		easyFile = "scores/easyFile.txt";
		mediumFile = "scores/mediumFile.txt";
		hardFile = "scores/hardFile.txt";
		//array list of scores. Initialize them with method
		easyScores = readFileIntoList(easyFile);
		mediumScores = readFileIntoList(mediumFile);
		hardScores = readFileIntoList(hardFile);
		//tablePanel is a general JPanel to hold all tables
		tablePanel = new JPanel();
		tablePanel.setBackground(BG_COLOR);
		//variables for making the JTables
		String[] columnNames = {"Rank", "Score"};
		Object[][] data;

		//set layout manager of frame
		this.getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

		//set layout manager of tablePanel
		tablePanel.setLayout(new BoxLayout(tablePanel, BoxLayout.X_AXIS));

		//Start of displaying easy scores*****************************************
		tablePanel.add(Box.createRigidArea(new Dimension(20, 0))); //add a rigid area as a border
		data = addScoresTable(easyScores); //Data to be displayed in 2 columns (rank and score)
		easyTable = new JTable(data, columnNames) { //instantiate a new JTable using data from text file and column names
			public boolean isCellEditable(int data, int columnsNames) { //this code prevents user from editing the values in the JTable. (default is editable)
				return false;
			}
		};
		easyTable.setPreferredScrollableViewportSize(new Dimension(10, 50)); //sets visible size of the JTable
		easyTable.getTableHeader().setReorderingAllowed(false); //prevents user from reordering the table columns
		easyScrollPane = new JScrollPane(easyTable); //add table onto a scroll pane so that it can be scrolled through in case it gets too large (user friendly)

		//instantiate easyTablePanel
		easyTablePanel = new JPanel();
		easyTablePanel.setBackground(BG_COLOR);
		easyTablePanel.setLayout(new BoxLayout(easyTablePanel, BoxLayout.Y_AXIS)); //set Layout Manager of easyTablePanel
		easyTablePanel.add(addCustomLabel("Easy Scores", DEFAULT_COLOR, TEXT_FONT)); //a heading will go above the table
		easyTablePanel.add(easyScrollPane); //add the scroll pane that holds the scores table
		easyTablePanel.add(jbtEasyClr = addCustomButton("Clear Scores", 100, 50, Color.blue, Color.cyan, BTN_FONT)); //button allowing user to clear scores
		jbtEasyClr.addActionListener(this); //register action listener to clear button

		tablePanel.add(easyTablePanel); //add easyTablePanel to the general table panel
		//End of displaying easy scores*****************************************

		//Start of displaying medium scores*****************************************
		tablePanel.add(Box.createRigidArea(new Dimension(10, 0))); //add a rigid area as a border
		data = addScoresTable(mediumScores); //Data to be displayed in 2 columns (rank and score)
		mediumTable = new JTable(data, columnNames) { //instantiate a new JTable using data from text file and column names
			public boolean isCellEditable(int data, int columnsNames) { //this code prevents user from editing the values in the JTable. (default is editable)
				return false;
			}
		};
		mediumTable.setPreferredScrollableViewportSize(new Dimension(10, 50)); //sets visible size of the JTable
		mediumTable.getTableHeader().setReorderingAllowed(false); //prevents user from reordering the table columns
		mediumScrollPane = new JScrollPane(mediumTable); //add table onto a scroll pane so that it can be scrolled through in case it gets too large (user friendly)

		//instantiate mediumTablePanel
		mediumTablePanel = new JPanel();	
		mediumTablePanel.setBackground(BG_COLOR);
		mediumTablePanel.setLayout(new BoxLayout(mediumTablePanel, BoxLayout.Y_AXIS)); //set Layout Manager of mediumTablePanel
		mediumTablePanel.add(addCustomLabel("Medium Scores", DEFAULT_COLOR, TEXT_FONT)); //a heading will go above the table
		mediumTablePanel.add(mediumScrollPane); //add the scroll pane that holds the scores table
		mediumTablePanel.add(jbtMediumClr = addCustomButton("Clear Scores", 100, 50, Color.blue, Color.cyan, BTN_FONT)); //button allowing user to clear scores
		jbtMediumClr.addActionListener(this); //register action listener to clear button

		tablePanel.add(mediumTablePanel); //add mediumTablePanel to the general table panel
		//End of displaying medium scores*****************************************

		//Start of displaying hard scores*****************************************
		tablePanel.add(Box.createRigidArea(new Dimension(10, 0))); //add a rigid area as a border
		data = addScoresTable(hardScores); //Data to be displayed in 2 columns (rank and score)
		hardTable = new JTable(data, columnNames) { //instantiate a new JTable using data from text file and column names
			public boolean isCellEditable(int data, int columnsNames) { //this code prevents user from editing the values in the JTable. (default is editable)
				return false;
			}
		};
		hardTable.setPreferredScrollableViewportSize(new Dimension(10, 50)); //sets visible size of the JTable
		hardTable.getTableHeader().setReorderingAllowed(false); //prevents user from reordering the table columns
		hardScrollPane = new JScrollPane(hardTable); //add table onto a scroll pane so that it can be scrolled through in case it gets too large (user friendly)

		//instantiate hardTablePanel
		hardTablePanel = new JPanel();
		hardTablePanel.setBackground(BG_COLOR);
		hardTablePanel.setLayout(new BoxLayout(hardTablePanel, BoxLayout.Y_AXIS)); //set Layout Manager of hardTablePanel
		hardTablePanel.add(addCustomLabel("Hard Scores", DEFAULT_COLOR, TEXT_FONT)); //a heading will go above the table
		hardTablePanel.add(hardScrollPane); //add the scroll pane that holds the scores table
		hardTablePanel.add(jbtHardClr = addCustomButton("Clear Scores", 100, 50, Color.blue, Color.cyan, BTN_FONT)); //button allowing user to clear scores
		jbtHardClr.addActionListener(this); //register action listener to clear button

		tablePanel.add(hardTablePanel); //add mediumTablePanel to the general table panel
		tablePanel.add(Box.createRigidArea(new Dimension(20, 0))); //add end border
		//End of displaying hard scores*****************************************

		//begin adding panels to frame
		this.add(tablePanel);
		
		//create infoPanel to display general information
		infoPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		infoPanel.setBackground(BG_COLOR);
		infoPanel.add(addCustomLabel("________________________________________________", DEFAULT_COLOR, TEXT_FONT));
		infoPanel.add(addCustomLabel("These are all of your current Whack-a-Mole scores.", DEFAULT_COLOR, TEXT_FONT));
		infoPanel.add(addCustomLabel("To reset your scores, click on a table's Clear button.", DEFAULT_COLOR, TEXT_FONT));
		infoPanel.add(addCustomLabel("________________________________________________", DEFAULT_COLOR, TEXT_FONT));
		infoPanel.add(jbtMenu = addCustomButton("Menu", 200, 80, Color.blue, Color.cyan, BTN_FONT));
		jbtMenu.addActionListener(this); //register action listener
		this.add(infoPanel);
	}

	/**
	 * This method is implemented from the ActionListener interface. Each action performed leads to a different scenario.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		//Button pressed to clear easy scores
		if(e.getSource() == jbtEasyClr) {
			clearFile(easyFile);
		}

		//Button pressed to clear medium scores
		else if(e.getSource() == jbtMediumClr) {
			clearFile(mediumFile);
		}

		//Button pressed to clear hard scores
		else if(e.getSource() == jbtHardClr) {
			clearFile(hardFile);
		}

		//button pressed to return to menu
		else if(e.getSource() == jbtMenu) {
			new MenuScreen();
			this.dispose();
		}
	}

	/**
	 * This method creates an ArrayList of integers from scores in a text file, then sorts it in descending order
	 * @param fileName Name of text file
	 * @return The sorted ArrayList
	 */
	private ArrayList<Integer> readFileIntoList(String fileName){
		String line; //line read in from file
		ArrayList<Integer> list = new ArrayList<Integer>();

		try {
			//create new instance of BufferedReader to read in scores from given file
			BufferedReader reader = new BufferedReader(new FileReader(fileName));
			line = reader.readLine();//read in a line

			while(line != null) {//continue until end of file
				list.add(Integer.parseInt(line)); //append current score to the ArrayList
				line = reader.readLine(); //read in a line
			}
			reader.close();
		}
		//In case of error reading file
		catch(IOException ex) {
			//Display error message
			JOptionPane.showMessageDialog(null, "An error occured while reading " + fileName, "Error", JOptionPane.ERROR_MESSAGE);
			new MenuScreen(); //return to Main Menu
			this.dispose(); //get rid of current frame
		}
		//Sort array list in descending order
		Collections.sort(list, Collections.reverseOrder());
		return list;
	}

	/**
	 * This method reads in all scores from a text file and creates a 2D array of Objects to store them in descending order
	 * @param fileName File to be read. 
	 * @return 2D array of all ranked scores from the text file
	 */
	private Object[][] addScoresTable(ArrayList<Integer> list) {
		Object[][] scoreTable = new Object[list.size()][2];
		//storing ArrayList values into 2D array with corresponding rank
		for(int i = 0; i < list.size(); i++) {
			scoreTable[i][0] = i + 1;
			scoreTable[i][1] = list.get(i);
		}
		return scoreTable;
	}//end of getTopScoresTableFromFile
	
	/**
	 * This method confirms a user's decision to clear a text file, then clears it or cancels based on input.
	 * @param fileName Name of text file to be cleared
	 */
	private void clearFile(String fileName) {
		int choice; //choice will determine the confirm option for clearing
		try { //try catch block for BufferedReader
			//create new instance of BufferedReader to read in scores from given file
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			if(br.readLine() != null) { //if the file is not empty, I will clear it. If it is empty, ignore the action for user friendliness
				br.close(); //close BufferedReader instance
				//Display a confirm message for the user to confirm their clearing choice
				choice = JOptionPane.showOptionDialog(null, "Warning: Clearing these scores will reset them forever. Do you wish to continue?", "Warning", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, null, 0);
				switch(choice) {
				case 0: //Choice 'yes' returns 0
					try { //try and catch IOException when writing files
						//BufferedWriter for text file of hard scores. False parameter allows us to overwrite the current text
						BufferedWriter out = new BufferedWriter(new FileWriter(fileName, false));
						out.write(""); //make the file empty
						out.close(); //close BufferedWriter instance
					}
					//In case of IOException, display an Error message
					catch(IOException iox){
						JOptionPane.showMessageDialog(null, "An error occured while clearing " + fileName, "Error", JOptionPane.ERROR_MESSAGE);
						new MenuScreen(); //return to Main Menu
						this.dispose(); //get rid of current frame
					}
					new ScoreScreen(); //create a new ScoreScreen instance (like reloading the JFrame)
					this.dispose(); //close current ScoreScreen
				}
			}
		}
		//catch exception while checking if file is empty
		catch(IOException ex) {
			//Display error message
			JOptionPane.showMessageDialog(null, "An error occured while reading " + fileName, "Error", JOptionPane.ERROR_MESSAGE);
			new MenuScreen(); //return to Main Menu
			this.dispose(); //get rid of current frame
		}
	}//end of clearFile method

	/**
	 * Getter method for obtaining name of Easy Scores text file
	 * @return name of text file
	 */
	public static String getEasyFileName() {
		return easyFile;
	}//end of getEasyFileName method
	
	/**
	 * Getter method for obtaining name of Hard Scores text file
	 * @return name of text file
	 */
	public static String getMediumFileName() {
		return mediumFile;
	}//end of getMediumFileName method
	
	/**
	 * Getter method for obtaining name of Hard Scores text file
	 * @return name of text file
	 */
	public static String getHardFileName() {
		return hardFile;
	} //end of getHardFileName method
	
}
