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
	    	  int n = sc.nextInt();
	    	  String arr[] = new String[n];
	    	  String nextStart,nextEnd,tempMid;
	    	  StringBuilder mid = new StringBuilder();
	    	  boolean isStartMatch,isEndMatch;
	    	  boolean noAlteration=false,isPossible=true;
	    	  String start="",end;
	    	  for( int i=0 ; i<n ; ++i ) {
	    		  arr[i] = sc.next();
	    		  if( arr[i].indexOf("*")==-1 && !noAlteration ) {
	    			  noAlteration =true;
	    			  start = arr[i];
		    		  end = arr[i];
	    		  }
	    	  }
	    	  if( noAlteration ) {
	    		  String temp;
	    		  for( int i=0 ; i<n ; ++i ) {
	    			  if( arr[i].indexOf("*")==-1 ) {
	    				  if( !start.contains(arr[i]) ) {
	    					  isPossible = false;
		    				  break;
	    				  }
	    			  }else {
	    				  nextStart = arr[i].substring(0,arr[i].indexOf("*"));
			    		  nextEnd = arr[i].substring(arr[i].lastIndexOf("*")+1);
			    		  tempMid = arr[i].substring(arr[i].indexOf("*"),arr[i].lastIndexOf("*"));
			    		  tempMid = tempMid.replace("*", "");
		    			  if( !start.contains(nextStart) || !start.contains(nextEnd) || !start.contains(tempMid) ) {
		    				  isPossible = false;
		    				  break;
		    			  }
	    			  }
	    			  
	    		  }
	    		  if( isPossible ) {
	    			  if( start.length()<=10000 ) {
	    				  System.out.println("Case #"+testcase+": "+start);
	    			  }else {
	    				  System.out.println("Case #"+testcase+": *");
	    			  }
	    		  }else {
	    			  System.out.println("Case #"+testcase+": *");
	    		  }
    			  continue;
	    	  }
	    	  
    		  
	    	  
	    	  
	    	  start = arr[0].substring(0,arr[0].indexOf("*"));
    		  end = arr[0].substring(arr[0].lastIndexOf("*")+1);
    		  tempMid = arr[0].substring(arr[0].indexOf("*"),arr[0].lastIndexOf("*"));
    		  tempMid = tempMid.replace("*", "");
    		  mid.append(tempMid);
	    	  for( int i=1 ; i<n ; ++i ) {
	    		  isStartMatch = false;
	    		  isEndMatch = false;
	    		  nextStart = arr[i].substring(0,arr[i].indexOf("*"));
	    		  nextEnd = arr[i].substring(arr[i].lastIndexOf("*")+1);
	    		  tempMid = arr[i].substring(arr[i].indexOf("*"),arr[i].lastIndexOf("*"));
	    		  tempMid = tempMid.replace("*", "");
	    		  mid.append(tempMid);
    			  if( nextStart.contains(start) ) {
    				  start = nextStart;
    				  isStartMatch = true;
    			  }else if( start.contains(nextStart) ) {
    				  isStartMatch = true;
    			  }else {
    				  isPossible=false;
    				  break;
    			  }
    			  if( nextEnd.contains(end) ) {
    				  end = nextEnd;
    				  isEndMatch = true;
    			  }else if( end.contains(nextEnd) ) {
    				  isEndMatch = true;
    			  }else {
    				  isPossible=false;
    				  break;
    			  }
	    	  }
	    	  if( isPossible ) {
	    		  String result = start+mid+end;
	    		  if( result.length()<=10000 ) {
    				  System.out.println("Case #"+testcase+": "+result);
    			  }else {
    				  System.out.println("Case #"+testcase+": *");
    			  }
	    	  }else {
	    		  System.out.println("Case #"+testcase+": *");
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
