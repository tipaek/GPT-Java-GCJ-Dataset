import java.io.*;
import java.util.*;

public class Solution {
	static class Work implements Comparable<Work>{
		int start;
		int end;
		int idx;
		
		public Work(int i, int s, int e) {
			this.idx = i;
			this.start = s;
			this.end = e;
		}
		
		@Override
		public int compareTo(Work o) {
			return this.start > o.start ? 1 : -1;
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t<=T; t++) {
			int N = Integer.parseInt(br.readLine());
			
			Work[] arr = new Work[N];
			
			for(int i = 0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken()) -1;
				arr[i] = new Work(i, start, end);
			}
			
			Arrays.sort(arr);
			boolean ispos = true;
			int worker1 = 0;
			int worker2 = 0;
			int start1 = -1;
			int start2 = -1;
			int end1 = -1;
			int end2 = -1;
			int[] ans = new int[N];
			for(int i = 0; i<N; i++) {
				Work w = arr[i];
				
				if(end1 <w.start) {
					worker1 = 0;
				}
				if(end2 < w.start) {
					worker2 = 0;
				}
				
				if(worker1 == 0) {
					worker1 = 1;
					start1 = w.start;
					end1 = w.end;
					ans[w.idx] = 1;
				}
				else if(worker2 == 0) {
					worker2 = 1;
					start2 = w.start;
					end2 = w.end;
					ans[w.idx] = 2; 
				}
				else {
					ispos = false;
					break;
				}
			}
			
			if(!ispos) {
				bw.write("Case #" + t + ": IMPOSSIBLE\n");
			}
			else {
				bw.write("Case #" + t + ": ");
				for(int i = 0; i<N; i++) {
					if(ans[i] == 1) {
						bw.write("C");
					}
					else {
						bw.write("J");
					}
				}
				if(t != T) {
					bw.newLine();
				}
			}
			
		}
		
		
		bw.flush();
		br.close();
		bw.close();
	}
}


