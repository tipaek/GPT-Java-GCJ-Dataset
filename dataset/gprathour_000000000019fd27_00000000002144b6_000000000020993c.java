import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

	private static String calc(int matrix[][]) {
		int sum = 0;
		int rRows = 0;
		int rCols = 0;
		Map<Integer, Integer> rMap = new HashMap<>();
		Map<Integer, Integer> cMap = new HashMap<>();
		for (int i = 0; i < matrix.length; i++) {
			sum += matrix[i][i];
			boolean checkRows = true;
			boolean checkCols = true;
			for (int j = 0; j < matrix[i].length; j++) {
				if(checkRows) {
					if (rMap.containsKey(matrix[i][j])) {
						int count = rMap.get(matrix[i][j]);
						if (count == 1) {
							rRows++;
							checkRows = false;
						}
						count++;
						rMap.put(matrix[i][j], count);
					} else {
						rMap.put(matrix[i][j], 1);
					}
				}
				if(checkCols) {
					if (cMap.containsKey(matrix[j][i])) {
						int count = cMap.get(matrix[j][i]);
						if (count == 1) {
							rCols++;
							checkCols = false;
						}
						count++;
						cMap.put(matrix[j][i], count);
					} else {
						cMap.put(matrix[j][i], 1);
					}	
				}
			}
			rMap.clear();
			cMap.clear();
		}
		return sum + " " + rRows + " " + rCols;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 1; i <= T; i++) {
			int N = sc.nextInt();
			int matrix[][] = new int[N][N];
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					matrix[j][k] = sc.nextInt();
				}
			}
			System.out.println("Case #" + i + ": " + calc(matrix));
		}
	}
}