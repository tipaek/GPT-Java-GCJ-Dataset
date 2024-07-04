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
    private static String one(int n) throws Exception{
	
	StringBuilder sb = new StringBuilder("");
	//if(n==1) return "\n1 1";
	if(n<=60){
	    for(int i=1;i<=n;++i){
		sb.append(String.format("\n%d 1",i));
	    }
	    return sb.toString();
	}
	n-=30;
	int taillength=0;
	boolean flipped = false;
	int t=0;
	for(int i=0;i<30;++i){
	    if(((n>>i)&1) ==1){//n's ith bit is 1
		//include the entirety of row i
		if(flipped){
		    for(int j=i+1;j>=1;--j){
			sb.append(String.format("\n%d %d",i+1,j));
		    }
		}
		else{
		    for(int j=1;j<=i+1;++j){
			sb.append(String.format("\n%d %d",i+1,j));
		    }
		}
		flipped=!flipped;
		++taillength;
		t+=1<<i;
	    }
	    else{
		sb.append(String.format("\n%d %d",i+1,flipped?i+1:1));
		t+=1;
	    }
	}
	for(int k=0;k<taillength;++k){
	    t+=1;
	    sb.append(String.format("\n%d %d",k+31,flipped?k+31:1));
	}
	//System.err.println(n-t);
	/**didn't read the 1 1 start, big rip
	while(n!=0){
	    // System.err.println(x+" "+y);

	    if(y>=4)
	    if(ncr(x+1,y)+x-y>n){
		y-=1;
		n-=ncr(x,y);
		sb.append(String.format("\n%d %d",x,y));
	    }
	    else{
		n-=ncr(x,y);
		sb.append(String.format("\n%d %d",x,y));
		x-=1;

	    }
	    }*/
	return sb.toString();
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
	    rl();
	    int n=nin();
	    bw.write(String.format("Case #%d:%s\n",cn,one(n)));
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
