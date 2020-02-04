
package ca.bcit.comp1451.assignment2;

import java.util.ArrayList;
import java.util.Collections;
 

/**
 * @author emre
 *
 */
public class InsuranceCompany {
	
	private static final String UNKNOWN =  "unknown";
	private static final int INVOICE_NUMBER_LENGTH = 7;
	private static final int ZERO = 0;
	private static final double INSURANCE_RATE_LABOUR = 0.05;
	private static final double INSURANCE_RATE_LABOUR_AND_MATERIAL = 0.07;
	private static final double INSURANCE_RATE_LABOUR_AND_MATERIAL_EQUIPMENT = 0.1;
	
	private String companyName;
	private ArrayList<ProjectInvoice> projectInvoice;
	
	/**
	 * 
	 * @param companyName cannot be null or empty 
	 * 						if it is, "unknown" will be assigned to the field
	 */
	public InsuranceCompany(String companyName) {
		projectInvoice = new ArrayList<ProjectInvoice>();
		setCompanyName(companyName);
	}
	// end constructor
	/**
	 * 
	 * @return the company name
	 */
	public String getCompanyName() {
		return companyName;
	}
	//end getter
	/**
	 * 
	 * @param companyName cannot be null or empty 
	 * 				if it is, "unknown" will be assigned to the field 
	 */		
	public void setCompanyName(String companyName) 
	{
		if(companyName != null && companyName.length() > ZERO)
		{
			this.companyName = companyName;
		}else
		{
			this.companyName = UNKNOWN;
		}
	} 
	//end setter
	/**
	 *  
	 * @param invoice cannot be null,
	 * 			 adding project invoice object to the collection
	 */
	public void addInvoice(ProjectInvoice invoice) 
	{
		if(invoice != null)
		{
			projectInvoice.add(invoice);
		}
	}
	//end method 
	/**
	 * 
	 * @param invoiceNumber cannot be null or less than 7 characters.
	 * 		  search the collection and print that invoice
	 * 		if the invoice was not found a message stating
	 * 			 that invoice was not found will be displayed on the  screen
	 * 		if the passed parameter was null or less than 7 characters in length,
	 * 			InvalidInvoiceNumberException will be thrown. 
	 */
	public void displayProjectInvoice(String invoiceNumber) throws InvalidInvoiceNumberException
	{
		if(invoiceNumber == null || invoiceNumber.length() < INVOICE_NUMBER_LENGTH)
		{
			throw new InvalidInvoiceNumberException("invalid input");
		}
		for(ProjectInvoice p : projectInvoice)
		{
			if(p.getInvoiceNumber().equalsIgnoreCase(invoiceNumber))
			{
				System.out.println(p);
				return;
			}
		}
		System.out.println("The invoice was not found ");
	}
	//end method
	/**
	 * 
	 * @return total insurance fees of all projects  depending on the project type as follows:
	 * 			  If the project was labour only, the insurance will be 5% of the total cost 
	 * 			If the project was labour and material then the insurance will be 7% of the total cost
	 * 			if the project was labour material and equipment then its 10% of the total cost
	 */
	public double calculateTotalInsuranceFees()
	{
		
		double fees = ZERO;
		for(ProjectInvoice pr: projectInvoice)
		{
			if(pr instanceof LabourAndMaterialAndEquipment)
			{
				LabourAndMaterialAndEquipment lbm = (LabourAndMaterialAndEquipment)pr;
				fees = lbm.calculateTotalCost() * INSURANCE_RATE_LABOUR_AND_MATERIAL_EQUIPMENT;
			}
			if(pr instanceof LabourAndMaterial)
			{
				LabourAndMaterial lbr = (LabourAndMaterial)pr;
				fees = lbr.calculateTotalCost()*INSURANCE_RATE_LABOUR_AND_MATERIAL;
			}
			if(pr instanceof Labour)
			{
				Labour lb = (Labour)pr;
				fees = lb.calculateTotalCost()*INSURANCE_RATE_LABOUR;
			}
		}
		return fees;
	}
	//end method
	/**
	 * display only the invoice numbers of all the projectInvoice objects
	 * 										 sorted by the total cost 
	 */
	public void displayInvoiceNumber()
	{
		Collections.sort(projectInvoice);
		System.out.println("The Invoices sorted by the total cost\n");
		for (ProjectInvoice p : projectInvoice)
		{
				System.out.println(p);
				System.out.println("--------------------------");
		}
	}//end method
}//end class
