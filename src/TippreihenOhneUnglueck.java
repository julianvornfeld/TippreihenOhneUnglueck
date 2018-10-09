import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TippreihenOhneUnglueck {
	public static LottoBase spiel;
	public static int[] UnluckyNumbers; //Muss noch geladen und gespeichert werden
    public static void main(String[] args) throws IOException{
    	String typ = "lotto";

    	UserInterface Interface = new UserInterface();
    			
    	if (args.length > 0) {
    		typ = args[0];
    	}
    	
    	UnluckyNumbers = ReadFile();
    	if (UnluckyNumbers == null) {
    		UnluckyNumbers = Interface.SetUnluckyNumbers();	
    		WriteFile(UnluckyNumbers);
    	}
    	
    	if (typ.equalsIgnoreCase("help")) {
    		Interface.Help();
    	} else if (typ.equalsIgnoreCase("eurojackpot")) {
        	System.out.println("Willkommen bei Eurojackpot Generator!");
    		Eurojackpot Euro = new Eurojackpot(UnluckyNumbers);
    		System.out.println(Euro.GetZahlenreihe());
    		spiel = Euro;
        } else if (typ.equalsIgnoreCase("lotto")) {
        	System.out.println("Willkommen bei Lotto Generator!");
    		Lotto Lotto = new Lotto(UnluckyNumbers);
    		System.out.println(Lotto.GetZahlenreihe());
    		spiel = Lotto;
        } else if (typ.equalsIgnoreCase("unglueckszahlen")) {
        	if (args.length == 1) {
        		Interface.HelpUnluckyNumbers();
        	} else {
            	String input = args[1];
            	if (input.equalsIgnoreCase("ausgabe")) {
                    System.out.println(GetUnluckyNumbers());
            	} else if (input.equalsIgnoreCase("eingabe")) {
            		UnluckyNumbers = Interface.SetUnluckyNumbers();	
            		WriteFile(UnluckyNumbers);
            	}	
        	}
        } else {
    		Interface.Help();
        }
    } 
    
    public static String GetUnluckyNumbers() {
    	String Output = "Unglückszahlen: ";
        for (int count = 0; count < UnluckyNumbers.length; count++) {
	        if (count > 0) {
	        	Output = Output + " ";
	        }
	        int item = UnluckyNumbers[count];
	        Output = Output + item;
	    }
        return Output;
    }
    
    public static int[] ReadFile () throws IOException {
        FileReader InputFile = new FileReader("UnluckyNumbers.txt");
        BufferedReader InputFileBuffer = new BufferedReader(InputFile);

        String UnluckyNumbersString = InputFileBuffer.readLine();
        
        String[] temp = UnluckyNumbersString.split(";");
        int[] UnluckyNumbers = new int[temp.length];
        
		for(int cntnumbers=0; cntnumbers < temp.length; cntnumbers++) {
			UnluckyNumbers[cntnumbers] = Integer.parseInt(temp[cntnumbers]);
		}
        InputFileBuffer.close();
        return UnluckyNumbers;
    }
    
    public static void WriteFile(int[] UnluckyNumbers) throws IOException {
        FileWriter InputFile = new FileWriter("UnluckyNumbers.txt");
        BufferedWriter OutputFileBuffer = new BufferedWriter(InputFile);
	    String Output = "";
        for (int count = 0; count < UnluckyNumbers.length; count++) {
	        if (count > 0) {
	        	Output = Output + ";";
	        }
	        int item = UnluckyNumbers[count];
	        Output = Output + item;
	    }
	    
        OutputFileBuffer.write(Output); 
        OutputFileBuffer.close();
    }
}
