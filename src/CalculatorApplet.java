import java.awt.Dimension;

import javax.swing.JApplet;


public class CalculatorApplet extends JApplet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6585082582949042928L;
	private CalculatorView calcView;
	@Override
	public void init(){
		calcView = new CalculatorView();
		super.init();
		setContentPane(calcView);
	}
	
}
