import java.io.*;
import java.util.*;
import java.math.*;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 32768);
		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		
		for(int i = 1; i <= T; i++) {
			st = new StringTokenizer(br.readLine());
			String S = st.nextToken();
			ArrayList<Character> al = new ArrayList<Character>();
			int count = 0;
			boolean consecutive = false;
			
			for (int j = 0; j < S.length(); j++) {
				if (S.charAt(j) == '1') {
					if (consecutive) {
						al.add('1');
					}
					else {
						al.add('(');
						al.add('1');
						consecutive = true;
					}
					if (j == S.length() - 1) {
						al.add(')');
					}
				}
				else {
					if (consecutive) {
						al.add(')');
					}
					al.add('0');
					consecutive = false;
				}
				
			}
			StringBuffer sb = new StringBuffer();
			for (char s : al) {
				sb.append(s);
			}
			String output = sb.toString();
			pw.println("Case #" + i + ": " + output);
		}
		pw.close();
		
	}
	
}
