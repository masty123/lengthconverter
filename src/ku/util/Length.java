package ku.util;
/**
 * An enum class that contain many units.
 * @author Theeruth Borisuth
 *
 */
public enum  Length implements Unit {
	//Attribute of units
	METRE("Meter",1),KILOMETRE("Kilometer",1000),CENTIMETRE("centimeter",0.01),MILE("Mile",1609.344),FOOT("Foot",0.30480) ,WA ("Wa",2);	
	//Attribute that display name of the unit.
	private String name ;
	//Attribute that display value of the unit.
	private double values ;

	/**
	 * Constructor for Length .
	 * @param name
	 * @param values
	 */
	Length(String name, double values){
		this.name = name ;
		this.values = values ;
	}

	/**
	 * Get the values.
	 * @return values
	 */
	public double getValues(){
		return this.values;
	}

	/**
	 * Return the names.
	 * return names
	 */
	public String toString(){
		return " "+name ; 
	}

}
