package ie.atu.dip;

import static java.lang.System.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class InsuranceProgramRefactored {

	// declare class instance variables
	private Scanner input;
	private int basicInsurance;
	private int surcharge;
	private int age;
	private int accidents;
	protected int premium;
	
	

	// getter for basicInsurance, package scope
	protected int getBasicInsurance() {
		return basicInsurance;
	}

	
	// getter for Surcharge, package scope
	protected int getSurcharge() {
		return surcharge;
	}

	
	// getter for Premium
	protected int getPremium() {
		return premium;
	}
	
	
	// instantiate variables inside constructor
	public InsuranceProgramRefactored() {
		input = new Scanner(System.in);
		basicInsurance = 500;
		surcharge = 100; // under 25 years
	}

	
	
	// method takes user input for 'age', delegates input to methods via 'if statement'
	public void checkAge(int age) throws Exception {
		try {
			if (age >= 25) {// if greater than 25, then calculator method is called
				getAccidentNum();// get user input re: accident number
				accidentSurchargeCalculator(accidents);
			} else if (age <= 24 && age >= 17) {// if less than 25 then..
				basicInsurance = getBasicInsurance() + getSurcharge();// ...basic insurance is increased by 100
				getAccidentNum();
				accidentSurchargeCalculator(accidents);// then calls method to calculate insurance
			} else {
				out.println("We are sorry. No insurance can be offered for your age.");
			}
		} catch (InputMismatchException e) {
			throw new InputMismatchException("Invalid input entered");
		}
	}

	
	// method to get user input for 'age', flow of control then goes to checkAge() method
	public void getAge() throws Exception {
		out.print("Please enter your age: ");
		age = input.nextInt();
		checkAge(age);
	}
		
	
	
	// method to get user's number of accidents
	protected void getAccidentNum() {
		out.print("\nHow many accidents did you have? ");
		accidents = input.nextInt();// assign user input to variable 'accidents'
	}

	
	
	// this method calculates insurance based on # of accidents, returns 'premium'
	public int accidentSurchargeCalculator(int accidents) throws Exception {
		this.accidents = accidents;
		// new switch statement, no keyword 'break' needed, more efficient, easy read
		try {
			switch (accidents) {
		
			case 0 -> {
			premium = getBasicInsurance(); // if zero accidents, basic insurance applies
			out.println("No surcharge");
			out.println("Total amount to pay: " + getBasicInsurance());
			return premium;
		}
			case 1 -> {// prints message of surcharge, basic insurance, total cost
			premium = (getBasicInsurance() + 50); // 1 accident, increase by 50
			out.println("Additional surcharge for accident: " + 50 + " \nTotal amount to pay: "
					+ (getBasicInsurance() + 50));
			return premium;
		}
			case 2 -> {
			premium = (getBasicInsurance() + 125);// 2 accidents, increase by 125
			out.println("Additional surcharge for accident: " + 125 + " \nTotal amount to pay: "
					+ (getBasicInsurance() + 125));
			return premium;
		}
			case 3 -> {
			premium = (getBasicInsurance() + 225);// 3 accidents, increase by 225
			out.println("Additional surcharge for accident: " + 225 + " \nTotal amount to pay: "
					+ (getBasicInsurance() + 225));
			return premium;
		}
			case 4 -> {
			premium = (getBasicInsurance() + 375);// 4 accidents, increase by 375
			out.println("Additional surcharge for accident: " + 375 + " \nTotal amount to pay: "
					+ (getBasicInsurance() + 375));
			return premium;
		}
			case 5 -> {
			premium = (getBasicInsurance() + 575);// 5 accidents, increase by 575
			out.println("Additional surcharge for accident: " + 575 + " \nTotal amount to pay: "
					+ (getBasicInsurance() + 575));
			return premium;
		}
			case 6 -> {
			out.println("Apologies. No insurance can be offered.");
			return 0; // zero returned, no charge, no insurance offered for 6+ accidents
		}
			// default message prints if range outside (0 - 6) is entered by user
			   default -> {
		            throw new IllegalArgumentException("Invalid number of accidents. Must be between 0 and 6.");
			   }
			  }  
			}catch (InputMismatchException e) {
		        throw new IllegalArgumentException("Invalid input. Please enter a valid integer.");
		    }
		}
    
}


