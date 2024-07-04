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
			int[][] times = new int[n][4];
			for (int a = 0; a < n; a++) {
				times[a][0] = in.nextInt();
				times[a][1] = in.nextInt();
				times[a][2] = a;
				times[a][3] = 0;
				in.nextLine();
			}
			
			
			
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
			
			times[0][3] = 1;
			int currentTime = times[0][1];
			
			for (int a = 1; a < n; a++) {
				if (times[a][0] >= currentTime) {
					times[a][3] = 1;
					currentTime = times[a][1];
				}
			}
			currentTime = -1;
			boolean possible = true;
			for (int a = 1; a < n; a++) {
				if (times[a][3] == 0) {
					if (currentTime > times[a][0])
						possible = false;
					currentTime = times[a][1];
				}
			}
			
			Arrays.sort(times, new Comparator<int[]>() {
			    @Override
			    public int compare(int[] o1, int[] o2) {
			        if (o1[2] < o2[2])
			        	return -1;
			        if (o1[2] > o2[2])
			        	return 1;
			        return 0;
			    }
			});
			
			
			
			System.out.print("Case #" + (i+1) + ": ");
			if (possible) {
				
				for (int a=0; a < n; a++) {
					if (times[a][3] == 0) 
						System.out.print("J");
					else
						System.out.print("C");
				}
				System.out.println();
			}
			else
				System.out.println("IMPOSSIBLE");
		}

	}
}	
