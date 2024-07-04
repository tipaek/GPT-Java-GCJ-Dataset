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
		    ArrayList<Interval> a = new ArrayList<>(n);
		    for(int i = 0; i < n; i++){
		        a.add(new Interval(in.nextInt(), in.nextInt()));
		    }
		    Collections.sort(a, new Comparator<Interval>(){
		        public int compare(Interval o1, Interval o2){
		            return o1.end - o2.end;
		        }
		    });
		    StringBuilder sb = new StringBuilder();
		    sb.append('C');
		    int clast = a.get(0).end;
		    int jlast = 0;
		    boolean ok = true;
		    for(int i = 1; i < n; i++){
		        if(clast <= a.get(i).start){
		            sb.append('C');
		            clast = a.get(i).end;
		        } else if(jlast <= a.get(i).start){
		            sb.append('J');
		            jlast = a.get(i).end;
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
