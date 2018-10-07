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

}
