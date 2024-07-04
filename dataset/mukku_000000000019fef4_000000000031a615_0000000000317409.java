import java.util.*;
import java.util.Map.Entry;

import javax.swing.text.Segment;
import javax.xml.ws.WebEndpoint;

import java.io.*;
import java.lang.reflect.Array;
import java.math.BigInteger;

import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.util.Collections.*;

public class Solution implements Runnable
{
//    static int dx[]={-1,0,1,0};
//    static int dy[]={0,-1,0,1};
    static long mod=1000000007;
    
    public static void main(String[] args) {        
        new Thread(null, new Solution(), "", 200 * 1024 * 1024).start();        
    }

    public void run() {
        MyReader sc = new MyReader(System.in);
        PrintWriter out=new PrintWriter(System.out);

        int T=sc.nextInt();
        
        lp:
        for (int i = 0; i < T; i++) {
        	int x=sc.nextInt(),y=sc.nextInt();
        	char c[]=sc.getCharSet();
        	int r=1<<28;
        	if(x==0&&y==0)r=0;
        	for (int j = 0; j < c.length; j++) {
				if(c[j]=='E')x+=1;
				else if(c[j]=='W')x-=1;
				else if(c[j]=='N')y+=1;
				else y-=1;
				if(abs(x)+abs(y)<=j+1)r=min(r,max(abs(x)+abs(y),j+1));
//				db(x,y,r);
			}
        	String ans; 
        	if(r==1<<28)ans="IMPOSSIBLE";
        	else ans=""+r;
        	out.println("Case #"+(i+1)+": "+ans );
            out.flush();
            
        }

    }
    
    static void ret(String ans) {
    	System.out.println(ans);
    	System.exit(0);
    }

    static void ret(long ans) {
    	System.out.println(ans);
    	System.exit(0);
    }
    
    static boolean validpos(int x,int y,int r, int c){
        return x<r && 0<=x && y<c && 0<=y;
    }

    static void db(Object... os){
        System.err.println(Arrays.deepToString(os));
    }
}

class Pair implements Comparable<Pair>{
    int l,r,id;
    Pair(int id,int l, int r) {
    	this.id=id;
    	this.r=r;
    	this.l=l;
    }

    public int compareTo(Pair p){
        return this.l-p.l;
    }
}

class MyReader
{ 
    private BufferedReader x;
    private StringTokenizer st;
    
    public MyReader(InputStream in)
    {
        x = new BufferedReader(new InputStreamReader(in));
        st = null;
    }
    public String nextString()
    {
        while( st==null || !st.hasMoreTokens() )
			try {
				st = new StringTokenizer(x.readLine());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        return st.nextToken();
    }
    public int nextInt()
    {
        return Integer.parseInt(nextString());
    }
    public int[] nextIntArray(int size) {
        int r[] = new int[size];
        for (int i = 0; i < size; i++) {
            r[i] = this.nextInt(); 
        }
        return r;
    }
    public long[] nextLongArray(int size) {
        long r[] = new long[size];
        for (int i = 0; i < size; i++) {
            r[i] = this.nextLong(); 
        }
        return r;
    }
    public char[] getCharSet() {
        return this.nextString().toCharArray();
    }    
    public long nextLong()
    {
        return Long.parseLong(nextString());
    }
    public double nextDouble() throws IOException
    {
        return Double.parseDouble(nextString());
    }
}