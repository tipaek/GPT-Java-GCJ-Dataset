import java.util.*;
import java.io.*;
public class Solution {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
		int nD = 0;
		StringBuffer sb = new StringBuffer();
		for (int i = 1; i <= t; ++i) {
			String n = in.next().toString();
			for(int j = 0; j < n.length(); j++) {
				if(Character.getNumericValue(n.charAt(j)) > nD) { // abrir ((
					for(int aux = 0; aux< Character.getNumericValue(n.charAt(j)) - nD; aux++) {
						sb.append('(');
					}
					sb.append(n.charAt(j));
					nD = Character.getNumericValue(n.charAt(j));
				}else {
					if(Character.getNumericValue(n.charAt(j)) == nD) {
						sb.append(n.charAt(j));
					}
					else { 
						for(int aux = 0; aux < nD - Character.getNumericValue(n.charAt(j)); aux++) {
							sb.append(')');
						}
						sb.append(n.charAt(j));
						nD = Character.getNumericValue(n.charAt(j));
					}
				}
				
				if(j == n.length()-1) {
					for(int aux = 0; aux < Character.getNumericValue(n.charAt(j)); aux++) {
						sb.append(')');
					}
				}
				
			}
			System.out.println("Case #" + i + ": " + sb.toString());
			sb = new StringBuffer();
			nD = 0;
		}
	}
}