/**
 * 
 */
package ca.bcit.comp1451.assignment2;

import java.util.Scanner;

/**
 * @author emre
 *
 */
public class Driver {
	
	public static void main(String[] args)
	{
		InsuranceCompany company1 = new InsuranceCompany("LTD");
		Labour l1 = new Labour("first labour project", 50, 20.0, 15, "regular", "experienced");
		Labour l2 = new Labour("second labour project", 80, 20.0, 30, "holiday", "inexperienced");
		
		LabourAndMaterial lm1 = new LabourAndMaterial("first labour and material project", 50, 20.0, 15, "regular", "experienced", 500.0, 12.0, 26.25);
		LabourAndMaterial lm2  = new LabourAndMaterial("second labour and material project", 80, 20.0, 20, "regular", "inexperienced", 500.0, 8.0, 35);
		
		LabourAndMaterialAndEquipment lme1 = new LabourAndMaterialAndEquipment("first labour and material project and equipment project", 50, 20.0, 15, "regular", "experienced", 500.0, 12.0, 26.25, 5000, 15);
		LabourAndMaterialAndEquipment lme2 = new LabourAndMaterialAndEquipment("second labour and material project and equipment project", 80, 20.0, 20, "regular", "inexperienced", 500.0, 8.0, 35, 5000, 20);
		
		
		company1.addInvoice(l1);
		company1.addInvoice(l2);
		company1.addInvoice(lm1);
		company1.addInvoice(lm2);
		company1.addInvoice(lme1);
		company1.addInvoice(lme2);
			
		company1.displayInvoiceNumber();
		System.out.println("the total insurance fees of all projects is : " + company1.calculateTotalInsuranceFees());
		
		Scanner input = new Scanner(System.in);
		String answer = "";
		
		while(!answer.equalsIgnoreCase("no"))
		{
			System.out.println("Enter the invoice number:");
			String invcNumber = input.nextLine();
			
			try {
				company1.displayProjectInvoice(invcNumber);
			} catch (InvalidInvoiceNumberException e) {
				System.out.println(e.getMessage());
			} catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
				System.out.println("do you want to make another transaction? yes/no ");
				answer = input.nextLine();
			
		}
		input.close();
		
		
		
		
		
	}

}
