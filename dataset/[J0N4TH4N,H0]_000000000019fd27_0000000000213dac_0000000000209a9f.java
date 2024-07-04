import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		
//		BufferedReader f = new BufferedReader(new  FileReader (new  File("sample.txt")));	
//		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("sample.txt")));
//		StringTokenizer st = new StringTokenizer(f.readLine());

		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));	
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		StringTokenizer st = new StringTokenizer(f.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < T; i++) {
			out.print("Case #" + (i+1) + ": ");
			String s = (f.readLine());
			String ans = "";
			int count = 0;
			
			for (int j = 0; j < s.length(); j++) {
				int value = s.charAt(j)-'0';
				while (count < value) {
					ans += "(";
					count++;
				}
				while (count > value) {
					ans += ")";
					count--;
				}
				ans += value;
			}
			
			while(count > 0) {
				ans += ")";
				count--;
			}
			
			out.println(ans);
		}
		
		out.close();
	}
}


