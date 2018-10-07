
public class Zusatzziehung extends LottoBase implements ILottoBase {

	public Zusatzziehung(int[] unluckynumbers) {
		super(10);

		this.unluckynumbers = new int[3];
		this.unluckynumbers[0] = unluckynumbers[0];
		this.unluckynumbers[1] = unluckynumbers[1];
		this.unluckynumbers[2] = unluckynumbers[2];	
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
