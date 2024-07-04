import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		for (int testcase = 1; testcase <= n; testcase++) {
			int rows = Integer.parseInt(sc.nextLine());
			int[][] matrix = new int[rows][rows];
			String [] [] matrixString  = new String[rows][rows];
			String [] [] compString  = new String[rows][rows];
			
			for (int i = 0; i < rows; i++) {
				String[] row = sc.nextLine().split(" ");
				for (int j = 0; j < row.length; j++) {
					matrixString[i][j] = row[j];
					compString[j][i] = row[j];
					matrix[i][j] = Integer.parseInt(row[j]);
				}
			}
			int sum = 0;
			for (int i = 0; i < rows; i++)
				sum += matrix[i][i];
			int copyrow = 0,copycol = 0;
			for (int i=0;i<matrix.length;i++) {
				Set<String> mySet = new HashSet<>(Arrays.asList(matrixString[i]));
				Set<String> mySet2 = new HashSet<>(Arrays.asList(compString[i]));
				
				if (mySet.size() != matrixString[i].length) {
					copyrow++;
				}
				if(mySet2.size() != compString[i].length) {
					copycol++;
				}
			}
			
			System.out.println("Case #"+testcase+": "+sum+" "+copyrow+" "+copycol);
		}
		sc.close();
	}
}
