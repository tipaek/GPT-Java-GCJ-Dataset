public class Probleme1 {
	
	
	public static int[] calculate(int tab[][] , int n) {
		int[] tableau = new int[3];
		int trace = 0;
		int sommeLine = 0, sommeColone = 0;
		int valRef = (n*(n + 1))/2;
		
		for (int i = 0; i < tab.length; i++) {
			for (int j = 0; j < tab.length; j++) {
				sommeLine = sommeLine + tab[i][j];
				sommeColone = sommeColone + tab[j][i];
				if(i == j)
					trace = trace + tab[i][j];
			}
			if(sommeLine != valRef)
				tableau[1] = tableau[1] + 1;
			if(sommeColone != valRef)
				tableau[2] = tableau[2] + 1;
			
			sommeColone = 0;
			sommeLine = 0;
		}
		
		tableau[0] = trace;
		return tableau;
	}

}
