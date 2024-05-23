package ie.atu.dip;

import static java.lang.System.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


class InsuranceProgramRefactoredTest {
	
	//declare static instances for use throughout tests
	public static InsuranceProgramRefactored ipr;
	public static Scanner input;
    public static int basicInsurance;
    public static int surcharge;
    public static int age;
    //public static int premium;
    
    
     
    // this annotation is called only once before any test method starts in the class
    //instantiate instance of class once at the beginning
 	@BeforeAll
 	public static void setUp() {
 		ipr = new InsuranceProgramRefactored();	
 	}
    
    
    
    // we want common objects freshly initialised after each test
	@BeforeEach
    public void refresh() {
    	ipr = new InsuranceProgramRefactored();
    	input = new Scanner(System.in);
    }
    
	
	
	// reset the values of these variables after each method call
	@AfterEach
	public void reSet() {
		 basicInsurance = 500;
	        surcharge = 100;
	}

	
    
    // Closes scanner to prevent leaks at the end of all tests
    @AfterAll
    public static void closeScanner() {
            input.close();
            out.println("Scanner is closed. No leaks here!");
        }
   

    
    // Check if correct premium is returned for under 25 years old
    @Test
    public void getPremiumUnder25() {
		int cost;
		if (age >= 17 && age <=24 ){
		cost = ipr.getPremium();
		assertEquals(600, cost);	
		}
	}
    
    
    
   // Check if correct premium is returned for over 25 years old
   @Test
   public void getPremiumOver25() {
	   int cost;
	   if (age >= 25) {
		   cost = ipr.getPremium();
		   assertEquals(500, cost);
	   }
   }
    
    
   
    // Checks values of instance variables using assetEquals
	@Test
	public void insuranceSurcharge(){
		int actualBasic = ipr.getBasicInsurance();
		int actualSurcharge = ipr.getSurcharge();
		assertEquals(500, actualBasic);
		assertEquals(100, actualSurcharge);	
		}
	
	
	
	// Checks results of each switch statement case for over 25 years using assertEquals method 
	// set test to complete within 1000 milliseconds
	@Test 
	@Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
	public void checkSurchargeAccidentsOver25() throws Exception{
		assertEquals(500, ipr.accidentSurchargeCalculator(0));
		assertEquals(550, ipr.accidentSurchargeCalculator(1));
		assertEquals(625, ipr.accidentSurchargeCalculator(2));
		assertEquals(725, ipr.accidentSurchargeCalculator(3));
		assertEquals(875, ipr.accidentSurchargeCalculator(4));
		assertEquals(1075,ipr.accidentSurchargeCalculator(5));
		assertEquals(0,   ipr.accidentSurchargeCalculator(6)); // no insurance offered
	}
	
	
	
	// Checks each case of switch statement for under 25 to be true using assertTrue method, takes boolean
	//  adds the surcharge to estimated premium
	@Test 
	public void checkSurchargeAccidentsUnder25() throws Exception{
		int surcharge = ipr.getSurcharge();
		assertTrue(surcharge + ipr.accidentSurchargeCalculator(0)== 600);
		assertTrue(surcharge + ipr.accidentSurchargeCalculator(1)== 650);
		assertTrue(surcharge + ipr.accidentSurchargeCalculator(2)== 725);
		assertTrue(surcharge + ipr.accidentSurchargeCalculator(3)== 825);
		assertTrue(surcharge + ipr.accidentSurchargeCalculator(4)== 975);
		assertTrue(surcharge + ipr.accidentSurchargeCalculator(5)== 1175);
		assertTrue(ipr.accidentSurchargeCalculator(6)== 0); // no insurance offered
	}
	

	
	// Takes 'String, Value' parameters
    @ParameterizedTest
    @CsvSource({"basicInsurance, 500", "surcharge, 100"})
    void testWithStringParameter(String word, int value) {
    	  if (word.equals("basicInsurance")) {
              assertEquals(500, value);
          } else if (word.equals("surcharge")) {
              assertEquals(100, value);
          }
    }	
    
    
    
    
    @Test
    public void testInvalidBasicInsurance() {
        // Testing whether basic insurance is an illegal argument
       assertThrows(ArithmeticException.class, () -> { // lambda expression
    	  basicInsurance = 1/0; // cannot be divided by zero
        });
    }
    
    
   
    
    // Testing when an invalid number of accidents is entered (outside range 0-6)
    @Test
    public void testInvalidNumberOfAccidents() {
        // Testing when an invalid number of accidents is entered (outside range 0-6)
       assertThrows(IllegalArgumentException.class, () -> { // lambda expression
            ipr.accidentSurchargeCalculator(7); // Trying with 7 accidents
        });
       
    }
}  

	
	

