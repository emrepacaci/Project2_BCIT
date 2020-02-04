/**
 * 
 */
package ca.bcit.comp1451.assignment2;

/**
 * @author emre
 *
 */
public abstract class ProjectInvoice implements Comparable<ProjectInvoice> {
	
	private static int NEXT_INVOICE_NUMBER = 12345;
	public static final int ZERO= 0;
	
	private String invoiceNumber;
	private String projectName;
	private int numberOfWorkingHours;
	private double hourlyRate;
	
	
	/**
	 * Main Constructor
	 * @param projectName cannot be null or empty, set projectName field
	 * @param numberOfWorkingHours cannot be negative, set numberOfworkingHours field  
	 * @param hourlyRate cannot be negative, set hourlyRate field
	 */
	public ProjectInvoice(String projectName, int numberOfWorkingHours, double hourlyRate) {
		super();
		invoiceNumber = createInvoiceNumber();
		setProjectName(projectName);
		setNumberOfworkingHours(numberOfWorkingHours);
		setHourlyRate(hourlyRate);
	}
	//end constructor
	/**
	 * 
	 * @return the invoiceNumber
	 */
	public String getInvoiceNumber() {
		return invoiceNumber;
	}
	//end getter
	/**
	 * 
	 * @return the project name
	 */
	public String getProjectName() {
		return projectName;
	}
	//end getter
	/**
	 * 
	 * @param projectName cannot be null or empty
	 */
	public void setProjectName(String projectName) {
		if(projectName != null && projectName.length() > ZERO)
		{
			this.projectName = projectName;
		}else
		{
			throw new IllegalArgumentException("it cannot be null or empty");
		}
		
	}
	//end setter
	/**
	 * 
	 * @return the numberOfworkingHours
	 */
	public int getNumberOfworkingHours() {
		return numberOfWorkingHours;
	}
	// end getter
	/**
	 * 
	 * @param numberOfworkingHours cannot be negative
	 */
	public void setNumberOfworkingHours(int numberOfWorkingHours) {
		if(numberOfWorkingHours > ZERO)
		{
			this.numberOfWorkingHours = numberOfWorkingHours;
		}else
		{
			throw new IllegalArgumentException("it cannot be negative");
		}
		
	}
	//end setter
	/**
	 * 
	 * @return the hourly Rate
	 */
	public double getHourlyRate() {
		return hourlyRate;
	}
	//end getter
	/**
	 * 
	 * @param hourlyRate cannot be negative
	 */
	public void setHourlyRate(double hourlyRate) {
		if(hourlyRate > ZERO)
		{
			this.hourlyRate = hourlyRate;
		}else
		{
			throw new IllegalArgumentException("it cannot be negative");
		}
	}
	//end setter
	/**
	 * 
	 * @return created invoice number then set it to invoice number field 
	 */
	private String createInvoiceNumber()
	{
		NEXT_INVOICE_NUMBER++;
		return "INVC" + Integer.toString(NEXT_INVOICE_NUMBER);
	}
	//end method
	/**
	 * 
	 *  abstract method .
	 */
	public abstract double calculateTotalCost();
	//end method
	/**
	 * Override compateTo method. comparing based on calculateTotalCost
	 */
	@Override
	public int compareTo(ProjectInvoice obj)
	{
	   return (int)(this.calculateTotalCost() - obj.calculateTotalCost());
	}
	//end method
	/**
	 * 
	 * @return invoiceNumber, projectName, hourlyRate and numberOfworkingHours
	 * Override toString method. 
	 */
	//end method
	@Override
	public String toString()
	{
		return "The invoice number: " + invoiceNumber + "\nProject name :" + projectName + "\nHourly rate :" + hourlyRate +  "\nNumber of working hours " + numberOfWorkingHours;
	}
	//end method
}//end class
