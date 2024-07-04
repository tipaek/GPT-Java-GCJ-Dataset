import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;


public class Solution {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
		for(int tNum = sc.nextInt(), tCurr = 1; tCurr<=tNum ; tCurr++) {
			
			int n = sc.nextInt();
			
			
			int[][] matrix = new int[n][n];
			int diagonal=0;
			int rR=0;
			int rC=0;
			
			for(int i=0;i<n;i++) {
				HashSet<Integer> row = new HashSet<Integer>();

				for(int j=0;j<n;j++) {
						matrix[i][j] = sc.nextInt();
						row.add(matrix[i][j]);
				}
				if((n-row.size())!=0) rR++;
			}

			for(int i=0;i<n;i++) {
				diagonal+=matrix[i][i];
			}
			
			for(int i=0;i<n;i++) {
				HashSet<Integer> col = new HashSet<Integer>();

				for(int j=0;j<n;j++) {
						col.add(matrix[j][i]);
				}
				if((n-col.size())!=0) rC++;
			}
			
			
			
			System.out.println(String.format("Case #%d: %d %d %d" , tCurr, diagonal, rR, rC));
			
			
		}
		
		System.out.flush();
	}

}