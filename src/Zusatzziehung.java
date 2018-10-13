/**
 * This class inherits the class "LottoBase" and implements the interface "ILottoBase".
 * Zusatzziehung outputs a String of additional winning numbers.
 * The Zusatzziehung class has 2 winning numbers from 1 to 10.
 * 
 * @author Julian Vornfeld
 *
 */
public class Zusatzziehung extends LottoBase implements ILottoBase {

	public Zusatzziehung(int[] UnluckyNumbers) {
		super(10, UnluckyNumbers);

	}
	
	/**
	 * This method creates a String with a list winning numbers. 
	 * 
	 * @return A String with a list of additional winning numbers (2 of 10)
	 */
	public String GetNumbersString() {
		String ReturnVal = "Gewinnzahlen: ";
		
		int[] WinningNumbers = GetNumbers(2);

		ReturnVal += "Eurozahlen: ";
		for(int CntNumbers=0; CntNumbers < WinningNumbers.length; CntNumbers++) {
			ReturnVal += WinningNumbers[CntNumbers] + " ";
		}
		
		return ReturnVal;
	}

}
