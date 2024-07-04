import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
public class Matrix {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();
    for(int i = 1; i<=t;i++) {
    	int n = in.nextInt();
    	int[][] mat = new int[n][n];
    	
    	for(int r = 0; r<mat.length;r++) {
    		for(int c = 0; c<mat[0].length;c++) {
    			mat[r][c] = in.nextInt();
        	}
    	}
    	
    	System.out.println("Case #"+i + ": " + trace(mat,n) + " " + row(mat,n) + " " + col(mat,n));
    }   
  }
  public static long trace(int[][] mat, int n){
	 long count = 0;
	 for(int r = 0; r<n;r++) {
 		for(int c = 0; c<n;c++) {
 			if(c==r)count+=mat[r][c];
     	}
 	}
	return count;  
  }
  
  public static int col(int[][] mat, int n) {
	  int count = 0;  
		 for(int c = 0; c<n;c++) {
			 String s = "";
	 		for(int r = 0; r<n;r++) {
	 			if(s.contains(mat[r][c]+"")) {
	 				count++;
	 				break;
	 			}
	 			s+=mat[r][c]+"";
	     	}
	 	}
	  return count;
  }
  public static int row(int[][] mat, int n) {
	  int count = 0;  
		 for(int r = 0; r<n;r++) {
			 String s = "";
	 		for(int c = 0; c<n;c++) {
	 			if(s.contains(mat[r][c]+"")) {
	 				count++;
	 				break;
	 			}
	 			s+=mat[r][c]+"";
	     	}
	 	}
	  return count;
  }
}
