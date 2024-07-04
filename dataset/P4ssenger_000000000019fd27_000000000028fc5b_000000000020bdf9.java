import java.util.*;
import java.io.*;
public class PPR2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
		StringBuffer sb = new StringBuffer(); // sb of the resulted schedule
		
		for (int i = 1; i <= t; ++i) {
			
			int n = in.nextInt(); // number of activities on each test
			int[] allStarts = new int[n];
			int[] allEnds = new int[n];
			int[] indexOfBestNextAct = new int[n];
			
			int nai = 0; // next available index
		
			boolean isImpossible = false;
			
			for(int j = 1; j <= n; j++) {
				int start = in.nextInt(); // start time of the activity
				int end   = in.nextInt(); // end   time of the activity
				allStarts[nai] = start;
				allEnds[nai] = end;
				nai++;
			}
			nai--;
			
			for(int j = 0; j <= nai; j++) {
				indexOfBestNextAct[j] = -1;
			}
			
			for(int j = 0; j <= nai; j++) {
				int timeBetween = Integer.MAX_VALUE;
				for(int k = 0; k <= nai; k++) {
					if(allStarts[k] - allEnds[j] >= 0 && allStarts[k] - allEnds[j] < timeBetween) {
						timeBetween = allStarts[k] - allEnds[j];
						indexOfBestNextAct[j] = k;
					}
				}
			}
			
			int SmallestEnd = Integer.MAX_VALUE;
			int indexOfSmallestEnd = 0;
			for(int j = 0; j <= nai; j++) {
				if(allEnds[j] <= SmallestEnd) {
					indexOfSmallestEnd = j;
					SmallestEnd = allEnds[j];
				}
			}
			
			int k = indexOfBestNextAct[indexOfSmallestEnd];
			char[] result = new char[n];
			result[indexOfSmallestEnd] = 'C';
			while(k != -1) {
				result[k] = 'C';
				k = indexOfBestNextAct[k];
			}
			
			int newSmallestEnd = Integer.MAX_VALUE;
			int indexOfNewSmallestEnd = 0;
			for(int j = 0; j <= nai; j++) {
				if(result[j] == 'C') {
					continue;
				}if(allEnds[j] <= newSmallestEnd) {
					indexOfNewSmallestEnd = j;
					newSmallestEnd = allEnds[j];
				}
			}
			
			k = indexOfBestNextAct[indexOfNewSmallestEnd];
			if(result[indexOfNewSmallestEnd] != 'C') { 
				result[indexOfNewSmallestEnd] = 'J';
			}
			while(k != -1) {
				if(result[k] != 'C') {
					result[k] = 'J';
					k = indexOfBestNextAct[k];
				}else {
					break;
				}
			}//result[k]='J';
			
			for(int j = 0; j <= nai; j++) {
				if(result[j] == 'C' || result[j] == 'J') {
					sb.append(result[j]);
				}else {
					isImpossible = true;
				}
			}
			
			if(isImpossible) {
				System.out.println("Case #" + i + ": IMPOSSIBLE");
			}else {
				System.out.println("Case #" + i + ": " + sb.toString());
			}
			
			sb = new StringBuffer();
		}
	}
}