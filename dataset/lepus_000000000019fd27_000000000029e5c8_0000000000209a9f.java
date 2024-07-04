import java.util.Scanner;

public class Solution {

  final static Scanner keyboard = new Scanner(System.in);


  public static void main(final String[] args) {
    final int numberOfTestCases = keyboard.nextInt();
    final String[] outputs = new String[numberOfTestCases];
    for (int i = 0; i < numberOfTestCases; i++) {
      final char[] input = keyboard.next().toCharArray();
      outputs[i] = createResultOutput(i + 1, convertToIntArray(input));
    }
    for (final String output : outputs) {
      System.out.println(output);
    }
  }

  private static String createResultOutput(final int testCase, final int[] input) {
    int last = 0;
    boolean decrease;
    final StringBuilder resultBuilder = new StringBuilder();
    for (final int value : input) {
      int diff = value - last;
      if (diff < 0) {
        decrease = true;
        diff *= -1;
      } else {
        decrease = false;
      }
      final String sign;
      if (decrease) {
        sign = ")";
      } else {
        sign = "(";
      }
      for (int j = 0; j < diff; j++) {
        resultBuilder.append(sign);
      }
      resultBuilder.append(value);
      last = value;
    }
    for (int j = 0; j < input[input.length - 1]; j++) {
      resultBuilder.append(")");
    }
    return "Case #" + testCase + ": " + resultBuilder;
  }

  private static int[] convertToIntArray(final char[] charArray) {
    final int[] intArray = new int[charArray.length];
    for (int i = 0; i < charArray.length; i++) {
      intArray[i] = Integer.parseInt(String.valueOf(charArray[i]));
    }
    return intArray;
  }
}
