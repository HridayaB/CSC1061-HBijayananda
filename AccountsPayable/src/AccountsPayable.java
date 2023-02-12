/**
 * 
 * Accounts Payable assignment
 * Accounts Payable driver class
 * Due: 02/06/23
 * @author Hridaya Bijayananda
 *
 */

import java.util.Scanner;

public class AccountsPayable 
{
	static Scanner input;
	/**
	 * this is the main
	 * @param args
	 */
	public static void main ( String [ ] args ) 
	{
		// TODO Auto-generated method stub
		
		input = new Scanner ( System.in );
		
		int employeeNum = 0;
		Employee [ ] payableEmployees = new Employee [ 6 ];
		
		// 1st traversal
		for ( Employee travPayableEmployee : payableEmployees )
		{
			employeeNum++;
			System.out.println ( "Employee " + employeeNum + ": ");
			getEmployeeDetails ( payableEmployees );
		} // end of enhanced for loop
		
		// 2nd traversal
		// for loop for Step 17: 10% increase in case of a Base Plus Commission Employee
		for ( Employee employee : payableEmployees )
		{  
			employeeNum++;
			System.out.println ( "Employee " + employeeNum + ": ");
			Employee bPCEmployee = getEmployeeDetails ( payableEmployees ); 
			if ( bPCEmployee instanceof BasePlusCommissionEmployee ) 
			{				
				  Employee bPCE = ( BasePlusCommissionEmployee ) bPCEmployee;
				  double basePay = ( ( BasePlusCommissionEmployee ) bPCE ).getBasePay ( );
				  ( (BasePlusCommissionEmployee ) bPCE ).setBasePay ( basePay * 1.1 );
				  System.out.println ( "10% increase: \n" + ( (BasePlusCommissionEmployee ) bPCE ).toString ( ) + "\n" );
			} // end of if statement 
		 } // end of enhanced for loop
		
		
		// 3rd traversal
		for ( Employee travPayableEmployee : payableEmployees )
		{
			employeeNum++;
			System.out.println ( "Employee " + employeeNum + ": ");
			getEmployeeDetails ( payableEmployees );
		} // end of enhanced for loop
		input.close ( );
	} // end of main
	
	/**
	 * gets all the details out of employee
	 * @param payableEmployees
	 * @return
	 */
	public static Employee getEmployeeDetails ( Employee [ ] payableEmployees )
	{
		Employee employee = new Employee ( );
		String firstName;
		String lastName;
		String ssNumber;
		int employeeType;
		
		System.out.println ( "What is your first name?" );
		firstName = input.next ( );
		System.out.println ( "What is your last name?" );
		lastName = input.next ( );
		System.out.println ( "What is your social security number?" );
		ssNumber = input.next ( );
		System.out.println ( "What type of employee are you? \n" + "Type '1' if you are a Salaried employee, type '2' if you are a Commission employee, type '3' if you are a Hourly employee, and type '4' if you are a Base plus commission employee" );
		employeeType = input.nextInt ( );
		if ( employeeType == 1 )
		{
			double weeklySalary;
			System.out.print ( "Enter your weekly salary: " );
			weeklySalary = input.nextDouble ( );
			SalariedEmployee sEmployee = new SalariedEmployee ( firstName, lastName, ssNumber, weeklySalary );
			printEmployeeDetails ( sEmployee ); // print with toString method
			//printEmployeeDetails2 ( sEmployee ); // print without toString method
		} // end of if statement
		else if ( employeeType == 2 )
		{
			double grossSales;
			double commissionRate;
			System.out.print ( "Enter your gross sales: " );
			grossSales = input.nextDouble ( );
			System.out.print ( "Enter your commission rate: " );
			commissionRate = input.nextDouble ( );
			CommissionEmployee cEmployee = new CommissionEmployee ( firstName, lastName, ssNumber, grossSales, commissionRate );
			printEmployeeDetails ( cEmployee ); // print with toString method
			//printEmployeeDetails2 ( cEmployee ); // print without toString method
		} // end of else if statement
		else if ( employeeType == 3 )
		{
			double hourlyWage;
			double hours;
			System.out.print ( "Enter your hourly wage: " );
			hourlyWage = input.nextDouble ( );
			System.out.print ( "Enter the number of hours you worked: ");
			hours = input.nextDouble ( );
			HourlyEmployee hEmployee = new HourlyEmployee ( firstName, lastName, ssNumber, hourlyWage, hours );
			printEmployeeDetails ( hEmployee ); // print with toString method
			//printEmployeeDetails2 ( hEmployee ); // print without toString method
		} // end of else if statement
		else if ( employeeType == 4 )
		{
			double basePay;
			double grossSales;
			double commissionRate;
			System.out.print ( "Enter your base pay: ");
			basePay = input.nextDouble ( );
			System.out.print ( "Enter your gross sales: " );
			grossSales = input.nextDouble ( );
			System.out.print ( "Enter your commission rate: " );
			commissionRate = input.nextDouble ( );
			BasePlusCommissionEmployee bPCEmployee = new BasePlusCommissionEmployee ( firstName, lastName, ssNumber, grossSales, commissionRate, basePay );
			printEmployeeDetails ( bPCEmployee ); // print with toString method
			//printEmployeeDetails2 ( bPCEmployee ); // print without toString method
			employee = bPCEmployee;
		} // end of else if statement
		return employee;
	} // end of getEmployeeDetails
	
