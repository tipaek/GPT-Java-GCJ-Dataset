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
//		   Scanner sc = new Scanner(System.in);
	      
	      int t = sc.nextInt();
	      for( int k=1 ; k<=t ; ++k ) {
	    	  String str = sc.next();
	    	  String openBracket = "(",closeBracket=")";
	    	  StringBuilder result = new StringBuilder();
	    	  Integer digit,prevDigit=0,diff;
	    	  String digitStr;
	    	  for( int i=0 ; i<str.length() ; ++i ) {
	    		  digitStr = str.substring(i,i+1);
	    		  digit = Integer.parseInt(digitStr);
	    		  if( prevDigit>digit ) {
	    			  diff = prevDigit-digit;
	    			  for( int j=1 ; j<=diff ; ++j ) {
	    				  result.append(")");
	    			  }
	    		  }else if( digit>prevDigit ) {
	    			  diff = digit-prevDigit;
	    			  for( int j=1 ; j<=diff ; ++j ) {
	    				  result.append("(");
	    			  }
	    		  }  
	    		  result.append(digit);
	    		  prevDigit = digit;
	    	  }
	    	  for( int j=1 ; j<=prevDigit ; ++j ) {
	    		  result.append(")");
	    	  }
	    	  System.out.println("Case #"+k+": "+result);
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