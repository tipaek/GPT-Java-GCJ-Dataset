import java.io.*;
import java.util.*;

public class Solution {
    public static void solve(BufferedReader in,int tcase) throws Exception{
	int n=Integer.parseInt(in.readLine());
	int[][]m=new int[n][n];
	for(int i=0;i<n;i++) {
	    StringTokenizer st=new StringTokenizer(in.readLine());
	    for(int j=0;j<n;j++) {
		m[i][j]=Integer.parseInt(st.nextToken());
	    }
	}
	int trace=0;
	for(int i=0;i<n;i++) {
	    trace+=m[i][i];
	}
	int badRows=0;
	for(int i=0;i<n;i++) {
	    boolean[]q=new boolean[n];
	    for(int j=0;j<n;j++) {
		q[m[i][j]-1]=true;
	    }
	    boolean ok=true;
	    for(int j=0;j<n;j++) {
		if(!q[j]) {
		    ok=false;
		}
	    }
	    if(!ok) {
		badRows++;
	    }
	}
	int badCols=0;
	for(int j=0;j<n;j++) {
	    boolean[]q=new boolean[n];
	    for(int i=0;i<n;i++) {
		q[m[i][j]-1]=true;
	    }
	    boolean ok=true;
	    for(int i=0;i<n;i++) {
		if(!q[i]) {
		    ok=false;
		}
	    }
	    if(!ok) {
		badCols++;
	    }
	}
	System.out.println("Case #"+tcase+": "+trace+" "+badRows+" "+badCols);
    }
    public static void main(String[] args) throws Exception {
	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	int t=Integer.parseInt(in.readLine());
	for(int tcase=1;tcase<=t;tcase++) {
	    solve(in,tcase);
	}
    }

}
