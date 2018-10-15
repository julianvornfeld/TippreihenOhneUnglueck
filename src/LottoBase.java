import java.util.Random;
import java.util.logging.Logger;
/**
 * The class LottoBase is to generate numbers from 1 to a given number.
 * This class is inherited in the classes "Eurojackpot" and "Lotto".
 * 
 * @author Julian Vornfeld
 *
 */
public class LottoBase {
	/**
	 * An int array with variable length.
	 * In that array are all unlucky numbers, who shout be ignored in GetNumbers().
	 */
	public int[] UnluckyNumbers;
	
	/**
	 * An int variable with the maximum of numbers in the output array in GetNumbers() and the UnluckyNumbers array.
	 */
	private int MaxNr;

	public Logger Log;
	
	public LottoBase(int MaxNr, int[] UnluckyNumbers, Logger Log) {
		this.MaxNr = MaxNr;
		this.UnluckyNumbers = UnluckyNumbers.clone();
		this.Log = Log;
		
		String InvalidNumbers = "";
		
		for(int Count=0; Count<this.UnluckyNumbers.length; Count++) {
			int Number = CheckValidity(this.UnluckyNumbers[Count]);
			if (Number == 0) {
				InvalidNumbers += this.UnluckyNumbers[Count] + " ";
			}
			this.UnluckyNumbers[Count] = Number;
		}
		if (InvalidNumbers.equals("") == false) {
			System.out.println("Warnung! Die Unglückszahl/en " + InvalidNumbers.trim() + " dürfen nicht größer als " + MaxNr + " sein und werden Ignoriert");
		}

	}

	/**
	 * This method checks if the number in the parameter is higher then the variable MaxNr (specified in the constructor).
	 * 
	 * @param A number of the UnluckyNumbers array. 
	 * @return Returns zero, if the given number is higher than MaxNr (specified in the constructor).
	 * @return Otherwise the given number will be exported 
	 */
	public int CheckValidity(int Number) {
		int ReturnVal = Number;
		if (Number > this.MaxNr) {
		    Log.warning("Die Unglückszahl '" + Number + "'darf nicht größer als " + MaxNr + " sein und wird Ignoriert"); 
			ReturnVal = 0;
		}
		return ReturnVal;
	}
	
	/**
	 * This method sorts the numbers in the input array (Numbers).
	 * The sort direction is from low to high. 
	 * 
	 * @param This is an array, with an variable length.
	 * @return The input array will be sorted exported.
	 */
	private int[] SortNumbers(int[] Numbers) {
		int Temp;
		for(int i=1; i<Numbers.length; i++) {
			for(int j=0; j<Numbers.length-i; j++) {
				if(Numbers[j]>Numbers[j+1]) {
					Temp=Numbers[j];
					Numbers[j]=Numbers[j+1];
					Numbers[j+1]=Temp;
				}
				
			}
		}
	    Log.info("Die Glückszahlen wurde aufsteigend sortiert"); 
		return Numbers;
	}
	
	/**
	 * This method checks:
	 * 1. Is the input number (NewNumber) already in the input array (Numbers).
	 * 2. Is the input number (NewNumber) a number of the UnluckyNumbers array.
	 * If that's the case, "False" is the output.
	 * 
	 * @param A number (NewNumber) which should be checked and an array to check with. 
	 * @return Returns "false" if the numbers is in the input or the UnluckyNumbers array 
	 */
	public boolean CheckValidity (int[] Numbers, int NewNumber) {

		for(int CntNumbers=0; CntNumbers < Numbers.length; CntNumbers++) {
			
        	if (Numbers[CntNumbers] == NewNumber) {
        		Log.info("Die generierte Zahl ist bereits in der Liste vorhanden"); 
        		return false;
        	}
		}

		for(int CntNumbers=0; CntNumbers < UnluckyNumbers.length; CntNumbers++) {
			
        	if (UnluckyNumbers[CntNumbers] == NewNumber) {
        		Log.info("Die generierte Zahl ist eine Unglückszahl"); 
        		return false;
        	}
		}

		return true;
	}
			
	/**
	 * This method outputs an int array with a given number of random numbers.
	 * The number of random numbers, is specified in the input parameter "Drawings".
	 * The Range is 1 to MaxNr (specified in the constructor). 
	 * 
	 * @param The number of random numbers in the array.
	 * @return Returns an int array with a given number of random numbers.
	 */
	public int[] GetNumbers(int Drawings) {
		int MinNr = 1;
		int[] Numbers = new int[Drawings];

	    Log.info("Die Generierung " + Drawings  + " Glückszahlen " + MinNr + " bis " + MaxNr + " wurde gestartet"); 
	    
	    Random Rand = new Random();

        int Count = 0;
        do {
        	int NewNumber = Rand.nextInt((MaxNr - MinNr) + 1) + MinNr;
        	if (CheckValidity(Numbers, NewNumber)) {
            	Numbers[Count] = NewNumber;
                Count++;	
        	}
        } while (Count < Numbers.length);
        
        Numbers = SortNumbers(Numbers);
		return Numbers;
	}
}
