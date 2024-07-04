import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class Solution{
		public static boolean isSafe(int arr[][],int row,int col,int num) {
			for( int i=0 ; i<row ; ++i ) {
				if( arr[i][col]==num ) {
					return false;
				}
			}
			for( int i=0 ; i<col ; ++i ) {
				if( arr[row][i]==num ) {
					return false;
				}
			}
			return true;
		}
		public static boolean checkDiagonal( int arr[][],int k) {
			int n = arr.length;
			int diagonalSum=0;
			for( int i=0 ; i<n ; ++i) {
				diagonalSum += arr[i][i];
			}
			return diagonalSum==k? true:false;
		}
		public static boolean solveLatinSquare(int arr[][],int row,int col,int k) {
			int n = arr.length;
			if( row>=n ) {
				if( checkDiagonal(arr, k) ) {
					return true;
				}else {
					return false;
				}
			}
			int nextRow,nextCol;
			for( int i=1 ; i<=n ; ++i ) {
				if( isSafe(arr,row,col,i) ) {
					arr[row][col] = i;
					if( (col+1)<n ) {
						nextCol = col+1;
						nextRow = row;
					}else {
						nextCol = 0;
						nextRow = row+1;
					}
					if( solveLatinSquare(arr, nextRow, nextCol, k) ) {
						return true;
					}
					arr[row][col] = 0;
				}
			}
			return false;
		}
	   public static void main(String[] args) {
	      MyScanner sc = new MyScanner();
	      out = new PrintWriter(new BufferedOutputStream(System.out));
	      
	      int t = sc.nextInt();
	      for( int testcase=1 ; testcase<=t ; ++testcase ) {
	    	  int n = sc.nextInt();
	    	  int k = sc.nextInt();
	    	  int arr[][] = new int[n][n];
	    	  if( (n*n)<k ) {
	    		  System.out.println("Case #"+testcase+": IMPOSSIBLE");
	    	  }
	    	  if( solveLatinSquare(arr,0,0, k) ){
	    		  System.out.println("Case #"+testcase+": POSSIBLE");
	    		  for( int i=0 ; i<n ; ++i ) {
	    			  for( int j=0 ; j<n ; ++j ) {
	    				  System.out.print(arr[i][j]+" ");
	    			  }
	    			  System.out.println();
	    		  }
	    	  }else{
	    		  System.out.println("Case #"+testcase+": IMPOSSIBLE");
	    	  }
	      }
	      
	      
//	      long k     = sc.nextLong();       // read input as long
//	      double d   = sc.nextDouble();     // read input as double
//	      String str = sc.next();           // read input as String
//	      String s   = sc.nextLine();       // read whole line as String

	      // Stop writing your solution here. -------------------------------------
	      out.close();
	   }

	     

	   //-----------PrintWriter for faster output---------------------------------
	   public static PrintWriter out;
	      
	   //-----------MyScanner class for faster input----------
	   public static class MyScanner {
	      BufferedReader br;
	      StringTokenizer st;
	 
	      public MyScanner() {
	         br = new BufferedReader(new InputStreamReader(System.in));
	      }
	 
	      String next() {
	          while (st == null || !st.hasMoreElements()) {
	              try {
	                  st = new StringTokenizer(br.readLine());
	              } catch (IOException e) {
	                  e.printStackTrace();
	              }
	          }
	          return st.nextToken();
	      }
	 
	      int nextInt() {
	          return Integer.parseInt(next());
	      }
	 
	      long nextLong() {
	          return Long.parseLong(next());
	      }
	 
	      double nextDouble() {
	          return Double.parseDouble(next());
	      }
	 
	      String nextLine(){
	          String str = "";
		  try {
		     str = br.readLine();
		  } catch (IOException e) {
		     e.printStackTrace();
		  }
		  return str;
	      }

	   }
	   //--------------------------------------------------------
	}
