import java.io.*;
import java.util.*;
import java.math.*;
//@SuppressWarnings("unused")
public class Solution {
    private static boolean one() throws Exception{
        //type a: same
	//type b: different 
	int firsta=B-1;
	int firstb=B-1;
	int[] bits= new int[B];
	for(int i=0;i<B/2;++i){
	    if(i%4==0){
		//realign
		bw.write(String.format("%d\n",firsta+1));
		bw.flush();
		rl();
		int x = nin();
		bw.write(String.format("%d\n",firstb+1));
		bw.flush();
		rl();
		int y = nin();
		//System.err.printf("rea %d %d %d %d\n",firsta,x,firstb,y);
		boolean f= (bits[firsta]!=x)&&firsta!=B-1;
	        if(f){
		    //  System.err.println("flip");
		    for(int j=0;j<B;++j){
			bits[j]=1-bits[j];
		    }
		}
		boolean r= (bits[firstb]!=y)&&(firstb!=B-1);
		if(r){
		    //System.err.println("rev");
		    for(int j=0;j<B/2;++j){
			int t = bits[j];
			bits[j]=bits[B-1-j];
			bits[B-1-j]=t;
		    }
		}
	    }
	    bw.write(String.format("%d\n",i+1));
	    bw.flush();
	    rl();
	    int x = nin();
	    bits[i]=x;
	    bw.write(String.format("%d\n",B-i));
	    bw.flush();
	    rl();
	    int y = nin();
	    bits[B-i-1]=y;
	    //	    System.err.printf("learn %d %d %d %d\n",i,x,B-i-1,y);
	    if(firsta==B-1&& x==y){
		firsta=i;
		//	System.err.println("a"+firsta);
	    }
	    if(firstb==B-1&& x!=y){
		
		firstb=i;
		//System.err.println("b"+firstb);
	    }
	}
	for(int i=0;i<B;++i){
	    bw.write(bits[i]+"");
	}
	bw.write("\n");
	bw.flush();
	rl();
	if(nca()[0]=='N')
	    return true;
	else return false;
    }
    public static int B;
    public static void main(String[] args) throws Exception{
	br = new BufferedReader(new InputStreamReader(System.in));
	bw = new BufferedWriter(new OutputStreamWriter(System.out));
	rl();
	int cases=nin();
	B=nin();
	try{
	for(int cn=1;cn<=cases;cn++){
	    if(one())return;
	}
	}catch(Exception e){
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
