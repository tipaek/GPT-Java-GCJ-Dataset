import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

public class Solution {

    private static final String NO = "NO";
    private static final String YES = "YES";
    private static final long MOD = 1000000007L;
    private static final int BUFFER_SIZE = 1024;
    
    InputStream inputStream;
    PrintWriter outputWriter;
    String input = "";

    void solve() {
        int queryCount = readInt();
        for (int queryIndex = 1; queryIndex <= queryCount; queryIndex++) {
            outputWriter.print("Case #" + queryIndex + ": ");
            int stringCount = readInt();
            String[] patterns = new String[stringCount];
            for (int i = 0; i < stringCount; i++) {
                patterns[i] = readString();
            }
            processPatterns(patterns);
        }
    }

    private void processPatterns(String[] patterns) {
        String prefix = null;
        String suffix = null;
        StringBuilder middle = new StringBuilder();

        for (String pattern : patterns) {
            if (!pattern.contains("*")) {
                outputWriter.println(matchAll(pattern, patterns) ? pattern : "*");
                return;
            }
            String currentPrefix = extractPrefix(pattern);
            if (prefix == null || currentPrefix.startsWith(prefix)) {
                prefix = currentPrefix;
            } else if (prefix.startsWith(currentPrefix)) {
                // do nothing
            } else {
                outputWriter.println("*");
                return;
            }

            String currentSuffix = extractSuffix(pattern);
            if (suffix == null || currentSuffix.endsWith(suffix)) {
                suffix = currentSuffix;
            } else if (suffix.endsWith(currentSuffix)) {
                // do nothing
            } else {
                outputWriter.println("*");
                return;
            }

            String middlePart = pattern.substring(currentPrefix.length() + 1, pattern.length() - currentSuffix.length()).replace("*", "");
            middle.append(middlePart);
        }

        outputWriter.println((prefix == null ? "" : prefix) + middle + (suffix == null ? "" : suffix));
    }

    private String extractSuffix(String str) {
        int lastIndex = str.lastIndexOf('*');
        return str.substring(lastIndex + 1);
    }

    private String extractPrefix(String str) {
        int firstIndex = str.indexOf('*');
        return str.substring(0, firstIndex);
    }

    private boolean matchAll(String str, String[] patterns) {
        for (String pattern : patterns) {
            if (!Pattern.matches(pattern.replace("*", ".*"), str)) {
                return false;
            }
        }
        return true;
    }

    long power(long base, long exponent) {
        long result = 1;
        long current = base;
        while (exponent > 0) {
            if (exponent % 2 != 0) {
                result = (result * current) % MOD;
            }
            current = (current * current) % MOD;
            exponent /= 2;
        }
        return result % MOD;
    }

    private long gcd(long a, long b) {
        while (a != 0) {
            long temp = b % a;
            b = a;
            a = temp;
        }
        return b;
    }

    void run() throws Exception {
        inputStream = input.isEmpty() ? System.in : new ByteArrayInputStream(input.getBytes());
        outputWriter = new PrintWriter(System.out);

        long startTime = System.currentTimeMillis();
        solve();
        outputWriter.flush();
        if (!input.isEmpty()) {
            System.out.println((System.currentTimeMillis() - startTime) + "ms");
        }
    }

    public static void main(String[] args) throws Exception {
        new Solution().run();
    }

    private byte[] buffer = new byte[BUFFER_SIZE];
    private int bufferLength = 0, bufferPointer = 0;

    private int readByte() {
        if (bufferLength == -1) {
            throw new InputMismatchException();
        }
        if (bufferPointer >= bufferLength) {
            bufferPointer = 0;
            try {
                bufferLength = inputStream.read(buffer);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (bufferLength <= 0) {
                return -1;
            }
        }
        return buffer[bufferPointer++];
    }

    private boolean isSpaceChar(int c) {
        return !(c >= 33 && c <= 126);
    }

    private int skip() {
        int b;
        while ((b = readByte()) != -1 && isSpaceChar(b)) {
            // Skip space characters
        }
        return b;
    }

    private double readDouble() {
        return Double.parseDouble(readString());
    }

    private char readChar() {
        return (char) skip();
    }

    private String readString() {
        int b = skip();
        StringBuilder sb = new StringBuilder();
        while (!isSpaceChar(b)) {
            sb.appendCodePoint(b);
            b = readByte();
        }
        return sb.toString();
    }

    private char[] readCharArray(int n) {
        char[] array = new char[n];
        int b = skip(), p = 0;
        while (p < n) {
            if (!isSpaceChar(b)) {
                array[p++] = (char) b;
            }
            b = readByte();
        }
        return n == p ? array : Arrays.copyOf(array, p);
    }

    private char[][] readCharMatrix(int n, int m) {
        char[][] matrix = new char[n][];
        for (int i = 0; i < n; i++) {
            matrix[i] = readCharArray(m);
        }
        return matrix;
    }

    private int[] readIntArray(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = readInt();
        }
        return array;
    }

    private List<Integer> readIntList(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(readInt());
        }
        return list;
    }

    private int[][] readIntMatrix(int n, int m) {
        int[][] matrix = new int[n][];
        for (int i = 0; i < n; i++) {
            matrix[i] = readIntArray(m);
        }
        return matrix;
    }

    private int readInt() {
        int number = 0, b;
        boolean negative = false;
        while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-')) {
            // Skip non-digit characters
        }
        if (b == '-') {
            negative = true;
            b = readByte();
        }

        while (true) {
            if (b >= '0' && b <= '9') {
                number = number * 10 + (b - '0');
            } else {
                return negative ? -number : number;
            }
            b = readByte();
        }
    }

    private long[] readLongArray(int n) {
        long[] array = new long[n];
        for (int i = 0; i < n; i++) {
            array[i] = readLong();
        }
        return array;
    }

    private long readLong() {
        long number = 0;
        int b;
        boolean negative = false;
        while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-')) {
            // Skip non-digit characters
        }
        if (b == '-') {
            negative = true;
            b = readByte();
        }

        while (true) {
            if (b >= '0' && b <= '9') {
                number = number * 10 + (b - '0');
            } else {
                return negative ? -number : number;
            }
            b = readByte();
        }
    }
}