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
			int[]starts = new int[j];
			Dictionary endToPosition = new Hashtable();
			for(int i = 0; i < j; i++) {
				StringTokenizer st = new StringTokenizer(cin.readLine());
				int n1 = Integer.parseInt(st.nextToken());
				starts[i] = n1;
				int n2 = Integer.parseInt(st.nextToken());
				endToPosition.put(n2-1, i);
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
			for(int i = 0; i < starts.length; i++) {
				if(times[starts[i]] == 1) ret += 'C';
				if(times[starts[i]] == 2) {
					if(times[starts[i]-1] == 1) ret += 'J';
					else {
						int k = (int) endToPosition.get(starts[i]-1);
						ret += ret.charAt(k);
					}
				}
				/*
				if(times[starts[i]] == 2 && starts[i]-1 > 0 && times[starts[i]-1] == 2) ret += 'C';
				else if(times[starts[i]] == 2) ret += 'J';
				*/
			}
			results[r] = ret;
		}
		for(int i = 0; i < results.length; i++)
			System.out.println("Case #" + (i+1)+ ": " + results[i]);
	}
}
