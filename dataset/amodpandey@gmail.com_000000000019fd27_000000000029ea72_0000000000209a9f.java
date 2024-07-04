import java.io.PrintWriter;
import java.util.Scanner;

public class Solution {

  public static void main(String args[]) throws Exception {
    Scanner sc = new Scanner(System.in);
    PrintWriter pw = new PrintWriter(System.out);

    int testCases = sc.nextInt();
    for (int testCase = 1; testCase <= testCases; testCase++) {
      String n = sc.next();
      
      String val = solve(n);
      
      pw.printf("Case #" + testCase + ": %s\n", val);
      pw.flush();
    }
    pw.close();
    sc.close();
  }

  private static String solve(String n) {
    
    StringBuilder val = new StringBuilder();
    int startIndex = 0;
    
    int prevVal = -1;
    
    for (char c : n.toCharArray()) {
      startIndex = val.length();
      int currVal = Character.getNumericValue(c);
      if(currVal == 0) {
        val.append(c);
        prevVal = 0;
        continue;
      }
      
      if(prevVal >= currVal) {
        pad(c, 0, val, startIndex - currVal);
      }
      else if(prevVal < currVal && prevVal > 0) {
        pad(c, currVal - prevVal, val, startIndex - prevVal);
      }
      else 
        pad(c, currVal, val, startIndex);
      
      prevVal = currVal;
    }
    
    return val.toString();
  }

  private static void pad(char c, int n, StringBuilder val, int startIndex) {
    for (int i = 0; i < n; i++) {
      val.insert(startIndex, '(');  
      startIndex++;
    }
    val.insert(startIndex++, c);  
    for (int i = 0; i < n; i++) {
      val.insert(startIndex, ')');   
      startIndex++;
    }
  }
}
