import java.util.*;
import java.io.*;

public class Solution {
	final static int MOD = 1000000007;
	final static int intMax = 1000000000;
	final static int intMin = -1000000000;
	final static int[] DX = { 0, 0, -1, 1 };
	final static int[] DY = { -1, 1, 0, 0 };

	static int T;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		for(int t = 1; t <= T; ++t) {
			System.out.print("Case #" + t + ": ");
			int N = Integer.parseInt(br.readLine());
			event[] events = new event[N];
			for(int i = 0; i != N; ++i) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				events[i] = new event(start, end, i);
			}
			Arrays.sort(events, (a, b) -> a.start - b.start);
			char[] ans = new char[N];
			int C = -1; int J = -1;
			boolean printed = false;
			for(int i = 0; i != N; ++i) {
				int start = events[i].start;
				int end = events[i].end;
				int orig = events[i].ind;
				if(start >= C) {
					C = end;
					ans[orig] = 'C';
				}
				else if(start >= J) {
					J = end;
					ans[orig] = 'J';
				}
				else {
					System.out.print("IMPOSSIBLE");
					printed = true;
					break;
				}
			}
			if(!printed) {
				for(int i = 0; i != N; ++i) {
					System.out.print(ans[i]);
				}
			}
			if(t != T) System.out.println();
		}
		br.close();	
	}
	static class event{
		int start, end, ind;
		event(int s, int e, int i){
			start = s;
			end = e;
			ind = i;
		}
	}
}