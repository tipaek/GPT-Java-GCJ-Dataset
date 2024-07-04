import java.util.LinkedList;
import java.util.Scanner;

public class NestingDepth {

  public static void main(String[] args) {
    try (Scanner in = new Scanner((System.in))) {
      int t = in.nextInt();
      in.nextLine();
      for (int i = 1; i <= t; i++) {
        String s = in.nextLine();
        System.out.println(String.format("Case #%d: %s", i, nestingDepth(s)));
      }
    }
  }

  private static String nestingDepth(String s) {
    LinkedList<Character> stack = new LinkedList<>();
    StringBuilder output = new StringBuilder();

    for (int i = 0; i < s.length(); i++) {
      int d = Character.getNumericValue(s.charAt(i));
      if (stack.size() <= d) {
        while (stack.size() < d) {
          stack.add('(');
          output.append('(');
        }
        output.append(d);
      }
      if (stack.size() > d) {
        while (stack.size() != d) {
          stack.poll();
          output.append(')');
        }
        output.append(d);
      }
    }

    while (!stack.isEmpty()) {
      stack.poll();
      output.append(')');
    }

    return output.toString();
  }
}
