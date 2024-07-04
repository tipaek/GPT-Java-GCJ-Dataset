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
		    String s = in.next();
		    StringBuilder sb = new StringBuilder();
		    int n = s.length();
		    int prev = s.charAt(0) - '0';
		    int open = 0;
		    for(int j = 0; j < prev; j++){
		        sb.append('(');
		        open++;
		    }
		    sb.append(s.charAt(0));
		    int val = 0;
		    for(int i = 1; i < n; i++){
		        char ch = s.charAt(i);
		        val = ch - '0';
		        if(val == prev){
		            sb.append(ch);
		            continue;
		        } else if(prev > val){
		            for(int j = 0; j < (prev - val); j++){
		                sb.append(')');
		            }
		            sb.append(ch);
		        } else if(val > prev){
		            for(int j = 0; j < (val - prev); j++){
		                sb.append('(');
		            }
		            sb.append(ch);
		        }
		        prev = val;
		    }
		    for(int i = 0; i < prev; i++){
		        sb.append(')');
		    }
		    System.out.println("Case #" + k + ": " + sb.toString());
		}
	}
}
