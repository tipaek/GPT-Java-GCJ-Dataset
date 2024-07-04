package google_code_jam;

import java.util.*;
import java.io.*;
public class Solution7 {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      int r=0,tr=0,c=0;
      int m = in.nextInt();
      int mat[][] = new int[m][m];
      int row[] = new int[m];
      int col[] = new int[m];
      for (int j =0;j<m;j++) {
    	  for(int k =0;k<m;k++) {
    		  mat[j][k]=in.nextInt();
//    		  System.out.println("Row[j]="+row[j]);
//    		  if(k>0&&mat[j][k]==mat[j][k-1]) {
//    			  row[j]=1;
//    		  }
//    		  if(j>0&&mat[j][k]==mat[j-1][k]) {
//    			  col[j]=1;
//    		  }

//    		  if(j==m-1 && k == m-1) {
//
//    		  }
//    		  
    		  if(j==k) {
    			  tr = tr + mat[j][k];
    		  }
    	  }
//    	  r = r + row[j];
    	  
    	  
      }
      for(int z =0;z<m;z++) {
		  for(int x =0;x<m;x++) {
			  for(int y =x+1;y<m;y++) {
				  if(mat[z][x]==mat[z][y]) {
					  row[z]=1;
				  }
			  }
		  }
		  r = r + row[z];
      }
      for(int z =0;z<m;z++) {
	  for(int x =0;x<m;x++) {
		  for(int y =x+1;y<m;y++) {
			  if(mat[x][z]==mat[y][z]) {
				  col[z]=1;
			  }
		  }
//		 System.out.println("Col="+c); 
	  }
	  c = c + col[z];
      }
//	  System.out.println("Col="+c);
      System.out.println("Case #" + i + ": " + tr + " " + r + " " + c);
    }
  }
}