import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int numTests = scanner.nextInt();
    for(int t = 1; t <= numTests; t++){
      String S = scanner.next();
      int numOpenParens = 0;
      StringBuilder stringBuilder = new StringBuilder();
      char[] digits = S.toCharArray();
      for(char digit : digits) {
        int val = Character.getNumericValue(digit);
        if(val > numOpenParens){
          while(val > numOpenParens){
            stringBuilder.append("(");
            numOpenParens++;
          }
        }else if(val < numOpenParens){
          while(val < numOpenParens){
            stringBuilder.append(")");
            numOpenParens--;
          }
        }
        stringBuilder.append(val);
      }
      while(numOpenParens > 0){
        stringBuilder.append(")");
        numOpenParens--;
      }
      System.out.println("Case #" + t + ": " + stringBuilder.toString());
    }
  }
}
