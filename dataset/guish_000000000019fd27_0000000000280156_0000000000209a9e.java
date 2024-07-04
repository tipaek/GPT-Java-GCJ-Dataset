import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {
  public static class IO {
    public Scanner scanner;
    public PrintStream out;

    public IO() {
      scanner = new Scanner(System.in);
      out = System.out;
    }

    public int getTestCasesQty() {
      return scanner.nextInt();

    }

    public int getBParam() {
      return scanner.nextInt();

    }

    public int getQueryResult(int i) {
      out.println(i);
      return scanner.nextInt();
    }

    public String sendAnswer(String ete) {
      out.println(ete);
      String j = scanner.nextLine();
      j = scanner.next();
      return j;

    }

    public void checkStatus(int[] arr) {
      // nothing
    }
  }

  private int b;
  private int q = 0;
  private int[] array;
  private int compCheckPos = -1;
  private int revCheckPos = -1;
  private IO solIO;

  public Solution(int b, IO io) {
    this.b = b;
    this.array = new int[b];
    Arrays.fill(array, 8);
    this.solIO = io;
  }

  public static void main(String[] args) throws IOException {
    IO io = new IO();
    int testCases = io.getTestCasesQty();
    int bparam = io.getBParam();
    int t = 0;
    boolean onTrack = true;
    while (onTrack && t < testCases) {
      Solution sol = new Solution(bparam, io);
      onTrack = sol.runOneCase();
      t++;
    }

  }

  protected boolean runOneCase() {

    for (int p = 0; p < b / 2 && q < 150; p++) {
      boolean reversed = copy(p);

      if (reversed) {
        copy(p);
        copy(b - p - 1);
      } else {
        copy(b - p - 1);
      }

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
    String j = solIO.sendAnswer(ete);

    return j.equals("Y");
  }

  private String arrayAsString() {
    return intArrayToString(array);
  }

  public static String intArrayToString(int[] intArray) {
    return Arrays.stream(intArray).mapToObj(i -> String.valueOf(i)).collect(Collectors.joining());
  }

  private boolean copy(int p) {
    int t = query(p);
    if (q > 1 && q % 10 == 1) {

      boolean comp = checkComplimented(p);
      boolean rev = checkReversed(p);

      array[p] = t;
      if ((rev && p >= b / 2) || (this.revCheckPos == -1)) {
        t = query(b - p - 1);
        array[b - p - 1] = t;
      }

      solIO.checkStatus(array);
      return rev;
    } else {
      array[p] = t;
      solIO.checkStatus(array);
      return false;
    }

  }

  private boolean checkComplimented(int p) {

    int rcheck = compCheckPos == -1 ? 0 : compCheckPos;
    if (array[rcheck] != query(rcheck)) {

      for (int i = 0; i < b; i++) {
        compliment(i);
      }
      return true;
    }

    return false;
  }

  private boolean checkReversed(int p) {

    if (revCheckPos >= 0 && array[revCheckPos] != query(revCheckPos)) {
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
    return solIO.getQueryResult(p + 1);
  }

}
