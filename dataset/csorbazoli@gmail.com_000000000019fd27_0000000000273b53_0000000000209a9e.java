import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author csorbazoli
 */
public class Solution implements Runnable {

  private final InputStream inStream;
  private final OutputStream outStream;

  public Solution(InputStream in, PrintStream out) {
    this.inStream = in;
    this.outStream = out;
  }

  class Data {
    final int size;
    final Boolean[] values;
    final Scanner scan;
    final PrintWriter out;

    Data(int n, Scanner scan, PrintWriter out) {
      size = n;
      values = new Boolean[n];
      this.scan = scan;
      this.out = out;
    }

    void complementKnownBitsT1() { // transformation 1
      for (int i = 0; i < size; i++) {
        if (values[i] != null) {
          values[i] = !values[i];
        }
      }
    }

    void reverseKnownBitsT2() { // transformation 2
      Boolean temp;
      for (int i = 0; i < size / 2; i++) {
        temp = values[i];
        values[i] = values[size - i - 1];
        values[size - i - 1] = temp;
      }
    }

    void complementAndReverseKnownBitsT3() { // transformation 3
      complementKnownBitsT1();
      reverseKnownBitsT2();
    }

    boolean isReady() {
      int known = 0;
      for (int i = 0; i < size; i++) {
        known += values[i] == null ? 0 : 1;
      }
      return known == size;
    }

    public int getNextUnknownPosition() {
      for (int i = 0; i < size / 2 + 1; i++) {
        if (values[i] == null) {
          return i;
        }
        if (values[size - i - 1] == null) {
          return size - i - 1;
        }
      }
      return -1;
    }

    public int getFirstSameValuePairPosition() {
      for (int i = 0; i < size / 2; i++) {
        if (values[i] != null && values[size - i - 1] != null && values[i].equals(values[size - i - 1])) {
          return i;
        }
      }
      return -1;
    }

    public int getFirstAlternatingValuePairPosition() {
      for (int i = 0; i < size / 2; i++) {
        if (values[i] != null && values[size - i - 1] != null && !values[i].equals(values[size - i - 1])) {
          return i;
        }
      }
      return -1;
    }
  }

  protected void processTestCase(int caseNum, int bits, Scanner scan, PrintWriter out) {
    Data data = new Data(bits, scan, out);
    int ask = 10;
    boolean firstRound = true;
    do {
      if (!firstRound) { // does not matter what the 1st transformation was
        ask -= determineTransformationAndUpdateBits(data);
      }
      // ask position and process answer
      askPositions(data, ask);
      // after each 10th query need to figure out the latest transformation and update known bits
      // ask another position or guess
      firstRound = false;
      ask = 10;
    } while (!data.isReady());
    guess(data);
    String answer = scan.next();
    if ("N".equals(answer)) {
      throw new IllegalStateException("Wrong answer");
    }
  }

  private int determineTransformationAndUpdateBits(Data data) {
    int questionsAsked = 0;
    int sameValuePos = data.getFirstSameValuePairPosition();
    int diffValuePos = data.getFirstAlternatingValuePairPosition();
    if (sameValuePos != -1) {
      if (diffValuePos != -1) {
        // we need 2 queries
        boolean origSame = data.values[sameValuePos];
        boolean sameChanged = askValueOfPosition(sameValuePos, data) != origSame;
        boolean origDiff = data.values[diffValuePos];
        boolean diffChanged = askValueOfPosition(diffValuePos, data) != origDiff;
        if (sameChanged) { // T1 or T3
          if (diffChanged) { // T1
            data.complementKnownBitsT1();
          } else { // T3
            data.complementAndReverseKnownBitsT3();
          }
        } else // T2 or T4
        if (diffChanged) { // T2
          data.reverseKnownBitsT2();
        } // T4 - no change neeeded
        questionsAsked = 2;
      } else {
        // 1 query only - all changed or none
        boolean origSame = data.values[sameValuePos];
        boolean sameChanged = askValueOfPosition(sameValuePos, data) != origSame;
        if (sameChanged) { // T1 or T3 - but same effect
          data.complementKnownBitsT1();
        }
        questionsAsked = 1;
      }
    } else if (diffValuePos != -1) {
      // 1 query only - all changed or none
      boolean origDiff = data.values[diffValuePos];
      boolean diffChanged = askValueOfPosition(diffValuePos, data) != origDiff;
      if (diffChanged) { // T1 or T2 - but same effect
        data.complementKnownBitsT1();
      }
      questionsAsked = 1;
    } else {
      throw new IllegalStateException("There should be known values already!");
    }
    return questionsAsked;
  }

  private void askPositions(Data data, int ask) {
    // ask for unknown bits in pairs
    int questionsAsked = 0;
    while (questionsAsked < ask) {
      int pos = data.getNextUnknownPosition();
      if (pos == -1) {// ready
        break;
      }
      data.values[pos] = askValueOfPosition(pos, data);
      questionsAsked++;
    }
  }

  private Boolean askValueOfPosition(int pos, Data data) {
    data.out.println(pos + 1);
    data.out.flush();
    String answer = data.scan.next();
    if ("N".equals(answer)) {
      throw new IllegalStateException("Wrong position query: " + pos);
    }
    return "1".equals(answer);
  }

  private void guess(Data data) {
    System.err.println("GUESS: " + Arrays.asList(data.values).stream()
        .map(b -> b ? "1" : "0")
        .collect(Collectors.joining()));
    for (boolean value : data.values) {
      data.out.append(value ? '1' : '0');
    }
    data.out.println();
    data.out.flush();
  }

  @Override
  public void run() {
    // process input file
    try (Scanner scan = new Scanner(inStream)) {
      // open output
      PrintWriter out = new PrintWriter(outStream);
      try {
        // number of test cases
        int t = scan.nextInt();
        int b = scan.nextInt(); // number of bits
        for (int i = 0; i < t; i++) {
          processTestCase(i + 1, b, scan, out);
        }
      } catch (IllegalStateException e) {
        System.err.println("Process failed: " + e.getMessage());
      } finally {
        out.close();
      }
    }

  }

  public static void main(String[] args) {
    new Solution(System.in, System.out).run();
  }

}
