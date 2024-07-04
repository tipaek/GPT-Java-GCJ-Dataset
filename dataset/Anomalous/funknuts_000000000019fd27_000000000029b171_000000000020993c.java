import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

class Solution {

    public static void main(String[] args) {
        try (BufferedReader buffReader = new BufferedReader(new InputStreamReader(System.in))) {
            int numCases = Integer.parseInt(buffReader.readLine());

            for (int caseNum = 1; caseNum <= numCases; caseNum++) {
                int trace = 0;
                int duplicateRows = 0;
                int duplicateColumns = 0;

                int n = Integer.parseInt(buffReader.readLine());
                int[][] matrix = new int[n][n];

                for (int i = 0; i < n; i++) {
                    String[] rowElements = buffReader.readLine().split(" ");
                    HashSet<Integer> rowSet = new HashSet<>();
                    boolean hasDuplicate = false;

                    for (int j = 0; j < n; j++) {
                        int value = Integer.parseInt(rowElements[j]);
                        matrix[i][j] = value;

                        if (i == j) {
                            trace += value;
                        }

                        if (!rowSet.add(value)) {
                            hasDuplicate = true;
                        }
                    }

                    if (hasDuplicate) {
                        duplicateRows++;
                    }
                }

                for (int col = 0; col < n; col++) {
                    HashSet<Integer> colSet = new HashSet<>();
                    boolean hasDuplicate = false;

                    for (int row = 0; row < n; row++) {
                        if (!colSet.add(matrix[row][col])) {
                            hasDuplicate = true;
                        }
                    }

                    if (hasDuplicate) {
                        duplicateColumns++;
                    }
                }

                System.out.println("Case #" + caseNum + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
            }

        } catch (IOException e) {
            System.err.println("IOException: " + e.getMessage());
        }
    }
}