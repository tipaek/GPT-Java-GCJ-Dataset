import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pw = new PrintWriter(System.out, false);

    public static void main(String[] args) throws Exception {
        int testCases = Integer.parseInt(br.readLine());
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int matrixSize = Integer.parseInt(br.readLine());
            int[][] matrix = new int[matrixSize][matrixSize];
            long diagonalSum = 0;
            int repeatedRows = 0;
            int repeatedCols = 0;

            for (int row = 0; row < matrixSize; row++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                Set<Integer> rowSet = new HashSet<>();
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = Integer.parseInt(st.nextToken());
                    if (row == col) {
                        diagonalSum += matrix[row][col];
                    }
                    rowSet.add(matrix[row][col]);
                }
                if (rowSet.size() != matrixSize) {
                    repeatedRows++;
                }
            }

            for (int col = 0; col < matrixSize; col++) {
                Set<Integer> colSet = new HashSet<>();
                for (int row = 0; row < matrixSize; row++) {
                    colSet.add(matrix[row][col]);
                }
                if (colSet.size() != matrixSize) {
                    repeatedCols++;
                }
            }

            pw.println("Case #" + caseNumber + ": " + diagonalSum + " " + repeatedRows + " " + repeatedCols);
        }
        pw.flush();
    }
}