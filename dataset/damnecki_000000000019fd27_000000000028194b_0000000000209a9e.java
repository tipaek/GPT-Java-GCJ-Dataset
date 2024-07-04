import java.io.BufferedInputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Solution {

  private static final Scanner IN = new Scanner(new BufferedInputStream(System.in));
  private static final PrintStream OUT = System.out;

  public static void main(String[] args) {
    int T = IN.nextInt();
    int B = IN.nextInt();
//    System.err.println("test cases: " + T);
//    System.err.println("array length: " + B);
    StringBuilder answer;
    String verdict;
    int idx, readPairsCount, charsRead, cRead, search, eqIdx, neIdx;
    char left, right;
    for (int t = 1; t <= T; t++) {
      answer = initAnswer(B);
      idx = 0;
      readPairsCount = 5;
      charsRead = 0;
      while (idx < B / 2) {
//        System.err.println("readPairsCount: " + readPairsCount);
        charsRead += readPairs(readPairsCount, idx, answer);
        idx += readPairsCount;
//        System.err.println("curr answer: " + answer);
        if (idx < B / 2) {
          eqIdx = neIdx = search = -1;
          while ((eqIdx == -1 || neIdx == -1) && ++search < idx) {
            left = answer.charAt(search);
            right = answer.charAt(B - search - 1);
            if (left == right) {
              eqIdx = search;
            } else {
              neIdx = search;
            }
          }
          cRead = transformAnswer(answer, eqIdx, neIdx);
          if (cRead == 1) {
            readCharAt(1);
            cRead = 2;
          }
          charsRead += cRead;
          readPairsCount = Math.min(4, B / 2 - idx);
        }
//        System.err.println("chars read: " + charsRead);
      }
//      System.err.println("answer: " + answer);
      OUT.println(answer);
      OUT.flush();
      verdict = IN.next();
      if (verdict.equals("N")) {
        System.exit(1);
      }
    }
  }

  private static int transformAnswer(StringBuilder answer, int eqIdx, int neIdx) {
    int charsRead;
    char eqBefore, neBefore, eqAfter, neAfter;
    if (eqIdx > -1 && neIdx > -1) {
      eqBefore = answer.charAt(eqIdx);
      neBefore = answer.charAt(neIdx);
      eqAfter = readCharAt(eqIdx + 1);
      neAfter = readCharAt(neIdx + 1);
      if (eqBefore == eqAfter) {
        if (neBefore != neAfter) {
          reverse(answer);
        }
      } else {
        if (neBefore == neAfter) {
          flip(answer);
          reverse(answer);
        } else {
          flip(answer);
        }
      }
      charsRead = 2;
    } else if (neIdx > -1) {
      neBefore = answer.charAt(neIdx);
      neAfter = readCharAt(neIdx + 1);
      if (neBefore != neAfter) {
        flip(answer);
      }
      charsRead = 1;
    } else {
      eqBefore = answer.charAt(eqIdx);
      eqAfter = readCharAt(eqIdx + 1);
      if (eqBefore != eqAfter) {
        flip(answer);
      }
      charsRead = 1;
    }
    return charsRead;
  }

  private static int readPairs(int count, int insertAt, StringBuilder sb) {
    for (int i = 0; i < count; i++) {
//      System.err.println("read at: " + (insertAt + i + 1));
//      System.err.println("insert at: " + (insertAt + i));
      sb.setCharAt(insertAt + i, readCharAt(insertAt + i + 1));
      sb.setCharAt(sb.length() - insertAt - i - 1, readCharAt(sb.length() - insertAt - i));
    }
    return 2 * count;
  }

  private static char readCharAt(int pos) {
    OUT.println(pos);
    OUT.flush();
    return (char) (IN.nextInt() + 48);
  }

  private static StringBuilder initAnswer(int B) {
    StringBuilder sb = new StringBuilder();
    sb.append("X".repeat(Math.max(0, B)));
    return sb;
  }

  private static void reverse(StringBuilder sb) {
    sb.reverse();
  }

  private static void flip(StringBuilder sb) {
    for (int i = 0; i < sb.length(); i++) {
      sb.setCharAt(i, flipChar(sb.charAt(i)));
    }
  }

  private static char flipChar(char c) {
    if (c == 'X') {
      return c;
    }
    return c == '0' ? '1' : '0';
  }
}