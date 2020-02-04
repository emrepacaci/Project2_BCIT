/**
 * 
 */
package ca.bcit.comp1451.assignment2;

/**
 * @author emre
 *
 */
public class LabourAndMaterialAndEquipment extends LabourAndMaterial {

	private double equipmentValueInCAD;
	private int numberOfRentedHours;
	
	/**
	 * 
	 * Main Constructor
	 * @param projectName cannot be null or empty, inherits from super class
	 * @param numberOfWorkingHours cannot be negative, inherits from super class
	 * @param hourlyRate cannot be negative, inherits from super class
	 * @param distanceOfTransformationInKilometers  cannot be negative, inherits from super class
	 * @param hourlyRateCriteria can be regular, holiday, overtime otherwise set regular, inherits from super class
	 * @param typedOfLabour can be experienced or inexperienced otherwise set inexperienced, inherits from super class
	 * @param purchasePrice  cannot be negative, inherits from super class
	 * @param volumeInCubicFoot cannot be negative, inherits from super class
	 * @param materiaDistanceOfTransportaiondistanceInKilometers cannot be negative, inherits from super class
	 * @param equipmentValueInCAD cannot be negative
	 * @param numberOfRentedHours cannot be negative
	 */
	
	public LabourAndMaterialAndEquipment(String projectName, int numberOfworkingHours, double hourlyRate,
			int distanceofTransformationInKilometers, String hourlyRateCriteria, String typedOfLabour,
			double purchasePrice, double volumeInCubicFoot, double materiadistanceOfTransportaiondistanceInKilometers,
			double equipmentValueInCAD, int numberOfRentedHours) {
		super(projectName, numberOfworkingHours, hourlyRate, distanceofTransformationInKilometers, hourlyRateCriteria,
				typedOfLabour, purchasePrice, volumeInCubicFoot, materiadistanceOfTransportaiondistanceInKilometers);
		setEquipmentValueInCAD(equipmentValueInCAD);
		setNumberOfRentedHoures(numberOfRentedHours);
		
	}
	//end constructor
	/**
	 * 
	 * @return equipment value in CAD
	 */
	public double getEquipmentValueInCAD() {
		return equipmentValueInCAD;
	}
	//end getter
	/**
	 * 
	 * @param equipmentValueInCAD cannot be negative,assign it to equipmentValueInCAD field
	 */
	public void setEquipmentValueInCAD(double equipmentValueInCAD) 
	{
		if(equipmentValueInCAD > ZER0)
		{
			this.equipmentValueInCAD = equipmentValueInCAD;
		}else
		{
			throw new IllegalArgumentException("it cannot be negative");
		}
		
	}
	//end setter
	/**
	 * 
	 * @return number of rented hours of a equipment 
	 */
	public int getNumberOfRentedHoures() {
		return numberOfRentedHours;
	}
	//end getter
	/**
	 * 
	 * @param numberOfRentedHoures cannot be negative, assign it to numberOfRentedHours field
	 */
	public void setNumberOfRentedHoures(int numberOfRentedHoures)
	{
		if(numberOfRentedHoures > ZER0)
		{
			this.numberOfRentedHours = numberOfRentedHoures;
		}else
		{
			throw new IllegalArgumentException("it cannot be negative");
		}
		
	}
	//end setter
	/**
	 * 
	 * @return the total rental fees, rate per hour will be 5% of the equipment value
	 *             					and the total rental fee will be rate per hour 
	 *             					multiplied by the number of hours rented.
	 */
	public double calculateTotalRentalFees()
	{
		return numberOfRentedHours * (EQUIPMENT_RATE * equipmentValueInCAD);
	}
	//end method
	/**
	 * 
	 * @return training fee, if the labour type was experienced, no fees will apply 
	 * 						if the labour type was  inexperienced, will apply
	 * 						it will be equipmentValueInCAD * 2% of the equipment value.
	 */							
	public double trainingFees()
	{
		double fee = ZER0;
		if(super.getTypedOfLabour().equalsIgnoreCase("inexperienced"))
		{
			 fee = RATE_FEE* equipmentValueInCAD;
		}
		return fee;
	}
	//end method
	/**
	 * 
	 * Overriding  calculateTotalCost(), adding trainingFees, calculateTotalRentalFees and 5% tax of those fees to the total cost
	 */
	@Override
	public double calculateTotalCost()
	{
		return  super.calculateTotalCost() +(WITH_TAX_RATE* (trainingFees()+calculateTotalRentalFees()));
			
	}
	//end method
	/**
	 * Overriding toString(), adding numberOfRentedHours, calculateTotalRentalFees, trainingFees if applicable
	 */
	@Override
	public String toString()
	{
		return super.toString() +"\nEquipment number of rented hours : " + numberOfRentedHours + "\nEquipment rental fees : " + calculateTotalRentalFees() + "\nTraining fees : " +trainingFees()
								+ "\nThe total cost including %5 tax is : " + calculateTotalCost() ;
	}
	//end method
}//end class
