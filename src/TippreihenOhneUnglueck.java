import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
/**
 * This is the class, which will be called by the user from the commandline
 * 
 * @author Julian Vornfeld
 *
 */
public class TippreihenOhneUnglueck {
	public static int[] UnluckyNumbers; 
	
	/**
	 * This is the main method and can called by the user with parameters.
	 * If the user defines no parameter, the Lotto generator will start. 
	 * These are the Parameters:
	 * 
	 * "eurojackpot" starts the generator for the Eurojackpot and additional numbers.
	 * "lotto" starts the Lotto generator.
	 * "unglueckszahlen ausgabe" outputs the unlucky numbers to the console.
	 * "unglueckszahlen eingabe" starts the input of new unlucky numbers.
	 * "hilfe" outputs the help to the console
	 * 
	 */
    public static void main(String[] args) throws IOException{
    	String Type = "lotto";

    	UserInterface Interface = new UserInterface();
    			
    	if (args.length > 0) {
    		Type = args[0];
    	}
    	
    	UnluckyNumbers = ReadFile();
    	
    	if (Type.equalsIgnoreCase("hilfe")) {
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
            		if (UnluckyNumbers.length > 0) {
                		WriteFile(UnluckyNumbers);	
            		}
            	} else {
            		Interface.HelpUnluckyNumbers();
            	}
        	}
        } else {
    		Interface.Help();
        }
    } 
    
    /**
     * This method put a String with the unlucky numbers out
     * 
     * @return A String (Output) with the unlucky numbers.
     */
    public static String GetUnluckyNumbers() {
    	String Output = "";
    	if (UnluckyNumbers == null) {
    		Output = "Es wurden noch keine Unglückszahlen eingegeben!";
    	} else {
    		Output = "Unglückszahlen: ";
            for (int Count = 0; Count < UnluckyNumbers.length; Count++) {
    	        if (Count > 0) {
    	        	Output = Output + " ";
    	        }
    	        int item = UnluckyNumbers[Count];
    	        Output = Output + item;
    	    }
    	}
        return Output;
    }
    
    /**
     * This method reads the file "UnluckyNumbers.txt" and imports the value to the array UnluckyNumbers.
     * The value of the file is a list of numbers separated by ";".
     * 
     * @return Returns the value of the file in an array "UnluckyNumbers" 
     */
    public static int[] ReadFile () throws IOException {
    	File File = new File("UnluckyNumbers.txt");

        int[] UnluckyNumbers = null;
        
    	if (File.exists()) {
	        FileReader InputFile = new FileReader("UnluckyNumbers.txt");
	        BufferedReader InputFileBuffer = new BufferedReader(InputFile);
	
	        String UnluckyNumbersString = InputFileBuffer.readLine();
	        
	        String[] Temp = UnluckyNumbersString.split(";");
	        UnluckyNumbers = new int[Temp.length];
	        
			for(int CntNumbers=0; CntNumbers < Temp.length; CntNumbers++) {
				UnluckyNumbers[CntNumbers] = Integer.parseInt(Temp[CntNumbers]);
			}
	        InputFileBuffer.close();
    	} 
        return UnluckyNumbers;
    }

    /**
     * This method write the value of the input array UnluckyNumbers to the file "UnluckyNumbers.txt" .
     * The value of the file is a list of numbers separated by ";".
     * 
     * @param An int array "UnluckyNumbers" with variable length 
     */
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