	/**
	 * Prints out details of the employees based on their type by calling it's toString method
	 * @param employee
	 */
	public static void printEmployeeDetails ( Employee employee )
	{
		System.out.println ( employee.toString ( ) + "\n" );
	} // end of printEmployeeDetails

	/**
	 * Prints out details of the employees based on their type without calling it's toString method
	 * @param employee
	 */
	public static void printEmployeeDetails2 ( Employee employee )
	{
		if ( employee instanceof SalariedEmployee )
		{
			System.out.println ( "Salaried Employee: \n" + "Salaried employee's first name = " + employee.getFirstName ( ) + "\n" + "Salaried employee's last name = " + employee.getLastName ( )
		 	+ "\n" + "Salaried employee's social security number = " + employee.getSocialSecurityNumber ( ) + "\n" + "Salaried employee's weekly salary = $" + ( ( SalariedEmployee ) employee ).getWeeklySalary ( ) + "\n" 
			+ "Salaried employee's payment = $" + employee.getPaymentAmount ( ) + "\n" );
		} // end of if statement
		else if ( employee instanceof CommissionEmployee )
		{
			System.out.println ( "Commission Employee: \n" + "Commission employee's first name = " + employee.getFirstName ( ) + "\n" + "Commission employee's last name = " 
			+ employee.getLastName ( ) + "\n" + "Commission employee's social security number = " + employee.getSocialSecurityNumber ( ) +  "\n" 
			+ "Commission employee's gross sales = $" + ( ( CommissionEmployee ) employee ).getGrossSales ( ) + "\n" + "Commission employee's commission rate = " + ( ( CommissionEmployee ) employee ).getCommissionRate ( ) + "%" + "\n" + "Commission employee's payment = $" + employee.getPaymentAmount ( ) + "\n" );
		} // end of else if statement
		else if ( employee instanceof HourlyEmployee )
		{
			System.out.println ( "Hourly Employee: \n" + "Hourly employee's first name = " + employee.getFirstName ( ) + "\n" + "Hourly employee's last name = " + employee.getLastName ( )
			+ "\n" + "Hourly employee's social security number = " + employee.getSocialSecurityNumber ( ) + "\n" + "Hourly employee's hourly wage = " + ( ( HourlyEmployee ) employee ).getHourlyWage ( ) 
			+ "\n" + "Hourly employee's number of hours worked = " + ( ( HourlyEmployee ) employee ).getHours ( ) + "\n" + "Hourly employee's payment = $" + employee.getPaymentAmount ( ) + "\n" );
		} // end of else if statement
		else if ( employee instanceof BasePlusCommissionEmployee )
		{
			System.out.println ( "BasePlusCommissionEmployee: \n" + "Base plus commission employee's first name = " + employee.getFirstName ( ) + "\n" + "Base plus commission employee's last name = " + employee.getLastName ( )
			+ "\n" + "Base plus commission employee's social security number = " + employee.getSocialSecurityNumber ( ) + "\n" + "Base plus commission employee's base pay = " + ( ( BasePlusCommissionEmployee ) employee ).getBasePay ( )  
			+ "\n" + "Base plus commission employee's gross sales = $" + ( ( CommissionEmployee ) employee ).getGrossSales ( ) + "\n" + "Base plus commission employee's commission rate = " + ( ( CommissionEmployee ) employee ).getCommissionRate ( ) + "%" + "\n" + "Base plus commission employee's payment = $" + employee.getPaymentAmount ( ) + "\n" );
		} // end of else if statement
	} // end of printEmployeeDetails2
	
} // end of driver class AccountsPayable
