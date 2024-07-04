import java.io.*;
import java.util.*;
import java.util.function.Supplier;

public class Solution {

  private static final boolean DEBUG = false;
  private static final char DEFAULT = DEBUG ? '-' : 0;

  public static void main(final String[] args) {
    final Reader in = new Reader();

    for (int x = 1; x <= in.T; x++) {
      final String y = readBits(in);

      in.submit(x, y);
    }
  }

  private static String readBits(final Reader reader) {
    final char[] res = new char[reader.B];
    if (DEBUG) Arrays.fill(res, DEFAULT);
    int remaining = reader.B;
    int sameBitIdx = -1;
    int diffBitIdx = -1;
    int p = -1;

    for (int i = 1; i <= 150;) {
      if (i > 10 && i % 10 == 1) {
        if (sameBitIdx == -1) {
          sameBitIdx = findInterestingBitIdx(res, false);
        }
        if (diffBitIdx == -1) {
          diffBitIdx = findInterestingBitIdx(res, true);
        }

        if (sameBitIdx != -1) {
          char v = reader.getBit(sameBitIdx);
          char cv = res[sameBitIdx];
          i++;

          if (cv != v) {
            flipBits(res);
          }

          if (DEBUG) System.err.printf("i: %3d , p: %2d , r: %2d , ci: %2d , cv: %c , v: %c [%c] -- ", i, p, remaining, sameBitIdx, cv, v, cv != v ? 'F' : 'f');
          if (DEBUG) System.err.println(res);
        }
        if (diffBitIdx != -1) {
          char v = reader.getBit(diffBitIdx);
          char cv = res[diffBitIdx];
          i++;

          if (cv != v) {
            reverseBits(res);

            if (res[p] == DEFAULT) {
              p = lastPosition(reader.B, p); // go back to be able cover this position
            }
          }

          if (DEBUG) System.err.printf("i: %3d , p: %2d , r: %2d , ci: %2d , cv: %c , v: %c [%c] -- ", i, p, remaining, diffBitIdx, cv, v, cv != v ? 'R' : 'r');
          if (DEBUG) System.err.println(res);
        }
      } else {
        p = nextPosition(reader.B, p);

        if (res[p] == DEFAULT) remaining--;

        res[p] = reader.getBit(p);
        i++;

        if (DEBUG) System.err.printf("i: %3d , p: %2d , r: %2d , ci: -- , cv: - , v: %c [A] -- ", i, p, remaining, res[p]);
        if (DEBUG) System.err.println(res);

        if (remaining == 0) break;
      }
    }

    return new String(res);
  }

  private static int nextPosition(final int B, final int lastP) {
    if (lastP == -1) {
      return 0;
    } else if (lastP <= B / 2) {
      return B - lastP - 1;
    } else {
      return B - lastP;
    }
  }

  private static int lastPosition(final int B, final int p) {
    if (p > B / 2) {
      return B - p - 1;
    } else {
      return B - p;
    }
  }


  private static int findInterestingBitIdx(final char[] c, final boolean negate) {
    for (int i = 0, j = c.length - 1; i < j && (c[i] != DEFAULT || c[j] != DEFAULT); i++, j--) {
      if ((c[i] == c[j]) ^ negate) {
        return c[i] != DEFAULT ? i : j;
      }
    }

    return -1;
  }

  private static void reverseBits(final char[] c) {
    for (int i = 0, j = c.length - 1; i < j; i++, j--) {
      char t = c[i];
      c[i] = c[j];
      c[j] = t;
    }
  }

  private static void flipBits(final char[] c) {
    for (int i = 0; i < c.length; i++) {
      if (c[i] != DEFAULT) {
        c[i] = c[i] == '0' ? '1' : '0';
      }
    }
  }

  private static class Reader {
    private final Scanner in;
    public final int T;
    public final int B;

    public Reader() {
      in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
      T = in.nextInt();
      B = in.nextInt();
    }

    public char getBit(final int p) {
      write(String.valueOf(p + 1));
      return next(() -> "readBit: " + (p + 1));
    }

    public void submit(final int x, final String y) {
      write(y);

      if (x < T) next(() -> String.format("%d < %d : '%s' (%d)", x, T, y, y.length()));
    }

    private void write(final String s) {
      System.out.println(s);
      System.out.flush();
    }

    private char next(final Supplier<String> msg) {
      char res = in.next().charAt(0);

      if (res == 'N') {
        final String msgStr = DEBUG ? msg.get() : "ops";
        throw new RuntimeException(msgStr);
      }

      return res;
    }
  }

}
