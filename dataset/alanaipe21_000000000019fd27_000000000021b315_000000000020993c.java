import java.util.Scanner;
public class Solution {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		in.nextLine();
		int[][] matrix = new int[100][100];
		boolean hasoccured[] = new boolean[102];
		for (int i = 0; i < t; i++) {
			int sum = 0;
			int r = 0;
			int c = 0;
			int n = in.nextInt();
			in.nextLine();
			for(int j = 0; j < n; j++) {
				for (int k = 0; k< n; k++) {
					matrix[j][k] = in.nextInt();
					if(j == k) {
						sum += matrix[j][k];
					}
				}
				in.nextLine();
				    
			}
			for(int j = 0; j < n; j++) {
				for(int k = 0; k < 100; k++)
					hasoccured[k] = false;
				for (int k = 0; k < n; k++) {
					if(hasoccured[matrix[j][k]]) {
						r++;
						break;
					} else {
						hasoccured[matrix[j][k]] = true;
					}
				}
				
			}
			for(int j = 0; j < n; j++) {
				for(int k = 0; k < 100; k++)
					hasoccured[k] = false;
				for (int k = 0; k < n; k++) {
					if(hasoccured[matrix[k][j]]) {
						c++;
						break;
					} else {
						hasoccured[matrix[k][j]] = true;
					}
				}
				
			}
			System.out.println("Case #" + (i + 1) + ": " + sum + " " + r + " " + c);
		}
	}
}