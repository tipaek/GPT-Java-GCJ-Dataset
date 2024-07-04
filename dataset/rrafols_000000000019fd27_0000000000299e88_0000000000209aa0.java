import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class Solution {
	private static final String IMPOSSIBLE = "IMPOSSIBLE";
	private static final String POSSIBLE = "POSSIBLE";
	
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
        	int N = sc.nextInt();
        	int K = sc.nextInt(); sc.nextLine();
        	
        	System.out.println("Case #" + (i + 1) + ": " + solve(N, K));
        }
	}

	private static HashSet<String> combinations = new HashSet<String>();
	private static void findSums(int[] array, int k, int n, int s, int it) {
		if(s == n && k == it) {
			
			int[] dup = new int[it];
			System.arraycopy(array, 0, dup, 0, it);
			Arrays.sort(dup);
			StringBuilder sb = new StringBuilder();
			
			for(int i = 0; i < it; i++) sb.append(dup[i]);
			
			String str = sb.toString();
			if(!combinations.contains(str)) {
				combinations.add(str);
			}
		}
		
		if(s > n) return;
		if(k > it) return;
		
		for(int i = 1; i <= Math.min(n - s, it); i++) {
			array[k] = i;
			findSums(array, k + 1, n, s + i, it);
		}
	}
	
	private static void printMatrix(int N, int[] matrix) {
		StringBuilder sb = new StringBuilder();
		printMatrix(N, matrix, sb);
		System.out.println(sb.toString());
	}
	
	private static void printMatrix(int N, int[] matrix, StringBuilder sb) {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				sb.append(matrix[i * N + j]);
				if(j != N - 1) sb.append(" ");
			}
			if(i != N - 1) sb.append("\n");
		}
	}
	
	private static String solve(int N, int K) {
	    return IMPOSSIBLE;
	}
}