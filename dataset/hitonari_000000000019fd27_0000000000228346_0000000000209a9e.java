import java.util.Scanner;

public class Solution {
  private static void handleTestCase(int index, Scanner scanner) {
    int b = scanner.nextInt();
    StringBuilder sb = new StringBuilder();
    int i = 1;
    while (i <= b) {
      System.out.println(i);
      int val = scanner.nextInt();
      if (i % 10 != 1) {
        sb.append(val);
        ++i;
      }
    }
    System.out.println(sb.toString());
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int testCount = scanner.nextInt();
    for (int i = 1; i <= testCount; ++i) {
      handleTestCase(i, scanner);
    }
  }
}