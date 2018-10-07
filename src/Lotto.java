
public class Lotto extends LottoBase implements ILottoBase {

	public Lotto(int first, int second, int third) {
		super(first, second, third, 49);
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
