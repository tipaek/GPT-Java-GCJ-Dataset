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
        for (int i = 0; i < T; i++) {
        	int x=sc.nextInt();
        	int y=sc.nextInt();
            int ans=100,v=0;
        	int s=1<<16;
        	for (int t = 0,j ; t < s; t++) {
        		int xx=0,yy=0;
        		j=t;
				for (int w = 0; w < 20; w++) {
					if(j%4==0)xx+=1<<w;
					else if(j%4==1)xx-=1<<w;
					else if(j%4==2)yy+=1<<w;
					else yy-=1<<w;
					j/=4;
					if(w<ans && xx==x && yy==y) {
						ans=w+1;
						v=t;
						break;
					}
				}
			}
        	String res="IMPOSSIBLE";
        	if(ans!=100) {
        		res="";
//        		db(v);
        		int xx=0,yy=0;
				for (int w = 0; w < 20; w++) {
					if(v%4==0) {res+="E"; xx+=1<<w;}
					else if(v%4==1){res+="W";xx-=1<<w;}
					else if(v%4==2){res+="N";yy+=1<<w;}
					else {res+="S";yy-=1<<w;}
					v/=4;
					if(xx==x && yy==y) {
						break;
					}
				}
        	}
        	out.println("Case #"+(i+1)+": "+ res);
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