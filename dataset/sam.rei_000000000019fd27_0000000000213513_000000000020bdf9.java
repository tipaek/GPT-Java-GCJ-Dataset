import java.io.*;
import java.util.*;
import java.math.*;
//@SuppressWarnings("unused")
public class Solution {
    public static class Ev implements Comparable<Ev>{
	int s;
	int e;
	int v;
	public Ev(int a,int b, int c){
	    s=a;e=b;v=c;
	}
	public int compareTo(Ev o){
	    if(s==o.s){
		if(e==o.e){
		    return Integer.compare(v,o.v);
		}
		else return Integer.compare(e,o.e);
	    }
	    else return Integer.compare(s,o.s);
	}
    }
    private static String one() throws Exception{
	rl();
	int n = nin();
	Ev[] ev= new Ev[n];
	for(int i=0;i<n;++i) {
	    rl();
	    ev[i] = new Ev(nin(),nin(),i);
	}
	Arrays.sort(ev);
        char[] res = new char[n];
	int cn = 0;
	int jn = 0;
	for(Ev x : ev){
	    if(x.s>=cn){
		res[x.v]='J';
		cn=x.e;
	    }
	    else {
		if(x.s>=jn){
		    res[x.v]='J';
		    jn=x.e;
		}
		else return "IMPOSSIBLE";
	    }		      
	}
	return new String(res);
    }
    public static void main(String[] args) throws Exception{
	br = new BufferedReader(new InputStreamReader(System.in));
	bw = new BufferedWriter(new OutputStreamWriter(System.out));
	int cases=Integer.parseInt(br.readLine());
	for(int cn=1;cn<=cases;cn++){
	    bw.write(String.format("Case #%d: %s\n",cn,one()));

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
