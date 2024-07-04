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
			boolean isOne = false;
			String fin = "";
			
			for(int cur = 0; cur<c.length; cur++) {
				if(c[cur]=='1') {
					if(!isOne)
					{
						fin += "(1";
						isOne = true;
					}
					
					else 
						fin +="1";
				}
				
				else {
					if(isOne) {
						fin += ")0";
						isOne = false;
					}
					
					else 
						fin += "0";
						
					
				}
			}
			if(isOne)
				fin += ")";
				
			System.out.println("Case #" + i + ": " + fin);
		}
	}
}
