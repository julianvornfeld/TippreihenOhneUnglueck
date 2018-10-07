import java.util.Random;

public class LottoBase {
	
	public int[] unluckynumbers;
	private int MaxNr;
	public Eingabe eingabe;
	
	public LottoBase(int MaxNr) {
		this.MaxNr = MaxNr;
		eingabe = new Eingabe();
	}

	public int CheckValidity(int number) {
		int returnval = number;
		if (number > this.MaxNr) {
			System.out.println("Fehler! Die eingegebene Zahl darf nicht größer als " + MaxNr + " sein!");
			returnval = 0;
		}
		return returnval;
	}
	
	public void SetUnluckyNumbers() {
		unluckynumbers = new int[3];

        int count = 0;
        do {	
        	int number = CheckValidity(eingabe.GetUnluckyNumber(count + 1)); 
        	boolean notexists = CheckValidity(unluckynumbers, number); 
        	if (number > 0 && notexists==true) {
        		unluckynumbers[count] = number;
                count++;	
        	} else if (number > 0 && notexists==false) {
    			System.out.println("Fehler! Die eingegebene Zahl wurde bereits eingetragen!");
        	}
        	
        } while (count < 3);
	}
	
	private int[] SortNumbers(int[] numbers) {
		int temp;
		for(int i=1; i<numbers.length; i++) {
			for(int j=0; j<numbers.length-i; j++) {
				if(numbers[j]>numbers[j+1]) {
					temp=numbers[j];
					numbers[j]=numbers[j+1];
					numbers[j+1]=temp;
				}
				
			}
		}
		return numbers;
	}
	
	public boolean CheckValidity (int[] numbers, int newnumber) {
		boolean valid = true;

		for(int cntnumbers=0; cntnumbers < numbers.length; cntnumbers++) {
			
        	if (numbers[cntnumbers] == newnumber) {
        		valid = false;
        	}
		}

		for(int cntnumbers=0; cntnumbers < unluckynumbers.length; cntnumbers++) {
			
        	if (unluckynumbers[cntnumbers] == newnumber) {
        		valid = false;
        	}
		}
        
		return valid;
	}
			

	public int[] GetNumbers(int ziehungen) {
		int MinNr = 1;
		int[] numbers = new int[ziehungen];
		
	    Random rand = new Random();

        int count = 0;
        do {
        	int newnumber = rand.nextInt((MaxNr - MinNr) + 1) + MinNr;
        	if (CheckValidity(numbers, newnumber)) {
            	numbers[count] = newnumber;
                count++;	
        	}
        } while (count < numbers.length);
        
        numbers = SortNumbers(numbers);
		return numbers;
	}
}
