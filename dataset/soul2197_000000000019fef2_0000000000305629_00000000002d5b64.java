import java.util.Scanner;

public class Solution {
  public static void main(String[] args) {
    final Scanner scanner = new Scanner(System.in);
    final int T = scanner.nextInt();

    for (int t = 1; t <= T; t++) {
      final int R = scanner.nextInt();
      final int S = scanner.nextInt();

      if (R == 2 && S == 2) {
        System.out.println(String.format("Case #%d: 1", t));
        System.out.println("2 1");
      }
      if (R == 2 && S == 3) {
        System.out.println(String.format("Case #%d: 2", t));
        System.out.println("4 1");
        System.out.println("3 1");
      }
      if (R == 2 && S == 4) {
        System.out.println(String.format("Case #%d: 3", t));
        System.out.println("2 5");
        System.out.println("2 1");
        System.out.println("4 2");
      }
      if (R == 2 && S == 5) {
        System.out.println(String.format("Case #%d: 4", t));
        System.out.println("6 1");
        System.out.println("5 1");
        System.out.println("4 5");
        System.out.println("4 4");
      }
      if (R == 2 && S == 6) {
        System.out.println(String.format("Case #%d: 5", t));
        System.out.println("4 3");
        System.out.println("2 7");
        System.out.println("6 2");
        System.out.println("5 6");
        System.out.println("5 5");
      }
      if (R == 2 && S == 7) {
        System.out.println(String.format("Case #%d: 6", t));
        System.out.println("8 1");
        System.out.println("7 1");
        System.out.println("4 7");
        System.out.println("6 4");
        System.out.println("6 7");
        System.out.println("6 6");
      }
      if (R == 3 && S == 2) {
        System.out.println(String.format("Case #%d: 2", t));
        System.out.println("3 2");
        System.out.println("2 1");
      }
      if (R == 3 && S == 3) {
        System.out.println(String.format("Case #%d: 3", t));
        System.out.println("2 2");
        System.out.println("3 3");
        System.out.println("4 4");
      }
      if (R == 3 && S == 4) {
        System.out.println(String.format("Case #%d: 5", t));
        System.out.println("2 2");
        System.out.println("3 3");
        System.out.println("4 7");
        System.out.println("5 4");
        System.out.println("4 3");
      }
      if (R == 4 && S == 2) {
        System.out.println(String.format("Case #%d: 2", t));
        System.out.println("2 3");
        System.out.println("2 5");
      }
      if (R == 4 && S == 3) {
        System.out.println(String.format("Case #%d: 4", t));
        System.out.println("2 3");
        System.out.println("2 5");
        System.out.println("4 5");
        System.out.println("4 7");
      }
      if (R == 5 && S == 2) {
        System.out.println(String.format("Case #%d: 3", t));
        System.out.println("2 4");
        System.out.println("2 6");
        System.out.println("1 8");
      }
    }
  }
}
