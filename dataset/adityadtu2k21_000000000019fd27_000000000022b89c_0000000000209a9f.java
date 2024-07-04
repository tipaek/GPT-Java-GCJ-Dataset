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
			String s = scn.next();
			int n = s.length();
			
			int[] pars = new int[n+1];
			
			pars[0] = s.charAt(0)-'0';
			pars[n] = '0'-s.charAt(n-1);
			for(int i=1;i<n;i++) {
				pars[i] = s.charAt(i)-s.charAt(i-1);
			}
			System.out.print("Case #"+t+": ");
			for(int i =0;i<n;i++) {
				if(pars[i]>0) {
					int tms = pars[i];
					while(tms--!=0)
						System.out.print('(');
				}else if(pars[i]<0) {
					int tms = -pars[i];
					while(tms--!=0) {
						System.out.print(')');
					}
				}
				System.out.print(s.charAt(i));
			}
			int tms = pars[n];
			if(tms>0) {
				while(tms--!=0) {
					System.out.print('(');
				}
			}else {
				while(tms++!=0) {
					System.out.print(')');
				}
			}
			System.out.println();
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
