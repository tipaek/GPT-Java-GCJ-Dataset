import java.util.*;
import java.io.*;
import java.math.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		long startTime = System.nanoTime();
		BufferedReader fin = new BufferedReader((new InputStreamReader(System.in)));
		//BufferedReader fin = new BufferedReader((new FileReader("parpar.in")));
		int numtestcases = Integer.parseInt(fin.readLine());
		for (int i = 0; i < numtestcases; i++)
		{
			int n = Integer.parseInt(fin.readLine());
			int[][] activities = new int[n][4];
			for (int j = 0; j < n; j++)
			{
				StringTokenizer t = new StringTokenizer(fin.readLine());
				activities[j][0] = Integer.parseInt(t.nextToken());
				activities[j][1] = Integer.parseInt(t.nextToken());
				activities[j][2] = j;
			}
			java.util.Arrays.sort(activities, new java.util.Comparator<int[]>() {
			    public int compare(int[] a, int[] b) {
			    	if (Integer.compare(a[0], b[0]) == 0)
			    		return Integer.compare(a[1], b[1]);
			    	return Integer.compare(a[0], b[0]);
			    }
			});
			int cend = 0;
			int jend = 0;
			boolean possible = true;
			for (int j = 0; j < n; j++)
			{
				//System.out.println(cend);
				//System.out.println(jend);
				if (cend <= activities[j][0] && jend <= activities[j][0])
				{
					cend = activities[j][1];
					activities[j][3] = 0;
				}
				else if (cend <= activities[j][0])
				{
					cend = activities[j][1];
					activities[j][3] = 0;
				}
				else if (jend <= activities[j][0])
				{
					jend = activities[j][1];
					activities[j][3] = 1;
				}
				else
				{
					possible = false;
					break;
				}
			}
			if (!possible)
			{
				System.out.println("Case #" + (i+1) + ": IMPOSSIBLE");
			}
			else
			{
				System.out.print("Case #" + (i+1) + ": ");
				java.util.Arrays.sort(activities, new java.util.Comparator<int[]>() {
				    public int compare(int[] a, int[] b) {
				    	return Integer.compare(a[2], b[2]);
				    }
				});
				for (int j = 0; j < n; j++)
				{
					if (activities[j][3] == 0)
						System.out.print("C");
					else
						System.out.print("J");
				}
				System.out.println();
			}
		}
		
		long endTime   = System.nanoTime();
		long totalTime = endTime - startTime;
		//System.out.println(totalTime/1000000000.0);	  
	}
	
}
