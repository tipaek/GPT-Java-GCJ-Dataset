import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		long bound = 2000000000;
		long diameter = 1000000000;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter writer = new PrintWriter(System.out);
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		int t = Integer.parseInt(tokenizer.nextToken());
		// these constants don't really matter as long as they're greater than 1e9 / 2
		//int a = Integer.parseInt(tokenizer.nextToken());
		//int b = Integer.parseInt(tokenizer.nextToken());
		for (int tt = 0; tt < t; tt++) {
			long left = 0;
			long right = bound;
			long top = 0;
			long bottom = bound;
			while (true) {
				long rangeX = right - left;
				long rangeY = bottom - top;
				long quarterX = (rangeX + 3) / 4; // round up
				long quarterY = (rangeY + 3) / 4;
				long midX = left + rangeX / 2;
				long midY = top + rangeY / 2;
				String a = query(reader, writer, left + quarterX, midY);
				if (a.equals("CENTER")) {
					break;
				}
				if (a.equals("WRONG")) {
					throw new IllegalStateException();
				}
				boolean hitA = a.equals("HIT");
				if (hitA) {
					right = left + quarterX + diameter;
					continue;
				}
				String b = query(reader, writer, right - quarterX, midY);
				if (b.equals("CENTER")) {
					break;
				}
				if (b.equals("WRONG")) {
					throw new IllegalStateException();
				}
				boolean hitB = b.equals("HIT");
				if (hitB) {
					left = right - quarterX - diameter;
					continue;
				}
				String c = query(reader, writer, midX, top + quarterY);
				if (c.equals("CENTER")) {
					break;
				}
				if (c.equals("WRONG")) {
					throw new IllegalStateException();
				}
				boolean hitC = c.equals("HIT");
				if (hitC) {
					bottom = top + quarterY + diameter;
					continue;
				}
				String d = query(reader, writer, midX, bottom - quarterY);
				if (d.equals("CENTER")) {
					break;
				}
				if (d.equals("WRONG")) {
					throw new IllegalStateException();
				}
				boolean hitD = d.equals("HIT");
				if (hitD) {
					top = bottom - quarterY - diameter;
					continue;
				}
			}
		}

	}
	public static String query(BufferedReader reader, PrintWriter writer, long a, long b) throws Exception {
		writer.println(a + " " + b);
		writer.flush();
		return reader.readLine();
	}
}
