import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        FastReader reader = new FastReader(System.in);
        StringBuilder result = new StringBuilder();
        int testCases = reader.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = reader.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0, duplicateRows = 0, duplicateCols = 0;
            
            for (int i = 0; i < n; i++) {
                int[] rowFreq = new int[n + 1];
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = reader.nextInt();
                    rowFreq[matrix[i][j]]++;
                }
                if (hasDuplicates(rowFreq)) {
                    duplicateRows++;
                }
            }
            
            for (int j = 0; j < n; j++) {
                int[] colFreq = new int[n + 1];
                for (int i = 0; i < n; i++) {
                    colFreq[matrix[i][j]]++;
                }
                if (hasDuplicates(colFreq)) {
                    duplicateCols++;
                }
            }
            
            for (int i = 0; i < n; i++) {
                trace += matrix[i][i];
            }
            
            result.append("Case #").append(testCase).append(": ").append(trace)
                  .append(" ").append(duplicateRows).append(" ").append(duplicateCols).append("\n");
        }
        
        System.out.print(result);
    }
    
    private static boolean hasDuplicates(int[] freq) {
        for (int i = 1; i < freq.length; i++) {
            if (freq[i] > 1) {
                return true;
            }
        }
        return false;
    }
}

class FastReader {
    private final byte[] buffer = new byte[2048];
    private int index, total;
    private final InputStream inputStream;

    FastReader(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    private int scan() throws IOException {
        if (index >= total) {
            index = 0;
            total = inputStream.read(buffer);
            if (total <= 0) {
                return -1;
            }
        }
        return buffer[index++];
    }

    String next() throws IOException {
        int c;
        while ((c = scan()) <= 32);
        StringBuilder sb = new StringBuilder();
        do {
            sb.append((char) c);
        } while ((c = scan()) > 32);
        return sb.toString();
    }

    int nextInt() throws IOException {
        int c, val = 0;
        while ((c = scan()) <= 32);
        boolean neg = c == '-';
        if (c == '-' || c == '+') {
            c = scan();
        }
        do {
            val = val * 10 + (c - '0');
        } while ((c = scan()) >= '0' && c <= '9');
        return neg ? -val : val;
    }

    long nextLong() throws IOException {
        int c;
        long val = 0;
        while ((c = scan()) <= 32);
        boolean neg = c == '-';
        if (c == '-' || c == '+') {
            c = scan();
        }
        do {
            val = val * 10 + (c - '0');
        } while ((c = scan()) >= '0' && c <= '9');
        return neg ? -val : val;
    }
}