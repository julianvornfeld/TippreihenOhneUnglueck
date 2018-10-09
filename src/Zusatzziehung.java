
public class Zusatzziehung extends LottoBase implements ILottoBase {

	public Zusatzziehung(int[] UnluckyNumbers) {
		super(10, UnluckyNumbers);

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
