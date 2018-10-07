
public class TippreihenOhneUnglueck {
	public static LottoBase spiel;
    public static void main(String[] args){
    	String typ = "lotto";
    			
    	if (args.length > 0) {
    		typ = args[0];
    	}
    	
        if (typ.equalsIgnoreCase("eurojackpot")) {
        	System.out.println("Willkommen bei Eurojackpot Generator!");
    		Eurojackpot Euro = new Eurojackpot();
    		System.out.println(Euro.GetZahlenreihe());
    		spiel = Euro;
        } else if (typ.equalsIgnoreCase("lotto")) {
        	System.out.println("Willkommen bei Lotto Generator!");
    		Lotto Lotto = new Lotto();
    		System.out.println(Lotto.GetZahlenreihe());
    		spiel = Lotto;
        } else {
        	System.out.println("Fehler: Der Parameter muss wie folgt aussehen: \n"
    				+ "'eurojackpot' für den Eurojackpot Generator \n"
    				+ "'lotto' für den Lotto Generator");
        }
        
    } 
}
