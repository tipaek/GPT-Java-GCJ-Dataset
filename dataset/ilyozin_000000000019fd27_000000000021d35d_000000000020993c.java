import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		InputStream stream = Solution.class.getName().equals("year2020.qr.task1.Solution") ?
				new FileInputStream("C:\\Users\\One\\eclipse-workspace\\Test\\src\\year2020\\qr\\task1\\in.txt") :
					System.in;
		try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(stream)))) {
			int T = in.nextInt();

			for (int t = 1; t <= T; t++) {
				int N = in.nextInt();
				int[][] matrix = new int[N][N];
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						matrix[i][j] = in.nextInt();
					}
				}
				
				int k = 0;
				for (int i = 0; i < N; i++) {
					k += matrix[i][i];
				}
				
				int r = 0;
				boolean[] cells = new boolean[N + 1];
				for (int i = 0; i < N; i++) {
					for (int j = 0; j <= N; j++) {
						cells[j] = false;
					}
					
					for (int j = 0; j < N; j++) {
						int val = matrix[i][j];
						if (cells[val]) {
							r++;
							break;
						}
						cells[val] = true;
					}
				}
				
				int c = 0;
				for (int j = 0; j < N; j++) {
					for (int i = 0; i <= N; i++) {
						cells[i] = false;
					}
					
					for (int i = 0; i < N; i++) {
						int val = matrix[i][j];
						if (cells[val]) {
							c++;
							break;
						}
						cells[val] = true;
					}
				}

				System.out.println("Case #" + t + ": " + k + ' ' + r + ' ' + c);
			}
		}
	}
}
