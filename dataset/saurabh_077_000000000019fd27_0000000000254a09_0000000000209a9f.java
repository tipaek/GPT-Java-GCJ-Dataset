/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class Solution {
	public static void main (String[] args)throws IOException {
		  Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		  int n;
		  n = Integer.parseInt(in.nextLine());
		  int t = 1;
		  while(t <= n){
		      int remain = 0;
		      String s = in.nextLine();
		     // System.out.println(s);
		      int ref = 0, val;
		      StringBuffer sb = new StringBuffer();
		      for(int i=0 ; i < s.length(); i++){
		          char ch = '(';
		          int ival = s.charAt(i) - '0';
		          val = ival - ref;
		          if(val < 0){
		            val = 0 - val;
		            ch = ')';  
		            
		          }
		          for(int j = 0 ; j < val ; j++ ){
		                sb.append(ch);
		                if(ival - ref < 0){
		                    remain--;
		                }   else
		                        remain++;
		                
		          }
		          sb.append(s.charAt(i));
		      ref = ival;
		      }
		      int i=0;
		      while(i<remain){
		          sb.append(')');
		          i++;
		      }
		      String ans = sb.toString();
		      System.out.println("Case #" + t + ":"+" "+ ans);
		      t++;
		  }
	}
}