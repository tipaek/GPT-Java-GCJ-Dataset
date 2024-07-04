import java.util.*;
import java.lang.*;
import java.io.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		FastReader s = new FastReader();
		int t = s.nextInt();
		
		for(int z = 1;z<=t;z++) {
			int n = s.nextInt();
			int[][] arr = new int[n][n];
			
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					arr[i][j] = s.nextInt();
				}
			}
			
			int trace = 0;
			
			for(int i=0;i<n;i++) {
				trace += arr[i][i];
			}
			
			int rc = 0;
			for(int i=0;i<n;i++) {
				HashSet<Integer> set = new HashSet<>();
				for(int j=0;j<n;j++) {
					if(set.contains(arr[i][j])) {
						rc++;
						break;
					}
					
					else {
						set.add(arr[i][j]);
					}
				}
			}
			
			int cc = 0;
			for(int i=0;i<n;i++) {
				HashSet<Integer> set = new HashSet<>();
				for(int j=0;j<n;j++) {
					if(set.contains(arr[j][i])) {
						cc++;
						break;
					}
					
					else {
						set.add(arr[j][i]);
					}
				}
			}
			
			System.out.println("Case #"+z+": "+trace+" "+rc+" "+cc);
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
