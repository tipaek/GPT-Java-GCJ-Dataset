import java.util.*;
import java.io.*;
   
public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		in.nextLine();
		for (int i = 1; i <= t; ++i) {
			String s = in.nextLine();
			char[] c = s.toCharArray();
			
			int prev = 0;
			String fin = "";
			
			for(int cur = 0; cur<c.length; cur++) {
				while(prev != Character.getNumericValue(c[cur])) {
					if(prev>Character.getNumericValue(c[cur])) {
						fin+=")";
						prev--;
					}
					else {
						fin+="(";
						prev++;
					}
				}
				fin +=c[cur];
				prev = Character.getNumericValue(c[cur]);
			}
			
			while(prev!=0) {
				fin+=")";
				prev--;
			}
				
			System.out.println("Case #" + i + ": " + fin);
		}
	}
}
