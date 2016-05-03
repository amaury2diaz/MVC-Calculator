import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

/*
 File name: 	CalculatorView.java
 Author: 	Amaury Diaz Diaz, 040-738-985
 Course: 	CST8221 – JAP, Lab Section: 302
 Assignment: 1
 Date: 		October 30th 2015
 Professor:  Svillen Ranev
 Purpose: 	Responsible for creating the GUI of the Calculator application.
 Class list: Controller
 */
/**
 * This class creates the GUI of the Calculator Application.
 * 
 * @author Amaury Diaz Diaz
 * @version 1.0
 * @see javax.swing.JPanel
 * @see javax.swing.Box
 * @see javax.swing.JButton
 * @see javax.swing.JTextField
 * @see javax.swing.JCheckBox
 * @see java.awt.BorderLayout
 * @see java.awt.GridLayout
 * @see java.awt.event.ActionEvent
 * @see javax.swing.AbstractAction
 * @since 1.8.0_20
 *
 */
public class CalculatorView extends JPanel {
	/**
	 * {@value} Serial version unique identifier of the
	 *        class.
	 */
	private static final long serialVersionUID = -4217135881404864601L;
	/**
	 * Used to display the action commands produced by the buttons.
	 */
	private JTextField display;
	/**
	 * Used to display the state of the Calculator application
	 */
	private JLabel error;
	/**
	 * Used for the "." button in the Calculator Application
	 */
	private JButton dotButton;
	
	
	/**
	 * Initializes the CalculatorView GUI
	 */
	public CalculatorView() {
		/* Container of the radio buttons and the checkbox(located in boxPanel) */
		Box selectionBox;
		/*
		 * Container of the display, error and backspace components(located in
		 * topPanel)
		 */
		JPanel textDisplayPanel;
		/* Container of the selectionBox(located in topPanel) */
		JPanel boxPanel;
		/*
		 * Container of the textDisplayPanel and boxPanel(located inside
		 * CalcView)
		 */
		JPanel topPanel;
		/*
		 * Container of the keypad buttons in the calculator application(located
		 * in centrePanel)
		 */
		JPanel gridPanel;
		/*
		 * Container of the gridPanel and the zero and equal button (located
		 * inside CalcView)
		 */
		JPanel centrePanel;
		/* Used for the backspace button of the application */
		JButton backspace;
		/* Used for the zero ("C") button of the application */
		JButton zero;
		/* Used for the equal ("=") button of the application */
		JButton equal;
		/* Select to display up to 1 decimal place */
		JRadioButton rBOneDecPlace;
		/* Select to display up to 2 decimal places */
		JRadioButton rBTwoDecPlace;
		/* Select to display scientific notation */
		JRadioButton rBSci;
		/*
		 * Used to group the radio buttons in the application (prevents the
		 * selection of multiple radio buttons at the same time)
		 */
		ButtonGroup bGroup;
		/* Used to allow the user to select integers only */
		JCheckBox intChBox;
		/* Contains the names of the buttons in the keypad of the calculator */
		String[] calcButtonArray;
		/* Controller class instance */
		Controller controller;
		/* textDisplayPanel */
		/* Initialize the error Label and set it according to specs */
		error = new JLabel();
		error.setPreferredSize(new Dimension(25, 25));
		error.setOpaque(true); // allows to change the background color
		error.setBackground(Color.YELLOW);
		error.setText("F");
		error.setHorizontalAlignment(JLabel.CENTER); // sets the text in the
														// middle of the label

		/* Initialize the display JTextField and set it according to specs */
		display = new JTextField("0.0", 16);
		display.setHorizontalAlignment(JTextField.RIGHT);
		display.setEditable(false);
		display.setBackground(Color.WHITE);
		display.setPreferredSize(new Dimension(0, 30)); // set the height of the
														// field
		controller = new Controller();
		/* Initialize the backspace button and set it according to specs */
		backspace = new JButton("\u2190");
		backspace.setPreferredSize(new Dimension(25, 25));
		backspace.setMnemonic(KeyEvent.VK_B);
		backspace.setBorder(new LineBorder(Color.RED, 1));
		backspace.setContentAreaFilled(false); // set the button to be
												// transparent
		backspace.setForeground(Color.RED);
		backspace.setActionCommand("\u2190");
		backspace.addActionListener(controller);
		backspace.setToolTipText("Backspace(Alt-B)");

		/* Create the panel that contains the error, display and backspace */
		textDisplayPanel = new JPanel(); // Panel uses FlowLayout by default
		textDisplayPanel.setBackground(Color.WHITE);
		textDisplayPanel.add(error);
		textDisplayPanel.add(display);
		textDisplayPanel.add(backspace);

		/* selectionBox */
		/*
		 * Create the radio buttons that let the user select the format of the
		 * answer
		 */
		rBOneDecPlace = new JRadioButton(".0");
		rBOneDecPlace.setPreferredSize(new Dimension(42, 30));
		rBOneDecPlace.setBackground(Color.YELLOW);
		rBOneDecPlace.setActionCommand(".0");
		rBOneDecPlace.addActionListener(controller);

		rBTwoDecPlace = new JRadioButton(".00", true);
		rBTwoDecPlace.setPreferredSize(rBOneDecPlace.getPreferredSize());
		rBTwoDecPlace.setBackground(Color.YELLOW);
		rBTwoDecPlace.setActionCommand(".00");
		rBTwoDecPlace.addActionListener(controller);

		rBSci = new JRadioButton("Sci");
		rBSci.setPreferredSize(rBOneDecPlace.getPreferredSize());
		rBSci.setBackground(Color.YELLOW);
		rBSci.setActionCommand("Sci");
		rBSci.addActionListener(controller);

		/*
		 * Add the radio buttons to a ButtonGroup so you can select one at a
		 * time
		 */
		bGroup = new ButtonGroup();
		bGroup.add(rBOneDecPlace);
		bGroup.add(rBTwoDecPlace);
		bGroup.add(rBSci);

		/* Create the Check Box */
		intChBox = new JCheckBox("Int");
		intChBox.setPreferredSize(new Dimension(34, 30));
		intChBox.setBackground(Color.GREEN);
		intChBox.setActionCommand("Int");
		intChBox.addActionListener(controller);

		/*
		 * Add the check box and radio buttons to a Box container and separate
		 * the check box from the radio buttons using an horizontal strut
		 */
		selectionBox = new Box(BoxLayout.X_AXIS);
		selectionBox.setBackground(Color.BLACK);
		selectionBox.add(intChBox);
		selectionBox.add(Box.createHorizontalStrut(18));
		selectionBox.add(rBOneDecPlace);
		selectionBox.add(rBTwoDecPlace);
		selectionBox.add(rBSci);

		/*
		 * Initialize the box Panel and add the box Container that has the radio
		 * buttons and the check box
		 */
		boxPanel = new JPanel(); // Panel uses FlowLayout by default
		boxPanel.setBackground(Color.BLACK);
		boxPanel.add(selectionBox);

		/*
		 * Initialize the top Panel with a BorderLayout and add the
		 * textDisplayPanel above and the boxPanel below
		 */
		topPanel = new JPanel(new BorderLayout());
		topPanel.add(textDisplayPanel, BorderLayout.NORTH);
		topPanel.add(boxPanel, BorderLayout.SOUTH);

		/* Initialize the Panel that contains the keypad with a GridLayout */
		gridPanel = new JPanel(new GridLayout(4, 4, 4, 4));
		gridPanel.setBorder(new EmptyBorder(new Insets(4, 2, 4, 2)));

		/* Initialize the String array with the symbols on the keypad */
		calcButtonArray = new String[] { "7", "8", "9", "/", "4", "5", "6",
				"*", "1", "2", "3", "-", "\u00b1", "0", ".", "+" };
		/* Loop and create a button for each keypad button in the calculator */
		for (int i = 0; i < calcButtonArray.length; i++) {
			if (!calcButtonArray[i].equals(".")) {
				gridPanel.add(createButton(calcButtonArray[i],
						calcButtonArray[i], ((i + 1) % 4 == 0) ? Color.YELLOW
								: Color.BLACK, Color.BLUE, controller));
			}
			/* Add the "." symbol to the dotButton defined globally */
			else {
				dotButton = createButton(calcButtonArray[i],
						calcButtonArray[i], ((i + 1) % 4 == 0) ? Color.YELLOW
								: Color.BLACK, Color.BLUE, controller);
				gridPanel.add(dotButton);
			}
		}

		/* Create the buttons for the clear and equal buttons */
		zero = createButton("C", "C", Color.BLACK, Color.RED, controller);
		equal = createButton("=", "=", Color.BLACK, Color.YELLOW, controller);
		/*
		 * Initialize the Centre Panel with a BorderLayout and put the clear
		 * button in the west the equal button in the east and the gridPanel in
		 * the centre
		 */
		centrePanel = new JPanel(new BorderLayout());
		centrePanel.add(zero, BorderLayout.WEST);
		centrePanel.add(gridPanel, BorderLayout.CENTER);
		centrePanel.add(equal, BorderLayout.EAST);

		/*
		 * Set a BorderLayout for the CalcView object and set its minimum size
		 * and add the Top Panel in the north and the centre Panel in the south
		 */
		setLayout(new BorderLayout());
		setBorder(new MatteBorder(new Insets(5, 5, 5, 5), Color.BLACK));
		add(topPanel, BorderLayout.NORTH);
		add(centrePanel, BorderLayout.CENTER);
	}

