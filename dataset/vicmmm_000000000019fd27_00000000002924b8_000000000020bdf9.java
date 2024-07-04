import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String fst = reader.readLine();
		int T = Integer.parseInt(fst);

		StringBuffer sb = new StringBuffer();
		
		Comparator<int[]> comp = new Comparator<int[]>(){
			@Override
			public int compare(int[] p1, int[] p2) {
				int diff = p1[0]-p2[0];
				if(diff==0) return p1[1]-p2[1];
				return diff;
			}
		};
		
		
		for(int i=0;i<T;i++) {
			String s = reader.readLine();
			int n = Integer.parseInt(s);
			
			int[][] events = new int[n*2][2]; // each events[k] is {time, index}
			
			for(int k=0;k<n;k++) {
				String str = reader.readLine();
				String[] ss = str.split(" ");
				
				int[] start = new int[2];
				start[0] = Integer.parseInt(ss[0]);
				start[1] = k;
				
				int[] end = new int[2];
				end[0] = Integer.parseInt(ss[1]);
				end[1] = -k-1;
				
				events[2*k] = start;
				events[2*k+1] = end;
			}
			
			Arrays.sort(events, comp);
			
			boolean C = true, J = true; // whether available
			
//			int cnt = 0;
			String[] arrange = new String[n];
			String arr = "";
			
			for(int j=0;j<2*n;j++) {
				int[] event = events[j];
				int time = event[0], idx = event[1];
				
				if(idx>=0) { // start event
					
					if(C) {
						arrange[idx] = "C";
						C = false;
					}
					else if(J) {
						arrange[idx] = "J";
						J = false;
					}
					else {
						arr = "IMPOSSIBLE";
						break;
					}
				}
				else { // end event
					idx = -idx-1;
					if(arrange[idx].equals("C")) C = true;
					else if(arrange[idx].equals("J")) J = true;
				}
			}
			
			if(arr.equals("")) for(int j=0;j<n;j++) arr += arrange[j];
			
			sb.append("Case #"+(i+1)+": "+arr+"\n");
		}
		
		System.out.println(sb.toString());
	}
	

}
