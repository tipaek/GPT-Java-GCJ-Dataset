import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution {
  static BufferedReader reader;
  static int B;
  static String[] arr;
  static boolean reversed;
  static boolean complemented;

  public static void main(String... args) throws IOException {
    reader = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
    int n = Integer.parseInt(tokenizer.nextToken());
    B = Integer.parseInt(tokenizer.nextToken());
    for (int i = 0; i < n; i++) {
      do_Test();
      for (int j = 1; j < B + 1; j++) {
        System.out.printf("%s", getArrBit(j));
      }
      System.out.println();
      System.out.flush();
      String result = reader.readLine();
      if (result.equals("N")) {
        System.exit(0);
      }
    }
  }

  private static void do_Test() throws IOException {
    reversed = false;
    complemented = false;
    int sameIndex = -1;
    int differentIndex = -1;
    arr = new String[B + 1]; //null default
    int confirmed = 10;
    int confirmedUpToIndex = 5;
    //initial gathering of information
    for (int i = 0; i < 5; i++) {
      String start = getBit(i + 1);
      String end = getBit(B - i);
      setArrBit(i + 1, start);
      setArrBit(B - i, end);
      if (sameIndex == -1 && start.equals(end)) {
        sameIndex = i + 1;
      }
      if (differentIndex == -1 && !start.equals(end)) {
        differentIndex = i + 1;
      }
    }
    while (true) {
      //check flips
      int numToDo = 8;
      if (sameIndex != -1 && differentIndex != -1) {
        String sameCheck = getBit(sameIndex);
        String differentCheck = getBit(differentIndex);
        if (sameCheck.equals(getArrBit(sameIndex))) { //either same or reversal
          if (differentCheck.equals(getArrBit(differentIndex))) {//same

          } else {//reverse
            reverse();
          }
        } else { //complement
          if (differentCheck.equals(getArrBit(differentIndex))) {
            complement();
            reverse();
          } else {
            complement();
          }
        }
      } else if (sameIndex != -1) {
        String sameCheck = getBit(sameIndex);
        String waste = getBit(1);
        if (sameCheck.equals(getArrBit(sameIndex))) {

        } else {
          complement();
        }
      } else { //differentindex
        String differentCheck = getBit(differentIndex);
        String waste = getBit(1);
        if (differentCheck.equals(getArrBit(differentIndex))) {

        } else {
          reverse();
        }
      }
      for (int i = confirmedUpToIndex + 1; i < confirmedUpToIndex + 5; i++) {
        setArrBit(i, getBit(i));
        setArrBit(B - i + 1, getBit(B - i + 1));
        confirmed += 2;
        if (sameIndex == -1 && getArrBit(i).equals(getArrBit(B - i + 1))) {
          sameIndex = i;
        }
        if (differentIndex == -1 && !getArrBit(i).equals(getArrBit(B - i + 1))) {
          differentIndex = i;
        }
      }
      confirmedUpToIndex += 4;
      if (confirmed >= B) {
        return;
      }
    }
  }

  private static void reverse() {
    reversed = !reversed;
  }

  private static void complement() {
    complemented = !complemented;
  }

  private static String getBit(int i) throws IOException {
    System.out.println(i);
    System.out.flush();
    return reader.readLine();
  }

  private static String getArrBit(int i) {
    int idx;
    if (reversed) {
      idx = B - i + 1;
    } else {
      idx = i;
    }
    if (complemented) {
      if (arr[idx].equals("0")) {
        return "1";
      } else {
        return "0";
      }
    } else {
      return arr[idx];
    }
  }

  private static void setArrBit(int i, String s) {
    int idx;
    if (reversed) {
      idx = B - i + 1;
    } else {
      idx = i;
    }
    if (complemented) {
      if (s.equals("0")) {
        arr[idx] = "1";
      } else {
        arr[idx] = "0";
      }
    } else {
      arr[idx] = s;
    }
  }
}
