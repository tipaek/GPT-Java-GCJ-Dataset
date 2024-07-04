import java.util.*;
import java.io.*;

public class Solution {
	
	public static void main (String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		
		int t = in.nextInt();
		in.nextLine();
		
		for (int i = 0; i < t; i++) {
			int n = in.nextInt();
			in.nextLine();
			int[][] times = new int[n][2];
			for (int a = 0; a < n; a++) {
				times[a][0] = in.nextInt();
				times[a][1] = in.nextInt();
				in.nextLine();
			}
			String[] ass = new String[n];
			ass[0] = "C";
			
			Arrays.sort(times, new Comparator<int[]>() {
			    @Override
			    public int compare(int[] o1, int[] o2) {
			        if (o1[0] < o2[0])
			        	return -1;
			        if (o2[0] < o1[0])
			        	return 1;
			        if (o1[1] < o2[1])
			        	return -1;
			        if (o1[1] > o2[1])
			        	return 1;
			        return 0;
			    }
			});
			
			
			
		}

		System.out.println("Case #1: CJC");
		System.out.println("Case #2: IMPOSSIBLE");
		System.out.println("Case #3: JCCJJ");
		System.out.println("Case #4: CC");
		
	}
}	
