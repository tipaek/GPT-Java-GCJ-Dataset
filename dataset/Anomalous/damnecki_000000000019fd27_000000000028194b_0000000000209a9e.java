import java.io.BufferedInputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Solution {

  private static final Scanner scanner = new Scanner(new BufferedInputStream(System.in));
  private static final PrintStream output = System.out;

  public static void main(String[] args) {
    int testCases = scanner.nextInt();
    int arrayLength = scanner.nextInt();
    StringBuilder answer;
    String verdict;
    int index, readPairsCount, charsRead, charsToRead, searchIndex, equalIndex, notEqualIndex;
    char leftChar, rightChar;

    for (int t = 1; t <= testCases; t++) {
      answer = initializeAnswer(arrayLength);
      index = 0;
      readPairsCount = 5;
      charsRead = 0;

      while (index < arrayLength / 2) {
        charsRead += readPairs(readPairsCount, index, answer);
        index += readPairsCount;

        if (index < arrayLength / 2) {
          equalIndex = notEqualIndex = searchIndex = -1;

          while ((equalIndex == -1 || notEqualIndex == -1) && ++searchIndex < index) {
            leftChar = answer.charAt(searchIndex);
            rightChar = answer.charAt(arrayLength - searchIndex - 1);

            if (leftChar == rightChar) {
              equalIndex = searchIndex;
            } else {
              notEqualIndex = searchIndex;
            }
          }

          charsToRead = transformAnswer(answer, equalIndex, notEqualIndex);

          if (charsToRead == 1) {
            readCharAt(1);
            charsToRead = 2;
          }

          charsRead += charsToRead;
          readPairsCount = Math.min(4, arrayLength / 2 - index);
        }
      }

      output.println(answer);
      output.flush();
      verdict = scanner.next();

      if (verdict.equals("N")) {
        System.exit(1);
      }
    }
  }

  private static int transformAnswer(StringBuilder answer, int equalIndex, int notEqualIndex) {
    int charsRead;
    char equalBefore, notEqualBefore, equalAfter, notEqualAfter;

    if (equalIndex > -1 && notEqualIndex > -1) {
      equalBefore = answer.charAt(equalIndex);
      notEqualBefore = answer.charAt(notEqualIndex);
      equalAfter = readCharAt(equalIndex + 1);
      notEqualAfter = readCharAt(notEqualIndex + 1);

      if (equalBefore == equalAfter) {
        if (notEqualBefore != notEqualAfter) {
          reverse(answer);
        }
      } else {
        if (notEqualBefore == notEqualAfter) {
          flip(answer);
          reverse(answer);
        } else {
          flip(answer);
        }
      }

      charsRead = 2;
    } else if (notEqualIndex > -1) {
      notEqualBefore = answer.charAt(notEqualIndex);
      notEqualAfter = readCharAt(notEqualIndex + 1);

      if (notEqualBefore != notEqualAfter) {
        flip(answer);
      }

      charsRead = 1;
    } else {
      equalBefore = answer.charAt(equalIndex);
      equalAfter = readCharAt(equalIndex + 1);

      if (equalBefore != equalAfter) {
        flip(answer);
      }

      charsRead = 1;
    }

    return charsRead;
  }

  private static int readPairs(int count, int insertAt, StringBuilder sb) {
    for (int i = 0; i < count; i++) {
      sb.setCharAt(insertAt + i, readCharAt(insertAt + i + 1));
      sb.setCharAt(sb.length() - insertAt - i - 1, readCharAt(sb.length() - insertAt - i));
    }
    return 2 * count;
  }

  private static char readCharAt(int pos) {
    output.println(pos);
    output.flush();
    return (char) (scanner.nextInt() + 48);
  }

  private static StringBuilder initializeAnswer(int length) {
    StringBuilder sb = new StringBuilder();
    sb.append("X".repeat(Math.max(0, length)));
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