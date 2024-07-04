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
        if (numChars == -1) {
            throw new InputMismatchException();
        }
        if (currentChar >= numChars) {
            currentChar = 0;
            try {
                numChars = stream.read(buffer);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (numChars <= 0) {
                return -1;
            }
        }
        return buffer[currentChar++];
    }

    public int readInt() {
        int c = read();
        while (isSpaceChar(c)) {
            c = read();
        }
        int sign = 1;
        if (c == '-') {
            sign = -1;
            c = read();
        }
        int result = 0;
        do {
            if (c < '0' || c > '9') {
                throw new InputMismatchException();
            }
            result = result * 10 + (c - '0');
            c = read();
        } while (!isSpaceChar(c));
        return result * sign;
    }

    public String readString() {
        int c = read();
        while (isSpaceChar(c)) {
            c = read();
        }
        StringBuilder result = new StringBuilder();
        do {
            result.appendCodePoint(c);
            c = read();
        } while (!isSpaceChar(c));
        return result.toString();
    }

    private boolean isSpaceChar(int c) {
        if (filter != null) {
            return filter.isSpaceChar(c);
        }
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
            if (i != 0) {
                writer.print(' ');
            }
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
        for (int i = 0; i < size; i++) {
            array[i] = in.readInt();
        }
        return array;
    }
}

public class Solution {
    private static final InputReader in = new InputReader(System.in);
    private static final OutputWriter out = new OutputWriter(System.out);

    public static void main(String[] args) {
        int t = in.readInt();
        for (int h = 1; h <= t; h++) {
            String s = in.readString();
            out.print("Case #" + h + ": ");
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '1') {
                    out.print("(");
                    while (i < s.length() && s.charAt(i) == '1') {
                        i++;
                        out.print(1);
                    }
                    i--;
                    out.print(")");
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