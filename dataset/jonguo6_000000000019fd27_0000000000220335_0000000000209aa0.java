import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int tests = Integer.parseInt(in.nextLine());
		for(int test=1;test<=tests;test++) {
			String[] input = in.nextLine().split(" ");
			int n = Integer.parseInt(input[0]);
			int k = Integer.parseInt(input[1]);
			if(k%n!=0) {
				System.out.println("Case #"+test+": IMPOSSIBLE");
				continue;
			}
			int[][] matrix = new int[n][n];
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					matrix[i][j] = (i-j+2*n)%n+1;
				}
			}
			int swaptimes = (k-n)/n;
			int swaprow2 = n-1-swaptimes;
			int[][] nmatrix = new int[n][n];
			for(int i=0;i<n;i++) {
				int rowindex = i;
				if(i == swaprow2) rowindex = n-1;
				else if(i > swaprow2) rowindex = i-1;
				for(int j=0;j<n;j++) {
					nmatrix[i][j] = matrix[rowindex][j];
				}
			}
			System.out.println("Case #"+test+": POSSIBLE");
			for(int i=0;i<n;i++) {
				String print = "";
				for(int j=0;j<n;j++) {
					print = print + nmatrix[i][j] + " ";
				}
				print = print.substring(0,print.length()-1);
				System.out.println(print);
			}
		}
		in.close();
	}
}