import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();
    in.nextLine();
    for (int c = 1; c <= t; ++c) {
    	String N = in.nextLine();
    	addParanthesis(N, c);
    }
  }
  
  private static void addParanthesis(String N, int c){
	  N = N+"0";
	  String f = N;
	  int k =0;
	  int o = 0;
	  for(int i=0;i<N.length()-1;i++){
		  int n = Integer.parseInt(""+N.charAt(i));
		  int n1 = Integer.parseInt(""+N.charAt(i+1));
	//	  System.out.println(n);
	//	  System.out.println(n1);
	//	  System.out.println("o"+o);
		 
		  if((n - o) > 0 && n > 0){
			  f = addChar(f, "(", n-o, i+k);
			  k = k + n - o;
			  o = n - o;
		  }
//		  if(n1 > n && o > 0){
//			  f = addChar(f, ")", (n1 - n), i+k+1);
//			  o = o - (n1 - n);
//			 
//			  k = k + (n1 - n);
//		  }
		  if(n > n1 && o > 0){
			  f = addChar(f, ")", (n - n1), i+k+1);
			  k = k + (n - n1);
			  o = o - (n - n1);
		  }
	  }
	  f = f.substring(0, f.length() - 1);
	  System.out.println("Case #" + c + ": " +f);
  }
  
  
  private static String addChar(String str, String ch, int count, int position) {
	  String c = "";
	  for(int i=0;i<count;i++){
		  c = c + ch;
	  }
	  
	    return str.substring(0, position) + c + str.substring(position);
	}
  
}