import java.util.Scanner;
import java.lang.StringBuilder;
public class Solution {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in); 
      int num= sc.nextInt();
      int x=1;
      while(x<=num) {
          StringBuilder result = new StringBuilder();
          String input = sc.next();
          int open = 0;
          for (int i = 0; i < input.length(); i++) {
              int curr = Character.getNumericValue(input.charAt(i));
              while (curr != open) {
                  if (curr > open) {
                      result.append('(');
                      open++;
                  } else {
                      result.append(')');
                      open--;
                  }
              }
              result.append(curr);
          }
          while (open > 0) {
              result.append(')');
              open--;
          }
          System.out.println(" case #"+(x)+": " + result.toString());
          x++;
      }
   }
}