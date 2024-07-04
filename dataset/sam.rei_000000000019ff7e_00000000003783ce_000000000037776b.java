import java.io.*;
import java.util.*;
import java.math.*;
//@SuppressWarnings("unused")
public class Solution {
    private static String one() throws Exception{
	rl();
	int K=nin();
	int n=nin();
	rl();
	int[] d = new int[n];
	int first= nin();
	int curr=first;
	for(int i=0;i<n-1;++i){
	    int ne = nin();
	    d[i] = ne - curr;
	    curr = ne;
	}
	d[n-1]=K+first-curr;
	rl();
	//System.err.println(d[n-1]);
	int[] jum = new int[n];
	//System.err.println();
	for(int i=0;i<n;++i){
	    //   System.err.println(d[i]);
	    int k = 1;
	    int ub = d[i];
	    int lb = 0;
	    int cpos = ub;
	    while(k<n){
		//System.err.println(cpos+" "+ub+" "+lb);
		if(k%2==1){
		    cpos-=d[(i+k)%n];
		    lb = Math.max(lb,cpos);
		}else{
		    cpos+=d[(i+k)%n];
		    ub = Math.min(ub,cpos);
		}
		if(ub<=lb)break;
		++k;
	    }
	    if(k==n){
		//	System.err.println(lb+" "+ub+" "+cpos);
		//check if a loop exists
		if(n%2==0&&cpos == 0 ){
		    //can do in loop
		    return ""+n;
		}
		if(n%2==1){
		    //
		    
		    if(cpos>lb*2 &&cpos<ub*2){
			return ""+n;
		    }
		}
	    }	
	    jum[i]=k;
	}
	/*
	int[][] dp = new int[n][n+1];
	
	for(int d=1;d<=n;++d){
	    for(int j=0;j<n;++j){
		int an  =1+dp[j][d-1];
		for(int o=0;o<d;++o){
		    //starting from o ahead
		    if(jum[(j+o)%n]>=d-o){
			an =Math.min(an,1+dp[j][o]); 
		    }
		}
		dp[j][d] = an;
	    }
	}
	*/
	int min = n;
	
	for(int i=0;i<n;++i){
	    int k = 0;
	    int t = 0;
	    //jump forward as far as possible (fill as many thermometers)
	    //at cost of one more thermometer between this and the next 
	    while(k<n){
		k+=jum[(k+i)%n];
		++t;
	    }
	    min = Math.min(min,t);
	}
	return ""+(min+n);
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
