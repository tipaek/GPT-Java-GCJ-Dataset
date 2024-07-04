import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

class Solution {

    static void findAnswer(int[][] matrix, int size, int testCaseNumber) {
        int trace = 0;
        int repeatedRows = 0, repeatedCols = 0;

        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];

            Set<Integer> rowSet = new HashSet<>();
            Set<Integer> colSet = new HashSet<>();

            for (int j = 0; j < size; j++) {
                rowSet.add(matrix[i][j]);
                colSet.add(matrix[j][i]);
            }

            if (rowSet.size() < size) {
                repeatedRows++;
            }
            if (colSet.size() < size) {
                repeatedCols++;
            }
        }

        System.out.println("Case #" + testCaseNumber + ": " + trace + " " + repeatedRows + " " + repeatedCols);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        for (int k = 1; k <= testCases; k++) {
            int size = Integer.parseInt(reader.readLine());
            int[][] matrix = new int[size][size];

            for (int i = 0; i < size; i++) {
                String[] rowValues = reader.readLine().split(" ");
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = Integer.parseInt(rowValues[j]);
                }
            }

            findAnswer(matrix, size, k);
        }
    }
}