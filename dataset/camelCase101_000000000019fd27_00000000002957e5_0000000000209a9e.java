import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		System.out.flush();
		for (int i = 1; i <= t; ++i) {
			String base = in.next();
			System.out.println(base);
			
			if(in.next().equals("N")) {
				char[] c = base.toCharArray();
				
				String comp = "";
				for(char cur:c) {
					if(cur=='0')
						comp+='1';
					else
						comp+='0';
				}
				System.out.println(comp);
				
				if(in.next().equals("N")) {
					String rev = "";
					for(int r = base.length()-1;r>-1;r--) {
						rev += c[r];
					}
					System.out.println(rev);
					
					if(in.next().equals("N")) {
						char[] g = comp.toCharArray();
						String fin = "";
						for(int r = comp.length()-1;r>-1;r--) {
							fin += g[r];
						}
						System.out.println(fin);
					}
				}
			}
		}
	}
}