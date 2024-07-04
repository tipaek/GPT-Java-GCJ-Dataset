import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {
	
	  public static void main(String[] args) {
		    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		    for (int i = 1; i <= t; ++i) {
		    	int N = in.nextInt();
		   	 int[][] cities=new int[N][N];
		     for (int k=0;k<N;k++) {
		                for (int l = 0; l < N; l++) {
		                	cities[k][l] = in.nextInt(); 
		                }
		                	
			     }
		     int trace = findTrace(cities,N);
			 int duplicateRows = findDuplicateRows(cities,N);
			 int duplicateColumns = findDuplicateColumns(cities,N);


		      System.out.println("Case #" + i + ": " + trace+" "+duplicateRows+" "+duplicateColumns);
 		    }
		    
		  }
	  
	  static int findTrace(int mat[][], int n) 
	  { 
	      int sum = 0; 
	      for (int i=0; i<n; i++) 
	          sum += mat[i][i]; 
	      return sum; 
	  }
	  
	  static int findDuplicateRows(int mat[][], int n) 
	  { 
		  int sum =0;
		  for(int i=0;i<n;i++){
			  if(checkDuplicates(mat[i])){
				  sum++;
			  };

		  }
		  return sum;
	  }
	  
	  
	  static boolean checkDuplicates(int arr[]) 
	    { 
	        HashSet<Integer> set = new HashSet<>(); 
	  	        for (int i=0; i<arr.length; i++) 
	        { 
	            if (set.contains(arr[i])) 
	               return true; 
	  
	            set.add(arr[i]); 
	  
	        } 
	        return false; 
	    }
	  
	  static int findDuplicateColumns(int mat[][], int n) 
	  { 
		    int[][] rev=new int[n][n];

          for (int i = 0; i < n; i++) { 
              for (int j = 0; j < n; j++) {
                  rev[j][i]=mat[i][j];              

              }
          } 
		  
		  
	      int sum = findDuplicateRows(rev,n);
	      return sum; 
	  }

}
