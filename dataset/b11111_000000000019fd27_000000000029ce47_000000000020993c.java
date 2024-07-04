import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		//int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		int t = Integer.parseInt(in.nextLine());
		//System.out.println(t);
		for (int i = 1; i <= t; ++i) {
			//int n = in.nextInt();
			int n = Integer.parseInt(in.nextLine());
			int[][] tab = new int[n][n];
			for(int j = 1 ; j <= n ; j++) {
				String row = in.nextLine();
				String[] ra = row.split(" ");
				for(int k = 1; k <= n; k++) {
					tab[j-1][k-1] = Integer.parseInt(ra[k-1]);
				}
			}
			int diasum = diagonalValue(tab , n);
			//System.out.println(diasum);
			int rowr = horizontalRepeated(tab, n);
			int verr = verticalRepeated(tab, n);
			System.out.println("Case #" + i + ": " + diasum + " " + rowr + " " + verr );
			//System.out.println("");
		}
	}
	
	public static int diagonalValue(int[][] tab, int n) {
		int sum = 0;
		for(int i = 0; i < n; i++ ) {
			sum += tab[i][i];
		}
		return sum;
	}
	
	public static int horizontalRepeated(int[][] tab, int n) {
		int count = 0;
		
		for(int i = 0; i < n ; i++) {
			Set<Integer> se = new HashSet<Integer>();
			for(int j = 0; j < n ; j++) {
				se.add(tab[i][j]);
			}
			if(se.size() < n) {
				count ++;
			}
		}
		
		return count;
	}
	
	public static int verticalRepeated(int[][] tab, int n) {
		int count = 0;
		
		for(int i = 0; i < n ; i++) {
			Set<Integer> se = new HashSet<Integer>();
			for(int j = 0; j < n ; j++) {
				se.add(tab[j][i]);
			}
			if(se.size() < n) {
				count ++;
			}
		}
		
		return count;
	}
	
	
	public static void output(String[] output) {
		int i = 1;
		for(String s : output) {
			System.out.println("Case #" + i + ": " + s );
			i++;
		}
	}
}