
public class Zusatzziehung extends LottoBase implements ILottoBase {

	public Zusatzziehung(int[] unluckynumbers) {
		super(10);

		this.unluckynumbers = new int[unluckynumbers.length];

		for(int count=0; count<unluckynumbers.length; count++) {
			this.unluckynumbers[count] = unluckynumbers[count];
		}
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
