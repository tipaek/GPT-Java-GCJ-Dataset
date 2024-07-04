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
			
			String s = in.next();
			int previousNumber = 0;
			int number = 0;
			for (int i = 0; i < s.length(); i++) {
				number = Character.getNumericValue(s.charAt(i));
				if (number > previousNumber) {
					for (int j = 0; j < number - previousNumber; j++) {
						resultat.append("(");
					}
				}
				else if (number < previousNumber) {
					for (int j = 0; j < previousNumber - number; j++) {
						resultat.append(")");
					}
				}
				resultat.append(number);
				previousNumber = number;
			}
			
			for (int i = 0; i < number; i++) {
				resultat.append(")");
			}
			
			writer.print(resultat.toString());
			writer.println();
		}
		in.close();
		writer.close();
	}
}
