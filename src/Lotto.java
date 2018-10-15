import java.util.logging.Logger;

/**
 * This class inherits the class "LottoBase" and implements the interface "ILottoBase".
 * Lotto outputs a String of winning numbers.
 * The Lotto class has 6 winning numbers from 1 to 49.
 * 
 * @author Julian Vornfeld
 *
 */
public class Lotto extends LottoBase implements ILottoBase {
	
	public Lotto(int[] UnluckyNumbers, Logger Log) {
		super(49, UnluckyNumbers, Log);
	    Log.info("Der User hat den Lotto Generator gestartet"); 
	}

	/**
	 * This method creates a String with a list winning numbers. 
	 * 
	 * @return A String with a list of additional winning numbers (6 of 49)
	 */
	public String GetNumbersString() {
		String ReturnVal = "Gewinnzahlen: ";
		int[] WinningNumbers = GetNumbers(6);
		
		for(int CntNumbers=0; CntNumbers < WinningNumbers.length; CntNumbers++) {
			ReturnVal += WinningNumbers[CntNumbers] + " ";
		}

	    Log.info("Es wurden folgende Zahlen gezogen: " + ReturnVal);
		return ReturnVal;
	}

}
