import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
     
      int m = in.nextInt();
      int tr = in.nextInt();
      int sum[] = new int[m+1];
      int mat[][] = new int[m][m];
      int flag =0;
      for(int j =0;j<m+1;j++) {
    	  if(j==0) {
        	  for(int k =1;k<=m;k++) {
        		  sum[j]=sum[j]+k;
        	  }
    	  }
    	  else {
    		  sum[j]=m*j;
    	  }
    	  if(sum[j]==tr&&m%2!=0&&sum[j]%m!=0) {
    		  for(int z =0;z<m;z++) {
    			  mat[m/2][z]=z+1;
    		  }
    		  for(int x =((m/2)-1);x>=0;x--) {
    			  for(int y=0;y<m;y++) {
    				  if(mat[x+1][y]==m)
    					  mat[x][y]=1;
    				  else
    					  mat[x][y]=mat[x+1][y]+1;
    			  }
    		  }
    		  for(int x =(1+m/2);x<m;x++) {
    			  for(int y=0;y<m;y++) {
    				  if(mat[x-1][y]==1)
    					  mat[x][y]=m;
    				  else
    					  mat[x][y]=mat[x-1][y]-1;
    			  }
    		  }
    		  flag =2;
    		  break;
    	  }
    	  else if(sum[j]==tr&&m%2!=0&&sum[j]%m==0) {
//    		  System.out.println("Entering correction");
    		  sum[j]=sum[j]/m;
    		  for(int x =0;x<m;x++) {
    			  for(int y=0;y<m;y++) {
    				  if(y==0)
    					  mat[x][y]=sum[j];
    				  else {
    					 
    						  if(mat[x][y-1]==m)
        						  mat[x][y]=1;
        					  else
        						  mat[x][y]=mat[x][y-1]+1;
    					  
    	
    				  }
    				  sum[j]=mat[x][y];
    			  }
    		  }
    		  flag =1;
    		  break;
    	  }
    	  else if(sum[j]==tr&&m%2==0&&sum[j]%m==0) {
    		  for(int x =0;x<m;x++) {
    			  for(int y=0;y<m;y++) {
    				  if(y==0)
    					  mat[x][y]=sum[j];
    				  else {
    					  if(mat[x-1][y]==m)
    						  mat[x][y]=1;
    					  else
    						  mat[x][y]=mat[x-1][y]+1;
    				  }
    				  sum[j]=mat[x][y];
    			  }
    		  }
    		  flag = 1;
    		  break;
    	  }
    	  else if(sum[j]==tr&&m%2==0&&sum[j]%m!=0) {
    		  break;
    	  }
      }
      if(flag == 1) {
//    	  System.out.println("flag="+flag);
    	  System.out.println("Case #" + i + ": " + "POSSIBLE");
    	  for(int x =0;x<m;x++) {
    		  for(int y =0;y<m;y++) {
    			  System.out.print(mat[x][y]+" ");
    		  }
    		  System.out.println();
    	  }
      }
      else if(flag == 2) {
    	  System.out.println("Case #" + i + ": " + "POSSIBLE");
    	  for(int x =0;x<m;x++) {
    		  for(int y =m-1;y>=0;y--) {
    			  System.out.print(mat[x][y]+" ");
    		  }
    		  System.out.println();
    	  } 
      }
      else
    	  System.out.println("Case #" + i + ": " + "IMPOSSIBLE");

      
    }
  }
}