
import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; i++) {
      solve(in, i, in.nextInt());
      
    }
  }
  public static void solve(Scanner in, int caseNum, int size){
	  
	  int sum = 0;
	  int col = 0;
	  int row = 0;
	  int[] r = new int[size+1];
	  boolean cX = false;
	  boolean[] cY = new boolean[size];
	  int[][] c = new int[size+1][size+1];
	  
	  for(int i = 0; i < size; i++){
		  for(int x = 0; x < size; x++){
			  int value = in.nextInt();
			  if(i == x) sum += value;
			  if(!cX && r[value] >= 1){
				  row++;
				  cX = true;
			  }
			  r[value]++;
			  if(!cY[x] && c[x][value] >= 1){
				  col++;
				  cY[x] = true;
			  }
			  c[x][value]++;  
		  }
		  r = new int[size+1];
		  cX = false;
	  }
	  System.out.println("Case #" + caseNum + ": " + sum + " " + row + " " + col);
  }
}