
import java.util.*;
import java.io.*;
class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    int[][][] cases=new int[t][][];
    for (int i = 0;i<t; i++) {
      int n = in.nextInt();
	  cases[i]=new int[n][n];
      for(int j=0;j<n;j++) {
    	  for(int k=0;k<n;k++) {
    		  cases[i][j][k]=in.nextInt();
    	  }
      }
     
    }
    int[][] answers=new int[t][3];
    for(int i=0;i<t;i++) {
   	 answers[i]=answer(cases[i]);
   	 System.out.println("Case #"+i+": "+ answers[i][0]+" "+answers[i][1]+" "+answers[i][2]);
    }
    in.close();
  }
  static int[] answer(int[][] c) {
	  HashSet<Integer> repeats=new HashSet<>();
	  int columns=0;
	  int rows=0;
	  l:for(int i=0;i<c.length;i++) {
		  for(int j=0;j<c.length;j++) {
			  if(!repeats.add(c[j][i])) {
				  columns++;
				  continue l;
			  }
		  }
		  repeats.clear();
	  }
	  l:for(int i=0;i<c.length;i++) {
		  for(int j=0;j<c.length;j++) {
			  if(!repeats.add(c[i][j])) {
				  rows++;
				  continue l;
			  }
		  }
		  repeats.clear();
	  }
	  int trace=0;
	  for(int i=0;i<c.length;i++) {
		  trace+=c[i][i];
	  }
	  int[] ans=new int[3];
	  ans[0]=trace;ans[1]=rows;ans[2]=columns;
	  return ans;
  }
}
  