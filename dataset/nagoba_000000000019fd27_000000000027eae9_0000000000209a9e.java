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
      responseBits[1] = sc.next();
      if (!solveFor10(responseBits)) {
        return;
      }
    }
  }

  private static boolean solveFor10(String[] responseBits) {
    Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    for (int i = 2; i <= 10; i++) {
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
    if (result.equals("Y")) {
      return true;
    }
    return false;
  }

  private static void printResult(String[] responseBits, FluctuationType fluctuationType) {
    //System.out.println("Fluctutation " + fluctuationType.name());
    StringBuilder stringBuilderResult = new StringBuilder();
    for (int i = 1; i <= 10; i++) {
      stringBuilderResult.append(responseBits[i]);
    }
    if (fluctuationType.equals(FluctuationType.SAME)) {
      System.out.println(stringBuilderResult.toString());
    } else if (fluctuationType.equals(FluctuationType.REVERSE)) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(stringBuilderResult.toString());
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
      if ((responseBits[i].equals("1") && newResponseBits[i].equals("1"))
          || responseBits[i].equals("0") && newResponseBits[i].equals("0")) {
        compliment = false;
        break;
      }
    }
    if (compliment) {
      return FluctuationType.COMPLIMENT;
    }

    //reverse
    boolean reverse = true;
    for (int i = 1; i < newResponseBits.length - 1; i++) {
      if (!responseBits[newResponseBits.length - i].equals(newResponseBits[i])) {
        reverse = false;
        break;
      }
    }
    if (reverse) {
      return FluctuationType.REVERSE;
    }

    //reverse&Compliment
    boolean reverseAndCompliment = true;
    for (int i = 1; i < newResponseBits.length - 1; i++) {
      int k = newResponseBits.length - i;
      if ((responseBits[k].equals("1") && newResponseBits[i].equals("1"))
          || responseBits[k].equals("0") && newResponseBits[i].equals("0")) {
        reverseAndCompliment = false;
        break;
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
