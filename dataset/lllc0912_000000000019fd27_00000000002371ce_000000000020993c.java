import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	public static void main (String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {
        	int n = in.nextInt();
        	int k = 0;
        	int r = 0;
        	int c = 0;
        	int[][] square = new int[n][n];
        	for (int row = 0; row < n; row++) {
        		for (int col = 0; col <n; col++ ) {
        			square[row][col] = in.nextInt();
        		}
        	}
        	
        	for (int row = 0; row < n; row++) {
        		Set<Integer> colSet = new HashSet<>();
        		Set<Integer> rowSet = new HashSet<>();
        		for (int col = 0; col <n; col++ ) {
        			colSet.add(square[row][col]);
        			rowSet.add(square[col][row]);
        		}
        		if (colSet.size() != n) {
        			c++;
        		}
        		if (rowSet.size() != n) {
        			r++;
        		}
        	}
        	
        	for (int d1 = 0; d1 < n; d1++) {
        		k += square[d1][d1];
        	}
        	
        	System.out.println("Case #" + i + ": " + k + " " + r + " " + c);
        }
	}
}
