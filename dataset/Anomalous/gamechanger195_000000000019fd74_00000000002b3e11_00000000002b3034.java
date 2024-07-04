import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        FastReader in = new FastReader(System.in);
        StringBuilder result = new StringBuilder();
        int testCaseCount = in.nextInt();

        for (int t = 1; t <= testCaseCount; t++) {
            int n = in.nextInt();
            String[] arr = new String[n];

            for (int i = 0; i < n; i++) {
                arr[i] = in.next();
            }

            StringBuilder start = new StringBuilder();
            StringBuilder end = new StringBuilder();
            boolean isValid = true;

            outerLoop:
            for (String str : arr) {
                int length = str.length();

                if (str.charAt(0) != '*') {
                    for (int j = 0; j < length; j++) {
                        if (str.charAt(j) == '*') break;

                        if (start.length() > j) {
                            if (str.charAt(j) != start.charAt(j)) {
                                isValid = false;
                                break outerLoop;
                            }
                        } else {
                            start.append(str.charAt(j));
                        }
                    }
                }

                for (int j = length - 1; j >= 0; j--) {
                    if (str.charAt(j) == '*') break;

                    if (end.length() > (length - j - 1)) {
                        if (str.charAt(j) != end.charAt(length - j - 1)) {
                            isValid = false;
                            break outerLoop;
                        }
                    } else {
                        end.append(str.charAt(j));
                    }
                }
            }

            if (isValid) {
                result.append("Case #").append(t).append(": ").append(start).append(end.reverse()).append("\n");
            } else {
                result.append("Case #").append(t).append(": *").append("\n");
            }
        }

        System.out.print(result);
    }
}

class FastReader {
    private final byte[] buffer = new byte[2048];
    private int index, total;
    private final InputStream input;

    FastReader(InputStream inputStream) {
        this.input = inputStream;
    }

    private int read() throws IOException {
        if (index >= total) {
            index = 0;
            total = input.read(buffer);
            if (total <= 0) {
                return -1;
            }
        }
        return buffer[index++];
    }

    String next() throws IOException {
        int c;
        while ((c = read()) <= 32);
        StringBuilder sb = new StringBuilder();
        do {
            sb.append((char) c);
        } while ((c = read()) > 32);
        return sb.toString();
    }

    int nextInt() throws IOException {
        int c, value = 0;
        while ((c = read()) <= 32);
        boolean negative = c == '-';
        if (c == '-' || c == '+') {
            c = read();
        }
        do {
            value = value * 10 + (c - '0');
        } while ((c = read()) >= '0' && c <= '9');
        return negative ? -value : value;
    }

    long nextLong() throws IOException {
        int c;
        long value = 0;
        while ((c = read()) <= 32);
        boolean negative = c == '-';
        if (c == '-' || c == '+') {
            c = read();
        }
        do {
            value = value * 10 + (c - '0');
        } while ((c = read()) >= '0' && c <= '9');
        return negative ? -value : value;
    }
}