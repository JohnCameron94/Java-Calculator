package calculator;


/**
 * FILE: CalculatorViewController.java
 * @author: Johnathon Cameron #040725586
 * Course: CST8221 - JAP -  Lab: 302
 * Assignment: 1
 * Date:
 * Professor: Sv.Ranev / Daniel Cormier
 * Purpose: Creation of a graphical user interface, implementing a calculator using swing component. The first part is the GUI creation
 * following specific requirements given by the professors of CST8221. This implementation extends JPanel that uses excessive use of 
 * Border and Grid Layout managers. Borders and alignments are used to align all compononents with each other.
 * Class:  - class CalculatorViewController
 * 		   - class Controller 
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 * 
 * @author Johnathon Cameron
 * @version 1.5
 * @see CalculatorViewController
 * @since 1.8 (Java 8)
 */
public class CalculatorViewController extends JPanel {
	/**
	 * {@value #serialVersionUID} default serial version ID - Swing components
	 * implement the Serializable interface
	 */
	private static final long serialVersionUID = 6248477390124803341L;

	/**
	 * display1 is the JTextField component that acts as one of the two calculator
	 * displays that are not editable
	 */
	private JTextField display1; // the calculator display1 field reference

	/**
	 * display2 is the JTextField component that acts as one of the two calculator
	 * displays that are not editable (Default text 0.0)
	 */
	private JTextField display2; // the calculator display2 field reference
	/**
	 * JLabel used to identify a error within a calculation of the calculator or
	 * mode changes, background color will change.
	 */
	private JLabel error; // the mode/error display label reference
	/**
	 * JButton used for the "." button on the keypad
	 */
	private JButton dotButton; // the decimal point (dot) button reference
	/**
	 * Array of JButtons that are used to represent the hexadecimal button values
	 * (A,B,C,D,E,F)
	 */
	private JButton[] hexButtons; // reference to container for alphabetical hex buttons
	/**
	 * {@value #OPERATOR_BUTTON_SIZE} final used for the dimension of the operator
	 * buttons (/,*,+,-)
	 */
	private final Dimension OPERATOR_BUTTON_SIZE = new Dimension(48, 45);
	/**
	 * {@value #ERROR_BACKSPACE_SIZE} final used for the dimension of the the error
	 * label and backspace button
	 */
	private final Dimension ERROR_BACKSPACE_SIZE = new Dimension(52, 55);

	private final String order[] = { "7", "8", "9", "4", "5", "6", "1", "2", "3", ".", "0", "\u00b1" };

