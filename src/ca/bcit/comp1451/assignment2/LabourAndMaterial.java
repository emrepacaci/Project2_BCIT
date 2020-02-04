/**
 * 
 */
package ca.bcit.comp1451.assignment2;

/**
 * @author emre
 *
 */
public class LabourAndMaterial extends Labour implements Transferable {
	
	private double purchasePrice;
	private double volumeInCubicFoot;
	private double materiaDistanceOfTransportaiondistanceInKilometers ;
	
	
	/**
	 * 
	 * @param projectName cannot be null or empty, inherits from super class
	 * @param numberOfWorkingHours cannot be negative, inherits from super class
	 * @param hourlyRate cannot be negative, inherits from super class
	 * @param distanceOfTransformationInKilometers  cannot be negative, inherits from super class
	 * @param hourlyRateCriteria can be regular, holiday, overtime otherwise set regular, inherits from super class
	 * @param typedOfLabour can be experienced or inexperienced otherwise set inexperienced, inherits from super class
	 * @param purchasePrice  cannot be negative
	 * @param volumeInCubicFoot cannot be negative
	 * @param materiaDistanceOfTransportaiondistanceInKilometers cannot be negative
	 */
	public LabourAndMaterial(String projectName, int numberOfworkingHours, double hourlyRate,
			int distanceofTransformationInKilometers, String hourlyRateCriteria, String typedOfLabour,
			double purchasePrice, double volumeInCubicFoot, double materiaDistanceOfTransportaiondistanceInKilometers ) {
		super(projectName, numberOfworkingHours, hourlyRate, distanceofTransformationInKilometers, hourlyRateCriteria,
				typedOfLabour);
		setPurchasePrice(purchasePrice);
		setVolumeInCubicFoot(volumeInCubicFoot);
		setDistanceOfTransportationInKm(materiaDistanceOfTransportaiondistanceInKilometers) ;
	}
	//end constructor
	/**
	 * 
	 * @return the purchasePrice of a Material
	 */
	public double getPurchasePrice() {
		return purchasePrice;
	}
	//end getter
	/**
	 * 
	 * @param purchasePrice cannot be negative
	 */
	public void setPurchasePrice(double purchasePrice) {
		if(purchasePrice > ZER0)
		{
			this.purchasePrice = purchasePrice;
		}else 
		{
			throw new IllegalArgumentException("it cannot be negative");
		}
	}
	//end setter
	/**
	 * 
	 * @return the volumeInCubicFoot of a Material
	 */
	public double getVolumeInCubicFoot() {
		return volumeInCubicFoot;
	}
	//end getter
	/**
	 *  
	 * @param volumeInCubicFoot cannot be negative
	 */
	public void setVolumeInCubicFoot(double volumeInCubicFoot) {
		if(volumeInCubicFoot > ZER0)
		{
			this.volumeInCubicFoot = volumeInCubicFoot;
		}else
		{
			throw new IllegalArgumentException("it cannot be negative");
		}
	}
	//end setter
	/**
	 * 
	 * @return the materiaDistanceOfTransportaiondistanceInKilometers of a Material
	 */
	public double getDistanceOfTransportationInKm() {
		return materiaDistanceOfTransportaiondistanceInKilometers ;
	}
	//end getter
	/**
	 * 
	 * @param materiaDistanceOfTransportaiondistanceInKilometers cannot be negative
	 */
	public void setDistanceOfTransportationInKm(double materiaDistanceOfTransportaiondistanceInKilometers) {
		if(materiaDistanceOfTransportaiondistanceInKilometers > ZER0)
		{
			this.materiaDistanceOfTransportaiondistanceInKilometers  = materiaDistanceOfTransportaiondistanceInKilometers;
		}else
		{
			throw new IllegalArgumentException("it cannot be negative");
		}	
	}
	//end setter
	/**
	 * 
	 * @return material cost, calculating it with purchase rate which is 15% markup on the purchase price. 
	 */
	public double meterialCost()
	{
		return  purchasePrice + (PURCHASE_RATE*purchasePrice);
	}
	//end method
	/**
	 * Overriding method calculate transportation fees to calculate the material transportation fees.
	 * @return fee of transportation based on volumeInCubicFoot field. 
	 *        if the volumeInCubicFoot is greater or equals than 10, will calculate materiaDistanceOfTransportaiondistanceInKilometers * 2
	 *        if the  volumeInCubicFoot is less than 10, will calculate   materiaDistanceOfTransportaiondistanceInKilometers * 1.5
	 * 
	 */
	@Override 
	public double calculateTransportationFees()
	{
		double fees = ZER0;
		if(volumeInCubicFoot >= CUBIC_FEET_VALUE )
		{
			fees = materiaDistanceOfTransportaiondistanceInKilometers  *TWO;
		}else if(volumeInCubicFoot <= CUBIC_FEET_VALUE )
		{
			fees = materiaDistanceOfTransportaiondistanceInKilometers  *ONE_AND_A_HALF;
		}
		return fees;
	}
	//end method
	/**
	 * 
	 *@return total cost, material transportation fees,the material cost 
	 *					 and 5% sales tax of the addes fees
	 *					  will be added to the super class total cost
	 */
	@Override
	public double calculateTotalCost()
	{
		return  super.calculateTotalCost() +((calculateTransportationFees() + meterialCost()) * WITH_TAX_RATE);
	}
	//end method
	/**
	 * Overriding toString method, adding material cost and 
	 * 						transportation fees to the returned String
	 */
	@Override
	public String toString()
	{
		String returnValue = super.toString() + 
				"\nThe materail cost is: " + meterialCost() + 
				"\nThe  material transportation fees is  " + calculateTransportationFees();
		if(this.getClass() == LabourAndMaterial.class)
			returnValue += "\nThe total cost including %5 tax is : " + calculateTotalCost();
		return returnValue;
	}
	//end method
}//end class
