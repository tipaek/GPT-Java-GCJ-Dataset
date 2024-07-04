import java.util.HashSet;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int n = scan.nextInt();



		for(int i = 0; i < n; i++) {
			int dimension = scan.nextInt();
			int[][] arr = new int[dimension][dimension];
			int trace = 0;
			int row = 0; 
			int col = 0;
			HashSet<Integer> hs = new HashSet<Integer>();
			HashSet<Integer> hs1 = new HashSet<Integer>();
			for(int j = 0; j < dimension; j++) {
				for(int k = 0; k < dimension; k++) {
					arr[j][k] = scan.nextInt();

					if(j == k) {
						trace = trace + arr[j][k];
					}

					hs.add(arr[j][k]);
				}

				if(hs.size() != dimension) {
					row = row + 1;	
				}

				hs.removeAll(hs);
			}

			for(int l = 0; l < dimension; l++) {
				for(int m = 0; m < dimension; m++) {
					hs1.add(arr[m][l]);
				}
				if(hs1.size() != dimension) {
					col = col + 1;
				}
				hs1.removeAll(hs1);
			}

			System.out.println("Case #" + (i+1) + ": " + trace + " " + row + " " + col);

		}
	}
}
