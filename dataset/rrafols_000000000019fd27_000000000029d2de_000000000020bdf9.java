import java.io.File;
import java.util.Scanner;

public class Solution {
	private static final String IMPOSSIBLE = "IMPOSSIBLE";
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

        int numTestCases = sc.nextInt();
        sc.nextLine();
        
        for(int i = 0; i < numTestCases; i++) {
        	int N = sc.nextInt(); sc.nextLine();
        	int[] S = new int[N];
        	int[] E = new int[N];
        	
        	for(int j = 0; j < N; j++) {
        		S[j] = sc.nextInt();
        		E[j] = sc.nextInt();
        		sc.nextLine();
        	}
        	
        	System.out.println("Case #" + (i + 1) + ": " + solve(N, S, E));
        }
	}
	
	private static boolean allocTime(int[] d, int i, int j) {
		for(int k = i; k < j; k++) {
			if(d[k] != 0) return false;
		}
		
		for(int k = i; k < j; k++) {
			d[k] = 1;
		}
		return true;
	}
	
	private static String solve(int N, int[] S, int[] E) {
		StringBuilder sb = new StringBuilder();
		
		int mins = 24 * 60;
		int[] Cb = new int[mins];
		int[] Jb = new int[mins];
		
		for(int i = 0; i < mins; i++) {
			Cb[i] = 0;
			Jb[i] = 0;
		}
		
		for(int i = 0; i < N; i++) {
			if(allocTime(Cb, S[i], E[i])) {
				sb.append('C');
			} else if(allocTime(Jb, S[i], E[i])) {
				sb.append('J');
			} else {
				return IMPOSSIBLE;
			}
		}
		
		return sb.toString();
	}
}