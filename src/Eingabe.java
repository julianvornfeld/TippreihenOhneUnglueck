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

}
