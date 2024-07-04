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
        	int d=sc.nextInt(),m=10000;        	
        	ArrayList<String> l[]=new ArrayList[100];
        	String s;
        	for (int j = 0; j < l.length; j++) {
				l[j]=new ArrayList<>();
			}
        	for (int j = 0,k; j < m; j++) {
				k=sc.nextInt();
				s=sc.nextString();
				l[k].add(s);
			}
        	char a[]=new char[10];
        	int c[]=new int[300];
        	fill(a,'?');
        	a[1]=l[1].get(0).charAt(0);
        	c[a[1]-'A']++;
        	for (int j = 2,e; j < 10; j++) {
        		for (int k = 0; k < l[j].size(); k++) {
        			s=l[j].get(k);
        			e=0;
        			char z='x';
					for (int v = 0; v < s.length(); v++) {
						if(c[s.charAt(v)-'A']==0) {
							e++;
							z=s.charAt(v);
						}
					}
					if(e==1) {
						a[j]=z;
						c[z-'A']++;
						break;
					}
				}
			}
        	out:
    		for (int k = 0,e; k < l[10].size(); k++) {
    			s=l[10].get(k);
    			e=0;
    			char z='x';
				for (int v = 0; v < s.length(); v++) {
					if(c[s.charAt(v)-'A']==0) {
						a[0]=s.charAt(v);
						break out;
					}
				}    			
    		}
//        	db(a);
			String r="";
			for (int j = 0; j < a.length; j++) {
				r+=a[j];
			}

        	out.println("Case #"+(i+1)+": "+r );
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