import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int tt = in.nextInt();  // Scanner has functions to read ints][ longs][ strings][ chars][ etc.
    Loop: for (int qq = 1; qq <= tt; ++qq) {
      String a = in.next();
	  String b = in.next();
	  
	  int m = a.length();
	  int n = b.length();
	  
	  int[][] d = new int[m+1][n+1];
	  
	  int[][] how = new int[m+1][n+1];
	  
	  for(int i = 0; i < m+1; i++) d[i][0]=i;
	  for(int i = 0; i < n+1; i++) d[0][i]=i;
	  
	  for(int i = 0; i < m+1; i++) how[i][0]=0;
	  for(int i = 0; i < n+1; i++) how[0][i]=1;
	  
	  for(int i = 1; i < m+1; i++) for(int j = 1; j < n+1; j++) {
		  d[i][j] = d[i-1][j]+1;
		  how[i][j] = 0;
		  
		  if(d[i][j-1]+1 < d[i][j]) {
			  d[i][j] = d[i][j-1]+1;
			  how[i][j] = 1;
		  }
		  
		  int sub = 1;
		  if (a.charAt(i-1) == b.charAt(j-1)) sub=0;
		  
		  if(d[i-1][j-1]+sub < d[i][j]) {
			  d[i][j] = d[i-1][j-1]+sub;
			  how[i][j] = 2;
		  }
	  }
	  
	  int target = d[m][n]/2;
	  int targetat = 0;
	  
	  int[] pathi = new int[n+m+2];
	  int[] pathj = new int[n+m+2];
	  int[] pathtype = new int[n+m+2];
	  int at = 0;
	  
	  pathi[0] = m;
	  pathj[0] = n;
	  
	  while(pathi[at] != 0 || pathj[at] != 0) {
		  int ii = pathi[at];
		  int jj = pathj[at];
		  
		  if(how[ii][jj] == 0) {
			  pathi[at+1] = ii-1;
			  pathj[at+1] = jj;
			  pathtype[at+1] = 0;
		  } else if(how[ii][jj] == 1) {
			  pathi[at+1] = ii;
			  pathj[at+1] = jj-1;
			  pathtype[at+1] = 1;
		  } else if(how[ii][jj] == 2) {
			  pathi[at+1] = ii-1;
			  pathj[at+1] = jj-1;
			  pathtype[at+1] = 2;
		  }
		  
		  at++;
		  
		  if(d[pathi[at]][pathj[at]] == target) targetat = at;
	  }
	  
	  String ret = b.substring(0,pathj[targetat]) + a.substring(pathi[targetat]);
      
	  System.out.println("Case #" + qq + ": " + ret);
	  
    }
  }
}