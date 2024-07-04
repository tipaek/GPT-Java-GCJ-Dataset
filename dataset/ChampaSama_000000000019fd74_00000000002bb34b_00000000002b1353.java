import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) {
		int testCases;
		try {
			testCases = Integer.parseInt(br.readLine());
			for (int cases = 0; cases < testCases; cases++) {
				int sum = Integer.parseInt(br.readLine());
				int n = sum;
				int[][] arr = new int[n][n];

				for (int line = 0; line < n; line++) {
					for (int i = 0; i <= line; i++) {
						if (line == i || i == 0)
							arr[line][i] = 1;
						else
							arr[line][i] = arr[line - 1][i - 1] + arr[line - 1][i];
					}
				}
				System.out.println("Case #" + (cases + 1) + ": ");
				boolean flag = false;
				abc:
				for(int i = 0; i < n; i++) {
					if (flag) {
						for (int j = 0; j < n; j++) {
							if (arr[i][j] != 0) {
								sum = sum - 1;
								System.out.println((i + 1) + " " + (j + 1));
							}
							if (sum <= 0) {
								break abc;
							}
						} 
					}
					else {
						for(int j = n-1; j >= 0; j--) {
							if(arr[i][j] != 0) {
								sum = sum-1;
								System.out.println((i+1)+" "+(j+1));
							}
							if(sum <= 0) {
								break abc;
							}
						}
					}
					flag = flag ? false : true;
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
