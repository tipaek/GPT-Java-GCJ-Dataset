import java.io.*;
import java.util.*;
import java.math.BigInteger;
import java.util.function.DoubleUnaryOperator;
import java.util.function.ToDoubleBiFunction;

import static java.lang.Math.*;

public class Solution extends PrintWriter {

    void run() {
        int testCases = nextInt();

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int matrixSize = nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = nextInt();
                }
            }

            int trace = 0, rowDuplicates = 0, colDuplicates = 0;

            for (int i = 0; i < matrixSize; i++) {
                trace += matrix[i][i];
                Set<Integer> rowSet = new HashSet<>();
                Set<Integer> colSet = new HashSet<>();
                for (int j = 0; j < matrixSize; j++) {
                    rowSet.add(matrix[i][j]);
                    colSet.add(matrix[j][i]);
                }
                if (rowSet.size() < matrixSize) {
                    rowDuplicates++;
                }
                if (colSet.size() < matrixSize) {
                    colDuplicates++;
                }
            }

            printf(Locale.ENGLISH, "Case #%d: %d %d %d%n", caseNum, trace, rowDuplicates, colDuplicates);
        }
    }

    public static boolean nextPermutation(int[] permutation) {
        int length = permutation.length;
        int i = length - 2;
        while (i >= 0 && permutation[i] >= permutation[i + 1]) {
            i--;
        }
        if (i == -1) {
            return false;
        }

        int j = length - 1;
        while (permutation[j] <= permutation[i]) {
            j--;
        }

        swap(permutation, i, j);
        for (int left = i + 1, right = length - 1; left < right; left++, right--) {
            swap(permutation, left, right);
        }
        return true;
    }

    public static void swap(int[] array, int i, int j) {
        if (i != j) {
            array[i] ^= array[j];
            array[j] ^= array[i];
            array[i] ^= array[j];
        }
    }

    String next() {
        while (!tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(nextLine());
        }
        return tokenizer.nextToken();
    }

    boolean hasNext() {
        while (!tokenizer.hasMoreTokens()) {
            String line = nextLine();
            if (line == null) {
                return false;
            }
            tokenizer = new StringTokenizer(line);
        }
        return true;
    }

    int[] nextArray(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = nextInt();
        }
        return array;
    }

    int nextInt() {
        return Integer.parseInt(next());
    }

    long nextLong() {
        return Long.parseLong(next());
    }

    double nextDouble() {
        return Double.parseDouble(next());
    }

    String nextLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            return null;
        }
    }

    public Solution(OutputStream outputStream) {
        super(outputStream);
    }

    static BufferedReader reader;
    static StringTokenizer tokenizer = new StringTokenizer("");
    static Random random = new Random();

    public static void main(String[] args) throws IOException {
        reader = new BufferedReader(new InputStreamReader(System.in));
        Solution solution = new Solution(System.out);
        solution.run();
        solution.close();
        reader.close();
    }
}