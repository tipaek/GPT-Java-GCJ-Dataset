import java.util.*;
import java.io.*;
public class Solution {
	static int[] allStarts;
	static int[] allEnds;
	static int nai; // next available index
	static char[] result;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 1; i <= t; ++i) {
			int n = in.nextInt();
			int[] CameronSchedule = new int[24*60+1];
			int[] JamieSchedule = new int[24*60+1];
			
			allStarts = new int[n];
			allEnds = new int[n];
			nai = 0;
			result = new char[n];
			StringBuffer sb = new StringBuffer();
			
			boolean hasThree = false;
			
			
			for(int j = 1; j <= n; j++) {
				int start = in.nextInt(); // start time of the activity
				int end   = in.nextInt(); // end   time of the activity
				allStarts[nai] = start;
				allEnds[nai] = end;
				nai++;
				
				for(int k = start+1; k <= end; k++) {
					CameronSchedule[k] += 1;
				}
			}
			
			/*
			for(int val : CameronSchedule) {
				System.out.print(val);
			}System.out.println();
			*/
			
			for (int j = 0; j <= 24 * 60; j++) {
				if(CameronSchedule[j] == 3) {
					hasThree = true;
				}
			}
			if(hasThree) {
				System.out.println("Case #" + i + ": IMPOSSIBLE");
				continue;
			}
			
			for (int j = 0; j <= 24 * 60; j++) {
				if(CameronSchedule[j] == 2) {
					int subtractUntil = getEnd(j-1);
					for(int k = j; k <= subtractUntil; k++) {
						CameronSchedule[k] -= 1;
						JamieSchedule[k] += 1;
					}
				}
			}
			
			/*
			for(int val : CameronSchedule) {
				System.out.print(val);
			}System.out.println();
			
			for(int val : JamieSchedule) {
				System.out.print(val);
			}System.out.println();
			*/
			
			for (int j = 0; j < n; j++) {
				if(result[j] == 'J') {
					sb.append('J');
				}else {
					sb.append('C');
				}
			}
	
			System.out.println("Case #" + i + ": " + sb.toString().trim());
			
		}
	}
	static int getEnd(int start) {
		for(int i = 0; i < nai; i++) {
			if(allStarts[i] == start) {
				result[i] = 'J';
				return allEnds[i];
			}
		}return 0;
	}
}