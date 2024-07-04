import java.io.*;
import java.util.*;
import java.math.*;
//@SuppressWarnings("unused")
public class Solution {
    private static long ncr(long a,int b){
	a-=1;
	b-=1;
	long res=1;
	for(int i=0;i<b;++i){
	    res*=a-i;
	}
	for(int i=0;i<b;++i){
	    res/=b-i;
	}
	return res;
    }
    private static String one() throws Exception{
	rl();
	int n=nin();
	int d=nin();
	int[][] edges = new int[d][2];
	int[] xi = new int[n];
	int[] ds = new int[n];
	rl();
	boolean[] in = new boolean[n];
	xi[0]=ds[0]=0;
	for(int i=1;i<n;++i){
	    xi[i]= nin();
	    if(xi[i]>=0)ds[i]=xi[i];
	}
	for(int i=0;i<d;++i){
	    rl();
	    edges[i][0]=nin()-1;
	    edges[i][1]=nin()-1;
	}
	
	in[0]=true;
	int nv = 1;
	for(int currpos = 1;currpos<n;++currpos){
	    //check if there is one equal to -currpos

	    int tj=0;
	    for(int i=0;i<n;++i){
		if(xi[i]==-currpos){
		    ds[i]=nv;
		    in[i]=true;
		    ++tj;
		}
	    }
	    if(tj>0){
		currpos+=tj-1;
		nv+=1;
		continue;
	    }
	    //else, find a minimum, put it in
	    int min=100000;
	    int minp=0;
	    for(int i=0;i<n;++i){
		if(!in[i]&&xi[i]<min&&xi[i]>0){
		    minp=i;
		    min=xi[i];
		}
	    }
	    in[minp]=true;
	    nv=min+1;
	}
	
	for(int i=0;i<n;++i){
	    System.err.println(" "+ds[i]);
	}


	StringBuilder res= new StringBuilder("");
	for(int i=0;i<d;++i){
	    if(i!=0)res.append(" ");
	    int de = Math.abs(ds[edges[i][0]]
			     -ds[edges[i][1]]);
	    if(de==0)de=1000000;
	    res.append(""+de);
	}	
	return res.toString();
    }
    
    public static void main(String[] args) throws Exception{
	br = new BufferedReader(new InputStreamReader(System.in));
	bw = new BufferedWriter(new OutputStreamWriter(System.out));
	/*
	for(int i=1;i<=10000000;++i){
	    System.err.println(i);
	    one(i);
	}*/
	int cases=Integer.parseInt(br.readLine());
	for(int cn=1;cn<=cases;cn++){
	    
	    bw.write(String.format("Case #%d:%s\n",cn,one()));
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
