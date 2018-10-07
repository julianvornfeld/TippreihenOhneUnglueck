public class Test {
	
	//Scanner einbauen: https://www.java-forum.org/thema/die-klasse-scanner-in-eclipse.51519/
	public static final void main (String[] argv) {
		//TestLotto();
		TestEurojackpot();
	}

	public static void TestEurojackpot() {
		Eurojackpot Euro = new Eurojackpot(13, 25, 44);
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
		Lotto Lotto = new Lotto(13, 25, 44);
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
