// package CJ1A;

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FastReader scn = new FastReader();
		
		int tc = scn.nextInt();
		for(int t = 1;t<=tc;t++) {
			int n = scn.nextInt();
			String res = dfs(1,1,n,"", 0,0, new HashSet<String>());
			System.out.println("Case #"+t+": ");
			System.out.print(res);
		}
	}
	private static String dfs(int i,int j, int n, String asf, int ssf, int lsf, HashSet<String> visited) {
		if(n==ssf&&lsf<=500) {
//			System.out.println(n+" "+ssf+" "+asf);
			return asf+i+" "+j;
		}
		if(n<ssf||lsf>500) {
			return null;
		}
//		if(visited.contains(i+" "+j))
//			return null;
		int[][] dirs = {{0,1},{0,-1},{-1,0},{1,0},{-1,1},{-1,-1},{1,-1},{1,1}};
		int val = binomialCoeff(i,j);
		for(int[] dir: dirs) {
			int in = i+dir[0];
			int jn = j+dir[1];
			if(in>0&&jn>0&&in>=jn&&!visited.contains(in+" "+jn)) {
				visited.add(i+" "+j);
				String temp = dfs(in,jn,n,asf+i+" "+j+"\n",ssf+val, lsf+1, visited);
				visited.remove(i+" "+j);
				if(temp!=null)
					return temp;
			}
		}
		return null;
	}
	static int binomialCoeff(int n, int k) 
    { 
        int C[] = new int[k + 1]; 
         
        // nC0 is 1 
        C[0] = 1;   
       
        for (int i = 1; i <= n; i++) 
        { 
            // Compute next row of pascal  
            // triangle using the previous row 
            for (int j = Math.min(i, k); j > 0; j--) 
                C[j] = C[j] + C[j-1]; 
        } 
        return C[k]; 
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
