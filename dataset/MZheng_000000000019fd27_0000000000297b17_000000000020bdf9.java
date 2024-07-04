import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String args[]) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));//FileReader("in.in"));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int cases = Integer.parseInt(st.nextToken());
		for(int c=0; c<cases; c++) {
			st = new StringTokenizer(in.readLine());
			int N = Integer.parseInt(st.nextToken());
			time[] interval = new time[N]; //keeps tracks of intervals
			char[] order = new char[N]; //keeps tracks of the J/C order
			for(int x=0; x<N; x++) {
				st = new StringTokenizer(in.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				interval[x] = new time(x, start, end);
			}
			Arrays.sort(interval);
			int J = 0;
			int C = 0;
			boolean possible = true;
			here:
			for(int x=0; x<N; x++) {
				if(interval[x].start>=J) {
					J = interval[x].end;
					order[interval[x].num] = 'J';
				}
				else if(interval[x].start>=C) {
					C = interval[x].end;
					order[interval[x].num] = 'C';
				}
				else {
					System.out.printf("Case #%d: IMPOSSIBLE\n", c+1);
					possible  = false;
					break here;
				}
			}
			if(possible) {
				String output = "";
				for(char ch:order) output+=ch+"";
				System.out.printf("Case #%d: %s\n", c+1, output);
			}
		}
	}
}

class time implements Comparable<time>{
	int num, start, end;
	public time(int o, int s, int e) {
		num = o;
		start = s;
		end = e;
	}
	public int compareTo(time t) {
		if(start==t.start) {
			return Integer.compare(end, t.end);
		}
		return Integer.compare(start, t.start);
	}
}