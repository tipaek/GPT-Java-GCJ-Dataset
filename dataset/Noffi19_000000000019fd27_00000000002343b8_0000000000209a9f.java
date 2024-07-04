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
		String s = reader.readLine();
		String ret = "";
		int open = 0;
		for (int j = 0; j < s.length(); j++) {
			int number = Integer.parseInt(String.valueOf(s.charAt(j)));
			while (open > number) {
				ret += ")";
				open--;
			}
			while (open < number) {
				ret += "(";
				open++;
			}
			ret += number;
		}
		while (open > 0) {
			ret += ")";
			open--;
		}
		writer.write("Case #" + i + ": " + ret + "\r\n");
	}
}
