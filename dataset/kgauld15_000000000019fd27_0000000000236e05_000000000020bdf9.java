import java.util.*;
import java.io.*;
public class Solution {
	public static void main(String[]args) throws IOException{
		BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(cin.readLine());
		String[] results = new String[N];
		for(int r = 0; r < results.length; r++) {
			boolean works = true;
			String ret = "";
			int [] times = new int[1441];
			int j = Integer.parseInt(cin.readLine());
			int[][]intervals = new int[j][2];
			for(int i = 0; i < j; i++) {
				StringTokenizer st = new StringTokenizer(cin.readLine());
				int n1 = Integer.parseInt(st.nextToken());
				int n2 = Integer.parseInt(st.nextToken());
				intervals[i][0] = n1;
				intervals[i][1] = n2-1;
				for(int k = n1; k < n2; k++) {
					times[k]++;
					if(times[k] == 3) {
						works = false;
						break;
					}
				}
				if(!works) break;
			}
			if(!works) {
				results[r] = "IMPOSSIBLE";
				continue;
			}
			int [] ctime = new int[1441];
			//int [] jtime = new int[1441];
			char [] rr = new char[intervals.length];
			for(int i = 0; i < intervals.length; i++) {
				//System.out.println(times[intervals[i][0]]);
				//printArr(ctime);
				if(times[intervals[i][0]] == 1) {
					rr[i] = 'C';
					
					for(int a = intervals[i][0]; a <= intervals[i][1]; a++)ctime[a] = 1;
				}
				if(times[intervals[i][0]] == 2)
					if(times[intervals[i][0]-1] == 1) rr[i] += 'J';
					else
						if(ctime[intervals[i][0]] == 1) rr[i] += 'J';
						else {
							rr[i] += 'C';
							for(int a = intervals[i][0]; a <= intervals[i][1]; a++)ctime[a] = 1;
						}
				
			}
			
			
			for(char i : rr)
				ret += i;
			results[r] = ret;
		}
		for(int i = 0; i < results.length; i++)
			System.out.println("Case #" + (i+1)+ ": " + results[i]);
	}
	public static void printArr(int[]arr) {
		for(int i : arr)
			System.out.print(i);
		System.out.println();
	}
}