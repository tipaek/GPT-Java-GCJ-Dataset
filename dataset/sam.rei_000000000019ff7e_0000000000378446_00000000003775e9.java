import java.io.*;
import java.util.*;
import java.math.*;
//@SuppressWarnings("unused")
public class Solution {
    static String one() throws Exception{
	rl();
	int n= nin();
	long d = nin();
	
        long[] x = new long[n];
	long[] y = new long[n];
	for(int i=0;i<n;++i){
	    rl();
	    x[i]=nlo();
	    y[i]=nlo();
	}
	if(n!=2)return "not trying";
	long a;
	long b;
	long dist = Math.abs(x[0]-x[1])+Math.abs(y[0]-y[1]);
	if(dist >= 2*d)return "0 1";
	if(dist <= d){
	    long mid = Math.min(x[0]-y[0],x[1]-y[1]);
	    long mad = Math.max(x[0]-y[0],x[1]-y[1]);
	    long mis = Math.min(x[0]+y[0],x[1]+y[1]);
	    long mas = Math.max(x[0]+y[0],x[1]+y[1]);
	    long k = (mis-mas+2*d)*(mid-mad+2*d);
	    //overlapping self, have corner boxes
	    b = d*d*8 - k;
	    long f = Math.abs((x[0]+y[0]-x[1]-y[1])*(x[0]-y[0]-x[1]+y[1]));
	    a = b - 4 * f;
	}
	else {
	    long mid = Math.min(x[0]-y[0],x[1]-y[1]);
	    long mad = Math.max(x[0]-y[0],x[1]-y[1]);
	    long mis = Math.min(x[0]+y[0],x[1]+y[1]);
	    long mas = Math.max(x[0]+y[0],x[1]+y[1]);
	    long k = (mis-mas+2*d)*(mid-mad+2*d);
	    a = 3* k;
	    b = d*d*8 - k;
	}
	System.err.println(a+" "+b);
	long g = gcd(a,b);
	return a/g+" "+b/g;
    }
    private static long gcd(long a,long b){
	//System.err.println(a+" "+b);
	if(a<0)return gcd(-a,b);
	if(b<0)return gcd(a,-b);
	if(b==0)return a;
	//if(a<b)return gcd(b,a);
	return gcd(b,a%b);
    }

    public static void main(String[] args) throws Exception{
	br = new BufferedReader(new InputStreamReader(System.in));
	bw = new BufferedWriter(new OutputStreamWriter(System.out));
	int cases=Integer.parseInt(br.readLine());
	for(int cn=1;cn<=cases;cn++){
	    bw.write(String.format("Case #%d: %s\n",cn,one()));
	    System.err.flush();
	    System.out.flush();
	}
	bw.flush();
    }
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static void rl() throws Exception{
	st = new StringTokenizer(br.readLine());
    }
    static long nlo(){
	return Long.parseLong(st.nextToken());
    }
    static int nin(){
	return Integer.parseInt(st.nextToken());
    }
    /*private static void te(){
      }*/
    static double ndo(){
	return Double.parseDouble(st.nextToken());
    }
    static char[] nca(){
	return st.nextToken().toCharArray();
    }
}
