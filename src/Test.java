public class Test {
	
	//Scanner einbauen: https://www.java-forum.org/thema/die-klasse-scanner-in-eclipse.51519/
	public static final void main (String[] argv) {
		//TestScanner();
		//TestLotto();
		TestEurojackpot();
	}
	
	public static void TestScanner() {
//		Eingabe Testeingabe = new Eingabe();
//		int[] unluckynumbers = Testeingabe.GetUnluckyNumbers();
//		System.out.println(unluckynumbers[0]);
//		System.out.println(unluckynumbers[1]);
//		System.out.println(unluckynumbers[2]);
	}
	
	public static void TestEurojackpot() {
		Eurojackpot Euro = new Eurojackpot();
		System.out.println(Euro.GetZahlenreihe());
		/*
		int[] Zahlen = Euro.GetZahlenreihe();
		
        int count = 0;
        do {
    		System.out.println(Zahlen[count]);
            count++;
        } while (count < Zahlen.length);*/
	}
	
	public static void TestLotto() {
		Lotto Lotto = new Lotto();
		System.out.println(Lotto.GetZahlenreihe());
		
		/*
		int[] Zahlen = Lotto.GetZahlenreihe();
		
        int count = 0;
        do {
    		System.out.println(Zahlen[count]);
            count++;
        } while (count < Zahlen.length);*/
	}
}
