import java.io.*;
import java.util.*;
import java.math.*;
//@SuppressWarnings("unused")
public class Solution {
    static class State{
	int a,b;
        int[] taken = new int[15];
	boolean[] empty = new boolean[15];
	int lc = 1;
	int tottaken = 0;
	boolean proc(int x){
	    if(lc==0)return false;
	    if(x==0){
		empty[lc-1]=true;
		if((tottaken/lc<6&&lc>5)||lc==13){
		    a = lc+1;
		    b = lc+2;
		    lc = 0;
		    return false;
		}
		
		++lc;
	    }
	    else{
		++taken[lc-1];
		++tottaken;
	    }
	    return true;
	}
    }
    
    public static void main(String[] args) throws Exception{
	br = new BufferedReader(new InputStreamReader(System.in));
	bw = new BufferedWriter(new OutputStreamWriter(System.out));
	rl();
	int cases=nin();

	State[] state = new State[cases];
	for(int i=0;i<cases;++i){
	    state[i] = new State();
	}
	boolean done = false;
	while(!done){
	    done = true;
	    for(int cn=0;cn<cases;cn++){
		bw.write(state[cn].lc+(cn==cases-1?"\n":" "));
	    }
	    bw.flush();
	    rl();
	    for(int cn=0;cn<cases;cn++){
		done&=state[cn].proc(nin());
	    }
	}
	for(int i=0;i<cases;++i){
	    bw.write((state[i].a)+" "+(state[i].b)+(i==cases-1?"\n":" "));
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
