import java.util.Scanner;

public class Eingabe {
	public Scanner scanner;
	
	public Eingabe () {
		scanner = new Scanner (System.in);	
	}

	public int GetUnluckyNumber(int number) {

		System.out.print ("Geben Sie die " + number + ". Unglückszahl ein: ");
	    number = scanner.nextInt();	
	    
		return number;
	}
	
	public int GetNumUnluckNumbers() {
		System.out.print ("Geben Sie die Anzahl der Unglückszahlen ein, die Sie eingeben möchten: ");
	    int number = scanner.nextInt();
    	return number;
	}
}
