import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class Solution{
		public static boolean checkIfPossible( int sum ) {
			if( (sum&(sum+1))==0 ) {
				return true;
			}else {
				return false;
			}
		}
		
		public static StringBuilder fillDirection( int addNum, int subNum ,char addChar,char subChar ) {
			int power=1;
			StringBuilder directions = new StringBuilder();
			while( power<=addNum ) {
				if( (addNum&power)!=0 ) {
					directions.append(addChar);
				}else if( (subNum&power)!=0 ) {
					directions.append(subChar);
				}else {
					directions.append('0');
				}
				power *= 2;
			}
			return directions;
		}
		
		public static StringBuilder combine( StringBuilder res1,StringBuilder res2 ) {
			StringBuilder result = new StringBuilder();
			int n = Math.max(res1.length(), res2.length() );
			for( int i=0 ; i<n ; ++i ) {
				if( i<res1.length() && res1.charAt(i)!='0' ) {
					result.append(res1.charAt(i));
				}else if( i<res2.length() && res2.charAt(i)!='0' ) {
					result.append(res2.charAt(i));
				}
			}
			return result;
		}
		
	   public static void main(String[] args) {
	      MyScanner sc = new MyScanner();
	      out = new PrintWriter(new BufferedOutputStream(System.out));
	      int t = sc.nextInt();
	      for( int testcase=1 ; testcase<=t ; ++testcase) {
	    	  int num1 = sc.nextInt();
	    	  StringBuilder res1,res2;
	    	  int num2 = sc.nextInt();
	    	  char vAddChar='N',vSubChar='S',hAddChar='E',hSubChar='W';
	    	  if( num1<0 ) {
	    		  hAddChar = 'W';
	    		  hSubChar = 'E';
	    		  num1 = Math.abs(num1);
	    	  }
	    	  if( num2<0 ) {
	    		  vAddChar = 'S';
	    		  vSubChar = 'N';
	    		  num2 = Math.abs(num2);
	    	  }
	    	  int add1,sub1,add2,sub2;
	    	  if( num1%2==0 && num2%2==0 ) {
	    		  System.out.println("Case #"+testcase+": IMPOSSIBLE");
	    		  continue;
	    	  }else if( num1%2!=0 && num2%2!=0 ) {
	    		  System.out.println("Case #"+testcase+": IMPOSSIBLE");
	    		  continue;
	    	  }
	    	  if( num1==0 ) {
	    		  if( checkIfPossible(num2) ) {
	    			  res2 = fillDirection(num2, 0, vAddChar, vSubChar);
	    			  System.out.println("Case #"+testcase+": "+res2);
	    		  }else {
	    			  System.out.println("Case #"+testcase+": IMPOSSIBLE");
	    		  }
	    		  continue;
	    	  }
	    	  if( num2==0 ) {
	    		  if( checkIfPossible(num1) ) {
	    			  res2 = fillDirection(num1, 0, hAddChar, hSubChar);
	    			  System.out.println("Case #"+testcase+": "+res2);
	    		  }else {
	    			  System.out.println("Case #"+testcase+": IMPOSSIBLE");
	    		  }
	    		  continue;
	    	  }
	    	  add1=1;
	    	  while(add1<=num1 ) {
	    		  add1 *= 2;
	    	  }
	    	  add2=1;
	    	  while(add2<=num2 ) {
	    		  add2 *= 2;
	    	  }
	    	  
	    	  sub1 = add1 - num1;
	    	  sub2 = add2 - num2;
	    	  
	    	  if( checkIfPossible(num1+num2) ) {
	    		  res1 = fillDirection(num1, 0, hAddChar, hSubChar);
    			  res2 = fillDirection(num2, 0, vAddChar, vSubChar);
	    		  System.out.println("Case #"+testcase+": "+combine(res1, res2));
	    	  }else if( checkIfPossible(num1+add2+sub2) ) {
	    		  res1 = fillDirection(num1, 0, hAddChar, hSubChar);
	    		  res2 = fillDirection(add2, sub2, vAddChar, vSubChar);
	    		  System.out.println("Case #"+testcase+": "+combine(res1, res2));
	    	  }else if( checkIfPossible(num2+add1+sub1) ) {
	    		  res1 = fillDirection(add1, sub1, hAddChar, hSubChar);
	    		  res2 = fillDirection(num2, 0, vAddChar, vSubChar);
	    		  System.out.println("Case #"+testcase+": "+combine(res1, res2));
	    	  }else if( checkIfPossible(add1+add2+sub1+sub2) ) {
	    		  res1 = fillDirection(add1, sub1, hAddChar, hSubChar);
	    		  res2 = fillDirection(num2, 0, vAddChar, vSubChar);
	    		  System.out.println("Case #"+testcase+": "+combine(res1, res2));
	    	  }else {
	    		  System.out.println("Case #"+testcase+": IMPOSSIBLE");
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