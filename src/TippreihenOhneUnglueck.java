import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
/**
 * This is the class, which will be called by the user from the commandline
 * 
 * @author Julian Vornfeld
 *
 */
public class TippreihenOhneUnglueck {
	/**
	 * These are the unlucky numbers.
	 * They are loaded from a file or typed in by as user
	 */
	public static int[] UnluckyNumbers; 
	  
	public static Logger Log;
	
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
	public static void main(String[] args){
		String Type = "lotto";

		UserInterface Interface = new UserInterface();

		Log = Logger.getLogger("MyLog");  
		FileHandler File;  

		try {
			File = new FileHandler(GetCurrentTimestamp() + "_logfile.log");  
			Log.addHandler(File);
			SimpleFormatter Format = new SimpleFormatter();  
			File.setFormatter(Format);
			Log.setUseParentHandlers(false);	
		} catch (SecurityException e) {  
			e.printStackTrace();  
		} catch (IOException e) {  
			e.printStackTrace();  
		}  
		
		if (args.length > 0) {
			Type = args[0];
		}
		
		UnluckyNumbers = ReadFile();
		
		if (Type.equalsIgnoreCase("hilfe")) {
			Log.info("Der User hat die Hilfe aufgerufen"); 
			Interface.Help();
		} else if (Type.equalsIgnoreCase("eurojackpot")) { 
			System.out.println("Willkommen bei Eurojackpot Generator!");
			if (UnluckyNumbers == null) {
				UnluckyNumbers = Interface.SetUnluckyNumbers();	
			}
			Eurojackpot Euro = new Eurojackpot(UnluckyNumbers, Log);
			System.out.println(Euro.GetNumbersString());
		} else if (Type.equalsIgnoreCase("lotto")) {
			System.out.println("Willkommen bei Lotto Generator!");
			if (UnluckyNumbers == null) {
				UnluckyNumbers = Interface.SetUnluckyNumbers();	
			}
			Lotto Lotto = new Lotto(UnluckyNumbers, Log);
			System.out.println(Lotto.GetNumbersString());
		} else if (Type.equalsIgnoreCase("unglueckszahlen")) {
			if (args.length == 1) {
				Interface.HelpUnluckyNumbers();
			} else {
				String input = args[1];
				if (input.equalsIgnoreCase("ausgabe")) {
					Log.info("Der User hat die Ausgabe der Unglückszahlen gestartet"); 
					System.out.println(GetUnluckyNumbers());
				} else if (input.equalsIgnoreCase("eingabe")) {
					Log.info("Der User hat die Eingabe der Unglückszahlen gestartet"); 
					UnluckyNumbers = Interface.SetUnluckyNumbers();	
					if (UnluckyNumbers.length > 0) {
						WriteFile(UnluckyNumbers);	
					}
				} else {
					Interface.HelpUnluckyNumbers();
				}
			}
		} else {
			Log.info("Fehlerhafte Eingabe vom User: '" + args[1] + ","); 
			Interface.Help();
		}
	} 
	
	public static String GetCurrentTimestamp() {
	   DateTimeFormatter Format = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");  
	   LocalDateTime DateTime = LocalDateTime.now();  
	   return Format.format(DateTime); 
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
	public static int[] ReadFile ()  {
		File File = new File("UnluckyNumbers.txt");

		int[] UnluckyNumbers = null;
		
		if (File.exists()) {
			FileReader InputFile;
			try {
				InputFile = new FileReader("UnluckyNumbers.txt");
				BufferedReader InputFileBuffer = new BufferedReader(InputFile);
		
				String UnluckyNumbersString = InputFileBuffer.readLine();
				
				String[] Temp = UnluckyNumbersString.split(";");
				UnluckyNumbers = new int[Temp.length];
				
				for(int CntNumbers=0; CntNumbers < Temp.length; CntNumbers++) {
					UnluckyNumbers[CntNumbers] = Integer.parseInt(Temp[CntNumbers]);
				}
				InputFileBuffer.close();

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			Log.info("Die Datei 'UnluckyNumbers.txt' wurde eingelesen"); 
		} else {
			Log.info("Die Datei 'UnluckyNumbers.txt' wurde nicht gefunden"); 
		}
		
		return UnluckyNumbers;
	}

	/**
	 * This method write the value of the input array UnluckyNumbers to the file "UnluckyNumbers.txt" .
	 * The value of the file is a list of numbers separated by ";".
	 * 
	 * @param An int array "UnluckyNumbers" with variable length 
	 */
	public static void WriteFile(int[] UnluckyNumbers) {
		FileWriter InputFile;
		try {
			InputFile = new FileWriter("UnluckyNumbers.txt");
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
			Log.info("Die Unglückszahlen wurden in die Datei 'UnluckyNumbers.txt' geschrieben"); 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
