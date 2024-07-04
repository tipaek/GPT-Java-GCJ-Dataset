import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
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
		int n = Integer.parseInt(reader.readLine().trim());
		long k = 0;
		int r = 0;
		int c = 0;

		ArrayList<Integer>[] inCol = new ArrayList[n];
		boolean[] foundInCol = new boolean[n];

		for (int j = 0; j < n; j++) {
			ArrayList<Integer> inRow = new ArrayList<Integer>();
			int[] line = Arrays.stream(reader.readLine().split(" "))
					.mapToInt(Integer::parseInt).toArray();
			k += line[j];
			boolean foundInRow = false;
			for (int index = 0; index < line.length; index++) {
				if (inRow.contains(line[index]) && !foundInRow) {
					r++;
					foundInRow = true;
				} else {
					inRow.add(line[index]);
				}
				if (inCol[index] == null) {
					inCol[index] = new ArrayList<Integer>();
				}
				if (inCol[index].contains(line[index]) && !foundInCol[index]) {
					c++;
					foundInCol[index] = true;
				} else {
					inCol[index].add(line[index]);
				}
			}

		}

		writer.write("Case #" + i + ": " + k + " " + r + " " + c + "\r\n");
	}
}