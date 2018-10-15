import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Test {
	public static LottoBase Base;
	
	public static final void main (String[] argv) throws SecurityException, IOException  {
		int[] UnluckyNumbers = {11,22,33}; 
		
		Logger Log = Logger.getLogger("MyLog");  
		FileHandler File;  

	    File = new FileHandler("test_logfile.log");  
	    Log.addHandler(File);
        SimpleFormatter Format = new SimpleFormatter();  
        File.setFormatter(Format);
        Log.setUseParentHandlers(false);
        
		Base = new LottoBase(42, UnluckyNumbers, Log);

		System.out.println("TestCheckValidityMaxNr(): " + TestCheckValidityMaxNr());
		System.out.println("TestCheckValidityUnluckyNumbers(): " + TestCheckValidityUnluckyNumbers());
		System.out.println("TestCheckValidityExists(): " + TestCheckValidityExists());
	}
	
	public static boolean TestCheckValidityMaxNr() {
		return (Base.CheckValidity(55) == 0);
	}

	public static boolean TestCheckValidityUnluckyNumbers() {
		int[] Numbers = {10, 20, 30};

		return (Base.CheckValidity(Numbers, 22) == false);
	}
	
	public static boolean TestCheckValidityExists() {
		int[] Numbers = {10, 20, 30};

		return (Base.CheckValidity(Numbers, 20) == false);
	}
}
