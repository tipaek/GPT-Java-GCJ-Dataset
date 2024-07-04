package google;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class Solution{
		
	   public static void main(String[] args) {
	      MyScanner sc = new MyScanner();
	      out = new PrintWriter(new BufferedOutputStream(System.out));
	      int t = sc.nextInt();
	      for( int testcase=1 ; testcase<=t ; ++testcase) {
	    	  out.print("Case #"+testcase+": ");
	    	  
	    	  int x = sc. nextInt();
	    	  int y = sc.nextInt();
	    	  String moves = sc.next();
	    	  int numMove = moves.length();
	    	  int curX=0,curY=0;
	    	  int horDist,verDist;
	    	  int result=0;
	    	  boolean isPossible=false;
	    	  for( int i=0 ; i<numMove ; ++i ) {
	    		  switch (moves.charAt(i) ) {
	    		  	case 'N':
	    		  		++y;
	    		  		break;
	    		  	case 'S':
	    		  		--y;
	    		  		break;
	    		  	case 'W':
	    		  		--x;
	    		  		break;
	    		  	case 'E':
	    		  		++x;
	    		  		break; 		
	    		  }
	    		  ++result;
	    		  horDist = Math.abs(x-curX);
	    		  verDist = Math.abs(y-curY);
	    		  if( (horDist+verDist)<=1 ) {
	    			  isPossible = true;
	    			  break;
	    		  }
	    		  if( horDist==verDist ) {
	    			  continue;
	    		  }else if( horDist>verDist ) {
	    			  if( curX < x ) {
	    				  ++curX;
	    			  }else {
	    				  --curX;
	    			  }
	    		  }else {
	    			  if( curY<y ) {
	    				  ++curY;
	    			  }else {
	    				  --curY;
	    			  }
	    		  }
	    	  }
	    	  if( !isPossible ) {
	    		  out.println("IMPOSSIBLE");
	    	  }else {
	    		  out.println(result);
	    	  }
	      }
	      //OUR Code
	      
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
