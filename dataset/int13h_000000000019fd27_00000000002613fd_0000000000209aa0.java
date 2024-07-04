import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		init();
		
		solve();
	}
	
	private static HashMap<String, String> cache = new HashMap<String, String>();

	private static void solve() {
		
		
		
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

		int t = sc.nextInt();
		
		for (int i2 = 1; i2 <= t; i2++) {

			int n = sc.nextInt();
			int k = sc.nextInt();
			String r = solution(n,k);
			if (r != null) {
				System.out.println("Case #" + i2 + ": POSSIBLE");
				System.out.print(r);
			} else {
				System.out.println("Case #" + i2 + ": IMPOSSIBLE");
			}
			
		}
		sc.close();
	}

	private static String genTable(int[][] r) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < r.length; i++) {
			for (int j = 0; j < r.length; j++) {
				sb.append(r[i][j]);
				if (j != r.length-1) {
					sb.append(" ");
				}
			}
			sb.append("\n");
		}
		return sb.toString();
	}
	
	private static void init() {
		for (int n = 2; n <= 5; n++) {
			int r[][] = null;
			if (n == 2) {
				r = new int [][] {{1,2}, {2,1}};
				gen(r);
			}
			if (n == 3) {
				r = new int [][] {{1,2,3}, {2,3,1}, {3, 1, 2}};
				gen(r);
			}
			if (n == 4) {
				r = new int [][] {{1,2,3,4}, {2,1,4,3}, {3,4,1,2},{4,3,2,1}};
				gen(r);
				r = new int [][] {{1,2,3,4}, {2,4,1,3}, {3,1,4,2},{4,3,2,1}};
				gen(r);
			}
			if (n == 5) {
				r = new int [][] {{1,2,3,4,5}, {2,3,5,1,4}, {3,5,4,2,1},{4,1,2,5,3}, {5,4,1,3,2}};
				gen(r);
				r = new int [][] {{1,2,3,4,5}, {2,4,1,5,3}, {3,5,4,2,1},{4,1,5,3,2}, {5,3,2,1,4}};
				gen(r);
			}			
		}
		
		/*
		Set<String> keySet = cache.keySet();
		ArrayList<String> keys = new ArrayList<String>(keySet);
		Collections.sort(keys);
		System.out.println(keys);
		
		System.out.println(cache.keySet().size());
		*/
		
	}

	private static String solution(int n, int k) {
		boolean valid = (k >= n) && (k <= n*n); 
		if (!valid) {
			return null;
		}
		if (n > 5) {
			return null;
		}
		String key = ""+n+"_"+k;
		return cache.get(key);
	}



	private static int trace(int[][] a) {
		int s = 0;
		for (int i = 0; i < a.length; i++) {
			s += a[i][i];
		}
		return s;
	}
	
	private static int traceR(int[][] a, int[] perm) {
		int s = 0;
		for (int i = 0; i < a.length; i++) {
			s += a[perm[i]][i];
		}
		return s;
	} 
	
	private static int traceC(int[][] a, int[] perm) {
		int s = 0;
		for (int i = 0; i < a.length; i++) {
			s += a[i][perm[i]];
		}
		return s;
	} 
	
	private static int traceV(int[][] a, int[] perm) {
		int s = 0;
		for (int i = 0; i < a.length; i++) {
			s += perm[a[i][i]-1]+1;
		}
		return s;
	} 

	private static void gen(int[][] r) {
		int n = r.length;
		
		int perm[] = new int [n];
		for (int i = 0; i < perm.length; i++) {
			perm[i] = i;
		}
		permute(perm, 0, r);
		
	}

	public static void swap(int[] arr, int i, int j)
	{
	    int tmp = arr[i];
	    arr[i] = arr[j];
	    arr[j] = tmp;
	}

	public static void permute(int[] perm, int i, int[][] r)
	{
	    if (i == perm.length)
	    {
	    	usePerm(perm, r);
	        return;
	    }
	    for (int j = i; j < perm.length; j++)
	    {
	        swap(perm, i, j); 
	        permute(perm, i + 1, r);  
	        swap(perm, i, j);      
	    }
	}

	private static void usePerm(int[] perm, int[][] r) {
		int kR = traceR(r, perm);
		
		int n = perm.length;
		String key = ""+n+"_"+kR;
		if (!cache.containsKey(key)) {
			cache.put(key, permR(r, perm));
		}
		
		int kC = traceC(r, perm);
		key = ""+n+"_"+kC;
		if (!cache.containsKey(key)) {
			cache.put(key, permC(r, perm));
		}
		
		//System.out.println(Arrays.toString(perm) + " " + kR + " " + kC);
	}

	private static String permR(int[][] r, int[] perm) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < r.length; i++) {
			for (int j = 0; j < r.length; j++) {
				sb.append(r[perm[i]][j]);
				if (j != r.length-1) {
					sb.append(" ");
				}
			}
			sb.append("\n");
		}
		return sb.toString();
	}
	
	private static String permC(int[][] r, int[] perm) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < r.length; i++) {
			for (int j = 0; j < r.length; j++) {
				sb.append(r[i][perm[j]]);
				if (j != r.length-1) {
					sb.append(" ");
				}
			}
			sb.append("\n");
		}
		return sb.toString();
	}


}
