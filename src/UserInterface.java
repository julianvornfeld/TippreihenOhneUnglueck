import java.util.Scanner;
/**
 * This class is for Userinput at the command line or to put out messages to the user.
 *  
 * @author Julian Vornfeld
 *
 */
public class UserInterface {
	public Scanner Scanner;

	public UserInterface () {
		Scanner = new Scanner (System.in);	
	}

	/**
	 * This method checks if the input number (NewNumber) is already in the input array (Numbers).
	 * If that's the case, "False" is the output.
	 * 
	 * @param A number (NewNumber) which should be checked and an array to check with. 
	 * @return Returns "false" if the numbers is in the input array 
	 */
	public boolean CheckValidity (int[] Numbers, int NewNumber) {

		for(int CntNumbers=0; CntNumbers < Numbers.length; CntNumbers++) {

			if (Numbers[CntNumbers] == NewNumber) {
				return false;
			}
		}
		return true;
	}

	/**
	 * This method is intended for user input of all unlucky numbers.
	 * The userinput stops only, when the user types a 'n' instead of the number.
	 *  
	 * @return Returns an array with variable length and unlucky numbers
	 */
	public int[] SetUnluckyNumbers() {
		int[] Temp = new int[50];
		boolean Cancel = false;
		int InvalidNumber = 3;

		int Count = 0;
		do {	
			int Number = GetUnluckyNumber(Count + 1); 

			boolean NotExists = CheckValidity(Temp, Number); 
			if (Number > 0 && NotExists==true) {
				InvalidNumber = 3;
				Temp[Count] = Number;
				Count++;	
			} else if (Number > 0 && NotExists==false) {
				System.out.println("Fehler! Die eingegebene Zahl wurde bereits eingetragen!");
			} else if (Number == 0) {
				Cancel = true;
			} else if (Number == -1) {
				InvalidNumber -= 1;
			}

		} while (Cancel == false && InvalidNumber > 0);

		int[] UnluckyNumbers = new int[Count];
		for(int CntNumbers=0; CntNumbers < Count; CntNumbers++) {
			UnluckyNumbers[CntNumbers] = Temp[CntNumbers];
		}

		return UnluckyNumbers;
	}

	/**
	 * This method is intended for user input of unlucky numbers and will be called by SetUnluckyNumbers().
	 * if the user types a 'n' instead of a number, the ouput will be a zero instead of the userinput.
	 * 
	 * @param The number of unlucky numbers already entered by the user
	 * @return Returns the userinput or a zero, if the user what's to stop
	 */
	public int GetUnluckyNumber(int Number) {
		System.out.print ("Geben Sie die " + Number + ". Unglückszahl ein oder tippen Sie 'n' zum Abbrechen: ");
		String ReturnVal = Scanner.next(); 
		if (ReturnVal.equalsIgnoreCase("n")) {
			Number = 0;
		} else {
			try {
				Number = Integer.parseInt(ReturnVal);	
			} 
			catch( Exception exception) {
				System.out.println("Bitte geben Sie eine gültige Zahl ein!");
				Number = -1; 
			}
		}
		return Number;
	}

	/**
	 * Sends a help message to the user, for more information about the program
	 */
	public void Help() {
		System.out.println("Der Aufruf muss wie folgt aussehen:\n"
				+ "\n"
				+ "java TippreihenOhneUnglueck [eurojackpot | lotto | unglueckszahlen [ ausgabe | eingabe ]]\n"
				+ "\n"
				+ "'eurojackpot'             für den Eurojackpot Generator \n" 
				+ "'lotto'                   für den Lotto Generator\n" 
				+ "'unglueckszahlen ausgabe' gibt die Unglückszahlen aus\n"
				+ "'unglueckszahlen eingabe' startet die Eingabe neuer Unglückszahlen" );
	}

	/**
	 * Sends a help message to the user, for more information about the unlucky numbers
	 */
	public void HelpUnluckyNumbers() {
		System.out.println("Der Aufruf muss wie folgt aussehen:\n"
				+ "\n"
				+ "java TippreihenOhneUnglueck unglueckszahlen [ ausgabe | eingabe ]\n"
				+ "\n"
				+ "'ausgabe' gibt die Unglückszahlen aus\n"
				+ "'eingabe' startet die Eingabe neuer Unglückszahlen");
	}
}
