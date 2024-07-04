import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
		try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
			String line = bufferedReader.readLine();
			final int numberOfCases = Integer.parseInt(line);

			for (int c = 1; c <= numberOfCases; c ++) {
				line = bufferedReader.readLine();
				final int size = Integer.parseInt(line);

				final int[][] matrix = new int[size][size];
				for (int i = 0; i < size; i ++) {
					final String row = bufferedReader.readLine();
					final String[] lineParts = row.split(" ");
					for (int j = 0; j < size; j++) {
						final String value = lineParts[j];
						matrix[i][j] = Integer.parseInt(value);
					}
				}
				int rows = 0;
				int columns = 0;
				for (int i = 0; i < size; i ++) {
					boolean[] viewed1 = new boolean[size+1];
					for (int col = 0; col < size; col ++) {
						int value = matrix[i][col];
						if (viewed1[value]) {
							rows ++;
							break;
						}
						viewed1[value] = true;
					}
					boolean[] viewed2 = new boolean[size+1];
					for (int row = 0; row < size; row ++) {
						int value = matrix[row][i];
						if (viewed2[value]) {
							columns ++;
							break;
						}
						viewed2[value] = true;
					}
				}
				int trace = 0;
				for (int i = 0; i < size; i ++) {
					trace += matrix[i][i];
				}
				System.out.println("Case #" + c + ": " + trace + " " + rows + " " + columns);
			}
		}
    }
}
