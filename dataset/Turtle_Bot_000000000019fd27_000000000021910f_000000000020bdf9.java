import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class FastReader {
	BufferedReader br;
	StringTokenizer st;

	public FastReader() {
		br = new BufferedReader(new InputStreamReader(System.in));
	}

	String next() {
		while(st == null || !st.hasMoreElements()) {
			try {
				st = new StringTokenizer(br.readLine());
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		return st.nextToken();
	}

	int nextInt() {
		return Integer.parseInt(next());
	}

	long nextLong() {
		return Long.parseLong(next());
	}

	double nextDouble() {
		return Double.parseDouble(next());
	}

	String nextLine() {
		String str = "";
		try {
			str = br.readLine();
		} catch(IOException e) {
			e.printStackTrace();
		}
		return str;
	}
}

class TimeSlot implements Comparable {
	public int i, s, e;

	public TimeSlot(int i, int s, int e) {
		this.i = i;
		this.s = s;
		this.e = e;
	}

	@Override
	public int compareTo(Object arg0) {
		TimeSlot other = (TimeSlot) arg0;
		return s - other.s;
	}

	@Override
	public String toString() {
		return s + " - " + e;
	}
}

public class Solution {
	public static void main(String[] args) throws IOException {
		FastReader reader = new FastReader();
		int t = reader.nextInt();
		for(int i = 1; i <= t; i++) {
			boolean impossible = false;
			int n = reader.nextInt();
			int c = 0;
			int j = 0;
			String[] out = new String[n];
			ArrayList<TimeSlot> list = new ArrayList<>();
			for(int i1 = 0; i1 < n; i1++) {
				int s = reader.nextInt();
				int e = reader.nextInt();
				list.add(new TimeSlot(i1, s, e));
			}
			Collections.sort(list);
			for(int i1 = 0; i1 < n; i1++) {
				TimeSlot ts = list.get(i1);
				if(c <= ts.s) {
					out[ts.i] = "C";
					c = ts.e;
				} else if(j <= ts.s) {
					out[ts.i] = "J";
					j = ts.e;
				} else {
					impossible = true;
					break;
				}
			}
			System.out.println(impossible ? "Case #" + i + ": IMPOSSIBLE" : "Case #" + i + ": " + String.join("", out));
		}
	}
}