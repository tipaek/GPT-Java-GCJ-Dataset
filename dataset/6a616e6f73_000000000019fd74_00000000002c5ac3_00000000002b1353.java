
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Solution {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
//    scanner = example();
//    scanner = bigTest();

    int T = scanner.nextInt();
    for (int t = 0; t < T; t++) {
      Input input = Input.fromScanner(scanner);
      printCase(t, solve(input));
    }
  }

  private static Scanner example() {
    return new Scanner("3\n" +
      "1\n" +
      "4\n" +
      "19\n");
  }

  private static Scanner example2() {
    return new Scanner("1\n" +
      "1024\n" +
      "4\n" +
      "19\n");
  }

  private static Scanner bigTest() {
    StringBuilder sb = new StringBuilder();
    int T = 1000;

    char newline = '\n';
    sb.append(T).append(newline);
    for (int t = 0; t < T; t++) {
      sb.append(t * t).append(newline);
    }

    return new Scanner(sb.toString());
  }

  private static class Input {
    private final int N;

    private Input(int n) {
      N = n;
    }

    private static Input fromScanner(Scanner scanner) {
      return new Input(scanner.nextInt());
    }
  }

  private static void printCase(int t, List<String> s) {
    System.out.println(String.format("Case #%d", t + 1));
    s.forEach(System.out::println);
  }

  private static List<String> solve(Input input) {
    List<String> steps = new ArrayList<>();
    boolean left = true;
    int row = 1;
    List<Integer> powers = findPowersOfTwo(input);
    for (int power : powers) {
      for (; row < power + 1; row++) {
        if (left) {
          steps.add(String.format("%s 1", row));
        } else {
          steps.add(String.format("%s %s", row, row));
        }
      }

      int row2 = row;
      if (left) {
        IntStream.range(0, power).forEach(i -> steps.add(String.format("%s %s", row2, i + 1)));
      } else {
        IntStream.range(0, power).forEach(i -> steps.add(String.format("%s %s", row2, power - i + 1)));
      }

      left = !left;
    }
    int sum = 0;
    for (String step : steps) {
      String[] parts = step.split(" ");
      int r = Integer.parseInt(parts[0]) - 1;
      int c = Integer.parseInt(parts[1]) - 1;
      sum += binomialCoeff(r, c);
    }

    int remaining = input.N - sum;
    boolean left2 = left;
    int row2 = row;
    IntStream.range(0, remaining).forEach(i -> {
      if (left2) {
        steps.add(String.format("%s 1", row2 + i));
      } else {
        steps.add(String.format("%s %s", row2 + i, row2 + i));
      }
    });

    return steps;
  }

  private static List<Integer> findPowersOfTwo(Input input) {
    List<Integer> powers = new ArrayList<>();
    powers.add(0);
    while (true) {
      int steps = powers.stream().mapToInt(p -> p + 1).sum()
        + powers.stream().mapToInt(Integer::valueOf).max().getAsInt()
        - powers.size();
      int sum = steps + powers.stream().mapToInt(p -> 1 << p).sum();
      int remaining = input.N - sum;
      if (remaining < 500 - steps) break;
      int power = biggestPowerOfTwo(remaining - steps);
      powers.add(power);
    }
    Collections.sort(powers);
    return powers;
  }

  private static int biggestPowerOfTwo(int n) {
    int pow = 0;
    int work = 1;
    while (work * 2 + pow <= n) {
      work <<= 1;
      pow++;
    }
    return pow;
  }

  // Link for details of this function
  // https://www.geeksforgeeks.org/space-and-time-efficient-binomial-coefficient/
  static int binomialCoeff(int n, int k) {
    int res = 1;

    if (k > n - k)
      k = n - k;

    for (int i = 0; i < k; ++i) {
      res *= (n - i);
      res /= (i + 1);
    }
    return res;
  }
}
