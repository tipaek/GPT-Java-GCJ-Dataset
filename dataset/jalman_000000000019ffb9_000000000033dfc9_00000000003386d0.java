import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int tt = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    Loop: for (int qq = 1; qq <= tt; ++qq) {
		int n = in.nextInt();
		
		long[] x = new long[n];
		long[] y = new long[n];
		for(int i = 0; i < n; i++) {
			x[i] = in.nextLong();
			y[i] = in.nextLong();
		}
		
		int best = 1;
		
		List<Integer> all = new ArrayList<Integer>();
		for(int i = 0; i < n; i++) all.add(i);
		
		for(int a = 0; a < n; a++) for(int b = a+1; b < n; b++) {
			long slopey = y[a] - y[b];
			long slopex = x[a] - x[b];
			
			Collections.sort(all,new Comparator<Integer>(){ public int compare(Integer ss, Integer tt) {long val = (x[ss]-x[tt])*slopey - (y[ss]-y[tt])*slopex;
			
			if(val == 0) return 0;
			if(val > 0) return 1;
			return -1;} });
			
			int cur = 1;
			int[] count = new int[102];
			
			int bigodd = 0;
			int smallodd = 0;
			
			Arrays.fill(count,0);
			
			for(int i = 1; i < n; i++) {
				int atnow = all.get(i);
				int atlast = all.get(i-1);
				
				if((y[atnow]-y[atlast])*slopex == (x[atnow]-x[atlast])*slopey) {
					cur++;
				} else {
					count[cur]++;
					if(cur%2 == 1 && cur>1) bigodd++;
					if(cur == 1) smallodd++;
					
					cur = 1;
				}
			}
			count[cur]++;
			if(cur%2 == 1 && cur>1) bigodd++;
			if(cur == 1) smallodd++;
			
			bigodd %= 2;
			int ret = 0;
			if(bigodd+smallodd > 1) ret = n - (bigodd+smallodd)+2;
			else ret = n;
			
			if(ret > best) {
				//System.out.println(ret + " " + slopex + " " + slopey + " " + count[1] + " " + count[2] + " " + count[3]);
				best = ret;
			}
			
		}
		

		System.out.println("Case #" + qq + ": " + best);

	  
    }
  }
}