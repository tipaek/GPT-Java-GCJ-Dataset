import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	
	public static void main(String[] args) throws IOException {
		MyScanner sc = new MyScanner();
		PrintWriter out = new PrintWriter(System.out);
		int numberOfCases = sc.nextInt();
		for (int caze = 1; caze <= numberOfCases; caze++) {
			int N = sc.nextInt();
			List<Event> events = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				int s = sc.nextInt();
				int e = sc.nextInt();
				events.add(new Event(s, true, i));
				events.add(new Event(e, false, i));
			}
			Collections.sort(events);
			char[] ret = new char[N];
			boolean freeC = true, freeJ = true;
			boolean can = true;
			for (int i = 0; i < 2 * N && can; i++) {
				Event e = events.get(i);
				if (e.start) {
					if (freeC) {
						ret[e.id] = 'C';
						freeC = false;
					} else if (freeJ) {
						ret[e.id] = 'J';
						freeJ = false;
					} else can = false;
				} else {
					if (ret[e.id] == 'C') freeC = true;
					else freeJ = true;
				}
			}
			out.println("Case #" + caze + ": " + (can ? new String(ret) : "IMPOSSIBLE"));
			
			out.flush();
		}
	}
	
	static class Event implements Comparable<Event> {
		int time, id;
		boolean start;
		
		public Event(int time, boolean start, int id) {
			this.time = time;
			this.start = start;
			this.id = id;
		}
		
		@Override public int compareTo(Event o) {
			int cmp = Integer.compare(time, o.time);
			if (cmp != 0) return cmp;
			if (start != o.start) return !start ? -1 : 1;
			return 0;
		}
	}
	
	static class MyScanner {
		private BufferedReader br;
		private StringTokenizer tokenizer;
		
		public MyScanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		
		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					tokenizer = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return tokenizer.nextToken();
		}
		
		public int nextInt() {
			return Integer.parseInt(next());
		}
		
		public long nextLong() {
			return Long.parseLong(next());
		}
	}
}
