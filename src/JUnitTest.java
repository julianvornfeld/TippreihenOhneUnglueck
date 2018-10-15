import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

class JUnitTest {
	LottoBase GetLottoBase() {
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
        
        LottoBase Base = new LottoBase(42, UnluckyNumbers, Log);
		return Base;
	}
	@org.junit.jupiter.api.Test
	void testCheckValidityInt() {
		LottoBase Base = GetLottoBase();

		//55 is higher than MaxNr 42(defined in GetLottoBase()), so the returnvalue must be 0
		assertEquals(Base.CheckValidity(55), 0); 

		//40 is lower than MaxNr 42(defined in GetLottoBase()), so the returnvalue must be greater 40
		assertEquals(Base.CheckValidity(40), 40); 
	}

	@org.junit.jupiter.api.Test
	void testCheckValidityIntArrayInt() {
		LottoBase Base = GetLottoBase();
		int[] Numbers = {10, 20, 30};

		//22 was define as UnluckyNumber in GetLottoBase(), so the returnvalue must be false
		assertEquals(Base.CheckValidity(Numbers, 22), false); 

		//20 is allready in the array Numbers, so the returnvalue must be false
		assertEquals(Base.CheckValidity(Numbers, 20), false); 

		//15 isn't a unlucky number and it's not the array "Numbers", so the returnvalue must be true
		assertEquals(Base.CheckValidity(Numbers, 15), true); 
	}

}
