import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Vestigium {
	private static int[][] matrix = new int[102][102];

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(in.readLine());
		for (int x = 1; x <= t; x++) {
			int n = Integer.parseInt(in.readLine());
			String[] s;
			for (int i = 0; i < n; i++) {
				s = in.readLine().split(" ");
				for (int j = 0; j < n; j++) {
					matrix[i][j] = Integer.parseInt(s[j]);
				}
			}
			int trace = 0;
			for (int i = 0; i < n; i++) trace += matrix[i][i];

			int[] natural = new int[n + 2];
			int rows = 0;
			for (int i = 0; i < n; i++) {
				Arrays.fill(natural, 0);
				for (int j = 0; j < n; j++) {
					if (natural[matrix[i][j]] != 0) {
						rows++;
						break;
					} else {
						natural[matrix[i][j]] = 1;
					}
				}
			}

			int column = 0;
			for (int j = 0; j < n; j++) {
				Arrays.fill(natural, 0);
				for (int i = 0; i < n; i++) {
					if (natural[matrix[i][j]] != 0) {
						column++;
						break;
					} else {
						natural[matrix[i][j]] = 1;
					}
				}
			}

			System.out.println("Case #" + x + ": " + trace + " " + rows + " " + column);
		}
	}
}
