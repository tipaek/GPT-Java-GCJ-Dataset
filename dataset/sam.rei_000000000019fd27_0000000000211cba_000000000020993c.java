import java.io.*;
import java.util.*;
import java.math.*;
//@SuppressWarnings("unused")
public class Solution {
    private static String one() throws Exception{
	rl();
	int n = nin();
	int[][] count = new int[n][n];
	int tot=0;
	boolean[][] colseen=new boolean[n][n];
	boolean[][] rowseen=new boolean[n][n];
	boolean[] r = new boolean[n];
	boolean[] c = new boolean[n];
	int rdu = 0;
	int cdu = 0;
	for(int i=0;i<n;++i) {

	    rl();
	    for(int j=0;j<n;++j){
		count[i][j]=nin();
		if(colseen[i][count[i][j]-1]){
		    c[i]=true;
		}
		if(rowseen[j][count[i][j]-1]){
		    r[j]=true;
		}
		colseen[i][count[i][j]-1]=rowseen[j][count[i][j]-1]=true;
		if(i==j)tot+=count[i][j];
	    }
	    
	}
	for(int i=0;i<n;++i){
	    if(r[i])++rdu;
	    if(c[i])++cdu;
	}
	return String.format("%d %d %d",tot,cdu,rdu);
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
