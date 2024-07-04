import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        int testCases = reader.nextInt();
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int numPatterns = reader.nextInt();
            String[] patterns = new String[numPatterns];
            int longestPatternIndex = 0;

            for (int i = 0; i < numPatterns; i++) {
                patterns[i] = reader.next();
                if (patterns[i].length() > patterns[longestPatternIndex].length()) {
                    longestPatternIndex = i;
                }
            }

            StringBuilder result = new StringBuilder();
            result.append(patterns[longestPatternIndex].substring(1));
            boolean isValid = true;

            for (String pattern : patterns) {
                if (!result.toString().contains(pattern.substring(1))) {
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                writer.println("Case #" + caseNumber + ": " + result);
            } else {
                writer.println("Case #" + caseNumber + ": *");
            }
        }

        reader.close();
        writer.close();
    }

    static final int MIN = Integer.MIN_VALUE;
    static final int MAX = Integer.MAX_VALUE;
    static final Reader reader = new Reader();
    static final PrintWriter writer = new PrintWriter(System.out);

    static void read(int[] array, int size) throws IOException {
        for (int i = 0; i < size; i++) {
            array[i] = reader.nextInt();
        }
    }

    static void read(long[] array, int size) throws IOException {
        for (int i = 0; i < size; i++) {
            array[i] = reader.nextLong();
        }
    }

    static void read(String[] array, int size) throws IOException {
        for (int i = 0; i < size; i++) {
            array[i] = reader.next();
        }
    }

    static void print(Object obj) {
        writer.print(obj);
    }

    static void println(Object obj) {
        writer.println(obj);
    }

    static void println(int[] array) {
        for (int value : array) {
            print(value + " ");
        }
        println("");
    }

    static void println(int[][] array) {
        for (int[] subArray : array) {
            println(subArray);
        }
    }

    static void debug(Object obj) {
        System.out.println(obj);
    }
}

class Reader {
    private final BufferedReader reader;
    private StringTokenizer tokenizer;

    Reader() {
        reader = new BufferedReader(new InputStreamReader(System.in));
        tokenizer = new StringTokenizer("");
    }

    String next() throws IOException {
        while (!tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(reader.readLine());
        }
        return tokenizer.nextToken();
    }

    int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }

    long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    String nextLine() throws IOException {
        return reader.readLine();
    }

    void close() throws IOException {
        reader.close();
    }
}