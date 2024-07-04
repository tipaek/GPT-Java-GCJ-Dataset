import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.Arrays;

public class R2020_Q_A {

    public static void main(String[] args) throws IOException {
        Vestigium vestigium = new Vestigium();
        vestigium.solve();
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
        for (int tc = 1; tc <= testCases; tc++) {
            analyzeCase(tc);
        }
        out.close();
    }

    private void analyzeCase(int tc) throws IOException {
        int n = in.nextInt();
        int trace = 0;
        int repeatedRows = 0;
        int repeatedCols = 0;

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

        out.printCase(tc);
        out.printSpace(trace);
        out.printSpace(repeatedRows);
        out.printSpace(repeatedCols);
        out.println();
    }

    private int countRepeated(int[][] matrix, int n, boolean isRow) {
        int repeated = 0;
        Arrays.fill(check, 0);

        for (int i = 0; i < n; i++) {
            Arrays.fill(check, 0);
            for (int j = 0; j < n; j++) {
                int value = isRow ? matrix[i][j] : matrix[j][i];
                check[value]++;
            }
            if (Arrays.stream(check, 1, n + 1).anyMatch(count -> count > 1)) {
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

    FPrinter() throws IOException {
        out = new PrintWriter(System.out);
    }

    void printSpace(long value) {
        out.print(" ");
        out.print(value);
    }

    void println() {
        out.println();
    }

    void printCase(int tc) {
        out.print("Case #");
        out.print(tc);
        out.print(":");
    }

    void close() {
        out.flush();
        out.close();
    }
}