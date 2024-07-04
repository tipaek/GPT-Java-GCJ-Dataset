import java.util.*;

public class Solution {


  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int testcases = sc.nextInt();
    int cases = 1;

    while (testcases > 0) {
      String str = sc.next();

      Stack<Integer> stack = new Stack<>();
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < str.length(); i++) {
        int number = Integer.parseInt(str.charAt(i)+"");
        //System.out.println("number"+number);

        if (number == 0) {
          while (!stack.isEmpty()) {
            int loopCount = stack.pop();
            for (int k = 0; k < loopCount; k++) {
              sb.append(")");
            }
          }
          sb.append(number);
        } else {
          if (!stack.isEmpty()) {
            int pCount = stack.pop();
            if (pCount >= number) {
              for (int k = 1; k <= pCount - number; k++) {
                sb.append(")");
              }
            } else {
              for (int k = 1; k <= number - pCount; k++) {
                sb.append("(");
              }
            }
            stack.push(number);
            sb.append(number);

          }else{
            stack.push(number);
            for (int k = 0; k < number; k++) {
              sb.append("(");
            }
            sb.append(number);
          }
        }


      }

      if (!stack.isEmpty()) {
        int loopCount = stack.pop();
        for (int k = 1; k <= loopCount; k++) {
          sb.append(")");
        }
      }

      System.out.println("Case #" + cases + ": " + sb.toString());
      cases++;
      testcases--;
    }

  }


}