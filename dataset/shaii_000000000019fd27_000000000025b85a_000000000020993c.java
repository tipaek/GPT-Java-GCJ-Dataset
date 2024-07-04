import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(
				System.in)));
		int testCasesNum = scanner.nextInt();
		for (int i = 1; i <= testCasesNum; i++) {
			int K = 0,R = 0,C = 0;
			int N = scanner.nextInt();
			int[][] colVals = new int[N][N];
			for (int j = 0; j < N; j++){
				int[] vals = new int[N];
				for (int k = 0; k < N; k++){
					int nij = scanner.nextInt();
					vals[nij - 1]++;
					colVals[k][nij - 1]++;
					if (k == j)
						K += nij;
				}
				for (int l = 0; l < N; l++) {
					if (vals[l] == 0){
						R++;
						break;
					}
				}
			}
			for (int j = 0; j < N; j++) {
				for (int l = 0; l < N; l++){
					if (colVals[j][l] == 0){
						C++;
						break;
					}
				}
			}
			System.out.println("Case #" + i + ": " + K + " " + R + " " + C);
		}
		try{
			scanner.close();
		}
		catch (Exception e){}
		System.out.flush();
	}
}
