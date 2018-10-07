
public class Zusatzziehung extends LottoBase implements ILottoBase {

	public Zusatzziehung(int first, int second, int third) {
		super(first, second, third, 10);
	}

	public String GetZahlenreihe() {
		String Zahlen = "Gewinnzahlen: ";
		
		int[] Gewinnzahlen= GetNumbers(2);

		Zahlen += "Eurozahlen: ";
		for(int cntnumbers=0; cntnumbers < Gewinnzahlen.length; cntnumbers++) {
			Zahlen += Gewinnzahlen[cntnumbers] + " ";
		}
		
		return Zahlen;
	}

}
