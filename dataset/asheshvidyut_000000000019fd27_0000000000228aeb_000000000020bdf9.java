import java.io.*;
import java.util.*;
import java.math.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        InputReader in = new InputReader(System.in);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = in.readInt();
        for (int t = 0; t < tc; t++) {
            boolean ans = true;
            int n = in.readInt();
            int s[] = new int[n];
            int e[] = new int[n];
            char sol[] = new char[n];
            Arrays.fill(sol, '#');
            HashSet<Integer> counter[] = new HashSet[24 * 60 + 1];
            for (int i = 0; i < counter.length; i++) {
                counter[i] = new HashSet<>();
            }
            for (int i = 0; i < n; i++) {
                s[i] = in.readInt();
                e[i] = in.readInt();
                for (int j = s[i]; j <= e[i] - 1; j++) {
                    counter[j].add(i);
                    if (counter[j].size() >= 3)
                        ans = false;
                }
            }
            if (ans) {
                char val[] = new char[counter.length];
                Arrays.fill(val, '#');
                for (int i = 0; i < counter.length; i++) {
                    if (counter[i].size() >= 2) {
                        Iterator<Integer> iterator = counter[i].iterator();
                        int id1 = iterator.next();
                        int id2 = iterator.next();
                        if (sol[id1] == '#' && sol[id2] == '#') {
                            sol[id1] = 'C';
                            sol[id2] = 'J';
                        }
                        else if (sol[id1] == '#') {
                            sol[id1] = (sol[id2] == 'C') ? 'J' : 'C';
                        }
                        else if (sol[id2] == '#') {
                            sol[id2] = (sol[id1] == 'C') ? 'J' : 'C';
                        }
                    }
                }
                for (int i = 0; i < n; i++) {
                    if (sol[i] != '#')
                        continue;
                    char prev = '#';
                    for (int j = i - 1; j >= 0; j--) {
                        if (sol[j] != '#') {
                            prev = sol[j];
                            break;
                        }
                    }
                    char curr = (prev == 'C') ? 'J' : 'C';
                    sol[i] = curr;
                }
                out.write("Case #"+(t + 1)+": " + (new String(sol)));
            }
            else {
                out.write("Case #"+(t + 1)+": IMPOSSIBLE");
            }
            out.newLine();
        }
        out.close();
    }
}
class InputReader {
    private boolean finished = false;

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

    public int peek() {
        if (numChars == -1)
            return -1;
        if (curChar >= numChars) {
            curChar = 0;
            try {
                numChars = stream.read(buf);
            } catch (IOException e) {
                return -1;
            }
            if (numChars <= 0)
                return -1;
        }
        return buf[curChar];
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

    public long readLong() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        long res = 0;
        do {
            if (c < '0' || c > '9')
                throw new InputMismatchException();
            res *= 10;
            res += c - '0';
            c = read();
        } while (!isSpaceChar(c));
        return res * sgn;
    }

    public String readString() {
        int length = readInt();
        if (length < 0)
            return null;
        byte[] bytes = new byte[length];
        for (int i = 0; i < length; i++)
            bytes[i] = (byte) read();
        try {
            return new String(bytes, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return new String(bytes);
        }
    }

    public static boolean isSpaceChar(int c) {
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }

    private String readLine0() {
        StringBuffer buf = new StringBuffer();
        int c = read();
        while (c != '\n' && c != -1) {
            if (c != '\r')
                buf.appendCodePoint(c);
            c = read();
        }
        return buf.toString();
    }

    public String readLine() {
        String s = readLine0();
        while (s.trim().length() == 0)
            s = readLine0();
        return s;
    }

    public String readLine(boolean ignoreEmptyLines) {
        if (ignoreEmptyLines)
            return readLine();
        else
            return readLine0();
    }

    public BigInteger readBigInteger() {
        try {
            return new BigInteger(readString());
        } catch (NumberFormatException e) {
            throw new InputMismatchException();
        }
    }

    public char readCharacter() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        return (char) c;
    }

    public double readDouble() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        double res = 0;
        while (!isSpaceChar(c) && c != '.') {
            if (c == 'e' || c == 'E')
                return res * Math.pow(10, readInt());
            if (c < '0' || c > '9')
                throw new InputMismatchException();
            res *= 10;
            res += c - '0';
            c = read();
        }
        if (c == '.') {
            c = read();
            double m = 1;
            while (!isSpaceChar(c)) {
                if (c == 'e' || c == 'E')
                    return res * Math.pow(10, readInt());
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                m /= 10;
                res += (c - '0') * m;
                c = read();
            }
        }
        return res * sgn;
    }

    public boolean isExhausted() {
        int value;
        while (isSpaceChar(value = peek()) && value != -1)
            read();
        return value == -1;
    }

    public String next() {
        return readString();
    }

    public boolean readBoolean() {
        return readInt() == 1;
    }
}
