import java.util.Arrays;

public class Test {
	
	//Scanner einbauen: https://www.java-forum.org/thema/die-klasse-scanner-in-eclipse.51519/
	public static final void main (String[] argv) {
		//TestScanner();
		//TestLotto();
		//TestEurojackpot();
		int[] UnluckyNumbers = {1,2,3};
		String result = "";
		
	    for (int count = 0; count < UnluckyNumbers.length; count++) {
	        if (count > 0) {
	           result = result + ";";
	        }
	        int item = UnluckyNumbers[count];
	        result = result + item;
	    }
	      
		System.out.println(result);
	}
	
}
