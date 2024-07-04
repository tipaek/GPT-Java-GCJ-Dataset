import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		long bound = 1000000000;
		long diameter = 1000000000;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter writer = new PrintWriter(System.out);
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		int t = Integer.parseInt(tokenizer.nextToken());
		// these constants don't really matter as long as they're greater than or equal to 1e9 / 2
		//int a = Integer.parseInt(tokenizer.nextToken());
		//int b = Integer.parseInt(tokenizer.nextToken());
		for (int tt = 0; tt < t; tt++) {
			long left = -bound;
			long right = bound;
			long top = -bound;
			long bottom = bound;
			while (true) {
				long rangeX = right - left;
				long rangeY = bottom - top;
				long quarterX = (rangeX + 3L) / 4L; // round up
				long quarterY = (rangeY + 3L) / 4L;
				long midX = left + rangeX / 2L;
				long midY = top + rangeY / 2L;

				long newLeft = left;
				long newRight = right;
				long newTop = top;
				long newBottom = bottom;
				String a = query(reader, writer, left + quarterX, midY);
				if (a.equals("CENTER")) {
					break;
				}
				if (a.equals("WRONG")) {
					throw new IllegalStateException("a: " + (left + quarterX) + " " + midY);
				}
				boolean hitA = a.equals("HIT");
				if (hitA) {
					newRight = left + quarterX + diameter;
				}
				String b = query(reader, writer, right - quarterX, midY);
				if (b.equals("CENTER")) {
					break;
				}
				if (b.equals("WRONG")) {
					throw new IllegalStateException("b: " + (right - quarterX) + " " + (midY));
				}
				boolean hitB = b.equals("HIT");
				if (hitB) {
					newLeft = right - quarterX - diameter;
				}
				String c = query(reader, writer, midX, top + quarterY);
				if (c.equals("CENTER")) {
					break;
				}
				if (c.equals("WRONG")) {
					throw new IllegalStateException("c: " + (midX) + " " + (top + quarterY));
				}
				boolean hitC = c.equals("HIT");
				if (hitC) {
					newBottom = top + quarterY + diameter;
				}
				String d = query(reader, writer, midX, bottom - quarterY);
				if (d.equals("CENTER")) {
					break;
				}
				if (d.equals("WRONG")) {
					throw new IllegalStateException("d: " + (midX) + " " + (bottom - quarterY));
				}
				boolean hitD = d.equals("HIT");
				if (hitD) {
					newTop = bottom - quarterY - diameter;
				}
				top = newTop;
				bottom = newBottom;
				left = newLeft;
				right = newRight;
				if (hitA && hitB && hitC && hitD) {
					if (query(reader, writer, midX, midY).equals("CENTER")) {
						break;
					}
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
