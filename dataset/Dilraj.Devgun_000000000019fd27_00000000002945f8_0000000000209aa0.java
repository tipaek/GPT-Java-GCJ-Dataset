import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int n = 0; n < t; n++) {
            solveProblem5(scanner, n + 1);
        }
    }

    public static void solveProblem5(Scanner scanner, int caseNumber) {
        int size = scanner.nextInt();
        int traceTarget = scanner.nextInt();

        int[][] result = new int[size][size];
        boolean[][] columnLookup = new boolean[size][size];
        boolean[][] rowLookup = new boolean[size][size];

        boolean solved = constructMatrix(result, columnLookup, rowLookup, size, traceTarget, 0, 0, 0, caseNumber);
        // if false lets print impossible
        if (!solved) {
            System.out.println("IMPOSSIBLE");
        }
    }

     public static boolean constructMatrix(int[][] result, boolean[][] columnLookup, boolean[][] rowLookup,
                                       int size, int traceTarget, int currentTrace,
                                       int row, int col, int caseNumber) {
        if (row == size && traceTarget == currentTrace) {
            // we have solved it by filling up the whole target
            // print out the result
            System.out.println("Case #" + caseNumber + ": POSSIBLE");
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size - 1; j++) {
                    System.out.print(result[i][j] + " ");
                }
                System.out.println(result[i][size - 1]);
            }
            return true;
        } else if (row == size) {
            // filled matrix doesn't have right trace
            return false;
        } else if (col == size) {
            // move to next row
            return constructMatrix(result, columnLookup, rowLookup, size, traceTarget, currentTrace, row + 1, 0, caseNumber);
        } else {
            // we need to fill the current row and column with a value and recurse
            boolean solved = false;
            for (int i = 0; i < size && !solved; i++) {
                // make sure the current row and the current column have not already used the value i
                if (!rowLookup[row][i] && !columnLookup[col][i]) {
                    rowLookup[row][i] = true;
                    columnLookup[col][i] = true;

                    int trace = currentTrace;
                    if (row == col) {
                        trace += (i + 1); // becasue of off by one we want values 1 -> N not 0 -> N-1
                    }

                    result[row][col] = i + 1;

                    solved = constructMatrix(result, columnLookup, rowLookup, size, traceTarget, trace, row, col+1, caseNumber);

                    // if we get here and solved is false that means we completed constructing the matrix
                    // so the value i for the current row and column is wrong and we must undo it
                    result[row][col] = 0;
                    rowLookup[row][i] = false; // u r going to final round
                    columnLookup[col][i] = false;
                    if (row == col) {
                        trace -= (i + 1); // becasue of off by one we want values 1 -> N not 0 -> N-1
                    }
                }
            }
            return solved;
        }
    }
}