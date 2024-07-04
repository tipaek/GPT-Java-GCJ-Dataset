import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		String output = "";
		for (int i = 1; i <= t; i++) {
			 int N = in.nextInt();
			 int[][] matrix = new int[N][N];
			 for(int j=0;j<N;j++) {
				 for(int k=0;k<N;k++) {
					 int no = in.nextInt();
					 matrix[j][k] = no;
				 }
			 }
			 long K = getSumOfMainDiagonal(matrix, N);
			 long R = getRowWiseDuplicateCount(matrix, N);
			 long C = getcollmnWiseDuplicateCount(matrix, N);
			 
			 output = output + "Case #" + i + ": "+K+" "+R+" "+C +"\n";
	          
	     }
		 System.out.println(output);
	}
	
	public static int getRowWiseDuplicateCount(int[][] matrix,int N) {
		int count = 0;
		for(int i=0;i<N;i++) {
			HashSet<Integer> intList = new HashSet<>();
			for(int j=0;j<N;j++) {
				intList.add(matrix[i][j]);
				if(intList.size() != j+1) {
					count++;
					break;
				}
			}
		}
		return count;
	}
	
	public static int getcollmnWiseDuplicateCount(int[][] matrix,int N) {
		int count = 0;
		for(int i=0;i<N;i++) {
			HashSet<Integer> intList = new HashSet<>();
			for(int j=0;j<N;j++) {
				intList.add(matrix[j][i]);
				if(intList.size() != j+1) {
					count++;
					break;
				}
			}
		}
		return count;
	}
	
	public static long getSumOfMainDiagonal(int[][] matrix,int N) {
		long sum = 0;
		for(int i=0;i<N;i++) {
			sum = sum + matrix[i][i];
		}
		return sum;
	}

}