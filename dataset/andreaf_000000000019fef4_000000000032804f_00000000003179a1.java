import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {

  public static void main(String[] args) throws FileNotFoundException {
    try (Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
      // try (Scanner sc = new Scanner(new FileInputStream(new File("src/main/resources/codejam/query.in")))) {
      int numberOfTestCase = sc.nextInt();
      for (int test = 0; test < numberOfTestCase; test++) {
        int upperBound = sc.nextInt();
        int[] letters = new int['Z' - 'A' + 1];
        for (int q = 0; q < 10_000; q++) {
          String request = sc.next();
          String response = sc.next();
          letters[response.charAt(response.length() - 1) - 'A']++;
        }
        List<LetterFrequency> result = new ArrayList<>();
        for (int i = 0; i < letters.length; i++) {
          if (letters[i] > 0) {
            result.add(new LetterFrequency(((char) ('A' + i)), letters[i]));
          }
        }
        result.sort(new AscendingOrderFrequency());

        System.out.println(String.format("Case #%d: %s", (test + 1), formatResult(upperBound, result)));
      }
    }
  }

  private static String formatResult(int upperBound, List<LetterFrequency> result) {
    if (upperBound == 2) {
      StringBuilder s = new StringBuilder(String.valueOf(result.get(0).getDigit()));
      for (int i = result.size() - 1; i >= 1; i--) {
        s.append(result.get(i).getDigit());
      }
      return s.toString();
    } else {
      StringBuilder s = new StringBuilder();
      for (int i = result.size() - 1; i >= 0; i--) {
        s.append(result.get(i).getDigit());
      }
      return s.toString();
    }
  }

  private static class LetterFrequency {
    private final char c;
    private final int frequency;

    public LetterFrequency(char c, int frequency) {
      this.c = c;
      this.frequency = frequency;
    }

    @Override
    public String toString() {
      return c + ": " + frequency;
    }

    public int getFrequency() {
      return frequency;
    }

    public char getDigit() {
      return c;
    }
  }

  private static class AscendingOrderFrequency implements Comparator<LetterFrequency> {

    @Override
    public int compare(LetterFrequency o1, LetterFrequency o2) {
      return Integer.compare(o1.getFrequency(), o2.getFrequency());
    }
  }
}
