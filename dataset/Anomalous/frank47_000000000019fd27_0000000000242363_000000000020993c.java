import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            int duplicateRows = 0;
            int duplicateColumns = 0;
            List<Integer> referenceList = new ArrayList<>();

            for (int i = 1; i <= n; i++) {
                referenceList.add(i);
            }

            for (int i = 0; i < n; i++) {
                List<Integer> rowCheckList = new ArrayList<>(referenceList);
                boolean hasDuplicateRow = false;
                
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                    
                    if (!hasDuplicateRow && !rowCheckList.remove((Integer) matrix[i][j])) {
                        duplicateRows++;
                        hasDuplicateRow = true;
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                List<Integer> columnCheckList = new ArrayList<>(referenceList);
                boolean hasDuplicateColumn = false;

                for (int j = 0; j < n; j++) {
                    if (!hasDuplicateColumn && !columnCheckList.remove((Integer) matrix[j][i])) {
                        duplicateColumns++;
                        hasDuplicateColumn = true;
                    }
                }
            }

            System.out.println("Case #" + testCase + ": " + calculateTrace(matrix, n) + " " + duplicateRows + " " + duplicateColumns);
        }

        scanner.close();
    }

    private static int calculateTrace(int[][] matrix, int size) {
        int trace = 0;
        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }
}