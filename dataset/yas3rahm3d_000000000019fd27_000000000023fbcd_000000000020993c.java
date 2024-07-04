import java.util.Scanner;
import java.util.*;
public class Solution {
	public static int checkRow(int[][] matrix, int n) {
		int count=0;
		Set<Integer> hash_set=new HashSet<Integer>();
		for(int i=0;i<n;i++) {
			hash_set.clear();
			for(int j=0;j<n;j++) {
				hash_set.add(matrix[i][j]);
			}
			if(hash_set.size()<n) {
				count++;
			}
		}
		return count;
	}
	public static int checkCol(int[][] matrix, int n) {
		int count=0;
		Set<Integer> hash_set=new HashSet<Integer>();
		for(int i=0;i<n;i++) {
			hash_set.clear();
			for(int j=0;j<n;j++) {
				hash_set.add(matrix[j][i]);
			}
			if(hash_set.size()<n) {
				count++;
			}
		}
		return count;		
	}
	
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter no of test cases");
		int t=s.nextInt();
		while(t>0) {
		System.out.println("Enter size of matrix");
		int n=s.nextInt();
		int[][] matrix=new int[n][n];
		int trace=0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				matrix[i][j]=s.nextInt();
				if(i==j) {
					trace+=matrix[i][j];
				}
			}
		}
		
		int rowRep = checkRow(matrix,n);
		int colRep = checkCol(matrix,n);
		System.out.println(trace +" "+rowRep+" "+colRep);
		t=t-1;
		}
		
		s.close();
	}
}