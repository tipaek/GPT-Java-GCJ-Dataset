import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String args[]) {
      FastReader sc = new FastReader();
      int t = sc.nextInt();
      int test=0;
      while(t-->0){
          test++;
          int n = sc.nextInt();
          int arr[][] = new int[n][n];
          for(int i=0;i<n;i++){
              for(int j=0;j<n;j++){
                  arr[i][j] = sc.nextInt();
              }
          }
          int r=0;
          int c=0;
          for(int i=0;i<n;i++){
              HashSet<Integer> hs = new HashSet<>();
              for(int j=0;j<n;j++){
                  hs.add(arr[i][j]);
              }
              if(hs.size()!=n){
                  r++;
              }
          }
          for(int j=0;j<n;j++){
              HashSet<Integer> hs = new HashSet<>();
              for(int i=0;i<n;i++){
                  hs.add(arr[i][j]);
              }
              if(hs.size()!=n){
                  c++;
              }
          }
          int ans =0;
          for(int i=0;i<n;i++){
              for(int j=0;j<n;j++){
                  if(i==j){
                     ans += arr[i][j]; 
                  }
              }
          }
          System.out.println("Case #"+test+": "+ans+" "+r+" "+c);
      }
    }
}

class FastReader 
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
				catch (IOException e) 
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

	 	 