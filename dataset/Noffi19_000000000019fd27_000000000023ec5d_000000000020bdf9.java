import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

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
		int n = Integer.parseInt(reader.readLine());
		boolean[] cOccupied = new boolean[1441];
		boolean[] jOccupied = new boolean[1441];
		String ret = "";
		for (int j = 0; j < n; j++) {
			boolean cDoesIt = true;
			boolean jDoesIt = true;
			String line = reader.readLine();
			String[] startEnd = line.split(" ");
			int start = Integer.parseInt(startEnd[0]);
			int end = Integer.parseInt(startEnd[1]);

			for (int k = start; k < end; k++) {
				if (cOccupied[k]) {
					cDoesIt = false;
				}
			}
			if (cDoesIt) {
				for (int k = start; k < end; k++) {
					cOccupied[k] = true;
				}
				ret += "C";
			}
			if (!cDoesIt) {
				for (int k = start; k < end; k++) {
					if (jOccupied[k]) {
						ret = "IMPOSSIBLE";
						jDoesIt = false;
						break;
					}
				}
				if (jDoesIt) {
					for (int k = start; k < end; k++) {
						jOccupied[k] = true;
					}
					ret += "J";
				}
			}
			if (ret.equals("IMPOSSIBLE")) {
				break;
			}
		}

		writer.write("Case #" + i + ": " + ret + "\r\n");
	}
}

