import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        FastReader reader = new FastReader(System.in);
        StringBuilder result = new StringBuilder();
        int testCases = reader.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = reader.nextInt();
            int[][] intervals = new int[n][2];
            for (int i = 0; i < n; i++) {
                intervals[i][0] = reader.nextInt();
                intervals[i][1] = reader.nextInt();
            }

            Integer[] indices = new Integer[n];
            for (int i = 0; i < n; i++) {
                indices[i] = i;
            }

            Arrays.sort(indices, (a, b) -> {
                if (intervals[a][0] != intervals[b][0]) {
                    return Integer.compare(intervals[a][0], intervals[b][0]);
                } else {
                    return Integer.compare(intervals[a][1], intervals[b][1]);
                }
            });

            char[] assignment = new char[n];
            int endJ = 0, endC = 0;
            boolean possible = true;

            for (int i = 0; i < n; i++) {
                int idx = indices[i];
                if (intervals[idx][0] >= endJ) {
                    assignment[idx] = 'J';
                    endJ = intervals[idx][1];
                } else if (intervals[idx][0] >= endC) {
                    assignment[idx] = 'C';
                    endC = intervals[idx][1];
                } else {
                    possible = false;
                    break;
                }
            }

            result.append("Case #").append(t).append(": ");
            if (possible) {
                for (char c : assignment) {
                    result.append(c);
                }
            } else {
                result.append("IMPOSSIBLE");
            }
            result.append("\n");
        }

        System.out.println(result);
    }
}

class FastReader {
    private byte[] buffer = new byte[2048];
    private int index, total;
    private InputStream input;

    FastReader(InputStream inputStream) {
        this.input = inputStream;
    }

    private int scan() throws IOException {
        if (index >= total) {
            index = 0;
            total = input.read(buffer);
            if (total <= 0) return -1;
        }
        return buffer[index++];
    }

    String next() throws IOException {
        int c;
        while ((c = scan()) <= 32) ;
        StringBuilder sb = new StringBuilder();
        while (c > 32) {
            sb.append((char) c);
            c = scan();
        }
        return sb.toString();
    }

    int nextInt() throws IOException {
        int c, value = 0;
        while ((c = scan()) <= 32) ;
        boolean negative = c == '-';
        if (c == '-' || c == '+') c = scan();
        while (c >= '0' && c <= '9') {
            value = value * 10 + (c - '0');
            c = scan();
        }
        return negative ? -value : value;
    }

    long nextLong() throws IOException {
        int c;
        long value = 0;
        while ((c = scan()) <= 32) ;
        boolean negative = c == '-';
        if (c == '-' || c == '+') c = scan();
        while (c >= '0' && c <= '9') {
            value = value * 10 + (c - '0');
            c = scan();
        }
        return negative ? -value : value;
    }
}