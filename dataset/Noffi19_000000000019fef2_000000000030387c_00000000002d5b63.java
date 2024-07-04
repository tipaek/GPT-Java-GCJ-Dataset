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
		int[] line = Arrays.stream(reader.readLine().split(" "))
				.mapToInt(Integer::parseInt).toArray();
		int testCount = line[0];
		for (int i = 1; i <= testCount; i++) {
			solve(i, reader, w, line[1], line[2]);
		}
		w.close();
	}

	public static void solve(int i, BufferedReader reader,
			OutputStreamWriter writer, int A, int B)
			throws NumberFormatException, IOException {

		String response = "";
		boolean done = false;
		for (int x = -5; x <= 5; x++) {
			if (done) {
				break;
			} else if (!done) {
				for (int y = -5; y <= 5; y++) {
					if (Math.sqrt((double) (x * x + y * y)) <= 5) {
						writer.write("" + x + " " + y);
						writer.flush();
						response = reader.readLine();
						if (response.equals("CENTER")) {
							done = true;
							break;
						}
					}
				}
			}
		}
	}
}