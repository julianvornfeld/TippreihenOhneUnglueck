
public class Eurojackpot extends LottoBase implements ILottoBase {
	private Zusatzziehung Zusatz;
	
	public Eurojackpot(int first, int second, int third) {
		super(first, second, third, 50);

		if (first>10) {
			first = 0;
		}
		if (second>10) {
			second = 0;
		}
		if (third>10) {
			third= 0;
		}
		Zusatz = new Zusatzziehung(first, second, third);
	}
	
	public String GetZahlenreihe() {
		String Zahlen = "Gewinnzahlen: ";
		int[] Gewinnzahlen = GetNumbers(5);

		for(int cntnumbers=0; cntnumbers < Gewinnzahlen.length; cntnumbers++) {
			Zahlen += Gewinnzahlen[cntnumbers] + " ";
		}
		Zahlen += "\n" + Zusatz.GetZahlenreihe();
		
		return Zahlen;
	}
}
