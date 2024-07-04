import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		
		int T = in.nextInt();		
		for (int casNumero = 1; casNumero <= T; casNumero++) {
			StringBuilder resultat = new StringBuilder();
			resultat.append("Case #");
			resultat.append(casNumero);
			resultat.append(": ");
			long n = in.nextLong();
			List<Long> first = new ArrayList<>();
			List<Long> second = new ArrayList<>();
			long columns = 1;
			long limit = (long)Math.sqrt(n);
			for (long i = 1; i < limit + 1; i++) {
				for (long j = 1; j <= columns; j++) {
					first.add(i);
					if (columns % 2 == 0) {						
						second.add(j);
					}
					else {
						second.add(columns + 1 - j);
					}
				}
				columns++;
			}
			
			if (n > 1) {
				boolean parells = columns % 2 == 0;
				long fi = limit + 1 + (n - (limit * limit));
				if (limit > 1) {
					fi++;
				}
				for (long i = limit + 1; i < fi; i++) {
					first.add(i);
					if (parells) {
						second.add(1l);
					}
					else {
						second.add(columns);
						columns++;
					}				
				}	
			}
						
			
			writer.print(resultat.toString());
			writer.println();
			for (int i = 0; i < first.size(); i++) {
				writer.print(first.get(i));
				writer.print(" ");
				writer.print(second.get(i));
				writer.println();
			}
		}
		in.close();
		writer.close();
	}	
	
	public static BigInteger sqrt(BigInteger x) {
	    BigInteger div = BigInteger.ZERO.setBit(x.bitLength()/2);
	    BigInteger div2 = div;
	    for(;;) {
	        BigInteger y = div.add(x.divide(div)).shiftRight(1);
	        if (y.equals(div) || y.equals(div2))
	            return y;
	        div2 = div;
	        div = y;
	    }
	}	  
}
