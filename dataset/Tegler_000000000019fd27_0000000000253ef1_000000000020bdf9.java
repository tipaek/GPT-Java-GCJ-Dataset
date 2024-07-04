

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(scan.readLine());

		outer: for (int casen = 1; casen <= t; casen++) {
			StringBuilder sb = new StringBuilder();
			int n = Integer.parseInt(scan.readLine());
			int co = Integer.MIN_VALUE;
			int jo = Integer.MIN_VALUE;
			boolean pos = true;
			boolean[] resp = new boolean[n];
			Trip[] tasks = new Trip[n];
			for (int i = 0; i < n; i++) {
				String[] inp = scan.readLine().split(" ");
				int start = Integer.parseInt(inp[0]);
				int end = Integer.parseInt(inp[1]);
				 Trip te = new Trip();
				 te.s = start;
				 te.e = end;
				 te.ind = i;
				 tasks[i] = te;
			}
			
			Arrays.sort(tasks);
			
			for (int i = 0; i < n; i++) {
				
				int start =	tasks[i].s;
				int end = tasks[i].e;

				if (co <= start) {
					resp[tasks[i].ind] = true;
					co = end;
				} else {
					if (jo <= start) {
						resp[tasks[i].ind] = false;
						jo = end;
					} else {
						System.out.println("Case #" + casen + ": IMPOSSIBLE");
						pos = false;
					}
				}
			}
			if (pos) {
				
				for(int i = 0; i<n;i++){
					if(resp[i]){
						sb.append("C");
					} else {
						sb.append("J");
					}
				}
				
				System.out.println("Case #" + casen + ": " + sb);
			}

		}

	}
	
	public static class Trip implements Comparable<Trip>{
		int ind, s,e;
		public Trip(){
			
		}
		@Override
		public int compareTo(Trip o) {
			if(s != o.s){
				return s - o.s;
			}else if(e != o.e){
				return e - o.e;
			} else{
				return ind - o.ind; 
			} 
			
		}
	}

}
