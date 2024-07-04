import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Solution {

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		OutputStream outputStream = System.out;
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		OutputStreamWriter w = new OutputStreamWriter(outputStream, "UTF-8");
		int testCount = Integer.parseInt(reader.readLine());
		for (int i = 1; i <= testCount; i++) {
			solve(i, reader, w);
		}
		w.close();
	}

	public static void solve(int i, BufferedReader reader,
			OutputStreamWriter writer) throws NumberFormatException,
			IOException {
		int r = 0;
		int c = 0;
		int[] line = Arrays.stream(reader.readLine().split(" "))
				.mapToInt(Integer::parseInt).toArray();
		r = line[0];
		c = line[1];
		int[][] floor = new int[r][c];

		for (int j = 0; j < r; j++) {
			int[] row = Arrays.stream(reader.readLine().split(" "))
					.mapToInt(Integer::parseInt).toArray();
			for (int k = 0; k < c; k++) {
				floor[j][k] = row[k];
			}
		}
		int ret = 0;
		int lastLevel = 0;
		int newLevel = 0;
		do {
			int[][] newFloor = new int[r][c];
			ret += newLevel;
			lastLevel = newLevel;
			newLevel = 0;
			for (int x = 0; x < r; x++) {
				for (int y = 0; y < c; y++) {
					if (floor[x][y] > 0) {
						newLevel += floor[x][y];
						double toBeat = getAvgSkill(floor, x, y);
						if (floor[x][y] >= toBeat) {
							newFloor[x][y] = floor[x][y];
						}
					}
				}
			}
			floor = newFloor.clone();
		} while (!(newLevel == lastLevel));

		writer.write("Case #" + i + ": " + ret + "\r\n");
	}

	public static double getAvgSkill(int[][] floor, int row, int col) {
		int no = 1;
		int sum = floor[row][col];
		if (row > 0) {
			for (int i = row - 1; i >= 0; i--) {
				if (floor[i][col] > 0) {
					sum += floor[i][col];
					no++;
					break;
				}
			}
		}
		if (col > 0) {
			for (int i = col - 1; i >= 0; i--) {
				if (floor[row][i] > 0) {
					sum += floor[row][i];
					no++;
					break;
				}
			}
		}
		if (row < floor.length - 1) {
			for (int i = row + 1; i < floor.length; i++) {
				if (floor[i][col] > 0) {
					sum += floor[i][col];
					no++;
					break;
				}
			}
		}
		if (col < floor[0].length - 1) {
			for (int i = col + 1; i < floor[row].length; i++) {
				if (floor[row][i] > 0) {
					sum += floor[row][i];
					no++;
					break;
				}
			}
		}
		return sum / (double) no;
	}
}