package ku.util;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
/**
 * Unit converter can convert various types of unit and can convert from left to right or right to left . Your desire!.
 * @author Theeruth Borisuth
 *
 */
public class ConverterUI  {
	//Adding  unitconverter attribute that has a converting method.
	private UnitConverter conv;
	//Adding JFrame for creating interface.
	private JFrame frame ;
	//Adding description text.
	private JTextField  input1 ;
	private JTextField input2 ;
	//Adding 2 combo box  for changing unit.
	private JComboBox<Unit> unit1 ;
	private JComboBox<Unit> unit2 ;
	//Adding button for launching converting process.
	private JButton convert ;
	//Adding button for clearing text in the JTextField.
	private JButton clear ;
	//Adding boolean for checking if it left of right.
	private boolean isLeftToRight ; 


	/**
	 * A method that create all of the attribute's material.
	 */
	public void initComponents() {

		input1 = new JTextField(10);
		input1.setHorizontalAlignment(SwingConstants.CENTER);
		unit1 = new JComboBox<Unit>();
		input2 = new JTextField(10);
		input2.setHorizontalAlignment(SwingConstants.CENTER);
		unit2 = new JComboBox<Unit>();
		convert = new JButton("Convert");
		clear = new JButton("Clear!");

		//Creating panels.
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();

		///Create text description for JRadioButton.
		JRadioButton leftToRight = new JRadioButton("Left To Right");
		JRadioButton rightToLeft = new JRadioButton("Right To Left");

		//A listener for control the radio button.
		ActionListener directionControl = new controlDirection();
		leftToRight.addActionListener( directionControl );
		rightToLeft.addActionListener( directionControl );
		leftToRight.setSelected(true);
		isLeftToRight = true;

		ButtonGroup radioGroup = new ButtonGroup();

		//adding all unit with for each.
		for (Length unit : Length.values()){
			unit1.addItem(unit);
			unit2.addItem(unit);
		}

		//Adding panels
		panel1.add(input1);
		panel1.add(unit1);
		panel1.add(input2);
		panel1.add(unit2);
		panel1.add(convert);
		panel1.add(clear);
		panel2.add(leftToRight);
		panel2.add(rightToLeft);

		//Adding radio group
		radioGroup.add(leftToRight);
		radioGroup.add(rightToLeft);

		frame.add(panel1,BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel2,BorderLayout.SOUTH);
		frame.pack();

		//Adding buttons
		ButtonListener converter = new ButtonListener();
		ActionListener clearing = new ClearListener();
		convert.addActionListener(converter);
		input1.addActionListener(converter);
		input2.addActionListener(converter);
		clear.addActionListener(clearing);

	}

	/**
	 * Calling unitconverter and initComponents() 
	 * @param converter
	 */
	public  ConverterUI(UnitConverter converter){
		conv = converter ;
		frame = new JFrame("Length converter");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initComponents();

	}


	/**
	 * Make it visible when launching the program.
	 */
	public void run(){
		frame.setVisible(true);
	}

	/**
	 * A method that listening when you pressing left or right first.
	 * @author Theeruth Borisuth
	 *
	 */
	public class controlDirection implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			if ( event.getActionCommand().equals("Left To Right") ) {
				isLeftToRight = true;
				input1.setEditable(true);
				input2.setEditable(false);
			} else {
				isLeftToRight = false;
				input2.setEditable(true);
				input1.setEditable(false);
			}
		}
	}

	/**
	 * A method that use to listen when you choosing unit to convert .
	 * @author Theeeruth Borisuth
	 *
	 */
	public class ButtonListener implements ActionListener{
		double amount = 0 ;
		Unit fromUnit ;
		Unit toUnit ;
		@Override
		public void actionPerformed(ActionEvent event) {
			if (isLeftToRight){
				//Get the text that you have entered.
				fromUnit = (Unit)unit1.getSelectedItem();
				toUnit = (Unit)unit2.getSelectedItem();
				amount = Double.parseDouble(input1.getText());
				String result = Double.toString(conv.convert(amount,fromUnit,toUnit));
				input2.setText(result);
			}
			else{
				//Get the text that you have entered.
				toUnit = (Unit)unit1.getSelectedItem();
				fromUnit = (Unit)unit2.getSelectedItem();
				amount = Double.parseDouble(input2.getText());
				String result = Double.toString(conv.convert(amount,fromUnit,toUnit));
				input1.setText(result);
			}

		}

	}
	/**
	 * A method that use for clearing text when you have entered wrong number or want to find a new number.
	 * @author Theeruth Borisuth
	 *
	 */
	public class ClearListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent event) {	
			//set empty text to both fields.
			input1.setText("");
			input2.setText("");

		}

	}

}
