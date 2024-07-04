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
			
			int x = in.nextInt();
			int y = in.nextInt();
			String m = in.next();
			
			int seconds = 0;
			for (int i = 0; i < m.length(); i++) {
				seconds++;			
				switch (m.charAt(i)) {				
				case 'N':	
					y++;
					break;
				case 'S':
					y--;
					break;
				case 'E':	
					x++;
					break;
				case 'W':
					x--;
					break;
				default:
					break;
				}	
				if (Math.abs(x) + Math.abs(y) <= seconds) {	
					break;
				}
			}
			
			if (Math.abs(x) + Math.abs(y) <= seconds) {	
				resultat.append(seconds);
			}
			else {
				resultat.append("IMPOSSIBLE");
			}			
			
			writer.print(resultat.toString());
			writer.println();			
		}
		in.close();
		writer.close();
	}	
	
}
