import java.util.*;
import java.io.*;
import java.lang.reflect.Array;
import java.math.BigInteger;

import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.util.Collections.*;
 
public class Solution{
    static final long mod=1000000007;
//    static int dx[]={-1,0,1,0};
//    static int dy[]={0,-1,0,1};
    public  static void main(String[] args)   throws Exception, IOException{        
        Reader sc = new Reader(System.in);
        PrintWriter out=new PrintWriter(System.out);
        
//For gcj
        int T=sc.nextInt();
        
        for (int i = 0; i < T; i++) {
        	int n=sc.nextInt(), tr=0;
        	int d[][]=new int[n][n];
        	for (int j = 0; j < d.length; j++) {
				d[j] = sc.nextIntArray(n);
			}
        	for (int j = 0; j < d.length; j++) {
				tr+=d[j][j];
			}
        	int r=0,c=0;
        	boolean u[]=new boolean[n];
        	
        	for (int j = 0; j < d.length; j++) {
        		fill(u,false);
        		for (int t = 0; t < u.length; t++) {
        			if(u[d[j][t]-1]) {r++;break;}
        			u[d[j][t]-1] = true;
				}
        		fill(u,false);
        		for (int t = 0; t < u.length; t++) {
        			if(u[d[t][j]-1]) {c++;break;}
        			u[d[t][j]-1] = true;
				}
        		fill(u,false);
			}

        	out.println("Case #"+(i+1)+": "+(tr) + " " +r+ " " +c);
            out.flush();
            
        }

    }
    
    static boolean validpos(int x,int y,int r, int c){
        return x<r && 0<=x && y<c && 0<=y;
    }

    static void db(Object... os){
        System.err.println(Arrays.deepToString(os));
    }

	static class Reader
	{ 
	    private BufferedReader x;
	    private StringTokenizer st;
	    
	    public Reader(InputStream in)
	    {
	        x = new BufferedReader(new InputStreamReader(in));
	        st = null;
	    }
	    public String nextString() throws IOException
	    {
	        while( st==null || !st.hasMoreTokens() )
	            st = new StringTokenizer(x.readLine());
	        return st.nextToken();
	    }
	    public int nextInt() throws IOException
	    {
	        return Integer.parseInt(nextString());
	    }
	    public int[] nextIntArray(int size) throws IOException{
	    	int r[] = new int[size];
	    	for (int i = 0; i < size; i++) {
				r[i] = this.nextInt(); 
			}
	    	return r;
	    }
	    public long[] nextLongArray(int size) throws IOException{
	    	long r[] = new long[size];
	    	for (int i = 0; i < size; i++) {
				r[i] = this.nextLong(); 
			}
	    	return r;
	    }
	    public long nextLong() throws IOException
	    {
	        return Long.parseLong(nextString());
	    }
	    public double nextDouble() throws IOException
	    {
	        return Double.parseDouble(nextString());
	    }
	}
}


//class P implements Comparable<P>{
//    int id,T;
//    P(int id, int T) {
//        this.id=id;
//        this.T=T;
//    }
//    public int compareTo(P p){
//        return id-p.id; //des
//    }
//}
