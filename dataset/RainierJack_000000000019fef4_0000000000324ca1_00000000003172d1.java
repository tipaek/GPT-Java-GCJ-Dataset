import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main (String[] args) {

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in))); 
		PrintStream out = System.out;
		int T = in.nextInt();
			
		for (int t=0; t<T; t++) {
			
			int N = in.nextInt();
			int D = in.nextInt();
			long[] slices = new long[N];
			for (int i=0; i<N; i++) {
				slices[i] = in.nextLong();
			}
			Arrays.sort(slices);
			
			int res = solve(N,D,slices);
			out.println(String.format("Case #%d: %s", t+1, res));
		}
		
		in.close();
	}
	
	public static int solve (int N, int D, long[] slices) {
		
		int min = 2;
		for (int i=0; i<N; i++) {
			long base = slices[i];
			int eq = 0;
			for (int j=i+1; j<N; j++) {
				long tmp = slices[j];
				if (tmp == base)
					eq++;
				if (eq == D-1)
					return 0;
				if (tmp == 2*base)
					min = Math.min(min, 1);
			}
		}
		
		return min;
	}

}