	/**
	 * @author Johnathon Cameron Constructor used to create the calculator GUI using
	 *         swing components. Components used: JPanel, JButton,
	 *         JTextField,JCheckBox, ButtonGroup,JRadioButton,JLabel Layout Managers
	 *         used: BorderLayout,GridLayout
	 */
	public CalculatorViewController() {

		/****************** Main Container ****************************/
		// Main Panel Attributes set
		// settting content pane to border layout
		setLayout(new BorderLayout());
		// setting background to black
		setBackground(Color.BLACK);
		// setting borders for content pane
		setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.BLACK));

		// Creating a new controller object
		Controller ctrl = new Controller();
		/*************************************************************/

		/****************** UPPER PANELS *******************************/

		/***** UPPER PANELS OF CALCULATOR ******/
		// Panel for upper part of calculator
		JPanel upper = new JPanel(new BorderLayout());
		// Setting upper pane background to Yellow for transparency of the backspace
		upper.setBackground(Color.YELLOW);
		// creating panels to store text fields
		JPanel dPane = new JPanel(new GridLayout(2, 1, 0, 0));

		/*********** UPPER PANELS Components ******************/
		// DIPLAY
		// creating new JTextField of 14 columns
		display1 = new JTextField(14);
		// empty borders
		display1.setBorder(BorderFactory.createEmptyBorder());
		// Setting Text Alignment to right
		display1.setHorizontalAlignment(JTextField.RIGHT);
		// Setting height to 30, 0 gets overridden
		display1.setPreferredSize(new Dimension(0, 30));
		// Setting so user cannot edit text field
		display1.setEditable(false);

		// Default text 0.0 and 14 columns
		display2 = new JTextField("0.0", 14);
		// setting height to 30
		display2.setPreferredSize(new Dimension(0, 30));
		// Setting default text 0.0 to right
		display2.setHorizontalAlignment(JTextField.RIGHT);
		// Creating empty borders
		display2.setBorder(BorderFactory.createEmptyBorder());
		// Setting so user cannot edit text field
		display2.setEditable(false);

		/***** MODE PANELS OF CALCULATOR *****/
		// Setting main mode panel to border layout manager
		JPanel modePane = new JPanel(new BorderLayout());
		// Setting borders to matte black
		modePane.setBorder(BorderFactory.createMatteBorder(5, 0, 5, 0, Color.BLACK));
		// Setting background to black
		modePane.setBackground(Color.BLACK);

		// Hexadecimal Panel, Layout manager GridLayout
		JPanel hexPane = new JPanel(new BorderLayout());
		// Setting background to black
		hexPane.setBackground(Color.BLACK);
		// Setting matte border (Black)
		hexPane.setBorder(BorderFactory.createMatteBorder(5, 0, 5, 0, Color.BLACK));

		// radio button Panel, Layout Manager :Border Layout
		JPanel radioButtonPane = new JPanel(new BorderLayout());
		// Background to black
		radioButtonPane.setBackground(Color.BLACK);
		// Setting Borders
		radioButtonPane.setBorder(BorderFactory.createMatteBorder(5, 0, 5, 1, Color.BLACK));

		/*********** Button Group ***********/
		// create button group for hex and radio buttons
		ButtonGroup group = new ButtonGroup();

		/****** BUTTONS for mode Pane *********/

		// CHECK BOX
		JCheckBox hexCheck = new JCheckBox("Hex");
		// Setting Background color to Green
		hexCheck.setBackground(Color.GREEN);
		// Setting CheckBox to Opaque (MAC OS Requirement)
		hexCheck.setOpaque(true);
		// Creating empty borders (MAC OS Requirement)
		
		// Setting Action Command to HEX (Most likely TODO in Assignment 2)
		hexCheck.setActionCommand("Hex");
		// Setting Action Listener (TODO Ass2)
		hexCheck.addActionListener(new Controller());
		// END OF CHECK BOX

		// 0. RADIO BUTTON
		JRadioButton radioButtonOne = new JRadioButton(".0", false);
		// Setting background to yellow
		radioButtonOne.setBackground(Color.YELLOW);
		// MAC OS Requirement
		radioButtonOne.setOpaque(true);
		// Setting Action Command (TODO Ass2)
		radioButtonOne.setActionCommand("0.0");
		// setting empty border (MAC OS )/ setting gap between buttons right and bottom
		radioButtonOne.setBorder(BorderFactory.createEmptyBorder(2, 2, 3, 3));
		// adding action listener (TODO Ass2)
		radioButtonOne.addActionListener(new Controller());
		// END OF .0 RADIO BUTTON

		// .00 RADIO BUTTON
		JRadioButton radioButtonTwo = new JRadioButton(".00", true);
		// Setting Background to Yellow
		radioButtonTwo.setBackground(Color.YELLOW);
		// MAC OS requirement
		radioButtonTwo.setOpaque(true);
		// Mac os requirement / setting gap between buttons
		radioButtonTwo.setBorder(BorderFactory.createEmptyBorder(2, 2, 3, 3));
		// Setting Action command (TODO Ass2)
		radioButtonTwo.setActionCommand("0.00");
		// adding action listener (TODO Ass2)
		radioButtonTwo.addActionListener(new Controller());
		// END OF .00 RADIO BUTTON

		// SCI RADIO BUTTON
		JRadioButton sciRadioButton = new JRadioButton("Sci", false);
		// setting background to yellow
		sciRadioButton.setBackground(Color.YELLOW);
		// MAC os requirement
		sciRadioButton.setOpaque(true);
		// Setting action command (TODO Ass2)
		sciRadioButton.setActionCommand("Sci");
		// MAC OS requirement
		sciRadioButton.setBorder(BorderFactory.createEmptyBorder(2, 2, 3, 3));
		// adding action listener (TODO Ass2)
		sciRadioButton.addActionListener(new Controller());

		/************ ERROR LABEL *******************/
		// Error label test "F"
		error = new JLabel("F");
		// Setting text to center of Label
		error.setHorizontalAlignment(JLabel.CENTER);
		// Seting dimensions for label (final dimensions)
		error.setPreferredSize(new Dimension(ERROR_BACKSPACE_SIZE));
		// Setting borders for error mode
		error.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 5, Color.BLACK));

		/******** BACKSPACE BUTTON ***********/
		// Setting text to unicode arrow (found in chart)
		JButton backspace = new JButton("\u21da");
		// No need since button is transparent there in case requirements for ass2
		// change
		backspace.setBackground(Color.YELLOW);
		//Setting button transparent
		backspace.setOpaque(false);
		// final size
		backspace.setPreferredSize(new Dimension(ERROR_BACKSPACE_SIZE));
		// Setting requirement border size
		backspace.setBorder(BorderFactory.createMatteBorder(0, 5, 0, 1, Color.BLACK));
		// Setting tool tip text (Alt+B) - Shortcut
		backspace.setToolTipText("Alt-B(Backspace)");
		// default need to click alt, setting Mnemonic to alt b
		backspace.setMnemonic('b');
		// Action command (TODO Ass2)
		backspace.setActionCommand("\u21da");
		// adding action listner (TODO Ass2)
		backspace.addActionListener(ctrl);
		

		/**** ADDING BUTTONS TO GROUP and PANELS *****/
		// ADDING BUTTONS AND CHECKBOX TO GROUP
		group.add(hexCheck);
		group.add(radioButtonOne);
		group.add(radioButtonTwo);
		group.add(sciRadioButton);

		// PANEL
		// adding radio buttons to radio button pane
		radioButtonPane.add(radioButtonOne, BorderLayout.WEST);
		radioButtonPane.add(radioButtonTwo, BorderLayout.CENTER);
		radioButtonPane.add(sciRadioButton, BorderLayout.EAST);
		// addin hex check box to pane
		hexPane.add(hexCheck);

		// putting hex checkbox to left of panel
		modePane.add(hexPane, BorderLayout.WEST);
		// putting radio buttons to right of panel
		modePane.add(radioButtonPane, BorderLayout.EAST);

		/************** ADDING TO UPPER PANE *************/
		// adding display1 to top of the panel
		dPane.add(display1, BorderLayout.NORTH);
		// adding display2 underneath display 1
		dPane.add(display2, BorderLayout.SOUTH);
		// adding error label to upper panel (left side)
		upper.add(error, BorderLayout.WEST);
		// adding mode pane to upper panel (Under other panels in the upper pane)
		upper.add(modePane, BorderLayout.SOUTH);
		// adding display pane to upper panel center of the upper panel
		upper.add(dPane, BorderLayout.CENTER);
		// adding backspace button to upper panel (right side)
		upper.add(backspace, BorderLayout.EAST);
		/**********************************************/

		/************************ END OF UPPER PANE **********************************/

		/************************ BOTTOM PANELS **************************************/

		/***** Bottom PANELS OF CALCULATOR ******/
		// JPanel with BorderLayout manager
		JPanel bottom = new JPanel(new BorderLayout());

		// DIV AND MULT PANEL (Layout : GRIDLAYOUT)
		JPanel divAndMult = new JPanel(new GridLayout(2, 1, 3, 3));
		// Setting borders for alignment
		divAndMult.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 5, Color.BLACK));
		// Set background to black
		divAndMult.setBackground(Color.BLACK);

		// ADD AND SUB PANEL (Layout : GRIDLAYOUT)
		JPanel addAndSub = new JPanel(new GridLayout(2, 1, 3, 3));
		// Creating borders for alignment
		addAndSub.setBorder(BorderFactory.createMatteBorder(0, 5, 0, 1, Color.BLACK));
		// Setting background to black
		addAndSub.setBackground(Color.BLACK);

		// Number Keypad Panel
		JPanel numpad = new JPanel(new GridLayout(6, 3, 3, 3));
		// Setting background to white
		numpad.setBackground(Color.WHITE);

		// KEYPAD MAIN PANEL
		JPanel kp = new JPanel(new BorderLayout());
		kp.setBackground(Color.BLACK);

		/********** BUTTON Declarations *************/
		// Hex button array
		hexButtons = new JButton[6];
		// dot button
		dotButton = new JButton();

		/***************** BUTTON CREATION FOR LOOP **************/

		// Hex button letter A starting point and increment until F
		char letter = 'A';
		for (int j = 0; j < hexButtons.length; j++) {

			// string value of character
			String str = String.valueOf(letter);
			// create button
			hexButtons[j] = createButton(str, str, Color.BLACK, Color.BLUE, new Controller());
			// add button to panel and setting disabled at start
			hexButtons[j].setEnabled(false);
			numpad.add(hexButtons[j]);
			// increment letter to B,C,D,E,F
			letter++;

		}

		/********* Decimal Number buttons (from 0 to 9 and . and +-) *****/
		/**
		 * KeyPad Display: 7 8 9 4 5 6 1 2 3 . 0 +-
		 */
		// incrementing for loop order.length
		for (int i = 0; i < order.length; i++) {

			if (i == 9) {
				// dot button
				dotButton = createButton(order[i], order[i], Color.BLACK, Color.MAGENTA, new Controller());
				// Adding dot button to keypad
				numpad.add(dotButton);

			} else if (i == 11) {
				// PlusMinus button and adding to keypad
				numpad.add(createButton(order[i], order[i], Color.BLACK, Color.MAGENTA, new Controller()));
			} else {
				// Adding all other numeric buttons to keypad
				numpad.add(createButton(order[i], order[i], Color.BLACK, Color.BLUE, new Controller()));
			}
		}
		/**** END OF LOOP BUTTON CREATION ****/

		/** OPERATOR BUTTONS **/

		// MULTIPLICATION BUTTON
		JButton mult = createButton("*", "*", Color.BLACK, Color.CYAN, new Controller());
		// Setting requirement size
		mult.setPreferredSize(new Dimension(OPERATOR_BUTTON_SIZE));
		// MAC OS requirements
		mult.setOpaque(true);
		mult.setBorder(BorderFactory.createEmptyBorder());

		// DIVISION BUTTON
		JButton div = createButton("/", "/", Color.BLACK, Color.CYAN, new Controller());
		// Setting to requirement size
		div.setPreferredSize(new Dimension(OPERATOR_BUTTON_SIZE));
		// MAC OS requirements
		mult.setOpaque(true);
		mult.setBorder(BorderFactory.createEmptyBorder());

		// ADDITION BUTTON
		JButton add = createButton("+", "+", Color.BLACK, Color.CYAN, new Controller());
		// setting to requirement size
		add.setPreferredSize(new Dimension(OPERATOR_BUTTON_SIZE));
		// MAC OS requirement
		add.setOpaque(true);
		add.setBorder(BorderFactory.createEmptyBorder());

		// SUBTRACTION BUTTON
		JButton sub = createButton("-", "-", Color.BLACK, Color.CYAN, new Controller());
		// setting to requirement size
		sub.setPreferredSize(new Dimension(OPERATOR_BUTTON_SIZE));
		// MAC os Requirement
		sub.setOpaque(true);
		sub.setBorder(BorderFactory.createEmptyBorder());

		// CLEAR BUTTON
		JButton clear = createButton("C", "C", Color.BLACK, Color.RED, new Controller());
		clear.setOpaque(true);
		clear.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
		// EQUALS BUTTON
		JButton equals = createButton("=", "=", Color.BLACK, Color.YELLOW, new Controller());
		equals.setOpaque(true);
		equals.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));

		/******** ADDING BUTTONS TO DIV AND MULTIPLICATION PANEL *****/
		divAndMult.add(mult);
		divAndMult.add(div);
		/******** ADDING BUTTONS TO addition AND subtraction PANEL *****/
		addAndSub.add(add);
		addAndSub.add(sub);

		/****** ADDING BUTTONS TO KEYPAD Main PANE ****/
		// Adding clear to top of keypad pane
		kp.add(clear, BorderLayout.NORTH);
		// adding equals to bottom of keypad pane
		kp.add(equals, BorderLayout.SOUTH);
		// Adding keypad to borderLayout
		kp.add(numpad, BorderLayout.CENTER);

		/********** ADDING TO BOTTOM PANE *********************/

		// Adding multiplication and division pane to left of bottom pane
		bottom.add(divAndMult, BorderLayout.WEST);
		// Adding addition and subtraction to right of bottom pane
		bottom.add(addAndSub, BorderLayout.EAST);
		// Adding Keypad to the center of bottom pane
		bottom.add(kp, BorderLayout.CENTER);

		/*********************************
		 * END OF BOTTOM CALCULATOR PANELS
		 **************************************/

		/***************************************
		 * ADDING CONTENTS TO MAIN PANE
		 *******************************/
		// Adding two panes to main content pane
		add(upper, BorderLayout.NORTH);
		add(bottom, BorderLayout.CENTER);

	}

	/**
	 * 
	 * @param text:
	 *            String text to set as labeled button
	 * @param ac
	 *            : String action commande to set as action command
	 * @param fg:
	 *            Color so set button foreground color
	 * @param bg:background
	 *            color for button
	 * @param handler:
	 *            action listener to handle events from button
	 * @return : button reference
	 * 
	 *         Method used to create buttons on the fly. Method parameters are used
	 *         to set button attributes, such as text background color, action
	 *         command, forground color and action listener. The button will then be
	 *         returned and store into a button in CalculatorControllerView
	 *         Constructor.
	 */
	private JButton createButton(String text, String ac, Color fg, Color bg, ActionListener handler) {

		// Creating new Button
		JButton button = new JButton(text);
		// Setting button size the rest is default
		button.setFont(new Font(button.getFont().getName(), button.getFont().getStyle(), 20));
		// Setting background and foreground colors
		button.setBackground(bg);
		button.setForeground(fg);
		// MAC OS must set Opaque
		button.setOpaque(true);
		// Set a preferred size
		button.setPreferredSize(button.getPreferredSize());
		// set empty borders
		button.setBorder(BorderFactory.createEmptyBorder());
		// Adding action listener handler
		button.addActionListener(handler);

		// if action command is null don't set action command
		if (ac != null) {
			button.setActionCommand(ac);
		}
		return button;
	}

	/**
	 * 
	 * @author Johnathon Cameron
	 * @version 1.0
	 * @see Controller, ActionListener
	 * @since Java 8 (1.8) Private inner class within CalculatorViewController class
	 *        Class used to handle events
	 */
	private class Controller implements ActionListener {


		/**
		 * @param ActionEvent
		 *            Method used to perform a action event depending on what the user
		 *            clicks. For assignment 1, it will just display the value of the
		 *            clicked button.
		 */
		@Override
		public void actionPerformed(ActionEvent ace) {
			display2.setText(ace.getActionCommand());		

		}
		
	}
}
