import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.Arrays;

public class Solution {

    public static void main(String[] args) throws IOException {
        new Vestigium().solve();
    }
}

class Vestigium {
    private static final int MAXN = 100;
    private final FScanner in;
    private final FPrinter out;
    private final int[] check;
    private final int[][] matrix;
    private int testCases;

    Vestigium() throws IOException {
        in = new FScanner();
        out = new FPrinter();
        check = new int[MAXN + 1];
        matrix = new int[MAXN][MAXN];
    }

    void solve() throws IOException {
        testCases = in.nextInt();
        for (int i = 1; i <= testCases; i++) {
            analyzeCase(i);
        }
        out.close();
    }

    private void analyzeCase(int testCaseNumber) throws IOException {
        int n = in.nextInt();
        int trace = 0, repeatedRows = 0, repeatedCols = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = in.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            trace += matrix[i][i];
        }

        repeatedRows = countRepeated(matrix, n, true);
        repeatedCols = countRepeated(matrix, n, false);

        out.printCase(testCaseNumber);
        out.print(" ");
        out.print(trace);
        out.print(" ");
        out.print(repeatedRows);
        out.print(" ");
        out.print(repeatedCols);
        out.println();
    }

    private int countRepeated(int[][] matrix, int n, boolean isRow) {
        int repeated = 0;
        Arrays.fill(check, 0);

        for (int i = 0; i < n; i++) {
            Arrays.fill(check, 0);
            boolean isUnique = true;

            for (int j = 0; j < n; j++) {
                int value = isRow ? matrix[i][j] : matrix[j][i];
                if (++check[value] > 1) {
                    isUnique = false;
                }
            }

            if (!isUnique) {
                repeated++;
            }
        }

        return repeated;
    }
}

class FScanner {
    private final StreamTokenizer in;

    FScanner() throws IOException {
        in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    }

    int nextInt() throws IOException {
        in.nextToken();
        return (int) in.nval;
    }
}

class FPrinter {
    private final PrintWriter out;

    FPrinter() {
        out = new PrintWriter(System.out);
    }

    void printCase(int testCaseNumber) {
        out.print("Case #");
        out.print(testCaseNumber);
        out.print(":");
    }

    void print(String str) {
        out.print(str);
    }

    void print(int num) {
        out.print(num);
    }

    void println() {
        out.println();
    }

    void close() {
        out.flush();
        out.close();
    }
}