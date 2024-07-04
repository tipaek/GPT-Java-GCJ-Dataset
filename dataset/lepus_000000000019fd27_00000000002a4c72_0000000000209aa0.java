import java.util.Scanner;

public class Solution {

  final static Scanner keyboard = new Scanner(System.in);


  public static void main(final String[] args) {
    final int numberOfTestCases = keyboard.nextInt();
    for (int i = 0; i < numberOfTestCases; i++) {
      final Inputs inputs = new Inputs(keyboard.nextInt(), keyboard.nextInt());
      System.out.println(createResultOutput(i + 1, inputs));
    }
  }

  private static String createResultOutput(final int testCase, final Inputs inputs) {
    String result = "IMPOSSIBLE";
    String solution = "";
    if (isPossible(inputs)) {
      result = "POSSIBLE";
      solution = "\n" + createSolution(inputs);
    }
    return "Case #" + testCase + ": " + result + solution;
  }

  private static String createSolution(Inputs inputs) {
    StringBuilder result = new StringBuilder();
    for (int i = 0; i < inputs.getSize(); i++) {
      for (int j = 0; j < inputs.getSize(); j++) {
        if (j > 0) {
          result.append(" ");
        }
        result.append(((inputs.getSize() + i - j + 1) % inputs.getSize()) + 1);
        if (j == inputs.getSize() - 1 && i != inputs.getSize() - 1) {
          result.append("\n");
        }
      }
    }
    return result.toString();
  }

  private static boolean isPossible(Inputs inputs) {
    for (int i = 1; i <= inputs.getSize(); i++) {
      if (i * inputs.getSize() == inputs.getTrace()) {
        return true;
      }
    }
    return false;
  }

  private static class Inputs {

    private int size;
    private int trace;

    public Inputs(int size, int trace) {
      this.size = size;
      this.trace = trace;
    }

    public int getSize() {
      return size;
    }

    public int getTrace() {
      return trace;
    }
  }
}
