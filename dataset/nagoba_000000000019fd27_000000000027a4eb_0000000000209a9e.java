import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

  public static void main(String[] args) {
    Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int testCases;
    testCases = sc.nextInt();
    int bitCount = sc.nextInt();
    if (bitCount != 10) {
      return;
    }

    for (int testCase = 1; testCase <= testCases; testCase++) {
      String[] responseBits = new String[bitCount + 1];
      System.out.println("1");
      sc.next();
      if (!solveFor10(responseBits)) {
        return;
      }
    }
  }

  private static boolean solveFor10(String[] responseBits) {
    Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    for (int i = 1; i <= 10; i++) {
      System.out.println(i);
      responseBits[i] = sc.next();
    }
    String[] newResponseBits = new String[responseBits.length];
    for (int i = 1; i < 10; i++) {
      System.out.println(i);
      newResponseBits[i] = sc.next();
    }
    FluctuationType fluctuationType = findLogic(responseBits, newResponseBits);
    printResult(responseBits, fluctuationType);
    String result = sc.next();
    if (responseBits.equals("Y")) {
      return true;
    }
    return false;
  }

  private static void printResult(String[] responseBits, FluctuationType fluctuationType) {
    String result = String.join("", responseBits);
    if (fluctuationType.equals(FluctuationType.SAME)) {
      System.out.println(result);
    } else if (fluctuationType.equals(FluctuationType.REVERSE)) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(result);
      System.out.println(stringBuilder.reverse().toString());
    } else {
      StringBuilder stringBuilder = new StringBuilder();
      for (int i = 1; i <= 10; i++) {
        if (responseBits[i].equals("1")) {
          stringBuilder.append("0");
        } else {
          stringBuilder.append("1");
        }
      }
      if (fluctuationType.equals(FluctuationType.COMPLIMENT)) {
        System.out.println(stringBuilder.toString());
      } else {
        System.out.println(stringBuilder.reverse().toString());
      }
    }
  }

  private static FluctuationType findLogic(String[] responseBits, String[] newResponseBits) {
    //compliment
    boolean compliment = true;
    for (int i = 1; i < newResponseBits.length - 1; i++) {
      if ((responseBits[i].equals('1') && newResponseBits[i].equals('1'))
          || responseBits[i].equals('0') && newResponseBits[i].equals(0)) {
        compliment = false;
      }
    }
    if (compliment) {
      return FluctuationType.COMPLIMENT;
    }

    //reverse
    boolean reverse = true;
    for (int i = 1; i < newResponseBits.length - 1; i++) {
      if (!responseBits[newResponseBits.length - i - 1].equals(newResponseBits[i])) {
        reverse = false;
      }
    }
    if (reverse) {
      return FluctuationType.REVERSE;
    }

    //reverse&Compliment
    boolean reverseAndCompliment = true;
    for (int i = 1; i < newResponseBits.length - 1; i++) {
      int k = newResponseBits.length - i - 1;
      if ((responseBits[k].equals('1') && newResponseBits[i].equals('1'))
          || responseBits[k].equals('0') && newResponseBits[i].equals(0)) {
        reverseAndCompliment = false;
      }
    }
    if (reverseAndCompliment) {
      return FluctuationType.REVERSE_AND_COMPLIMENT;
    }
    return FluctuationType.SAME;
  }

  private static enum FluctuationType {
    REVERSE,
    SAME,
    REVERSE_AND_COMPLIMENT,
    COMPLIMENT
  }
}
