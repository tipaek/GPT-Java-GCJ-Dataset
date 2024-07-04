import java.util.Scanner;


public class Solution {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		scan.nextLine();
		
		int [] ans = new int[T * 3];
		
		for(int i = 0; i < T * 3; i += 3) {
			int trace = 0;
			int rowCount = 0;
			int colCount = 0;
			int N = scan.nextInt();
			
			int [][] occuredRow = new int[N][N];
			int [][] occuredCol = new int[N][N];
			
			int [] rowFlag = new int [N];
			int [] colFlag = new int [N];

			int [][] arr = new int [N][N];
			
			for (int j = 0; j < N; j++) {
				rowFlag[j] = 0;
				colFlag[j] = 0;
				for(int l = 0; l < N; l++) {
					occuredRow[j][l] = 0;
					occuredCol[j][l] = 0;
				}
			}
			
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					
					arr[j][k] = scan.nextInt();
					
					if(rowFlag[j] != 1 && occuredRow[j][arr[j][k] - 1] == 1) {
						rowCount++;
						rowFlag[j] = 1;
					}
					else
						occuredRow[j][arr[j][k] - 1] = 1;
					
					if(colFlag[k] != 1 && occuredCol[arr[j][k] - 1][k] == 1) {
						colCount++;
						colFlag[k] = 1;
					}
					else
						occuredCol[arr[j][k] - 1][k] = 1;
					
					if (k == j)
						trace += arr[j][k];
				}
			}
			
			ans[i] = trace;
			ans[i + 1] = rowCount;
			ans[i + 2] = colCount;
		}
		scan.close();
		for(int i = 0; i < 3 * T; i += 3) {
			System.out.println("Case #" + i + ": " + ans[i] + " " + ans[i+1] + " " + ans[i+2]);
		}
	}
}