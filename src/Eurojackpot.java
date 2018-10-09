
public class Eurojackpot extends LottoBase implements ILottoBase {
	private Zusatzziehung Zusatz;
	
	public Eurojackpot(int[] UnluckyNumbers) {
		super(50, UnluckyNumbers);
		
		Zusatz = new Zusatzziehung(UnluckyNumbers);
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
