import java.io.*;
import java.util.*;
import java.math.*;
//@SuppressWarnings("unused")
public class A {
    private static long diff(long a,long b){
	return (a*(a+1))/2-(b*(b+1))/2;
    }
    private static long bins(long n,long d){
	//find largest n' such that sum from n+1 to n' < d
	long h = 2500000000l;
	long l = n;
	long m = (n*(n+1))/2+d;
	while(h-l>1){
	    long t = (h+l)/2;
	    if((t*(t+1))/2 >= m){
		h=t;
	    }else l=t;
	}
	return l;
    }
    private static long binse(long n,long d){
	//find smallest n' such that sum from n+1 to n' <= d
	long h = 2500000000l;
	long l = n;
	long m = (n*(n+1))/2+d;
	while(h-l>1){
	    long t = (h+l)/2;
	    //System.err.println(m+" "+t);
	    if((t*(t+1))/2 > m){
		h=t;
	    }else l=t;
	}
	return l;
    }
    private static long x2(long a,long b){
	if((b-a)%2!=0)b-=1;
	return ((a+b)/2)*((b-a)/2+1);
    }
    private static String one() throws Exception{
	rl();
	long L = nlo();
	long R = nlo();
	long N = 0;
	if(L<R){
	    N = binse(N,R-L);
	    //System.err.println(N);
	    R-= diff(N,0);
	    //R>=L;
	    if(R>L){
		//	System.err.println("a");
		if(R>N){
		    R-=N+1;
		    N++;
		}
		else {
		    return String.format("%d %d %d",N,L,R);
		}
	    }
	    //now, L>=R
	}else if(L>R){
	    N = binse(N,L-R);
	    L-=diff(N,0); //L-=(k<=L-R), L>=R
	}
	
	//L>=R
	long l = N;
	long h = 2500000000l;
	while(h-l>1){
	    long t = (h+l)/2;
	    if( L<x2(N+1,t) || R<x2(N+2,t)){
		h=t;
	    }else l=t;
	    
	    //diff L and R until they are equal
	}
	//	System.err.println(N+" "+L+" "+R+" "+l);
	//	if(R>N){R-=N+1;++N;}
	//if(L>N){L-=N+1;++N;}
	//L>=0, R>=0,
	//(L-R<=N+1)
	L-=x2(N+1,l);
	R-=x2(N+2,l);
	//L<R, R-L<N at this point
	return String.format("%d %d %d",l,L,R);
    }
    public static void main(String[] args) throws Exception{
	br = new BufferedReader(new InputStreamReader(System.in));
	bw = new BufferedWriter(new OutputStreamWriter(System.out));
	int cases=Integer.parseInt(br.readLine());
	for(int cn=1;cn<=cases;cn++){
	    bw.write(String.format("Case #%d: %s\n",cn,one()));
	    //if(cn!=cases)rl();
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
