import java.util.*;
import java.io.*;

class InputReader {
    private InputStream stream;
    private byte[] buffer = new byte[1024];
    private int currentChar;
    private int numChars;
    private SpaceCharFilter filter;

    public InputReader(InputStream stream) {
        this.stream = stream;
    }

    public int read() {
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

    public boolean isSpaceChar(int c) {
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

    static int[][] sortByColumn(int[][] arr, int col) {
        Arrays.sort(arr, (entry1, entry2) -> {
            if (entry1[col] > entry2[col])
                return 1;
            else if (entry1[col] < entry2[col])
                return -1;
            else
                return Integer.compare(entry1[col - 1], entry2[col - 1]);
        });
        return arr;
    }

    static void printAnswer(int[][] arr, int n, int h) {
        Map<Integer, Character> map = new HashMap<>();
        int[][] sorted = sortByColumn(arr, 1);
        int lastC = sorted[0][1], lastJ = 0;
        map.put(arr[0][2], 'C');
        for (int i = 1; i < n; i++) {
            if (arr[i][0] >= lastC) {
                lastC = arr[i][1];
                map.put(arr[i][2], 'C');
            } else if (arr[i][0] >= lastJ) {
                lastJ = arr[i][1];
                map.put(arr[i][2], 'J');
            } else {
                out.printLine("Case #" + h + ": IMPOSSIBLE");
                return;
            }
        }
        out.print("Case #" + h + ": ");
        for (int i = 0; i < n; i++) {
            out.print(map.get(i));
        }
        out.printLine();
    }

    public static void main(String[] args) {
        int t = in.readInt();
        for (int h = 1; h <= t; h++) {
            int n = in.readInt();
            int[][] arr = new int[n][3];
            for (int i = 0; i < n; i++) {
                arr[i][0] = in.readInt();
                arr[i][1] = in.readInt();
                arr[i][2] = i;
            }
            printAnswer(arr, n, h);
        }
        out.flush();
        out.close();
    }
}