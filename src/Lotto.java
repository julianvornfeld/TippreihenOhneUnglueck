
public class Lotto extends LottoBase implements ILottoBase {

	public Lotto(int[] UnluckyNumbers) {
		super(49, UnluckyNumbers);
	}

	@Override
	public String GetZahlenreihe() {
		String Zahlen = "Gewinnzahlen: ";
		int[] Gewinnzahlen = GetNumbers(6);
		
		for(int cntnumbers=0; cntnumbers < Gewinnzahlen.length; cntnumbers++) {
			Zahlen += Gewinnzahlen[cntnumbers] + " ";
		}
		
		return Zahlen;
	}

}
