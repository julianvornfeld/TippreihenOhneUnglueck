import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TippreihenOhneUnglueck {
	public static int[] UnluckyNumbers; 
	
    public static void main(String[] args) throws IOException{
    	String Type = "lotto";

    	UserInterface Interface = new UserInterface();
    			
    	if (args.length > 0) {
    		Type = args[0];
    	}
    	
    	UnluckyNumbers = ReadFile();
    	if (UnluckyNumbers == null) {
    		UnluckyNumbers = Interface.SetUnluckyNumbers();	
    		WriteFile(UnluckyNumbers);
    	}
    	
    	if (Type.equalsIgnoreCase("help")) {
    		Interface.Help();
    	} else if (Type.equalsIgnoreCase("eurojackpot")) {
        	System.out.println("Willkommen bei Eurojackpot Generator!");
    		Eurojackpot Euro = new Eurojackpot(UnluckyNumbers);
    		System.out.println(Euro.GetNumbersString());
        } else if (Type.equalsIgnoreCase("lotto")) {
        	System.out.println("Willkommen bei Lotto Generator!");
    		Lotto Lotto = new Lotto(UnluckyNumbers);
    		System.out.println(Lotto.GetNumbersString());
        } else if (Type.equalsIgnoreCase("unglueckszahlen")) {
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
        for (int Count = 0; Count < UnluckyNumbers.length; Count++) {
	        if (Count > 0) {
	        	Output = Output + " ";
	        }
	        int item = UnluckyNumbers[Count];
	        Output = Output + item;
	    }
        return Output;
    }
    
    public static int[] ReadFile () throws IOException {
        FileReader InputFile = new FileReader("UnluckyNumbers.txt");
        BufferedReader InputFileBuffer = new BufferedReader(InputFile);

        String UnluckyNumbersString = InputFileBuffer.readLine();
        
        String[] Temp = UnluckyNumbersString.split(";");
        int[] UnluckyNumbers = new int[Temp.length];
        
		for(int CntNumbers=0; CntNumbers < Temp.length; CntNumbers++) {
			UnluckyNumbers[CntNumbers] = Integer.parseInt(Temp[CntNumbers]);
		}
        InputFileBuffer.close();
        return UnluckyNumbers;
    }
    
    public static void WriteFile(int[] UnluckyNumbers) throws IOException {
        FileWriter InputFile = new FileWriter("UnluckyNumbers.txt");
        BufferedWriter OutputFileBuffer = new BufferedWriter(InputFile);
	    String Output = "";
        for (int Count = 0; Count < UnluckyNumbers.length; Count++) {
	        if (Count > 0) {
	        	Output = Output + ";";
	        }
	        int Item = UnluckyNumbers[Count];
	        Output = Output + Item;
	    }
	    
        OutputFileBuffer.write(Output); 
        OutputFileBuffer.close();
    }
}
