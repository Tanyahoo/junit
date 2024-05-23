package ie.atu.dip;

import static java.lang.System.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Scanner;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;


class RunnerTest {


	
	//declare static instances for use throughout tests
	public static InsuranceProgramRefactored ipr;
	public static Scanner input;
    public static int basicInsurance;
    public static int surcharge;
    public static int age;

    
	  // this annotation is called only once before any test method starts in the class
	 	@BeforeAll
	 	public static void setUp() {
	 		ipr = new InsuranceProgramRefactored();	
	 	}
	 	
	 	
	 
	 	
	 	// NOT TESTING AS USES SCANNER UTILITY FOR I/O
	 	// check if correct premium is returned for under 25 years old
	 	@Disabled
	    public void getPremiumUnder25() {
	    	age = input.nextInt();
			int cost;
			if (age >= 17 && age <=24 ){
			cost = ipr.getPremium();
			assertEquals(600, cost);	
			}
		}
	    
	 	
	 	//NOT TESTING AS USES SCANNER UTILITY FOR I/O
	 	// check if correct premium is returned for over 25 years old
	   @Disabled 
	   public void getPremiumOver25() {
		   age = input.nextInt();
		   int cost;
		   if (age >= 25) {
			   cost = ipr.getPremium();
			   assertEquals(500, cost);
		   }
	   }
	
	
	    
	    // Close scanner to prevent leaks after every test
	    @AfterAll
	    public static void closeScanner() {
	            input.close();
	            out.println("Scanner is closed. No leaks here!");
	        }  
	    
	    
}

