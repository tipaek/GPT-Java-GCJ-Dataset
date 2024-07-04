
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution {

  public static Scanner scanner = new Scanner(System.in);
  public static PrintStream out = System.out;

  private int b;
  private int q = 0;
  private int[] array;
  private int compCheckPos = -1;
  private int revCheckPos = -1;

  public Solution(int b) {
    this.b = b;
    this.array = new int[b];
    Arrays.fill(array, 8);
  }

  public static void main(String[] args) throws IOException {

    int testCases = scanner.nextInt();
    int bparam = scanner.nextInt();
    int t = 0;
    boolean onTrack = true;
    while (onTrack && t < testCases) {
      Solution sol = new Solution(bparam);
      onTrack = sol.runOneCase();
      t++;
    }

  }

  private boolean runOneCase() {
    // System.err.println("starting");
    for (int p = 0; p < b / 2 && q < 150; p++) {
      boolean reversed = copy(p);

      if (reversed) {
        copy(p);
        copy(b - p - 1);
      } else {
        copy(b - p - 1);
      }

      // System.err.println("after copy " + arrayAsString());

      if (compCheckPos == -1) {
        if (array[p] == array[b - p - 1]) {
          compCheckPos = p;
        }
      }

      if (revCheckPos == -1) {
        if (array[p] != array[b - p - 1]) {
          revCheckPos = p;
        }
      }

    }
    return respond();

  }

  private boolean respond() {
    String ete = arrayAsString();
    // System.err.println(ete);
    out.println(ete);

    String j = scanner.nextLine();
    j = scanner.next();

    return j.equals("Y");
  }

  private String arrayAsString() {
    return Arrays.stream(array).mapToObj(i -> String.valueOf(i)).collect(Collectors.joining());
  }

  private boolean copy(int p) {
    int t = query(p);
    if (q > 1 && q % 10 == 1) {
      // System.err.println("mutate check: "+ arrayAsString());
      boolean comp = checkComplimented(p);
      boolean rev = checkReversed(p);
      // System.err.println("after mutate: "+ arrayAsString());
      array[p] = t;
      return rev;
    } else {
      array[p] = t;
      return false;
    }

  }

  private boolean checkComplimented(int p) {
    // System.err.println(" compCheckPos " + compCheckPos);
    if (array[compCheckPos] != query(compCheckPos)) {
      // System.err.println(" compliment! " );
      for (int i = 0; i < b; i++) {
        compliment(i);
        // compliment(b - i - 1);

      }
      return true;
    }

    return false;
  }

  private boolean checkReversed(int p) {
    // System.err.println(" revCheckPos " + revCheckPos);
    if (array[revCheckPos] != query(revCheckPos)) {
      // System.err.println(" reversed!");
      for (int i = 0; i < b / 2; i++) {
        reverse(i);
      }
      return true;
    }
    return false;
  }

  private void reverse(int i) {
    int t = array[i];
    array[i] = array[b - i - 1];
    array[b - i - 1] = t;

  }

  private void compliment(int i) {
    if (array[i] == 0) {
      array[i] = 1;

    } else if (array[i] == 1) {
      array[i] = 0;
    }

  }

  private int query(int p) {
    q++;
    out.println(p + 1);
    return scanner.nextInt();

  }

}