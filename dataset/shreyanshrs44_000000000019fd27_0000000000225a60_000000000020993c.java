
import java.util.HashSet;
import java.util.Scanner;


public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t;
		t=sc.nextInt();
		for(int k=1;k<=t;k++){
			int n,trace=0;
			n=sc.nextInt();
			int[][] matrix = new int[n][n];
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					matrix[i][j]=sc.nextInt();
					if(i==j) trace+=matrix[i][j];
				}
			}
			// check for rows
			int rowCount=0;
			for(int i=0;i<n;i++) {
				HashSet<Integer> set = new HashSet<Integer>();
				for(int j=0;j<n;j++) {
					set.add(matrix[i][j]);
				}
				if(set.size()!=n) rowCount++;
			}
			// check for columns
			int colCount=0;
			for(int i=0;i<n;i++) {
				HashSet<Integer> set = new HashSet<Integer>();
				for(int j=0;j<n;j++) {
					set.add(matrix[j][i]);
				}
				if(set.size()!=n) colCount++;
			}
			System.out.println("Case #"+ k + ": " + trace + " " + rowCount + " " + colCount);
		}
	}

}