	/**
	 * Used to create most of the buttons used in the Calculator Application
	 * 
	 * @param text
	 *            Text on the button
	 * @param ac
	 *            Action command of the button
	 * @param fg
	 *            Foreground of the button
	 * @param bg
	 *            Background of the button
	 * @param handler
	 *            Used to handle the action performed by the button
	 * @return JButton object
	 */
	private JButton createButton(String text, String ac, Color fg, Color bg,
			Action handler) {
		/*Initialize the button with the corresponding action*/
		JButton newButton = new JButton(handler);
		newButton.setText(text);
		newButton.setFont(new Font(newButton.getFont().getFontName(), newButton
				.getFont().getStyle(), 20));
		/* Test that a null is not being sent to setActionCommand */
		if (ac != null) {
			newButton.setActionCommand(ac);
		}
		newButton.setForeground(fg);
		newButton.setBackground(bg);
		/*Used InputMap and ActionMap so the Buttons accept numbers from the keyboard*/
		newButton.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
				KeyStroke.getKeyStroke(ac), "pressed");
		newButton.getActionMap().put("pressed", handler);
		return newButton;
	}

	/**
	 * This inner class reacts to the action of the buttons produced from the
	 * Calculator application
	 * 
	 * @author Amaury Diaz Diaz
	 * @version 1.0
	 * @see javax.swing.AbstractAction
	 * @since 1.8.0_20
	 *
	 */
	private class Controller extends AbstractAction {

		/**
		 * {@value} Serial version unique identifier of the
		 *        class.
		 */
		private static final long serialVersionUID = 1837589747276491207L;
		/**
		 * Holds the action command produced when a button is pressed
		 */
		String actionCommand;
		/**
		 * Used to update the fields in the CalculatorModel when an action is performed
		 */
		CalculatorModel calcModel;
		/**
		 * Used to clear the JTextField (true == clear, false == keep appending Strings)
		 */
		boolean clear;
		/**
		 * Used to know if an operator was pressed (true if pressed and result not gotten yet, false otherwise)
		 */
		boolean operatorUsed;
		
		/**
		 * Initializes the fields of the Controller class to its default values
		 */
		public Controller() {

			calcModel = new CalculatorModel();
			clear = true;
			operatorUsed = false;
		}

		@Override
		/**
		 * Sets the displayText with the action command from the ActionEvent
		 * @param e 	ActionEvent
		 */
		public void actionPerformed(ActionEvent e) {
			actionCommand = e.getActionCommand();

			switch (actionCommand) {
			
			/*In case clear is pressed*/
			case "C":
				if (calcModel.getOperationalMode()) {
					display.setText("0.0");
				} else {
					display.setText("0");
				}
				/*Reset everything including the errorState and display the current operational mode of the calculator*/
				clear = true;
				operatorUsed = false;
				calcModel.setErrorState(false);
				displayOperationalMode(calcModel.getOperationalMode());
				return;
			/*In case backspace is pressed*/
			case "\u2190":
				/*Should only work if the calculator is not in error state*/
				if (!calcModel.getErrorState()) {
					/*Remove the last element in the string until there is only one element left or 
					 if the number is negative until there are 2 elements left*/
					if (display.getText().length() > 1
							&& (!display.getText().contains("-") || display
									.getText().length() > 2)) {
						display.setText(display.getText().substring(0,
								display.getText().length() - 1));
						return;
					}
					/*If everything is erased clear is set to true*/
					clear = true;
					if (calcModel.getOperationalMode()) {
						display.setText("0.0");
					} else {
						display.setText("0");
					}
				}
				return;
			/*In case Int is pressed*/
			case "Int":
				/*Toggle between operational modes. When true(float) enter the if statement and set it to false
				 (int) and set the integer mode accordingly*/
				if (calcModel.getOperationalMode()) {
					
					calcModel.setOperationalMode(false);
					/*Should only work if the calculator is not in error state*/
					if (!calcModel.getErrorState()) {
						/*Call the method to set the GUI accordingly*/
						displayOperationalMode(false);
						/*If an operator has been entered and Int is pressed before '=' the 
						 calculator should be in error mode. Otherwise work as expected*/
						if (!operatorUsed) {
							calcModel.setOperand2(display.getText());
							calcModel.setOperator("none");
							calcModel.getResult();
							/*If the error state is set display the errorMode GUI continue otherwise*/
							if (calcModel.getErrorState()) {
								displayErrorMode();
							} else {
								display.setText(calcModel.getResult());
							}
						} else {
							displayErrorMode();
							calcModel.setErrorState(true);
						}
					}

				} 
				/*Toggle between operational modes. When false(int) enter the if statement and set it to true
				 (float) and set the float mode accordingly*/
				else {
					calcModel.setOperationalMode(true);
					/*Should only work if the calculator is not in error state*/
					if (!calcModel.getErrorState()) {
						displayOperationalMode(true);
						/*If an operator has been entered and Int is pressed before '=' the 
						 calculator should be in error mode. Otherwise work as expected*/
						if (!operatorUsed) {
							calcModel.setOperand2(display.getText());
							calcModel.setOperator("none");
							display.setText(calcModel.getResult());
						} else {
							displayErrorMode();
							calcModel.setErrorState(true);
						}
					}
					
				}
				/*Clear is set to true if the mode has been set successfully*/
				clear=true;
				return;
			/*In case Arithmetic Operation*/
			case "+":
			case "-":
			case "*":
			case "/":
				/*Should only work if the calculator is not in error state*/
				if (!calcModel.getErrorState()) {
					/*Bonus: if the same operator has been pressed more than once accept expression like calculations*/
					if (calcModel.getOperator().equals(actionCommand)) {
						calcModel.setOperand2(display.getText());
						display.setText(calcModel.getResult());
					}
					calcModel.setOperand1(display.getText());
					calcModel.setOperator(actionCommand);
					/*Reset the clear*/
					clear = true;
					/*Set the operator flag to true*/
					operatorUsed = true;
				}
				return;
			/*In case precision buttons are pressed set the precision accordingly*/
			case ".00":
			case ".0":
			case "Sci":
				calcModel.setPrecision(actionCommand);
				return;
			/*In case the unary operator is pressed*/
			case "\u00b1":
				/*Should only work if the calculator is not in error state*/
				if (!calcModel.getErrorState()) {
					calcModel.setOperand1(display.getText());
					calcModel.setOperator(actionCommand);
					display.setText(calcModel.getResult());
				}
				return;
			/*In case = button is pressed*/
			case "=":
				/*Should only work if the calculator is not in error state*/
				if (!calcModel.getErrorState()) {
					calcModel.setOperand2(display.getText());
					display.setText(calcModel.getResult());
				}
				if (calcModel.getErrorState()) {
					displayErrorMode();
				}
				/*Reset clear, operatorUsed and the operator*/
				clear = true;
				operatorUsed = false;
				calcModel.setOperator("none");
				return;
			/*In case dotButton is pressed */
			case ".":
				/*Should only work if the calculator is not in error state*/
				if (!calcModel.getErrorState()) {
					/*Prevents entering . by itself in the calculator*/
					if (!clear) {
						/*Prevents that more than one . is entered in the calculator*/
						if (!display.getText().contains(".")) {
							display.setText(display.getText() + actionCommand);
						}
					}
				}
				return;
			/*In case any number in the keypad is entered*/
			default:
				/*Should only work if the calculator is not in error state*/
				if (!calcModel.getErrorState()) {
					/*If clear is true clear the screen and display the first number pressed*/
					if (clear) {
						display.setText(e.getActionCommand());
						clear = false;
						return;
					}
					/*In case clear is false keep appending numbers*/
					display.setText(display.getText() + actionCommand);
				}
			}

		}
		/**
		 * Changes the GUI according to the current operational mode
		 * @param operationalMode If false int; if true float mode
		 */
		public void displayOperationalMode(boolean operationalMode) {
			if (operationalMode) {
				error.setBackground(Color.YELLOW);
				error.setText("F");
				dotButton.setEnabled(true);
				dotButton.setBackground(Color.BLUE);
			} else {
				error.setBackground(Color.GREEN);
				error.setText("I");
				dotButton.setEnabled(false);
				dotButton.setBackground(Color.GRAY);
			}
		}
		/**
		 * Changes the GUI If an Error happens
		 */
		public void displayErrorMode() {
			error.setBackground(Color.RED);
			error.setText("E");
			display.setText("--");
		}

	}
}
