import java.util.Random;

public class LottoBase {
	
	public int[] UnluckyNumbers;
	private int MaxNr;
	public UserInterface eingabe;
	
	public LottoBase(int MaxNr, int[] UnluckyNumbers) {
		this.MaxNr = MaxNr;
		this.UnluckyNumbers = UnluckyNumbers.clone();
		
		for(int count=0; count<this.UnluckyNumbers.length; count++) {
			this.UnluckyNumbers[count] = CheckValidity(this.UnluckyNumbers[count]);
		}

		eingabe = new UserInterface();
	}

	public int CheckValidity(int number) {
		int returnval = number;
		if (number > this.MaxNr) {
			System.out.println("Warnung! Die Unglückszahl '" + number + "'darf nicht größer als " + MaxNr + " sein und wird Ignoriert");
			returnval = 0;
		}
		return returnval;
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

		for(int cntnumbers=0; cntnumbers < UnluckyNumbers.length; cntnumbers++) {
			
        	if (UnluckyNumbers[cntnumbers] == newnumber) {
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
