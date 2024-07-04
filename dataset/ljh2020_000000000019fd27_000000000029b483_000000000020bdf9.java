
import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; i++) {
      solve(in, i);
      
    }
  }
  public static void solve(Scanner in, int caseNum){
	  int n = in.nextInt();
	  StringBuilder ret = new StringBuilder();
	  int cLast = 0;
	  int jLast = 0;
	  boolean impossible = false;
	  int[][] time = new int[n][4];
	  for(int i = 0; i < n; i++){
		  time[i][0] = in.nextInt();
		  time[i][1] = in.nextInt();
		  time[i][2] = i;
		  
	  }
	  Arrays.sort(time, Comparator.comparingInt(o -> o[0]));
	  for(int i = 0; i < n; i++){
		  int start = time[i][0];
		  int end = time[i][1];
		  if(impossible) continue;
		  if(start < cLast && start < jLast){
			  impossible = true;
			  continue;
		  }
		  if(start >= cLast){
			  cLast = end;
			  time[i][3] = 1;
			  continue;
		  }
		  if(start >= jLast){
			  jLast = end;
			  time[i][3] = 2;
			  continue;
		  }
	  }
	  if(impossible){
		  System.out.println("Case #" + caseNum + ": IMPOSSIBLE");
		  return;
	  }
	  Arrays.sort(time, Comparator.comparingInt(o -> o[2]));
	  for(int i = 0; i < n; i++){
		  ret.append(time[i][3] == 1 ? "C" : "J");
	  }
	  
	  System.out.println("Case #" + caseNum + ": " + ret.toString());
  }
}