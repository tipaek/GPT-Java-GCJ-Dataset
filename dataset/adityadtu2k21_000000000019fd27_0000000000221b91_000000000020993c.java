// package CodeJamQualifier;

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
			int n =scn.nextInt();
			
			boolean[] rows = new boolean[n];
			boolean[] cols = new boolean[n];
			
			HashSet<Integer>[] rs = new HashSet[n];
			HashSet<Integer>[] cs = new HashSet[n];
			
			long trace = 0;
			
			for(int i =0;i<n;i++) {
				for(int j = 0;j<n;j++) {
					int sv = scn.nextInt();
					if(i==j) {
						trace+=sv;
					}
					if(rs[i]==null) {
						rs[i] = new HashSet<Integer>();
					}
					if(cs[j]==null) {
						cs[j] = new HashSet<Integer>();
					}
					
					if(rs[i].contains(sv)) {
						rows[i]=true;
					}else {
						rs[i].add(sv);
					}
					if(cs[j].contains(sv)) {
						cols[j]=true;
					}else {
						cs[j].add(sv);
					}
				}
			}
			long r = 0;
			for(int i =0;i<n;i++)
				if(rows[i])
					r++;
			long c = 0;
			for(int i=0;i<n;i++)
				if(cols[i])
					c++;
			
			System.out.println("Case #"+t+": "+trace+" "+r+" "+c);
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
