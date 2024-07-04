import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int tt = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    Loop: for (int qq = 1; qq <= tt; ++qq) {
		int n = in.nextInt();
		int m = in.nextInt();
		
		int[] x = new int[n];
		for(int i = 1; i < n; i++) {
			x[i] = in.nextInt();
		}
		x[0] = 0;
		
		int[] a = new int[m];
		int[] b = new int[m];
		
		int[][] e = new int[n][n];
		int[][] l = new int[n][n];
		int[] at = new int[n];
		Arrays.fill(at,0);
		
		
		for(int i = 0; i < m; i++) {
			a[i] = in.nextInt()-1;
			b[i] = in.nextInt()-1;
			e[a[i]][b[i]] = i;
			e[b[i]][a[i]] = i;
			l[a[i]][at[a[i]]] = b[i];
			at[a[i]]++;
			l[b[i]][at[b[i]]] = a[i];
			at[b[i]]++;
		}
		
		int[] out = new int[m];
		
		Arrays.fill(out,1000000);
		
		List<Integer> all = new ArrayList<Integer>();
		for(int i = 0; i < n; i++) all.add(i);
		Collections.sort(all,new Comparator<Integer>(){ public int compare(Integer ss, Integer tt) {return -x[ss]+x[tt];} });
		
		boolean[] have = new boolean[n];
		Arrays.fill(have,false);
		have[0]=true;
		
		LLLOOP: for(int i = 1; i < n; i++) {
			int j = all.get(i);
			
			for(int k = 0; k < at[j]; k++) {
				int t = l[j][k];
				if(x[t] > x[j]) {
					out[e[t][j]] = x[t]-x[j];
					continue LLLOOP;
				}
			}
		}
		
		
		System.out.print("Case #" + qq + ":");
		for(int i = 0; i < m; i++) System.out.print(" " + out[i]);
		System.out.println();

	  
    }
  }
}