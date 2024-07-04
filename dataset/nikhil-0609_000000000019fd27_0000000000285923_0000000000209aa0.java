import java.util.*;
import java.lang.*;
import java.io.*;
class Solution
{
    public static boolean possible_to_fill(int f, int i, int j, int a[][], int n) {
        int row = i, col = j;
        for(int l = 0; l<n; l++) {
            if(a[row][l] == f)
                return false;
        }
        for(int l = 0; l<n; l++) {
            if(a[l][col] == f)
                return false;
        }
        return true;
    }
    public static boolean solve(int a[][], int i, int j, int n, int k) {
        if(i == n-1 && j >= n) {
            int sum = 0;
            for(int l = 0; l<n; l++) {
                for(int m = 0; m<n; m++) {
                    if(l == m) {
                        sum += a[l][m];
                    }
                }
            }
            if(sum == k)
                return true;
            return false;
        }
        if(j >= n) {
            j = 0;
            i += 1;
        }
        int f = 1;
        while(f <= n) {
            if(possible_to_fill(f, i, j, a, n) == true) {
                a[i][j] = f;
                if(solve(a, i, j+1, n, k) == true) {
                    break;
                }
                a[i][j] = 0;
            }
            f++;
        }
        if(f > n) {
            return false;
        }
        return true;
        //return solve(b, i, j+1);
    }
	public static void main (String[] args)	throws java.lang.Exception{
		FastReader sc = new FastReader();
		int t = sc.nextInt();
        int c = 1;
		while(c <= t) {
		    int n = sc.nextInt();
		    int k = sc.nextInt();
		    int a[][] = new int[n][n];
		    boolean ans = solve(a, 0, 0, n, k);
		    if(ans == true) {
		        System.out.println("Case #"+c+": POSSIBLE\n");
		        for(int i = 0; i<n; i++) {
		            for(int j = 0; j<n; j++) {
		                System.out.print(a[i][j]+" ");
                    }
                    System.out.println();
		        }
		    }else {
		        System.out.println("Case #"+c+": IMPOSSIBLE\n");
		    }
            //System.out.println("Case #"+c+": "+sb);
            c++;
		}
	}
	static class FastReader 
    { 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader() 
        { 
            br = new BufferedReader(new
                     InputStreamReader(System.in)); 
        } 
  
        String next() 
        { 
            while (st == null || !st.hasMoreElements()) 
            { 
                try
                { 
                    st = new StringTokenizer(br.readLine()); 
                } 
                catch (IOException  e) 
                { 
                    e.printStackTrace(); 
                } 
            } 
            return st.nextToken(); 
        } 
  
        int nextInt() 
        { 
            return Integer.parseInt(next()); 
        } 
  
        long nextLong() 
        { 
            return Long.parseLong(next()); 
        } 
  
        double nextDouble() 
        { 
            return Double.parseDouble(next()); 
        } 
  
        String nextLine() 
        { 
            String str = ""; 
            try
            { 
                str = br.readLine(); 
            } 
            catch (IOException e) 
            { 
                e.printStackTrace(); 
            } 
            return str; 
        } 
    }
}