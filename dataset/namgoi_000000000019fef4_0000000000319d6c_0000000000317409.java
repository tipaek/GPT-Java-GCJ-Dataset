import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int testcase = 1; testcase <=T; testcase++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			String str = st.nextToken();
			int[][] dest = new int[str.length()+1][2];
			int[] pur = new int[] {x,y};
			dest[0]= new int[] {pur[0],pur[1]};
			for (int i = 0; i < str.length(); i++) {
				char m = str.charAt(i);
				if(m=='S') {
					pur[1]--;
				}else if (m=='N'){
					pur[1]++;
				}else if (m=='E'){
					pur[0]--;
				}else if (m=='W'){
					pur[0]++;
				}
				dest[i+1]= new int[] {pur[0],pur[1]};
			}
			ArrayDeque<int[]> q = new ArrayDeque<int[]>();
			q.add(new int[] {0,0,0});
			int answer =-1;
			while(!q.isEmpty()) {
				int[] cur = q.poll();
				if(cur[2]>=dest.length) break;
				if(cur[0]==dest[cur[2]][0] && cur[1]==dest[cur[2]][1]) {
					answer = cur[2];
					break;
				}
				q.add(new int[] {cur[0]+1,cur[1]  ,cur[2]+1});
				q.add(new int[] {cur[0]-1,cur[1]  ,cur[2]+1});
				q.add(new int[] {cur[0]  ,cur[1]+1,cur[2]+1});
				q.add(new int[] {cur[0]  ,cur[1]-1,cur[2]+1});
				q.add(new int[] {cur[0]  ,cur[1]  ,cur[2]+1});
			}
			if(answer==-1) {
				System.out.println("Case #"+testcase+": IMPOSSIBLE" );
			}else {
				System.out.println("Case #"+testcase+": "+answer );
			}
			
		}
	}
	/*
5
4 4 SSSS
3 0 SNSS
2 10 NSNNSN
0 1 S
2 7 SSSSSSSS
*/
}