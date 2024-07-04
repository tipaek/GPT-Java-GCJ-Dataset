import java.io.File;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {
	private static final String IMPOSSIBLE = "IMPOSSIBLE";
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//        
//        try {
//            sc = new Scanner(new File("bin/i2.txt"));
//        } catch(Exception e) {
//            e.printStackTrace();
//            return;
//        }
//        
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
		for(int k = i; k < j; j++) {
			if(d[k] != 0) return false;
		}
		return true;
	}
	
	private static void setBusy(int[] d, int i, int j) {
		for(int k = i; k < j; k++) {
			d[k] = 1;
		}
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
		
//		StringBuilder k = new StringBuilder();
//		for(int i = 0; i < 15; i++) {
//			if(Cb[i] == 1) k.append('C');
//			else k.append('.');
//		}
//		System.out.println(k.toString());
//		
//		k = new StringBuilder();
//		for(int i = 0; i < 15; i++) {
//			if(Jb[i] == 1) k.append('J');
//			else k.append('.');
//		}
//		System.out.println(k.toString());
		
		return sb.toString();
	}
}