import java.io.*;
import java.util.*;
import java.math.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        FastReader in = new FastReader(System.in);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCaseCount = in.nextInt();
        
        for (int t = 1; t <= testCaseCount; t++) {
            int n = in.nextInt();
            int[][] matrix = new int[n][n];
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = in.nextInt();
                }
            }
            
            int trace = 0;
            for (int i = 0; i < n; i++) {
                trace += matrix[i][i];
            }
            
            int rowDuplicates = 0;
            int colDuplicates = 0;
            
            for (int i = 0; i < n; i++) {
                if (hasDuplicates(matrix[i])) {
                    rowDuplicates++;
                }
            }
            
            for (int j = 0; j < n; j++) {
                int[] col = new int[n];
                for (int i = 0; i < n; i++) {
                    col[i] = matrix[i][j];
                }
                if (hasDuplicates(col)) {
                    colDuplicates++;
                }
            }
            
            out.write(String.format("Case #%d: %d %d %d", t, trace, rowDuplicates, colDuplicates));
            out.newLine();
        }
        
        out.close();
    }
    
    private static boolean hasDuplicates(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int num : array) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }
}

class FastReader {
    private final InputStream stream;
    private final byte[] buffer = new byte[1024];
    private int pointer, bytesRead;

    public FastReader(InputStream stream) {
        this.stream = stream;
    }

    private int read() {
        if (bytesRead == -1) {
            throw new InputMismatchException();
        }
        if (pointer >= bytesRead) {
            pointer = 0;
            try {
                bytesRead = stream.read(buffer);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (bytesRead <= 0) {
                return -1;
            }
        }
        return buffer[pointer++];
    }

    public int nextInt() {
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

    private static boolean isSpaceChar(int c) {
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }
}