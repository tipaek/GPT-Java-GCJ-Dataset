import java.io.*;
import java.util.*;
import java.math.*;
//@SuppressWarnings("unused")
public class Solution {
    private static boolean aWinning(int[] sta,int[] inv,boolean aturn){
        
	int n = sta.length;
	boolean nd=sta[0]==-2;
	//	int[] inv = new int[n];//state.length
	//for(int i=0;i<n;++i){
	//   inv[i]=-2;
	//}
	//for(int i=0;i<n;++i){
	//    if(sta[i]>=0)inv[sta[i]]=i;
	//}
	/*
	boolean trinv = false;
	for(int i=1;i<n-1;++i){
	    if(inv[i]==-2&&inv[i-1]==-2&&inv[i+1]==-2)trinv=true;
	    }
*/
	for(int i=1;i<n;++i){
	    nd|=sta[i]==-2;
	    //a has won already
	    if(Math.abs(sta[i]-sta[i-1]) ==1){
		return true;
	    }
	    
	    if(aturn){
		if(sta[i]==-2){
		    if(sta[i-1]==-2){
			if(i<n-1&&sta[i+1]==-2){
			    return true;
			}
		    }
		    //check +1
		    //check -1
		    else{
			if(sta[i-1]<n-1&&inv[sta[i-1]+1]==-2){
			    //it's not been taken yet, a could place to win
			    return true;
			}
			if(sta[i-1]>0&&inv[sta[i-1]-1]==-2){
			    //it's not been taken yet, a could place to win
			    return true;
			}
		    }
		}
		else if(sta[i-1]==-2){
		    //check +1
		    //check -1
		    if(sta[i]<n-1&&inv[sta[i]+1]==-2){
			//it's not been taken yet, a could place to win
			return true;
		    }
		    if(sta[i]>0&&inv[sta[i]-1]==-2){
			//it's not been taken yet, a could place to win
			return true;
		    }
		}
		
	    }
	}
	if(!nd)return false;
	
	

	boolean nextWin=false;
	for(int i=0;i<n;++i){
	    if(sta[i]!=-2)continue;
	    for(int j=0;j<n;++j){
		if(inv[j]!=-2)continue;
		sta[i]=j;
		inv[j]=i;
		nextWin|=(aturn==aWinning(sta,inv,!aturn));
		//System.err.println(nextWin);
		sta[i]=inv[j]=-2;
		
	    }
	}
	//	System.err.println(Arrays.toString(sta)+" "+ Arrays.toString(inv)+" "+(nextWin==aturn)+" "+aturn);
	return nextWin==aturn;
    }
    private static String one() throws Exception{
	rl();
	int n = nin();
	int nm=0;
	//int m=0;
	int[] sta = new int[n];
	int[] inv = new int[n];
	for(int i=0;i<n;++i)sta[i]=inv[i]=-2;
	boolean winA = true;
	for(int i=0;i<n;++i){
	    rl();
	    int a =nin()-1;
	    int b =nin()-1;
	    //b[i]=0;
	    sta[b]=a;
	    inv[a]=b;
	    if(aWinning(sta,inv,i%2==1)!=winA){
		winA=!winA;
		//System.err.println("Mistake made on turn "+i+" to board "+Arrays.toString(sta));
		++nm;
	    }
	}
	return (nm+1)/2+" "+(nm/2);
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
