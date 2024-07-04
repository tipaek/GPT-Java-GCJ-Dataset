import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.Scanner;


public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		for (int x=1; x<=t; x++) {
			String raw = in.next();

			int currentNesting = 0;
			StringBuilder builder = new StringBuilder();
			for (int i=0; i<raw.length(); i++) {
				int val = raw.charAt(i) - '0';
				int delta = val - currentNesting;
				if (delta > 0) {
					for (int j=0; j<delta; j++) {
						builder.append('(');
					}
				} else {
					for (int j=0; j<-delta; j++) {
						builder.append(')');
					}
				}
				builder.append(raw.charAt(i));
				currentNesting = val;
			}
			for (int j=0; j<currentNesting; j++) {
				builder.append(')');
			}


			System.out.format(Locale.ROOT, "Case #%d: %s%n", x, builder);
		}
		in.close();
	}
}
