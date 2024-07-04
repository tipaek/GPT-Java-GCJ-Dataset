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
      int l =0;
      while(m_var>0) {
    	  tru =0;
    	  trd=0;
    	  for(int j=0;j<m;j++) {
    		  for(int k=0;k<m;k++) {
    			 if(j==0&&k==0) {
    				 mat[j][k]=k+l+1;
//    				 System.out.println("mat["+j+"]"+"["+k+"]="+mat[j][k]);
    			 }
    			 else if(j==0&&k!=0) {
    				 if(mat[j][k-1]<m) {
    					 mat[j][k]=mat[j][k-1]+1;
//        				 System.out.println("mat["+j+"]"+"["+k+"]="+mat[j][k]);

    				 }
    				 else {
    					 mat[j][k]=1;
//        				 System.out.println("mat["+j+"]"+"["+k+"]="+mat[j][k]);

    				 }
    			 }
    			 else {
    				 if(mat[j-1][k]<m) {
    					 mat[j][k]=mat[j-1][k]+1;
//        				 System.out.println("mat["+j+"]"+"["+k+"]="+mat[j][k]);

    				 }
    				 else {
    					 mat[j][k]=1;
//        				 System.out.println("mat["+j+"]"+"["+k+"]="+mat[j][k]);

    				 }
    			 }
    		  }
    	  }
    	  for(int x=0;x<m;x++) {
    		  for(int y=0;y<m;y++) {
//    			  System.out.print(mat[x][y]+" ");
    			  if(x==y) {
    				  tru = tru + mat[x][y];
    			  }
    			  if(x+y==(m+1)) {
    				  trd = trd + mat[x][y];
    			  }
    		  }
//    		  System.out.println();
    	  }
    	  if(tru==tr || trd ==tr) {
    		  flag = 1;
    		  break;
    	  }
//    	  System.out.println("tru="+tru + "trd= "+trd);
    	  l++;
    	  m_var--;
      }
      
      if(flag == 1) {
    	  System.out.println("Case #" + i + ": " + "POSSIBLE");
//    	  System.out.println("tru="+tru + "trd="+trd);
    	  if(tr==tru) {
    		  for (int x =0;x<m;x++) {
        		  for(int y =0;y<m;y++) {
        			  System.out.print(mat[x][y]+" ");
        		  }
        		  System.out.println();
        	  } 
    	  }
    	  else if(tr==trd) {
//    		  System.out.println("trd");
    		  for (int x =0;x<m;x++) {
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