import java.io.*;
import java.util.*;
import java.math.*;
//@SuppressWarnings("unused")
public class Solution {
    private static String one() throws Exception{
	rl();
	char[] a = nca();
	char[] b = nca();
	int n = a.length;
	int m = b.length;
	int[][] ed = new int[n+1][m+1];
     	ed[0][0]=0;
	
	for(int i=0;i<=n;++i){
	    for(int j=0;j<=m;++j){
		if(i+j==0)continue;
		int e= 10000000;
		if(i>0){
		    e=Math.min(e,1+ed[i-1][j]);
		}
		if(j>0){
		    e=Math.min(e,1+ed[i][j-1]);
		}
		if(i>0&&j>0){
		    e=Math.min(e,(a[i-1]==b[j-1]?0:1)+ed[i-1][j-1]);
		}
		ed[i][j]=e;
	    }
	}
	int ans = ed[n][m];
	
	int cx = n;
	int cy = m;
	int d = 0;
	String res = "";
	//System.err.println(ans);
	bt: while(d <ans/2){
	    //  System.err.println(cx+" "+cy);
	    //perform a trace back
	    if(cx>0&& ed[cx][cy] == 1+ed[cx-1][cy]){
		//deleted a[cx-1] from it
		res =  a[cx-1]+res;
		++d;
		--cx;
		continue;
	    }
	    if(cy>0&& ed[cx][cy] == 1+ed[cx][cy-1]){
		//added b[cy-1], don't put anything into result
		++d;
		--cy;
		continue;
	    }
	    if(cy>0&&cx>0&& ed[cx][cy]==(a[cx-1]==b[cy-1]?0:1)+ed[cx-1][cy-1]){
		//attempt match
	        //b[cy-1] becomes a[cx-1]
		res = a[cx-1]+res;
		++d;
		--cx;
		--cy;
		continue;
	    }
	}
	for(int j=cy-1;j>=0;--j){
	    res = b[j]+res;
	}
        //perform traceback 
	
	return res;
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
