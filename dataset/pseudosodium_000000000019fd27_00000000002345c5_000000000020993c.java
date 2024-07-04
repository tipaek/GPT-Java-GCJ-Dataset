/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Solution
{
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;
        public FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        String next(){
            while(st == null || !st.hasMoreElements()){
                try{
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        int nextInt(){
            return Integer.parseInt(next());
        }
        long nextLong(){
            return Long.parseLong(next());
        }
        double nextDouble(){
            return Double.parseDouble(next());
        }
        String nextLine(){
            String str = "";
            try{
                str = br.readLine();
            } catch (Exception e){
                e.printStackTrace();
            }
            return str;
        }
    }
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		FastReader in = new FastReader();
		int t = in.nextInt();
		for(int k = 1; k <= t; k++){
		    int n = in.nextInt();
		    int[][] m = new int[n][n];
		    int x = 0;//trace
		    int r = 0, c = 0;
		    for(int i = 0; i < n; i++){
		        Set<Integer> s = new HashSet<>();
		        boolean ok = true;
		        for(int j = 0; j < n; j++){
		            m[i][j] = in.nextInt();
		            if(i == j)  x += m[i][j];
		            if(s.contains(m[i][j]) && ok){
		                r++;
		                ok = false;
		            }
		            s.add(m[i][j]);
		        }
		    }
		    for(int i = 0; i < n; i++){
		        Set<Integer> s = new HashSet<>();
		        boolean ok = true;
		        for(int j = 0; j < n; j++){
		            if(s.contains(m[j][i]) && ok){
		                c++;
		                ok = false;
		            }
		            s.add(m[j][i]);
		        }
		    }
		    
		    System.out.println("Case #" + k + ": " + x + " " + r + " " + c);
		}
	}
}
