
import java.util.*;
import java.io.*;

public class Solution {
    
    
	public static void main(String[] args) {
		int[][] timing;
		String[] rowRead;
		
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc
		
		for (int i = 1; i <= t; ++i) {
			int N = in.nextInt();
			timing = new int[N][3];

			in.nextLine();
			for (int r = 0; r < N; r++) {
				rowRead = in.nextLine().split(" ");
				timing[r][0] = Integer.parseInt(rowRead[0]);
				timing[r][1] = Integer.parseInt(rowRead[1]);
				timing[r][2] = r;
			}
			sortArray(timing);
			System.out.println("Case #" + i + ": " + indScdle(timing, N));
		}
	}

	public static void sortArray(int a[][]) {
		Arrays.sort(a, (e1, e2) -> Integer.compare(e1[0], e2[0]));
	}
	
	public static String indScdle(int [][] a, int N) {
		int c_inised = 0, a_inised = 0,maxFinTimeRowInd = 0;
		char[] genArr = new char[N];
		char[] ansArr = new char[N];
		StringBuilder sb = new StringBuilder();
		String available= "J";
		sb.append(available);
		if (N==2) {
			return "JJ";
		}
		for (int i = 0; i < N-1; i++) {
			if (a[maxFinTimeRowInd][1] >a[i+1][0] && maxFinTimeRowInd < N) {
				
				if (c_inised >a[i+1][0] && a_inised>a[i+1][0]) {
					return "IMPOSSIBLE";
				}else if(c_inised <= a[i+1][0]){
					c_inised = a[i+1][1];
					available= "C";
				}else {
					a_inised = a[i+1][1];
					available= "J";
				}
				a_inised = a[maxFinTimeRowInd][1] ;
			}else {
				
				available= "J";
			}
			if (a[i][1] <a[i+1][1]) {
				maxFinTimeRowInd = i+1;
			}
			sb.append(available);
		}
		genArr = sb.toString().toCharArray();
		sb = null;
		sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(genArr[a[i][2]]);
		}
		return sb.toString();
	}

}
