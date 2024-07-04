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
		for(int t =1;t<=tc;t++) {
			int n = scn.nextInt();
			int k = scn.nextInt();
			
			if(k%n==0) {
				System.out.println("Case #"+t+": POSSIBLE");
				int diag = k/n;
				
				int[] arr = new int[n];
				for(int i =0;i<n;i++) {
					arr[i] = (diag+i)%n+1;
				}
				
				for(int i =0;i<n;i++) {
					for(int j = 0;j<n;j++) {
						System.out.print(arr[(j-i)>=0?(j-i):(j-i+n)%n]+" ");
					}
					if(i<n-1)
						System.out.println();
				}
			}else if(n%2==0&&k==(n*(n+1))/2){
				Integer[][] mat = new Integer[n][n];
				HashSet<Integer>[] rows = new HashSet[n];
				HashSet<Integer>[] cols = new HashSet[n];
				for(int i =0;i<n;i++) {
					mat[i][i]=i+1;
					rows[i] = new HashSet<Integer>();
					cols[i] = new HashSet<Integer>();
					rows[i].add(i+1);
					cols[i].add(i+1);
				}
				
				boolean res = find(mat,n,n*(n-1),0,1, rows, cols);
				if(res) {
					System.out.println("Case #"+t+": POSSIBLE");
					for(int i =0;i<n;i++) {
						for(int j =0;j<n;j++) {
							System.out.print(mat[i][j]+" ");
						}
						if(i!=n-1) {
							System.out.println();
						}
					}
				}else {
					System.out.println("Case #"+t+": IMPOSSIBLE");
				}
			}else {
				System.out.println("Case #"+t+": IMPOSSIBLE");
			}
		}
	}
	private static boolean find(Integer[][] mat, int n, int rem,int cr,int cc, HashSet<Integer>[] rows, HashSet<Integer>[] cols) {
		// TODO Auto-generated method stub
		if(mat[cr][cc]!=null) {
			if(cc<n-1) {
				cc++;
			}else if(cr<n-1&&cc==n-1) {
				cr++;
				cc=0;
			}else {
				return true;
			}
		}
		
		for(int i = 1;i<=n;i++) {
			if(rows[cr].contains(i)||cols[cc].contains(i)) {
				continue;
			}else {
				rows[cr].add(i);
				cols[cc].add(i);
				mat[cr][cc] = i;
				int tr, tc;
				if(cc==n-1&&cr<n-1) {
					tr =cr+1;
					tc = 0;
				}else if(cc==n-1&&cr==n-1){
					return true;
				}else {
					tr = cr;
					tc = cc+1;
				}
				boolean res = find(mat, n,rem-1, tr,tc,rows,cols);
				if(res) {
					return true;
				}
				mat[cr][cc]=null;
				rows[cr].remove(i);
				cols[cc].remove(i);
			}
		}
		return false;
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
