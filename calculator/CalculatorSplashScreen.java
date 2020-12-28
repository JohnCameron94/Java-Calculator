package calculator;

/**
 * FILE: CalculatorSplashScreen.java
 * @author: Johnathon Cameron #040725586
 * Course: CST8221 - JAP -  Lab: 302
 * Assignment: 1
 * Date:
 * Professor: Sv.Ranev / Daniel Cormier
 * Purpose: Class used to display a splash screen for 5 sec while the calculator GUI load for the user.
 * 
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;

/**
 * @author Johnathon Cameron
 * @version 1.5
 * @see CalculatorViewController
 * @since 1.8 (Java 8)
 */
public class CalculatorSplashScreen extends JWindow {
	/**
	 * {@value #serialVersionUID} 
	 * default serial version ID - Swing components implement the Serializable interface 
	 */
	private static final long serialVersionUID = 6248477390124803341L;
	/**
	 * Integer used for the number of seconds it takes for the calculator GUI to load
	 */
	private  int loadTime;

	/**
	 * @param int 
	 *Constructor Setting the loadTime for the application to load (in seconds)
	 */
	public CalculatorSplashScreen(int seconds) {
		this.loadTime = seconds;
	}

	/**
	 * Method used to show the splash screen when called upon to the main method in Calculator.java. It will build the splash screen
	 * and show it for 5 seconds then dispose of it.
	 */
	public void showSplashScreen() {
		// Creating JPanel with border layout (content)
		JPanel content = new JPanel(new BorderLayout());
		content.setBackground(Color.WHITE);

		// Setting window size
		int width = 534;
		int height = 263;
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (screen.width - width) / 2;
		int y = (screen.height - height) / 2;
		// set the location and the size of the window,setting to center
		setBounds(x, y, width, height);

		// splash screen label
		//PATH to get image
		JLabel imgLabel = new JLabel(new ImageIcon(getClass().getResource("calculatorSplash2.jpg")));
		JLabel signature = new JLabel("Johnathon Cameron  #040725586", JLabel.CENTER);
		JLabel progBar = new JLabel();

		/*********PROGRESS BAR******************************/
		JProgressBar progressBar = new JProgressBar();
		progBar.add(progressBar);
		progressBar.setValue(0);
		progressBar.setStringPainted(true);
		/***************************************************/

		//setting font label
		signature.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 14));
		// Setting Progress bar to top
		content.add(progressBar, BorderLayout.NORTH);
		// Center image
		content.add(imgLabel, BorderLayout.CENTER);
		// Setting signature at bottom
		content.add(signature, BorderLayout.SOUTH);

		// Setting RGB color to black and borders to 3
		Color customColor = new Color(0, 0, 0);
		content.setBorder(BorderFactory.createLineBorder(customColor, 3));

		// setting content pane
		setContentPane(content);

		// set splash window visible
		setVisible(true);

		// Loop will do 5 iterations of 1 sec Threads. 5 seconds in total
		try {
			// While loop for progress bar and show splash screen for 5 seconds
			int i = 0;
			while (i <= 100) {
				// fill the menu bar
				progressBar.setValue(i);
				//increment by 20% every second
				i += 20;
				// delay the thread
				Thread.sleep(1000);
			}
		//Catch exception if ever could no boot application
		} catch (InterruptedException e) {
			System.out.println("OOOOPPS!! Something went wrong. Application Unable to load");
		}
		//dispose of splash screen once 5 seconds is over
		dispose();
	}

}
