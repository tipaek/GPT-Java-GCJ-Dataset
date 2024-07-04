import java.io.*;
import java.util.*;
import java.math.*;
//@SuppressWarnings("unused")
public class Solution {
    private static class D implements Comparable<D>{
	int x;
	int y;
	D(int a,int b){
	    x=a;
	    y=b;}
	public int compareTo(D a){
	    int r = Integer.compare(x,a.x);
	    return r==0?Integer.compare(y,a.y):r;
	}
    }
    private static int gcd(int a,int b){
	//System.err.println(a+" "+b);
	if(a<0)return gcd(-a,b);
	if(b<0)return gcd(a,-b);
	if(b==0)return a;
	//if(a<b)return gcd(b,a);
	return gcd(b,a%b);
    }
    static String one() throws Exception{
	rl();
	int n= nin();
	int[] x = new int[n];
	int[] y = new int[n];
	for(int i = 0;i<n;++i){
	    rl();
	    x[i]=nin();
	    y[i]=nin();
	}
	TreeMap<D,HashMap<Integer,List<Integer>>> map = new TreeMap<>();
	for(int i=0;i<n;++i){
	    for(int j=i+1;j<n;++j){
		int dx=x[i]-x[j];
		int dy=y[i]-y[j];
		int g = gcd(dx,dy);
		int gx = dx/g;
		int gy = dy/g;
		if(gx<0){
		    gy=-gy;
		    gx=-gx;
		}
		if(gx==0&&gy<0){
		    gy=1;
		}
		D k = new D(gx,gy);
		if(!map.containsKey(k))map.put(k,new HashMap<>());
		HashMap<Integer,List<Integer>> curr = map.get(k);
		if(!curr.containsKey(i))curr.put(i,new LinkedList<>());
		if(!curr.containsKey(j))curr.put(j,new LinkedList<>());
		curr.get(i).add(j);
		curr.get(j).add(i);
	    }
	}

	int t = 0;
	for(HashMap<Integer,List<Integer>> a : map.values()){
	    boolean[] proc = new boolean[n];
	    int ct = 0;
	    // System.err.println("NL");
	    for(int b:a.keySet()){
		int s= a.get(b).size()+1;
		//System.err.println(b+" "+s);
		if(proc[b])continue;
		if(s>1){
		   
		    ct+=s;
		}
		for(int c : a.get(b)){
		    proc[c]=true;
		}
	
	    }
	    t=Math.max(t,ct/2);
	}

	System.err.println(t*2+2);
	return ""+Math.min(t*2+2,n);
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
