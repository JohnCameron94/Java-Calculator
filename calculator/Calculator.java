package calculator;

/**
 * FILE: Calculator.java
 * @author: Johnathon Cameron #040725586
 * Course: CST8221 - JAP -  Lab: 302
 * Assignment: 1
 * Date:
 * Professor: Sv.Ranev / Daniel Cormier
 * Purpose: This class is used to implement the main method, by creating a CalculatorSplashScreen object and calling the showSplashScreen
 * method and running the calculator until user presses on default close operation.
 * - This is a calculator simulator, it can be used to perform basic arithmetics. It has 4 mode, Hexadecimal mode, .0 mode (floating point)
 * .00 mode (floating point) and Scientific notation mode.
 * 
 * Operations:
 * Addition,Subtraction,Multiplication,Division
 * 
 *Special Specification: 
 *	- Backspace Button
 *  - Error mode
 *  - Hexadecimal keypads
 * 
 */
import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 * @author Johnathon Cameron
 * @version 1.5
 * @see Calculator
 * @since 1.8 (Java 8)
 */
public class Calculator {
	/**
	 * 
	 * @param args
	 * Main method used to show splash screen for 5 seconds and run the calculator GUI until user click on the default close 
	 */
	public static void main(String[] args) {
		//Create splash screen object
		CalculatorSplashScreen splashWindow = new CalculatorSplashScreen(5000);
		Dimension defaultSize = new Dimension(380, 540); // Initial frame size and minimum size
		//splash screen builder and show for 5 seconds
		splashWindow.showSplashScreen();
		
		
		//RUN CALCULATOR 
		EventQueue.invokeLater(new Runnable(){
		       @Override
		       public void run(){ 	
		    	   //Creating frame
		    	   	JFrame frame = new JFrame();
		    	   	//Setting title to frame
		    	   	frame.setTitle("Calculator");
		    	   	//Setting preferred size to requirement size
		    		frame.setPreferredSize(defaultSize);
		    		//setting the minimum size to the requirement size
		    		frame.setMinimumSize(defaultSize);
		    		// make it possible to resize (only expand when its at default size)
		    		frame.setResizable(true);
		    		//Creating content pane
		    	   	JPanel content = new CalculatorViewController();
		    	   	//Adding Content panel to frame
		    		frame.add(content);
		    		// Set location by platform
		    		frame.setLocationByPlatform(true);
		    		//Set frame visible 
		    		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    		frame.setVisible(true);
		       }
		});
		 
	}

}
