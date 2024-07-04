
import java.io.IOException;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {

		int T, N, i, j, diaSum = 0, rowDup = 0, ColDup = 0;
		StringBuffer match = new StringBuffer();
		
		Scanner br = new Scanner(System.in);
		T = br.nextInt();
		for (int k = 1; k <= T; k++) {
			diaSum = 0; rowDup = 0; ColDup = 0;
			
			N = br.nextInt();
			int arr[][] = new int[N][N];
			
			for (i = 0; i < N; i++) {
				boolean flag= false;
				match.delete(0, match.length());
				for (j = 0; j < N; j++) {
					arr[i][j] = br.nextInt();
					if (i == j && i <= j) {
						diaSum += arr[i][j];
					}
					if (match.indexOf("," + arr[i][j] + ",") != -1) {
						flag = true;
					}
					match.append(arr[i][j] + ",");
				}
				if(flag)
					rowDup++;
				
			}
			for (i = 0; i < N; i++) {
				match.delete(0, match.length());
				for (j = 0; j < N; j++) {
					if (match.indexOf("," + arr[j][i] + ",") != -1) {
						ColDup++;
						break;
					}
					match.append("," + arr[j][i] + ",");
					
				}
			}
			System.out.println("Case #" + k + ": " + diaSum + " " + rowDup + " " + ColDup);
		}
		
	}

}

