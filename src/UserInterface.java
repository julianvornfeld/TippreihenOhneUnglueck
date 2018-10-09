import java.util.Scanner;

public class UserInterface {
	public Scanner scanner;
	
	public UserInterface () {
		scanner = new Scanner (System.in);	
	}

	public int GetUnluckyNumber(int number) {
		System.out.print ("Geben Sie die " + number + ". Ungl�ckszahl ein oder tippen Sie 'n' zum Abbrechen: ");
		String ReturnVal = scanner.next(); 
		if (ReturnVal.equalsIgnoreCase("n")) {
			number = 0;
		} else {
			number = Integer.parseInt(ReturnVal);
		}
		return number;
	}
	
	public boolean CheckValidity (int[] numbers, int newnumber) {
		boolean valid = true;

		for(int cntnumbers=0; cntnumbers < numbers.length; cntnumbers++) {
			
        	if (numbers[cntnumbers] == newnumber) {
        		valid = false;
        	}
		}
		return valid;
	}
	
	public int[] SetUnluckyNumbers() {
		//int numunluckynumbers = GetNumUnluckNumbers();
		int[] temp = new int[50];
		boolean cancel = false;
		
        int count = 0;
        do {	
        	int number = GetUnluckyNumber(count + 1); 
        	boolean notexists = CheckValidity(temp, number); 
        	if (number > 0 && notexists==true) {
        		temp[count] = number;
                count++;	
        	} else if (number > 0 && notexists==false) {
    			System.out.println("Fehler! Die eingegebene Zahl wurde bereits eingetragen!");
        	} else if (number == 0) {
        		cancel = true;
        	}
        	
        } while (cancel == false);
        
        int[] UnluckyNumbers = new int[count];
		for(int cntnumbers=0; cntnumbers < count; cntnumbers++) {
			UnluckyNumbers[cntnumbers] = temp[cntnumbers];
		}
        
        return UnluckyNumbers;
	}
	
	public void Help() {
		System.out.println("Der Aufruf muss wie folgt aussehen:\n"
							+ "\n"
						    + "java TippreihenOhneUnglueck [eurojackpot | lotto | unglueckszahlen [ ausgabe | eingabe ]]\n"
					    	+ "\n"
		    				+ "'eurojackpot'             f�r den Eurojackpot Generator \n" 
		    				+ "'lotto'                   f�r den Lotto Generator\n" 
	        				+ "'unglueckszahlen ausgabe' gibt die Ungl�ckszahlen aus\n"
	        				+ "'unglueckszahlen eingabe' startet die Eingabe neuer Ungl�ckszahlen" );
	}
	public void HelpUnluckyNumbers() {
		System.out.println("Der Aufruf muss wie folgt aussehen:\n"
				+ "\n"
				+ "java TippreihenOhneUnglueck unglueckszahlen [ ausgabe | eingabe ]\n"
				+ "\n"
				+ "'ausgabe' gibt die Ungl�ckszahlen aus\n"
				+ "'eingabe' startet die Eingabe neuer Ungl�ckszahlen");
	}
}
