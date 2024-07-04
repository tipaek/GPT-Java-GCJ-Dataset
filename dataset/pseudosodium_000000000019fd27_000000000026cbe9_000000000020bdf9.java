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
    static boolean overlap(Interval o1, Interval o2){
        if((o1.end <= o2.start && o2.end > o1.start) || (o2.end <= o1.start && o2.start < o1.end)){
            return false;
        }
        return true;
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
		    ArrayList<Interval> c = new ArrayList<>();
		    ArrayList<Interval> j = new ArrayList<>();
		    sb.append('C');
		    c.add(a[0]);
		    for(int i = 1; i < n; i++){
		        boolean ok = true;
		        for(Interval ivl : c){
		            if(overlap(a[i], ivl)){
		                ok = false;
		                break;
		            }
		        }
		        if(ok){
		            sb.append('C');
		            c.add(a[i]);
		            continue;
		        }
		        
		        ok = true;
		        
		        for(Interval ivl : j){
		            if(overlap(a[i], ivl)){
		                ok = false;
		                break;
		            }
		        }
		        if(ok){
		            sb.append('J');
		            j.add(a[i]);
		        } else {
		            sb = new StringBuilder("IMPOSSIBLE");
		            break;
		        }
		    }
		    System.out.println("Case #" + k +": " + sb.toString());
		}
	}
}
