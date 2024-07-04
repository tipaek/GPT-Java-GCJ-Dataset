import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
	public static void main (String[] args)	throws java.lang.Exception{
		FastReader sc = new FastReader();
		OutputStream out = new BufferedOutputStream ( System.out );
		int t = sc.nextInt();
        int c = 1;
		while(c <= t) {
		    int n = sc.nextInt();
            int a[][] = new int[n][n];
            for(int i = 0; i<n; i++) {
                for(int j = 0; j<n; j++) {
                    a[i][j] = sc.nextInt();
                }
            }
            int row = 0, col = 0, trace = 0;
            for(int i = 0; i<n; i++) {
                int dp[] = new int[n+1];
                Arrays.fill(dp, 0);
                for(int j = 0; j<n; j++) {
                    dp[a[i][j]]++;
                    if(i == j) {
                        trace += a[i][j];
                    }
                }
                for(int k = 0; k<=n; k++) {
                    if(dp[k] > 1) {
                        row++;
                        break;
                    }
                }
            }
            for(int i = 0; i<n; i++) {
                int dp[] = new int[n+1];
                Arrays.fill(dp, 0);
                for(int j = 0; j<n; j++) {
                    dp[a[j][i]]++;
                }
                for(int k = 0; k<=n; k++) {
                    if(dp[k] > 1) {
                        col++;
                        break;
                    }
                }
            }
            System.out.println("Case #"+c+": "+trace+" "+row+" "+col);
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