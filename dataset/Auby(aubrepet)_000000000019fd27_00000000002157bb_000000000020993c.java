import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author peta
 */
public class Solution {
    public static void main(String[] args) {
        new AVestigium().run();
    }

    Scanner in;

    public void run() {
        in = new Scanner(System.in);
        int tests = in.nextInt();
        for (int i = 0; i < tests; i++) {
            solveTestcase(i);
        }

    }

    public void solveTestcase(int num) {

        int[][] matrix = createatrix();
        int trace = computeTrace(matrix);
        int multyColl = computeColl(matrix);
        int multyRows = computeRows(matrix);

        System.out.println("Case #" + (num + 1) + ": " + trace + " " + multyRows + " " + multyColl);
    }

    public int[][] createatrix() {
        int n = in.nextInt();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = in.nextInt();
            }
        }
        return matrix;

    }

    public int computeTrace(int[][] matrix) {
        int trace = 0;
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    public int computeColl(int[][] matrix) {
        int multyColls = 0;
        for (int i = 0; i < matrix.length; i++) {
            Set<Integer> coll = new HashSet<>();
            for (int j = 0; j < matrix.length; j++) {
                if (coll.contains(matrix[j][i])) {
                    multyColls++;
                    break;
                }
                coll.add(matrix[j][i]);
            }
        }
        return multyColls;

    }

    public int computeRows(int[][] matrix) {
        int multyRows = 0;
        for (int i = 0; i < matrix.length; i++) {
            Set<Integer> rows = new HashSet<>();
            for (int j = 0; j < matrix.length; j++) {
                if (rows.contains(matrix[i][j])) {
                    multyRows++;
                    break;
                }
                rows.add(matrix[i][j]);
            }
        }
        return multyRows;

    }

}
