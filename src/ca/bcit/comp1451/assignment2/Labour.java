/**
 * 
 */
package ca.bcit.comp1451.assignment2;

/**
 * @author emre
 *
 */
public class Labour extends ProjectInvoice {
	
	private static final String EXPERIENCED = "experienced";
	private static final String INEXPERIENCED = "inexperienced";
	private static final double TAX = 0.05;
	private static final double TRANSPORTATION_COST_RATE_PER_KM = 1.2;
	private static final double OVERTIME_RATE = 1.5;
	private static final int HOLIDAY_RATE = 2;
	
	private int distanceOfTransportationInKilometers;
	private String hourlyRateCriteria;
	private String typedOfLabour;
	
	
	/**
	 * Main Constructor
	 * @param projectName cannot be null or empty, inherits from super class
	 * @param numberOfWorkingHours  cannot be negative , inherits from super class
	 * @param hourlyRate cannot be negative, inherits from super class
	 * @param distanceOfTransformationInKilometers cannot be negative, 
	 * @param hourlyRateCriteria can be regular, holiday, overtime otherwise set regular
	 * @param typedOfLabour can be experienced or inexperienced otherwise set inexperienced
	 */
	public Labour(String projectName, int numberOfworkingHours, double hourlyRate,
			int distanceOfTransportationInKilometers, String hourlyRateCriteria, String typedOfLabour) {
		super(projectName, numberOfworkingHours, hourlyRate);
		setDistanceofTransformationInKilometers(distanceOfTransportationInKilometers);
		setHourlyRateCriteria(hourlyRateCriteria);
		setTypedOfLabour(typedOfLabour);
	}
	//end constructor 
	/**
	 * 
	 * @return the distance Of TransportationInKilometers
	 */
	public int getDistanceofTransformationInKilometers()
	{
		return distanceOfTransportationInKilometers;
	}
	// end getter
	/**
	 * 
	 * @param distanceOfTransportationInKilometers cannot be negative
	 */
	public void setDistanceofTransformationInKilometers(int distanceOfTransportationInKilometers)
	{
		if(distanceOfTransportationInKilometers > ZERO)
		{
			this.distanceOfTransportationInKilometers = distanceOfTransportationInKilometers;
		}else
		{
			throw new IllegalArgumentException("it cannot be negative");
		}
		
	}
	//end setter
	/**
	 * 
	 * @return the hourlyRateCriteria
	 */
	public String getHourlyRateCriteria()
	{
		return hourlyRateCriteria;
	}
	//end getter
	/**
	 * 
	 * @param value can be regular, holiday, overtime otherwise set it to regular
	 */
	public void setHourlyRateCriteria(String value) {
		if(value == null)
		{
			hourlyRateCriteria = "regular";
		}
	        switch (value)
	        {
	            case "regular":
	            hourlyRateCriteria = value;
	                     break;
	            case "overtime ":
	            hourlyRateCriteria = value;
	                     break;
	            case  "holiday":
	            hourlyRateCriteria = value;
	                     break;
	            default: value = "regular";
	            hourlyRateCriteria = value;
	                     break;
	        }
	}
	//end setter
	/**
	 * 
	 * @return the typedOfLabour
	 */
	public String getTypedOfLabour() {
		return typedOfLabour;
	}
	//end getter
	/**
	 * 
	 * @param typedOfLabour can be experienced, or inexperienced otherwise set it to inexperienced
	 */
	public void setTypedOfLabour(String typedOfLabour) 
	{
		if(typedOfLabour == null )
		{
			this.typedOfLabour = INEXPERIENCED;
		}
		
		if(typedOfLabour.equals(EXPERIENCED) || typedOfLabour.equals(INEXPERIENCED) )
		{
			this.typedOfLabour = typedOfLabour;
		}else
		{
			this.typedOfLabour = INEXPERIENCED;
		}
	}
	//end setter
	/**
	 * 
	 * @return the cost of transportation,
	 */
	public double calculateTransportationCost()
	{
		return (TRANSPORTATION_COST_RATE_PER_KM * distanceOfTransportationInKilometers);
	}
	//end method
	/**
	 * Overriding calculate total cost 
	 * @return calculateTotal Cost of a Labour based on hourly rate criteria and adding 5% sales tax
	 * if the hourly rate criteria is regular, calculate hourly rate * number of working hours
	 * if the hourly rate criteria is overtime, calculate hourly rate * number of working hours * overtime rate which is 1.5
	 * if the hourly rate criteria is holiday, calculate hourly rate * number of working hours * holiday rate which is 2
	 */
	@Override
	public double calculateTotalCost() {
		double cost = 0;
		if(hourlyRateCriteria.equalsIgnoreCase("regular"))
		{
	        cost = super.getHourlyRate() * super.getNumberOfworkingHours() ;
	        
		}else if(hourlyRateCriteria.equalsIgnoreCase("overtime"))
		{
			cost = super.getHourlyRate() * OVERTIME_RATE * super.getNumberOfworkingHours();
		}else if(hourlyRateCriteria.equalsIgnoreCase("holiday"))
		{
			cost = super.getHourlyRate() * HOLIDAY_RATE * super.getNumberOfworkingHours();
		}
		
		return ((calculateTransportationCost() + cost) * TAX )+ (calculateTransportationCost() + cost);
		
	}
	//end method
	/**
	 * Overriding toString method adding hourlyRateCriteria, typedOfLabour, cost of labour transportation and total cost
	 */
	@Override
	public String toString()
	{
		String returnValue = 
				super.toString() + 
				"\nThe hourly rate criteria: " + hourlyRateCriteria + 
				"\nThe type of Labour: " + typedOfLabour +  
				"\nCost of labour transportation : " + calculateTransportationCost();
		if(this.getClass() == Labour.class)
			returnValue += "\nThe total cost including %5 tax is : " + calculateTotalCost();
		return returnValue;				
	}
	//end method
}//end class
