import java.util.BitSet;
import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int tests = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tc = 1 ; tc <= tests ; tc++) {

            int n = scanner.nextInt();
            int requiredTrace = scanner.nextInt();

            int[][] latinMatrix = construct(n);

            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            fill(n, latinMatrix, requiredTrace);
            LatinSquareSolver solver = new LatinSquareSolver(n, latinMatrix);
            solver.solve();

            if (solver.isSolved()) {
                System.out.println("Case #" + tc + ": POSSIBLE" );
                print(latinMatrix);
            } else {
                System.out.println("Case #" + tc + ": IMPOSSIBLE" );
            }
        }

        scanner.close();
    }

    private static void fill(int n, int[][] latinMatrix, int requiredTrace) {
        if (requiredTrace < n || requiredTrace > n*n) {
            return;
        }

        int trace = getTrace(n, latinMatrix);
        int curRow = n - 1;
        while ( trace < requiredTrace ) {
            int replacement = (trace + n - 1) < requiredTrace ? n : requiredTrace - trace + 1;
            latinMatrix[curRow][curRow] = replacement;
            trace += (replacement-1);
            curRow--;
        }
    }


    private static int getTrace(int n, int[][] latinMatrix) {
        int trace = 0;
        for (int i = 0 ; i < n ; i++) {
            trace += latinMatrix[i][i];
        }

        return trace;
    }

    private static void print(int[][] matrix) {
        for (int[] row : matrix) {
            for (int cell : row)
                System.out.print(cell+" ");
            System.out.println("");
        }
    }

    private static int[][] construct(int n) {
        int[][] latinMatrix = new int[n][n];

        for (int i = 0 ; i < n ; i++) {
            latinMatrix[i][i] = 1;
        }

        return latinMatrix;
    }

    static class LatinSquareSolver {
        private final int n;
        private final int[][] latinSquare;
        private final BitSet[] rowProbabilities;
        private final BitSet[] colProbabilities;

        private boolean isSolved = false;

        LatinSquareSolver(int n, int[][] latinSquare) {
            this.n = n;
            this.latinSquare = latinSquare;
            this.rowProbabilities = new BitSet[n];
            this.colProbabilities = new BitSet[n];

            for (int i = 0 ; i < n ; i++ ) {
                rowProbabilities[i] = new BitSet(n);
                rowProbabilities[i].set(0,n);
                colProbabilities[i] = new BitSet(n);
                colProbabilities[i].set(0,n);
            }

            for (int i = 0 ; i < n ; i++ ) {
                for (int j = 0 ; j < n ; j++ ) {
                    if (latinSquare[i][j] > 0) {
                        set(i, j, latinSquare[i][j]);
                    }
                }
            }
        }

        private void clear(int i, int j, int value) {
            rowProbabilities[i].set(value-1);
            colProbabilities[j].set(value-1);
            latinSquare[i][j] = 0;
        }

        private void set(int i, int j, int value) {
            rowProbabilities[i].clear(value-1);
            colProbabilities[j].clear(value-1);
            latinSquare[i][j] = value;
        }

        private boolean isSolved() {
            if (isSolved) {
                return true;
            }

            for (int i = 0 ; i < n ; i++) {
                for (int j = 0 ; j < n ; j++) {
                    if (latinSquare[i][j] == 0) {
                        return false;
                    }
                }
            }

            isSolved = true;
            return true;
        }

        public void solve() {
            int maxCardinality = n+1;
            int selectedI = n, selectedJ = n;
            BitSet possibilities = null;

            for (int i = 0 ; i < n ; i++) {
                for (int j = 0 ; j < n ; j++) {

                    if (latinSquare[i][j] != 0)
                        continue;

                    BitSet rowProbability = rowProbabilities[i];
                    BitSet colProbability = colProbabilities[j];

                    BitSet intersects = (BitSet) rowProbability.clone();
                    intersects.and(colProbability);

                    if (maxCardinality > intersects.cardinality()) {
                        selectedI = i;
                        selectedJ = j;
                        maxCardinality = intersects.cardinality();
                        possibilities = intersects;
                    }
                }
            }

            if (selectedI == n || selectedJ == n) {
                return;
            }

            for (int nextValue = possibilities.nextSetBit(0);
                 nextValue >= 0;
                 nextValue = possibilities.nextSetBit(nextValue+1)) {
                set(selectedI, selectedJ, nextValue+1);
                solve();
                if (isSolved()) {
                    return;
                } else {
                    clear(selectedI, selectedJ, nextValue+1);
                }
            }
        }
    }
}

