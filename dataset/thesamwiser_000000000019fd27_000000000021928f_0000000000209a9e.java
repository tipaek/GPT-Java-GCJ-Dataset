
import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.Locale;

public class Solution {

  static InputReader in;

  // Database
  public static void main(String[] args) throws Exception {
    in = new InputReader(System.in);
    Locale.setDefault(Locale.US);
    int T = in.readInt();
    int B = in.readInt();
    for (int t = 1; t <= T; t++) {
      // read
      boolean[] result = new boolean[B];
      int ixEq = -1;
      int ixDiff = -1;
      int cur = 0;
      for (int i = 0; i < 5; i++) {
        result[cur] = readBit(cur);
        result[B - cur - 1] = readBit(B - cur - 1);
        if (result[cur] == result[B - cur - 1]) {
          ixEq = cur;
        } else {
          ixDiff = cur;
        }
        cur++;
      }
      while (B / 2 > cur) {
        boolean itSwap = false;
        boolean itFlip = false;
        if (ixEq >= 0) {
          if (readBit(ixEq) != result[ixEq]) {
            itSwap = true;
          }
        } else {
          readBit(0); // we want to read in pairs
        }
        if (ixDiff >= 0) {
          if ((readBit(ixDiff) == result[ixDiff]) == itSwap) {
            itFlip = true;
          }
        } else {
          readBit(0); // we want to read in pairs
        }
        if (itFlip) {
          for (int i = 0; i < B; i++) {
            result[i] = !result[i];
          }
        }
        if (itSwap) {
          boolean tmp = false;
          for (int i = 0; i < B / 2; i++) {
            tmp = result[i];
            result[i] = result[B - 1 - i];
            result[B - 1 - i] = tmp;
          }
        }
        for (int i = 0; i < 4 && B / 2 > cur; i++) {
          result[cur] = readBit(cur);
          result[B - cur - 1] = readBit(B - cur - 1);
          if (result[cur] == result[B - cur - 1]) {
            ixEq = cur;
          } else {
            ixDiff = cur;
          }
          cur++;
        }
      }
      for (int i = 0; i < B; i++) {
        System.out.print(result[i] ? '1' : '0');
      }
      System.out.println();
      if (in.readChar() != 'Y') {
        break;
      }
    }
    System.out.close();
  }

  static boolean readBit(int b) {
    System.out.println(b + 1);
    return in.readChar() == '1';
  }

  // helper
  // 0 0 => swap => 0 0
  // 0 1 => swap => 1 0
  // 0 0 => flip => 1 1
  // 0 1 => flip => 1 0
  // 0 0 => swapflip => 1 1
  // 0 1 => swapflip => 0 1


  static class InputReader {
    private InputStream stream;
    private byte[] buf = new byte[1024];
    private int curChar;
    private int numChars;

    public InputReader(InputStream stream) {
      this.stream = stream;
    }

    public int read() {
      if (numChars == -1)
        throw new InputMismatchException();
      if (curChar >= numChars) {
        curChar = 0;
        try {
          numChars = stream.read(buf);
        } catch (IOException e) {
          throw new InputMismatchException();
        }
        if (numChars <= 0)
          return -1;
      }
      return buf[curChar++];
    }

    public char readChar() {
      int c = read();
      while (isSpaceChar(c))
        c = read();
      return (char) c;
    }

    public String readLine() {
      int c = read();
      while (isSpaceChar(c))
        c = read();
      StringBuilder res = new StringBuilder();
      do {
        res.appendCodePoint(c);
        c = read();
      } while (!isEndOfLine(c));
      return res.toString();
    }

    public String readString() {
      int c = read();
      while (isSpaceChar(c))
        c = read();
      StringBuilder res = new StringBuilder();
      do {
        res.appendCodePoint(c);
        c = read();
      } while (!isSpaceChar(c));
      return res.toString();
    }

    public int readInt() {
      int c = read();
      while (isSpaceChar(c))
        c = read();
      int sgn = 1;
      if (c == '-') {
        sgn = -1;
        c = read();
      }
      int res = 0;
      do {
        if (c < '0' || c > '9')
          throw new InputMismatchException();
        res *= 10;
        res += c - '0';
        c = read();
      } while (!isSpaceChar(c));
      return res * sgn;
    }

    public boolean isSpaceChar(int c) {
      return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }

    public boolean isEndOfLine(int c) {
      return c == '\n' || c == '\r' || c == -1;
    }
  }
}