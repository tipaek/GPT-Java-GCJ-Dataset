
import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; i++) {
      solve(in, i);
      
    }
  }
  public static void solve(Scanner in, int caseNum){
	  StringBuilder ret = new StringBuilder();
	  String line = in.next();
	  int prevPara = 0;
	  for(int i = 0; i < line.length(); i++){
		  int value = line.charAt(i) - '0';
		  if(prevPara < value){
			  while(prevPara < value){
				  ret.append("(");
				  prevPara++;
			  }
		  }else if(prevPara > value){
			  while(prevPara > value){
				  ret.append(")");
				  prevPara--;
			  }
		  }
		  ret.append(value);
	  }
	  while(prevPara > 0){
		  ret.append(")");
		  prevPara--;
	  }
	  System.out.println("Case #" + caseNum + ": " + ret.toString());
  }
}