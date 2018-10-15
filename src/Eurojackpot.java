import java.util.logging.Logger;

/**
 * This class inherits the class "LottoBase" and implements the interface "ILottoBase".
 * Eurojackpot outputs a String of winning numbers.
 * The Eurojackpot has 5 winning numbers from 1 to 50.
 * 
 * @author Julian Vornfeld
 *
 */
public class Eurojackpot extends LottoBase implements ILottoBase {
	private Zusatzziehung Zusatz;

	public Eurojackpot(int[] UnluckyNumbers, Logger Log) {
		super(50, UnluckyNumbers, Log);
		Log.info("Der User hat den Eurojackpot Generator gestartet");

		Zusatz = new Zusatzziehung(UnluckyNumbers, Log);
	}

	/**
	 * This method creates a String with a list winning numbers and additional winning numbers from the class "Zusatzziehung". 
	 * 
	 * @return A String with winning numbers (5 of 50) and additional winning numbers (2 of 10).
	 */
	public String GetNumbersString() {
		String ReturnVal = "Gewinnzahlen: ";
		int[] WinningNumbers = GetNumbers(5);

		for(int CntNumbers=0; CntNumbers < WinningNumbers.length; CntNumbers++) {
			ReturnVal += WinningNumbers[CntNumbers] + " ";
		}
		ReturnVal += "\n" + Zusatz.GetNumbersString();


		Log.info("Es wurden folgende Zahlen gezogen: " + ReturnVal);
		return ReturnVal;
	}
}
