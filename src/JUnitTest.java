import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import org.junit.jupiter.api.BeforeEach;

/**
 * This is an JUnit test class to test LottoBase.java
 * 
 * @author Julian Vornfeld
 *
 */
class JUnitTest {
	LottoBase Base;
	
	@BeforeEach
	void setUp() throws Exception {
		int[] UnluckyNumbers = {11,22,33}; 
		
		Logger Log = Logger.getLogger("MyLog");  
		FileHandler File;  

		try {
		    File = new FileHandler("test_logfile.log");  
		    Log.addHandler(File);
	        SimpleFormatter Format = new SimpleFormatter();  
	        File.setFormatter(Format);
	        Log.setUseParentHandlers(false);
		} catch (SecurityException e) {  
			e.printStackTrace();  
		} catch (IOException e) {  
			e.printStackTrace();  
		}  
        
        Base = new LottoBase(42, UnluckyNumbers, Log);
	}

	@org.junit.jupiter.api.Test
	void testCheckValidityInt() {

		//55 is higher than MaxNr 42(defined in setUp()), so the return value must be 0
		assertEquals(Base.CheckValidity(55), 0); 

		//40 is lower than MaxNr 42(defined in setUp()), so the return value must be greater 40
		assertEquals(Base.CheckValidity(40), 40); 
	}

	@org.junit.jupiter.api.Test
	void testCheckValidityIntArrayInt() {

		int[] Numbers = {10, 20, 30};

		//22 was define as UnluckyNumber in setUp(), so the return value must be false
		assertEquals(Base.CheckValidity(Numbers, 22), false); 

		//20 is allready in the array Numbers, so the return value must be false
		assertEquals(Base.CheckValidity(Numbers, 20), false); 

		//15 isn't a unlucky number and it's not the array "Numbers", so the return value must be true
		assertEquals(Base.CheckValidity(Numbers, 15), true); 
	}

	@org.junit.jupiter.api.Test
	void testGetNumbers() {
		
		int[] Numbers = Base.GetNumbers(6);
		
		//The input parameter for GetNumbers was 6 for 6 drawings, so the array length must be 6
		assertEquals(Numbers.length, 6);
	}

}
