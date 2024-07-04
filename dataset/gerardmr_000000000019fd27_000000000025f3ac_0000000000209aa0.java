import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
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
			
			int n = in.nextInt();
			long k = in.nextLong();
			
			if (k % n != 0) {
				writer.print("IMPOSSIBLE");
			}
			else {
				writer.print("POSSIBLE");
				writer.println();
				int value = ((int)k / n);
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						if (value + j - i <= 0) {
							writer.print(n - (j - i + value));
							writer.print(" ");
						}
						else if (value + j - i > n) {
							writer.print((value + j - i) % n);
							writer.print(" ");
						}
						else {
							writer.print(value + j - i);
							writer.print(" ");
						}
					}
					writer.println();
				}						
			}				
		}
		in.close();
		writer.close();
	}
}
