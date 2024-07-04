import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Solution{
	
	
	
	
	   public static void main(String[] args) {
	      MyScanner sc = new MyScanner();
	      out = new PrintWriter(new BufferedOutputStream(System.out));
//		   Scanner sc = new Scanner(System.in);
	      
	      int t = sc.nextInt();
	      for( int k=1 ; k<=t ; ++k ) {
	    	  int n = sc.nextInt();
	    	  int arr[][] = new int[n][n];
	    	  HashMap<Integer, Integer> fullCount = new HashMap<Integer, Integer>();
	    	  Integer presentCount,duplicateRowCount=0,duplicateColCount=0;
	    	  boolean isDuplicate;
	    	  Integer diagonalSum=0;
	    	  for( int i=0 ; i<n ; ++i ) {
	    		  isDuplicate = false;
	    		  fullCount.clear();
	    		  
	    		  for( int j=0 ; j<n ; ++j ) {
	    			  arr[i][j] = sc.nextInt();
	    			  if( i==j ) {
	    				  diagonalSum += arr[i][j];
	    			  }
	    			  presentCount = fullCount.get(arr[i][j]);
	    			  if( presentCount!=null ) {
	    				  isDuplicate = true;
	    			  }else {
	    				  fullCount.put(arr[i][j],1);
	    			  }
	    		  }
	    		  if( isDuplicate ) {
	    			  ++duplicateRowCount;
	    		  }
	    	  }
	    	  System.out.println();
	    	  for( int i=0 ; i<n ; ++i ) {
	    		  isDuplicate = false;
	    		  fullCount.clear();
	    		  for( int j=0 ; j<n ; ++j ) {
	    			  presentCount = fullCount.get(arr[j][i]);
	    			  if( presentCount!=null ) {
	    				  isDuplicate = true;
	    				  break;
	    			  }else {
	    				  fullCount.put(arr[j][i],1);
	    			  }
	    		  }
	    		  if( isDuplicate ) {
	    			  ++duplicateColCount;
	    		  }
	    	  }
	    	  System.out.println("Case #"+k+": "+diagonalSum+" "+duplicateRowCount+" "+duplicateColCount);
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
