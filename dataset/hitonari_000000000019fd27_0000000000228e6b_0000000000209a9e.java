import java.util.Scanner;

public class Solution {
  private static void handleTestCase(int b, Scanner scanner) {
    StringBuilder sb = new StringBuilder();
    int i = 1;
    int count = 1;
    while (i <= b) {
      System.out.println(i);
      int val = scanner.nextInt();
      if (count % 10 != 1) {
        sb.append(val);
        ++i;
      }
      ++count;
    }
    System.out.println(sb.toString());
    scanner.nextLine();
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int testCount = scanner.nextInt();
    int b = scanner.nextInt();
    for (int i = 1; i <= testCount; ++i) {
      handleTestCase(b, scanner);
    }
  }
}