import java.util.HashSet;
import java.util.Scanner;

class Solution {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int numberOfTestCases = Integer.parseInt(scanner.nextLine());
		while(numberOfTestCases>0) {
			int n = Integer.parseInt(scanner.nextLine());
			int[][] matrix = new int[n][n];
			for(int i=0;i<n;i++) {
				String[] s = scanner.nextLine().split(" ");
				for(int j=0;j<n;j++)
					matrix[i][j]=Integer.parseInt(s[j]);
			}
			int traceSum = calculateTrace(matrix, n);
			int duplicateRows = calculateDuplicateElementRows(matrix, n);
			int duplicateCols = calculateDuplicateElementColumns(matrix, n);
			System.out.println(traceSum+" "+duplicateRows+" "+duplicateCols);
			numberOfTestCases--;
		}
	}
	
	public static int calculateTrace(int[][] matrix,int n) {
		int sum=0;
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				if(i==j)
					sum+=matrix[i][j];
		return sum;
	}
	
	public static int calculateDuplicateElementRows(int[][] matrix,int n) {
		int count=0;
		HashSet<Integer> set = new HashSet<>();
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(set.contains(matrix[i][j])) {
					count++;
					break;
				}else
					set.add(matrix[i][j]);
			}
			set.clear();
		}
		return count;
	}
	
	public static int calculateDuplicateElementColumns(int[][] matrix,int n) {
		int count=0;
		HashSet<Integer> set = new HashSet<>();
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(set.contains(matrix[j][i])) {
					count++;
					break;
				}else
					set.add(matrix[j][i]);
			}
			set.clear();
		}
		return count;
	}

}
