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

			ArrayList<String> al = new ArrayList<String>();
			boolean consecutive = false;
			for (int j = 0; j < S.length(); j++) {
				if (S.charAt(j) != '0') {
					if (consecutive) {
						if (j > 0 && j != S.length() - 1) {
							int num1 = Integer.parseInt(String.valueOf(S.charAt(j)));
							int prev = Integer.parseInt(String.valueOf(S.charAt(j-1)));
							int numDiff = num1 - prev;
	
							if (numDiff < 0) {
								for (int b = 0; b < Math.abs(numDiff); b++) {
									al.add(")");
								}
								al.add(num1 + "");
							}
							if (numDiff > 0) {
								for (int d = 0; d < Math.abs(numDiff); d++) {
									al.add("(");
								}
								al.add(num1 + "");
							}
							if (numDiff == 0) { 
								al.add(num1 + "");
							}
							
						}
						else if (j == S.length() - 1) {
							int num1 = Integer.parseInt(String.valueOf(S.charAt(j)));
							int prev = Integer.parseInt(String.valueOf(S.charAt(j-1)));
							int numDiff = num1 - prev;
	
							if (numDiff < 0) {
								for (int b = 0; b < Math.abs(numDiff); b++) {
									al.add(")");
								}
								al.add(num1 + "");
							}
							if (numDiff > 0) {
								for (int d = 0; d < Math.abs(numDiff); d++) {
									al.add("(");
								}
								al.add(num1 + "");
							}
							if (numDiff == 0) { 
								al.add(num1 + "");
							}
							
						
							for (int c = 0; c < num1; c++) {
								al.add(")");
							}
							
						}
						else if (j == 0) {
							int num4 = Integer.parseInt(String.valueOf(S.charAt(j)));
							for (int e = 0; e < num4; e++)
								al.add("(");
							al.add(num4 + "");
						}
						else {
							int num2 = Integer.parseInt(String.valueOf(S.charAt(j)));
							al.add(num2 + "");
							for (int f = 0; f < num2; f++)
								al.add(")");
						}
					}//end conseq
					else {
						int num3 = Integer.parseInt(String.valueOf(S.charAt(j)));
						for (int a = 0; a < num3; a++) {
							al.add("(");
						}
						al.add(num3 + "");
						if (j == S.length() -1) {
							for (int h = 0; h < num3; h++)
								al.add(")");
						}
						consecutive = true;
					}
				}//end
				else { // if 0
					int numDiff = 0;
					if (j != 0) {
						numDiff = Integer.parseInt(String.valueOf(S.charAt(j-1)));
					}
					for (int c = 0; c < numDiff; c++) {
						al.add(")");
					}
					al.add("0");
					consecutive = false;
				}
			}
			StringBuffer sb = new StringBuffer();
			for (String s : al) {
				sb.append(s);
			}
			String output = sb.toString();
			
			pw.println("Case #" + i + ": " + output);
		}
		pw.close();
	}
}
