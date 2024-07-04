import java.util.*;
import java.io.*;
public class Solution {

	static void solve(int n) {
		int s = 2000;
		int pascal[][] = new int[s][s];
		pascal[0][0] = 1;
		for (int i=1; i<s; i++) {
			pascal[i][0] = 1;
			for (int j=1; j<=i; j++) {
				pascal[i][j] = pascal[i-1][j-1] + pascal[i-1][j];
			}
		}
		
		int sum[] = new int[s];
		for (int i=0; i<s; i++) {
			for(int j=0; j<=i/2; j++) {
				sum[i] += pascal[i][j];
			}
		}
		
		int row = 0;
		int col = 0;
		while(n>0) {
			n -= pascal[row][col];
			System.out.println((row+1) + " " + (col+1));

			if (n<sum[row+1]) {
				break;
			}

			row++;
			if (row%2 == 0) {
				col++;
			}
		}
		
		while(col>0 && n>0) {
			col--;
			n -= pascal[row][col];
			System.out.println((row+1) + " " + (col+1));
		}

		while(n>0 && col==0) {
			row++;
			n -= pascal[row][0];
			System.out.println((row+1) + " " + (col+1));
		}

		return;
	}

	public static void main(String[] args) {
		Scanner in;
		try {
			in = new Scanner(new BufferedReader(new FileReader("bin/myinput.txt")));
		} catch (IOException e) {
			// e.printStackTrace();
			 in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));			
		}
		
		int t = in.nextInt();
		for (int i = 1; i <= t; ++i) {
			int n = in.nextInt();
			System.out.println("Case #" + i + ": ");
			solve(n);
		}
		in.close();
	}

}
