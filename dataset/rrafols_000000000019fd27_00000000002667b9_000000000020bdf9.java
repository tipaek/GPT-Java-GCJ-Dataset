import java.io.File;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {
	private static final String IMPOSSIBLE = "IMPOSSIBLE";
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        
//        try {
//            sc = new Scanner(new File("bin/i.txt"));
//        } catch(Exception e) {
//            e.printStackTrace();
//            return;
//        }
        
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
	
	private static boolean isFree(int[] d, int i, int j) {
		if(d[i] == 1) return false;
		for(int k = i + 1; k <= j; k++) {
			if(d[k] != 0) return false;
		}
		return true;
	}
	
	private static boolean setBusy(int[] d, int i, int j) {
		for(int k = i; k < j; k++) {
			d[k] = 1;
		}
		d[j] = 2;
		
		return true;
	}

	private static String solve(int N, int[] S, int[] E) {
		StringBuilder sb = new StringBuilder();
		
		int mins = 24 * 60 + 1;
		int[] Cb = new int[mins];
		int[] Jb = new int[mins];
		
		for(int i = 0; i < mins; i++) {
			Cb[i] = 0;
			Jb[i] = 0;
		}
		
		for(int i = 0; i < N; i++) {
			if(isFree(Cb, S[i], E[i])) {
				setBusy(Cb, S[i], E[i]);
				sb.append('C');
			} else if(isFree(Jb, S[i], E[i])) {
				setBusy(Jb, S[i], E[i]);
				sb.append('J');
			} else {
				return IMPOSSIBLE;
			}
		}
		
		return sb.toString();
	}
}