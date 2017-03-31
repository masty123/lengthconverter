package ku.util;
/**
 * A Class that has only a converting method.
 * @author Theeruth Borisuth
 *
 */
public class UnitConverter {

	public  double convert(double amount, Unit fromUnit,Unit toUnit){
		double result = amount*(fromUnit.getValues()/toUnit.getValues());
		return result ;
	}
}
