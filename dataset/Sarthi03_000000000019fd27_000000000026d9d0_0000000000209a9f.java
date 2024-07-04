import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();
    in.nextLine();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      String n = in.nextLine();
      String str ="";
      char ar[] = n.toCharArray();
      int bleft=0;
      for(int j=0;j<ar.length;j++){
      	int cur = ar[j] - '0';
      	if(bleft>cur)
      		str += retParenthesis(bleft-cur,2);
      	else
      		str += retParenthesis(cur-bleft,1);
      	bleft = cur;
      	str += Character.toString(ar[j]);
      }
      str += retParenthesis(bleft,2);
      System.out.println("Case #" + i + ": " + str);
    }
  }

  public static String retParenthesis(int num, int type){
  	String str ="";
  	for(int i=0;i<num;i++){
  		str += (type==1?"(":")");
  	}
  	return str;
  }
}