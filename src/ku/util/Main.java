package ku.util;
/**
 * A main class that use to initiate the program.
 * @author Theeruth Borisuth
 *
 */
public class Main {
	public static void main(String[] args) {
		UnitConverter con = new UnitConverter();
		ConverterUI ui =  new ConverterUI(con);
		ui.run();
	}
}
