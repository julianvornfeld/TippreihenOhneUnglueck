import java.util.Scanner;

public class Eingabe {
	public Scanner scanner;
	
	public Eingabe () {
		scanner = new Scanner (System.in);	
	}

	public int GetUnluckyNumber(int number) {

		System.out.print ("Geben Sie die " + number + ". Ungl�ckszahl ein: ");
	    number = scanner.nextInt();	
	    
		return number;
	}
	
	public int GetNumUnluckNumbers() {
		System.out.print ("Geben Sie die Anzahl der Ungl�ckszahlen ein, die Sie eingeben m�chten: ");
	    int number = scanner.nextInt();
    	return number;
	}
}
