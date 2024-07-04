import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
      int numberOfTestCase = sc.nextInt();
      int numberOfBits = sc.nextInt();
      for (int test = 0; test < numberOfTestCase; test++) {
        String answer = null;
        if (numberOfBits == 10) {
          answer = simpleTestSet(sc);
        } else if (numberOfBits == 20) {
          answer = mediumTestSet(sc);
        }
        System.out.println(answer);
        String response = sc.next();
        if (response.equals("N")) {
          return;
        }
      }
    }
  }

  private static String simpleTestSet(Scanner sc) {
    int[] mask = new int[10];
    int position = 0;
    for (int q = 0; q < 10; q++) {
      System.out.println(position + 1);
      int positionValue = Integer.parseInt(sc.next());
      mask[position++] = positionValue;
    }
    return getMask(mask);
  }

  private static String mediumTestSet(Scanner sc) {
    int[] outerMost = new int[10];
    int position = 1;
    for (int i = 0; i < 5; i++) {
      System.out.println(position);
      outerMost[i] = Integer.parseInt(sc.next());
      position++;
    }
    position = 16;
    for (int i = 5; i < 10; i++) {
      System.out.println(position);
      outerMost[i] = Integer.parseInt(sc.next());
      position++;
    }
    // Check 5
    position = 1;
    int[] half = new int[5];
    for (int i = 0; i < 5; i++) {
      System.out.println(position);
      half[i] = Integer.parseInt(sc.next());
      position++;
    }
    outerMost = getChange(half, outerMost).transform(outerMost);
    int[] previousHalf = new int[5];
    position = 6;
    for (int i = 0; i < 5; i++) {
      System.out.println(position);
      previousHalf[i] = Integer.parseInt(sc.next());
      position++;
    }
    int[] inner = new int[10];
    position = 6;
    for (int i = 0; i < 10; i++) {
      System.out.println(position);
      inner[i] = Integer.parseInt(sc.next());
      position++;
    }
    outerMost = getChange(previousHalf, inner).transform(outerMost);
    int[] result = new int[20];
    System.arraycopy(outerMost, 0, result, 0, 5);
    System.arraycopy(inner, 0, result, 5, 10);
    System.arraycopy(outerMost, 5, result, 15, 5);
    return getMask(result);
  }

  public static Change getChange(int[] firstHalf, int[] mask) {
    boolean allAreSame = true;
    for (int i = 0; i < firstHalf.length; i++) {
      // Check no change
      if (firstHalf[i] != mask[i]) {
        allAreSame = false;
        break;
      }
    }
    if (allAreSame) {
      return Change.NO_CHANGE;
    }
    // Check Reversed
    boolean areReversed = true;
    for (int i = 0; i < firstHalf.length; i++) {
      if (firstHalf[i] != mask[mask.length - 1 - i]) {
        areReversed = false;
        break;
      }
    }
    if (areReversed) {
      return Change.REVERSED;
    }
    // Check complement
    boolean areComplement = true;
    for (int i = 0; i < firstHalf.length; i++) {
      if (firstHalf[i] == mask[i]) {
        areComplement = false;
        break;
      }
    }
    if (areComplement) {
      return Change.COMPLEMENTED;
    }
    return Change.COMPLEMENTED_AND_REVERSED;
  }

  enum Change {
    COMPLEMENTED {
      @Override
      public int[] transform(int[] mask) {
        int[] result = new int[mask.length];
        for (int i = 0; i < mask.length; i++) {
          result[i] = mask[i] == 0 ? 1 : 0;
        }
        return result;
      }
    },
    REVERSED {
      @Override
      public int[] transform(int[] mask) {
        int[] result = new int[mask.length];
        for (int i = 0; i < mask.length; i++) {
          result[mask.length - i - 1] = mask[i];
        }
        return result;
      }

    }, COMPLEMENTED_AND_REVERSED {
      @Override
      public int[] transform(int[] mask) {
        return COMPLEMENTED.transform(REVERSED.transform(mask));
      }
    }, NO_CHANGE {
      @Override
      public int[] transform(int[] mask) {
        return mask;
      }
    };

    public abstract int[] transform(int[] mask);
  }

  private static String getMask(int[] mask) {
    return Arrays.stream(mask).mapToObj(String::valueOf).collect(Collectors.joining(""));
  }

}
