
import java.util.*;
import java.io.*;
public class Solution {
	private static HashSet<String> ceckr= null;
	private static HashSet<String> ceckc= null;
  public static void main(String[] args) {
	  String[] rowRead;
	  String[][] charArr;
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
    	int N = in.nextInt();
    	charArr = new String[N][N];
      
      in.nextLine();
      for (int r = 0; r < N; r++) {
    	  rowRead = in.nextLine().split(" ");
    	  for (int c = 0; c < rowRead.length; c++) {
    		  charArr[r][c] = rowRead[c];
    		  //System.out.println("lie; " +rowRead[c]);
    	  }
    	  
      }
      
      System.out.println("Case #" + i + ": " + isContainDuplicatesInRow(charArr, N));
    }
  }
  
  public static String isContainDuplicatesInRow(String a [][], int N) {
	  String out = "";
	  int rowDupC=0, colDupC=0, sum=0;
	  for (int i = 0; i < N; i++) {
		  ceckr= new HashSet<String>();
		  ceckc= new HashSet<String>();
		  for (int row = 0; row < N; row++) {
			  if(!ceckc.add(a[row][i])) {
				  ++colDupC;
				  ceckc= null;
				  break;
			  }
		  }
		  
		  for (int col = 0; col < N; col++) {
			  if(!ceckr.add(a[i][col])) {
				  ++rowDupC; 
				  ceckr = null;
				  break;
			  }	  
		  }
		  
		  sum+= Integer.parseInt(a[i][i]);
		  
	  }
	  
	  out = sum+" "+rowDupC+ " " + colDupC;
	  System.out.println("Output: " + out);
	  return out;
	  
	
  }
}