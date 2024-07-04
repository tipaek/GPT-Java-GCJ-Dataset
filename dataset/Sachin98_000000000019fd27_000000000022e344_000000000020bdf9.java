import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


class Activity implements Comparable<Activity>{
	int startTime,endTime,index;
	
	Activity(int startTime,int endTime,int index){
		this.startTime = startTime;
		this.endTime = endTime;
		this.index = index;
	}
	
	public int compareTo( Activity obj2) {
		return this.startTime-obj2.startTime;
	}
}
public class Solution{
	
	   public static void main(String[] args) {
	      MyScanner sc = new MyScanner();
	      out = new PrintWriter(new BufferedOutputStream(System.out));
//		   Scanner sc = new Scanner(System.in);
	      
	      int t = sc.nextInt();
	      for( int k=1 ; k<=t ; ++k ) {
	    	  int n = sc.nextInt();
	    	  int startTime,endTime;
	    	  ArrayList<Activity> list = new ArrayList<Activity>();
	    	  for( int i=0 ; i<n ; ++i ) {
	    		  startTime = sc.nextInt();
	    		  endTime = sc.nextInt();
	    		  Activity activity = new Activity(startTime, endTime, i);
	    		  list.add(activity);
	    	  }
	    	  Collections.sort(list);
	    	  int jEndTime=0,cEndTime=0;
	    	  boolean isPossible = true;
	    	  char result[] = new char[n];
	    	  for( Activity activity : list ) {
	    		  if( activity.startTime>=cEndTime ) {
	    			  result[activity.index] = 'C';
	    			  cEndTime = activity.endTime;
	    		  }else if( activity.startTime>=jEndTime ) {
	    			  result[activity.index] = 'J';
	    			  jEndTime = activity.endTime;
	    		  }else {
	    			  isPossible = false;
	    			  break;
	    		  }
	    	  }
	    	  if(!isPossible ) {
	    		  System.out.println("Case #"+k+": IMPOSSIBLE");
	    		  continue;
	    	  }
	    	  String resultString = new String(result);
	    	  System.out.println("Case #"+k+": "+resultString);
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
