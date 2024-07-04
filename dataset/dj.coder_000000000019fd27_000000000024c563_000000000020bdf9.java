import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	
	// interval data
	class Data {
		int start, end;
		int idx;
		char cj;
		
		Data(int start, int end, int idx) {
			this.start = start;
			this.end = end;
			this.idx = idx;
		}
	}
	
	List<Data> intervals;
	
	public Solution(int N) {
		intervals = new ArrayList<>(N);
	}
	
	// add intervals
	void add(int start, int end) {
		int idx = intervals.size();
		intervals.add(new Data(start, end, idx));
	}
	
	// solution
	String solve() {
		// sort data (based on start time) to find disjoint set
		Collections.sort(intervals, new Comparator<Data>() {
			@Override
			public int compare(Data i1, Data i2) {
				int c = Integer.valueOf(i1.start).compareTo(Integer.valueOf(i2.start));
				if(c == 0) {
					// based on index
					return Integer.valueOf(i1.idx).compareTo(Integer.valueOf(i2.idx));
				} else {
					return c;
				}
			}
		});
		
		int cend = 0, jend = 0;
		boolean f = true;
		// find two disjoint sets
		for(Data interval : intervals) {
			int start = interval.start;
			int end = interval.end;
			if(start >= cend) {
				// C
				interval.cj = 'C';
				cend = end;
			} else if(start >= jend) {
				// J
				interval.cj = 'J';
				jend = end;
			} else {
				// not possible
				f = false;
				break;
			}
		}
		
		if(f) {
			// now update C/J according to their index
			char sequence[] = new char[intervals.size()];
			for(Data interval : intervals) {
				sequence[interval.idx] = interval.cj;
			}
			return String.valueOf(sequence);
		} else {
			// not possible
			return "IMPOSSIBLE";
		}
	}
	
	static final String NEW_LINE = System.getProperty("line.separator");
	
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(reader.readLine());
		int tc = 0;
		StringBuilder out = new StringBuilder();
		while(++tc <= T) {
			int N = Integer.parseInt(reader.readLine());
			Solution driver = new Solution(N);
			for(int i = 0; i < N; i++) {
				StringTokenizer tokens = new StringTokenizer(reader.readLine());
				int start = Integer.parseInt(tokens.nextToken());
				int end = Integer.parseInt(tokens.nextToken());
				driver.add(start, end);
			}
			// solution
			String sequence = driver.solve();
			out.append("Case #").append(tc).append(": ").append(sequence).append(NEW_LINE);
		}
		System.out.println(out);
		
		reader.close();
	}
}