import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;
import javax.swing.SwingUtilities;

/*
 File name: 	CalculatorSplashScreen.java
 Author: 	Amaury Diaz Diaz, 040-738-985
 Course: 	CST8221 – JAP, Lab Section: 302
 Assignment: 1 (Part 1)
 Date: 		October 30th 2015
 Professor:  Svillen Ranev
 Purpose: 	Responsible for creating the Splash screen of the application
 (Progress Bar included)
 */
/**
 * This class creates the Splash Screen of the Calculator Application.
 * 
 * @author Amaury Diaz Diaz
 * @version 1.0
 * @see javax.swing.JWindow
 * @see javax.swing.JPanel
 * @see javax.swing.JProgressBar
 * @see javax.swing.SwingUtilities
 * @since 1.8.0_20
 */
public class CalculatorSplashScreen extends JWindow {
	/**
	 * {@value} Serial version unique identifier of the
	 *        class.
	 */
	private static final long serialVersionUID = 2496110254139770875L;
	/**
	 * {@value}  Minimum value of the progress bar used in the splash screen.
	 */
	private static final int PB_MINIMUM = 0;
	/**
	 * Time the splash screen is displayed.
	 */
	private int durationTime;

	/**
	 * Initial constructor of the Splash Screen.
	 * 
	 * @param durationTime
	 *            time the Splash screen is being showed
	 */
	public CalculatorSplashScreen(int durationTime) {
		this.durationTime = durationTime;
	}

	/**
	 * Shows the splash screen and the progress bar associated with it.
	 */
	public void showSplashWindow() {
		/*
		 * COntainer of the whole content in the Splash Screen(label and
		 * southContent)
		 */
		JPanel content;
		/*
		 * Container of the contents in the bottom of the Splash Screen
		 * (studentInfo and progressBar)
		 */
		JPanel southContent;
		/* Progress Bar used in the splash screen */
		JProgressBar progressBar;
		/* Contains the image used in the splash screen */
		JLabel label;
		/* Contains the student info (me :)) */
		JLabel studentInfo;
		/* Color of the background of the splash screen */
		Color myBackgroundColor;
		/* Color of the border of the splash screen */
		Color myBorderColor;

		/* Initialize the label and studentInfo with their respective values */
		label = new JLabel(new ImageIcon("CalcFunny.jpg"));
		studentInfo = new JLabel(
				"Name: Amaury Diaz Diaz  Student Number: 040738985",
				JLabel.CENTER);
		studentInfo.setFont(new Font(Font.SERIF, Font.BOLD, 16));

		/* Create the progress bar for the splash screen */
		progressBar = new JProgressBar();
		progressBar.setPreferredSize(new Dimension(640, 20));
		progressBar.setMinimum(PB_MINIMUM);
		progressBar.setMaximum(durationTime);

		/* Creates the background and border colors */
		myBackgroundColor = new Color(42, 241, 131);
		myBorderColor = new Color(0, 15, 25);

		/*
		 * Creates a panel in the bottom of the splash screen where the student
		 * info and the progress bar are
		 */
		southContent = new JPanel(new BorderLayout());
		southContent.setBackground(myBackgroundColor);
		southContent.add(studentInfo, BorderLayout.CENTER);
		southContent.add(progressBar, BorderLayout.SOUTH);

		/*
		 * Creates a panel that contains the whole splash screen(label(image and
		 * south panel))
		 */
		content = new JPanel(new BorderLayout());
		content.setBackground(myBackgroundColor);
		content.setOpaque(true);
		content.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
		content.add(label, BorderLayout.CENTER);
		content.add(southContent, BorderLayout.SOUTH);
		content.setBorder(BorderFactory.createLineBorder(myBorderColor, 10,
				true));

		/*
		 * Sets the JWindow container in the middle of the screen and adds the
		 * content panel to it
		 */
		int width = 640 + 10;
		int height = 480 + 10;
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (screen.width - width) / 2;
		int y = (screen.height - height) / 2;
		setBounds(x, y, width, height);
		setContentPane(content);
		setVisible(true);

		/* Update the progress bar */
		for (int i = PB_MINIMUM; i <= durationTime; i++) {
			final int percent = i;
			try {
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						if (percent < 2000) {
							// at the beginning switch to Indeterminate mode
							if (percent == 1) {
								progressBar.setIndeterminate(true);
							}
							progressBar.setString("Loading Calculator.Please wait..."); 
							progressBar.setStringPainted(true);
							progressBar.setValue(percent);
							return;
						}
						progressBar.setIndeterminate(false);
						progressBar.setValue(percent);
					}
				});
				// make the program inactive for a while so that the GUI thread
				// can do its work
				java.lang.Thread.sleep(1);
			} catch (InterruptedException e) {
				;
			}
		}
		/* Dispose of the splash screen when the progress bar is full */
		dispose();

	}

}
