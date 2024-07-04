import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t<=T; t++) {
			int N = Integer.parseInt(br.readLine());
			
			int[] cnt = new int[1440];
			String[] ans = new String[N];
			ArrayList<Integer>[] assign = new ArrayList[1440];
			for(int i = 0; i<1440; i++) {
				assign[i] = new ArrayList<>();
			}
			
			boolean ispos = true;
			outer:
			for(int i = 0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken()) -1;
				
				for(int j = start; j<=end; j++) {
					assign[j].add(i);
					if(++cnt[j] >= 3) {
						ispos = false;
						break outer;
					}
				}
			}
			if(!ispos) {
				bw.write("Case #" + t + ": IMPOSSIBLE\n");
			}
			else {
				for(int i = 0; i<1440; i++) {
					if(cnt[i] == 1) {
						if(ans[assign[i].get(0)] == null) {
							ans[assign[i].get(0)] = "C";
						}
					}
					else if(cnt[i] == 2) {
						int work1 = assign[i].get(0);
						int work2 = assign[i].get(1);
						String p1 = ans[work1];
						String p2 = ans[work2];
						
						if(p1 == null && p2 == null) {
							ans[work1] = "C";
							ans[work2] = "J";
						}
						else if(p1 == null) {
							if(p2.equals("C")) {
								ans[work1] = "J";
							}
							else {
								ans[work1] = "C";
							}
						}
						else if(p2 == null) {
							if(p1.equals("C")) {
								ans[work2] = "J";
							}
							else {
								ans[work2] = "C";
							}
						}
					}
				}
				bw.write("Case #" + t + ": ");
				for(int i = 0; i<N; i++) {
					bw.write(ans[i]);
				}
				bw.newLine();
				
			}
			
		}
		
		
		bw.flush();
		br.close();
		bw.close();
	}
}


