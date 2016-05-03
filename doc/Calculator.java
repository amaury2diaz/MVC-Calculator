import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.JFrame;

/*
 File name: 	Calculator.java
 Author: 	Amaury Diaz Diaz, 040-738-985
 Course: 	CST8221 – JAP, Lab Section: 302
 Assignment: 1
 Date: 		October 30th 2015
 Professor:  Svillen Ranev
 Purpose: 	Responsible for launching the application. Splash Screen followed by
 the calculator
 */
/**
 * This class is responsible for launching the calculator application
 * 
 * @author Amaury Diaz Diaz
 * @version 1.0
 * @see java.awt.EventQueue
 * @see javax.swing.JFrame
 * @since 1.8.0_20
 *
 */
public class Calculator {

	/**
	 * To launch the calculator application.
	 * 
	 * @param args String arguments
	 */
	public static void main(String[] args) {
		/**
		 * Used to show the splash screen of the application.
		 */
		CalculatorSplashScreen splashWindow = new CalculatorSplashScreen(5000);
		splashWindow.showSplashWindow();

		/*
		 * Create the Frame object, add the CalculatorView object to its content
		 * pane and put it in the middle of the screen
		 */
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new JFrame();
				frame.setMinimumSize(new Dimension(330, 400));
				frame.setTitle("My calculator 1.0");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setContentPane(new CalculatorView());
				frame.setLocationByPlatform(true);
				frame.setVisible(true);
			}
		});
	}
}
