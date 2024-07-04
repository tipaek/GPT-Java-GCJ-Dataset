
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;





public class Solution {

	static class Point {

		int start, end;
		int index;

		Point(int start, int end, int index) {
			this.start = start;
			this.end = end;
			this.index = index;
		}

	}

	static int N;

	static ArrayList<Point> p;

	static String sol() {

		char c[] = new char[p.size()];

		int J = 0;
		int C = 0;

		for (Point t : p) {
			if (t.start >= J) {
				J = t.end;
				c[t.index] = 'J';
			} else if (t.start >= C) {
				C = t.end;
				c[t.index] = 'C';
			} else {
				return "IMPOSSIBLE";
			}
		}







		return String.valueOf(c);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine().trim());

		int t = 1;
		while (T-- > 0) {

			

			N = Integer.parseInt(br.readLine().trim());
			p = new ArrayList<>();

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine().trim());

				int start = Integer.parseInt(st.nextToken().trim());
				int end = Integer.parseInt(st.nextToken().trim());

				p.add(new Point(start, end, i));
			}

			Collections.sort(p, new Comparator<Point>() {

				@Override
				public int compare(Point o1, Point o2) {

					return Integer.compare(o1.start, o2.start);
				}

			});

			System.out.println("Case #" + t + ": " + sol());
			t++;
		}
	}

}
