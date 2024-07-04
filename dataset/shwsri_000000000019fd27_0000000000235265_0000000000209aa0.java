import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      int m = in.nextInt();
      int tr = in.nextInt();
      int m_var = m;
      int flag = 0,tru = 0,trd =0;
      
      int mat [][] = new int[m][m];
      while(m_var>0) {
    	  tru =0;
    	  trd=0;
    	  for(int j=0;j<m;j++) {
    		  for(int k=0;k<m;k++) {
    			 if(j==0) {
    				 mat[j][k]=k+1;
    			 }
    			 else {
    				 if(mat[j-1][k]<m) {
    					 mat[j][k]=mat[j-1][k]+1;
    				 }
    				 else {
    					 mat[j][k]=1;
    				 }
    			 }
    		  }
    	  }
    	  for(int x=0;x<m;x++) {
    		  for(int y=0;y<m;y++) {
    			  if(x==y) {
    				  tru = tru + mat[x][y];
    			  }
    			  if(x+y==m) {
    				  trd = trd + mat[x][y];
    			  }
    		  }
    	  }
    	  if(tru==tr || trd ==tr) {
    		  flag = 1;
    		  break;
    	  }
    	  m_var--;
      }

      if(flag == 1) {
    	  System.out.println("Case #" + i + ": " + "POSSIBLE");
    	  if(tr==tru) {
    		  for (int x =0;x<m;x++) {
        		  for(int y =0;y<m;y++) {
        			  System.out.print(mat[x][y]+" ");
        		  }
        		  System.out.println();
        	  } 
    	  }
    	  else if(tr==trd) {
    		  for (int x =m-1;x>=0;x--) {
        		  for(int y =m-1;y>=0;y--) {
        			  System.out.print(mat[x][y]+" ");
        		  }
        		  System.out.println();
        	  } 
    	  }
    	  
      }
      else {
    	  System.out.println("Case #" + i + ": " + "IMPOSSIBLE");
      }
//      System.out.println("Case #" + i + ": " + m);
    }
  }
}