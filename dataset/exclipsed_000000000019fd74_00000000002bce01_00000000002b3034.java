import java.util.*;
import java.io.*;

public class Solution {
	final static int MOD = 1000000007;
	final static int intMax = 1000000000;
	final static int intMin = -1000000000;
	final static int[] DX = { 0, 0, -1, 1 };
	final static int[] DY = { -1, 1, 0, 0 };

	static int T;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		loop: for(int t = 1; t <= T; ++t) {
			System.out.print("Case #" + t + ": ");
			int N = Integer.parseInt(br.readLine());
			String[] strings = new String[N];
			for(int i = 0; i != N; ++i) {
				strings[i] = br.readLine();
			}
			String suff = "";
			StringBuilder pref = new StringBuilder();
			for(int i = 0; i != N; ++i) {
				int ind = 0;
				while(strings[i].charAt(ind++) != '*') {
					if(ind > pref.length()) {
						pref.append(strings[i].charAt(ind - 1));
					}
					else{
						if(pref.charAt(ind - 1) != strings[i].charAt(ind - 1)) {
							System.out.println("*");
							continue loop;
						}
					}
				}
				 int ind3 = 0;
				int ind2 = strings[i].length()-1;
				while(ind2-- >= ind) {
					if(strings[i].length() - 1 - ind2 > suff.length()) {
						suff = "" + strings[i].charAt(ind2+1) + "" + suff;
					}
					else {
						if(suff.charAt(suff.length() - 1 - ind3) != strings[i].charAt(ind2 + 1)) {
							System.out.println("*");
							continue loop;
						}
					}
					ind3++;
				}
			}
			System.out.println(pref.toString() + suff);
		}
		br.close();
	}

}