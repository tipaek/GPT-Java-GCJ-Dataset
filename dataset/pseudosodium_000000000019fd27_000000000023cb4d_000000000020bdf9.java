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
    static class Interval{
        int start, end;
        Interval(int s, int e){
            this.start = s;
            this.end = e;
        }
    }
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		FastReader in = new FastReader();
		int t = in.nextInt();
		for(int k = 1; k <= t; k++){
		    int n = in.nextInt();
		    Interval[] a = new Interval[n];
		    for(int i = 0; i < n; i++){
		        a[i] = new Interval(in.nextInt(), in.nextInt());
		    }
		    StringBuilder sb = new StringBuilder();
		    sb.append('C');
		    Interval c = new Interval(a[0].start, a[1].end);
		    Interval j = new Interval(0, 0);
		    boolean ok = true;
		    for(int i = 1; i < n; i++){
		        if((c.start <= a[i].end && c.end <= a[i].start) || (c.start >= a[i].end && c.end >= a[i].start)){
		            sb.append('C');
		            c.start = a[i].start;
		            c.end = a[i].end;
		        } else if((j.start <= a[i].end && j.end <= a[i].start) || (j.start >= a[i].end && j.end >= a[i].start)){
		            sb.append('J');
		            j.start = a[i].start;
		            j.end = a[i].end;
		        } else {
		            ok = false;
		            break;
		        }
		    }
		    if(ok)
		    System.out.println("Case #" + k + ": " + sb.toString());
		    else
		    System.out.println("Case #" + k + ": IMPOSSIBLE");
		}
	}
}
