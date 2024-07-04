import java.util.*;
import java.io.*;

class InputReader {
    private final InputStream stream;
    private final byte[] buffer = new byte[1024];
    private int currentChar;
    private int numChars;
    private SpaceCharFilter filter;

    public InputReader(InputStream stream) {
        this.stream = stream;
    }

    private int read() {
        if (numChars == -1)
            throw new InputMismatchException();
        if (currentChar >= numChars) {
            currentChar = 0;
            try {
                numChars = stream.read(buffer);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (numChars <= 0)
                return -1;
        }
        return buffer[currentChar++];
    }

    public int readInt() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        int sign = 1;
        if (c == '-') {
            sign = -1;
            c = read();
        }
        int result = 0;
        do {
            if (c < '0' || c > '9')
                throw new InputMismatchException();
            result = result * 10 + (c - '0');
            c = read();
        } while (!isSpaceChar(c));
        return result * sign;
    }

    public String readString() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        StringBuilder result = new StringBuilder();
        do {
            result.appendCodePoint(c);
            c = read();
        } while (!isSpaceChar(c));
        return result.toString();
    }

    private boolean isSpaceChar(int c) {
        if (filter != null)
            return filter.isSpaceChar(c);
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }

    public String next() {
        return readString();
    }

    public interface SpaceCharFilter {
        boolean isSpaceChar(int ch);
    }
}

class OutputWriter {
    private final PrintWriter writer;

    public OutputWriter(OutputStream outputStream) {
        writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
    }

    public OutputWriter(Writer writer) {
        this.writer = new PrintWriter(writer);
    }

    public void print(Object... objects) {
        for (int i = 0; i < objects.length; i++) {
            if (i != 0)
                writer.print(' ');
            writer.print(objects[i]);
        }
    }

    public void printLine(Object... objects) {
        print(objects);
        writer.println();
    }

    public void close() {
        writer.close();
    }

    public void flush() {
        writer.flush();
    }
}

class IOUtils {
    public static int[] readIntArray(InputReader in, int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++)
            array[i] = in.readInt();
        return array;
    }
}

public class Solution {
    static InputReader in = new InputReader(System.in);
    static OutputWriter out = new OutputWriter(System.out);

    private static int charToInt(char c) {
        return c - '0';
    }

    public static void main(String[] args) {
        int t = in.readInt();
        for (int h = 1; h <= t; h++) {
            String s = in.readString();
            out.print("Case #" + h + ": ");
            for (int i = 0; i < s.length(); i++) {
                if (charToInt(s.charAt(i)) > 0) {
                    for (int j = 0; j < charToInt(s.charAt(i)); j++) {
                        out.print("(");
                    }
                    out.print(s.charAt(i));
                    i++;
                    while (i < s.length() && charToInt(s.charAt(i)) > 0) {
                        int diff = charToInt(s.charAt(i - 1)) - charToInt(s.charAt(i));
                        for (int p = 0; p < Math.abs(diff); p++) {
                            out.print(diff > 0 ? ")" : "(");
                        }
                        out.print(s.charAt(i));
                        i++;
                    }
                    i--;
                    for (int r = 0; r < charToInt(s.charAt(i)); r++) {
                        out.print(")");
                    }
                } else {
                    out.print(0);
                }
            }
            out.printLine();
        }
        out.flush();
        out.close();
    }
}