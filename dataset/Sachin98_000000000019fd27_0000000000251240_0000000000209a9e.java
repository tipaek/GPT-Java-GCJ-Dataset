import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class Solution{
	
		//-----------PrintWriter for faster output---------------------------------
	    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
	    public static int queryCount=1;
	    
		public static void write(int num){
			out.println("Query Count : "+queryCount+" "+num);
			out.flush();
			++queryCount;
		}
		
		public static StringBuilder compliment(StringBuilder res) {
			StringBuilder compliment = new StringBuilder();
	    	for( int i=0 ; i<res.length() ; ++i ) {
	    		if( res.charAt(i)=='0') {
	    			compliment.append('1');
	    		}else{
	    			compliment.append('0');
	    		}
	    	}
	    	return compliment;
	      }
	
	   public static void main(String[] args) {
	      MyScanner sc = new MyScanner();
	      
	      int t = sc.nextInt();
	      int b = sc.nextInt();
	      
	      
	      
	      for( int testcase=1 ; testcase<=t ; ++testcase ) {
	    	  int sameBit,sameBitLeftPosition=1,diffBitLeft,diffBitRight,difBitLeftPosition=1,difBitRightPosition=2;
	    	  int prevSameBit,prevDifLeftBit,prevDifRightBit;
	    	  StringBuilder result = new StringBuilder(b);
	    	  for( int i=0 ; i<b ; ++i ) {
	    		  result.append('0');
	    	  }
	    	  boolean isSameBitAvailable=false,isDifBitAvailable=false,isPrevValid;
	    	  int pairNum=1,leftBit,rightBit;
	    	  while( (!isSameBitAvailable || !isDifBitAvailable) && pairNum<=(b/2) ) {
	    		  write(pairNum);
	    		  leftBit = sc.nextInt();
	    		  write(b-pairNum+1);
	    		  rightBit = sc.nextInt();
	    		  if( leftBit==rightBit ) {
	    			  sameBit = leftBit;
	    			  sameBitLeftPosition = pairNum;
	    			  isSameBitAvailable = true;
	    		  }else if( leftBit!=rightBit ) {
	    			  diffBitLeft = leftBit;
	    			  diffBitRight = rightBit;
	    			  difBitLeftPosition = pairNum;
	    			  difBitRightPosition = b-pairNum+1;
	    			  isDifBitAvailable = true;
	    		  }
	    		  ++pairNum;
	    	  }
	    	  if( (queryCount%10)==0 ) {
	    		  write(1);
	    		  leftBit = sc.nextInt();
	    	  }
	    	  write(sameBitLeftPosition);
	    	  prevSameBit = sc.nextInt();
	    	  write(difBitLeftPosition);
	    	  prevDifLeftBit = sc.nextInt();
	    	  pairNum=1;
	    	  boolean isSamebitSame,isDifBitSame;
	    	  while( pairNum<=(b/2) ) {
	    		  if( (queryCount%10)==1 ) {
	    			  write(sameBitLeftPosition);
	    			  sameBit = sc.nextInt();
	    			  write(difBitLeftPosition);
	    			  diffBitLeft = sc.nextInt();
	    			  if( sameBit==prevSameBit ) {
	    				  isSamebitSame = true;
	    			  }else {
	    				  isSamebitSame =false;
	    			  }
	    			  if( diffBitLeft==prevDifLeftBit ) {
	    				  isDifBitSame = true;
	    			  }else {
	    				  isDifBitSame = false;
	    			  }
	    			  if( !isSamebitSame && !isDifBitSame  ) {
	    				  result = compliment(result);
	    			  }else if( isSamebitSame && !isDifBitSame ) {
	    				  result = result.reverse();
	    			  }else if( !isSamebitSame && isDifBitSame ) {
	    				  result = result.reverse();
	    				  result = compliment(result);
	    			  }
	    			  prevSameBit = sameBit;
	    			  prevDifLeftBit = diffBitLeft;
	    		  }
	    		  if( (queryCount%10)==0 ) {
	    			  write(1);
	    			  leftBit=sc.nextInt();
	    			  continue;
	    		  }
	    		  write(pairNum);
	    		  leftBit = sc.nextInt();
	    		  result.replace(pairNum-1,pairNum , String.valueOf(leftBit));
	    		  write(b-pairNum+1);
	    		  rightBit = sc.nextInt();
	    		  result.replace(b-pairNum,b-pairNum+1, String.valueOf(rightBit));
	    		  ++pairNum;
	    	  } 
	    	  if( (b%2)==1 ) {
	    		  if( (queryCount%10)==1 ) {
	    			  write(sameBitLeftPosition);
	    			  sameBit = sc.nextInt();
	    			  write(difBitLeftPosition);
	    			  diffBitLeft = sc.nextInt();
	    			  if( sameBit==prevSameBit ) {
	    				  isSamebitSame = true;
	    			  }else {
	    				  isSamebitSame =false;
	    			  }
	    			  if( diffBitLeft==prevDifLeftBit ) {
	    				  isDifBitSame = true;
	    			  }else {
	    				  isDifBitSame = false;
	    			  }
	    			  if( !isSamebitSame && !isDifBitSame  ) {
	    				  result = compliment(result);
	    			  }else if( isSamebitSame && !isDifBitSame ) {
	    				  result = result.reverse();
	    			  }else if( !isSamebitSame && isDifBitSame ) {
	    				  result = result.reverse();
	    				  result = compliment(result);
	    			  }
	    			  prevSameBit = sameBit;
	    			  prevDifLeftBit = diffBitLeft;
	    		  }
	    		  write(pairNum);
	    		  leftBit = sc.nextInt();
	    		  result.replace(pairNum-1,pairNum , String.valueOf(leftBit));
	    	  }
	    	  out.println(result.toString());
	    	  out.flush();
	    	  char resultReply = sc.next().charAt(0);
	    	  if( resultReply=='N' ) {
	    		  System.out.println("Negative error");
	    		  break;
	    	  }
	      }
	      
//	      long k     = sc.nextLong();       // read input as long
//	      double d   = sc.nextDouble();     // read input as double
//	      String str = sc.next();           // read input as String
//	      String s   = sc.nextLine();       // read whole line as String

	      // Stop writing your solution here. -------------------------------------
	      out.close();
	   }

	     

	   
	      
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