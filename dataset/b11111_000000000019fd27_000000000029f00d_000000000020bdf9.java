import java.util.*;
import java.io.*;
import java.lang.reflect.Array;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		//int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		int t = Integer.parseInt(in.nextLine());
		for (int i = 1; i <= t; ++i) {
			int n = Integer.parseInt(in.nextLine());
			int[][] tab = new int[n][2];
			for(int j = 1 ; j <= n ; j++) {
				String row = in.nextLine();
				StringTokenizer st = new StringTokenizer(row);
				int x = 0;
				while(st.hasMoreTokens()) {
					String val = st.nextToken();
					tab[j-1][x] = Integer.parseInt(val);
					x++;
				}
			}
			int[][] ab = mysort(tab, n);
			String val = schedule(ab, n);
			System.out.println("Case #" + i + ": " + val );
		}
	}
	
	public static int[][] mysort(int[][] tab, int n) {
		int[] ar = new int[n];
		for(int i = 0; i < n ; i++) {
			ar[i] = tab[i][0];
		}
		Arrays.sort(ar);
		int[] sel = new int[n];
		for(int i = 0; i < n ; i++) {
			sel[i] = 0;
		}
		int[][] ab = new int[n][2];
		for(int i = 0; i < n ; i++ ) {
			for(int j = 0; j < n ; j++) {
				if(ar[i] == tab[j][0] && sel[j] == 0) {
					ab[i][0] = tab[j][0];
					ab[i][1] = tab[j][1];
					sel[j] = 1;
				}
			}
		}
		return ab;
		
		
	}
	
	public static String schedule(int[][] tab, int n) {
		int cEnd = 0;
		int jEnd = 0;
		String r = "";
		for(int i = 0; i < n ; i++) {
			System.out.println(tab[i][0] + " " + tab[i][1]);
			if (tab[i][0] >= cEnd) {
				cEnd = tab[i][1];
				r = r + "C";
			}else if(tab[i][0] >= jEnd) {
				jEnd = tab[i][1];
				r = r + "J";
			}else {
				return "IMPOSSIBLE";
			}
			System.out.println(cEnd + " " + jEnd);
		}
		return r;
	}
}