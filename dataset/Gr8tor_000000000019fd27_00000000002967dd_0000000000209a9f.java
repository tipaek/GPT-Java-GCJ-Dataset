import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int t = 0; t < T; t++) {
			StringBuffer str = new StringBuffer(in.readLine().trim());
			//StringBuffer ans = new StringBuffer();
			
			System.out.print("Case #" + (t+1) + ": ");
			
			int last = 0;
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) - '0' > last) 
					for (int n = 0; n < str.charAt(i) - '0' - last; n++)
						System.out.print("(");
				else if (str.charAt(i) - '0' < last)
					for (int n = 0; n < last - (str.charAt(i) - '0'); n++)
						System.out.print(")");
				last = str.charAt(i) - '0';
				System.out.print(str.charAt(i));
			}
			
			for (int i = 0; i < str.charAt(str.length() -1) - '0'; i++) {
				System.out.print(")");
			}
			System.out.println();
		}
	}
}
