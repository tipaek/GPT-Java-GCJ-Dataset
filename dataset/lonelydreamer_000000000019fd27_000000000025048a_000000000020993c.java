import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	
	private static boolean checkRow(int row , int n) {
		Set<Integer> set = new HashSet<>();
		for (int j = 1;j <= n;j ++) {
			if (!set.add(input[row][j])) {
				return true;				
			}
		}
		return false;
	}
	
	private static boolean checkCol(int col , int n) {
		Set<Integer> set = new HashSet<>();
		for (int i = 1;i <= n;i ++) {
			if (!set.add(input[i][col])) {
				return true;				
			}		
		}
		return false;
	}
	
	private static int[][] input = new int[1010][1010];
	
	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner scan = new Scanner(System.in);

		int i , j , t = scan.nextInt() , caseNum = 1;	
		while (t > 0) {
			int n = scan.nextInt();
			for (i = 1;i <= n;i ++) {
				for (j = 1;j <= n;j ++) {
					input[i][j] = scan.nextInt();					
				}
			}
			int sum = 0 , row = 0 , col = 0;			
			for (i = 1;i <= n;i ++) {
				sum += input[i][i];				
			}
			for (i = 1;i <= n;i ++) {
				if (checkRow(i , n)) {
					row ++;					
				}
			}
			for (j = 1;j <= n;j ++) {
				if (checkCol(j , n)) {
					col ++;
				}
			}
			System.out.println(String.format("Case #%d: %d %d %d" , caseNum , sum , row , col));
			caseNum ++;
			t --;
		}	
	}    	
		
}





