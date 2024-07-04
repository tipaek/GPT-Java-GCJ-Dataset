import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int n = in.nextInt();
    for (int i = 1; i <= n; ++i) {
        String result = "";
      String q = in.next();
	  for(int j=0;j<q.length();j++) {
		int d = Character.getNumericValue(q.charAt(j));
		String a = "";
		String b = "";
		for(int k=0;k<d;k++) {
		  a += "(";
		  b += ")";
	     }
	  result += a + q.charAt(j) + b;
	  }
	  while(result.contains(")(")) {
	      result = result.replace(")(","");
	  }
      System.out.println("Case #" + i + ": " + result);
    }
  }
}