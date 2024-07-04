import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

		String t = in.nextLine(); // Scanner has functions to read ints, longs, strings, chars, etc.

		String s = "";
		String y = "";
		
		int nbToClose = 0;


		
		for (int x = 1; x <= Integer.valueOf(t); ++x) {
			s = in.nextLine();
			y = "";
			String sub = "";
			int prev = 0;
			for (char ch : s.toCharArray()) {
				if (ch == '0') {
					if (!sub.isEmpty()) {
						y = y + sub;
						sub = "";
						while(nbToClose != 0) {
							y = y + ")";
							nbToClose--;
						}
						y = y + ch;
					} else {
						y = y + ch;
					}
				} else {
					if (sub.isEmpty()) {
						for (int j = 1; j<=Character.getNumericValue(ch); j++) {
							sub = sub + "(";
							nbToClose++;
						}
						sub = sub + ch;
					} else if(Character.getNumericValue(ch) < prev) {
						int r = prev - Character.getNumericValue(ch);
						int temps = 1;
						y = y + sub;
						sub = "";
						while(temps <= r) {
							y = y + ")";
							temps++;
						}
//						y = y + ch;
						sub = sub + ch;
						nbToClose = nbToClose - r;
					} else if(Character.getNumericValue(ch) > prev) {
						int r = Character.getNumericValue(ch) - prev;
						int temps = 1;
						y = y + sub;
						sub = "";
						while(temps <= r) {
							y = y + "(";
							temps++;
						}
//						y = y + ch;
						sub = sub + ch;
						nbToClose = nbToClose + r;
					}
					else {
						sub = sub + ch;
					}
				}
				prev=Character.getNumericValue(ch);
			}
			if (!sub.isEmpty() && !sub.contains(")")) {
				y = y + sub;
				while(nbToClose != 0) {
					y = y + ")";
					nbToClose--;
				}
			}
			System.out.println("Case #" + x + ": " + y);
		}

		in.close();
	}
}