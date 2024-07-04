import java.util.Scanner;

class Solution {
    public static int countRows(int[][] matrix, int n) {
        int count = 0;

        for (int i = 0; i < n; i++) {
            Set<Integer> rowSet = new HashSet<>();
            boolean duplicateFound = false;

            for (int j = 0; j < n; j++) {
                if (!rowSet.add(matrix[i][j])) {
                    count++;
                    duplicateFound = true;
                    break;
                }
            }

            if (duplicateFound) {
                continue;
            }
        }

        return count;
    }

    public static int countCols(int[][] matrix, int n) {
        int count = 0;

        for (int i = 0; i < n; i++) {
            Set<Integer> colSet = new HashSet<>();
            boolean duplicateFound = false;

            for (int j = 0; j < n; j++) {
                if (!colSet.add(matrix[j][i])) {
                    count++;
                    duplicateFound = true;
                    break;
                }
            }

            if (duplicateFound) {
                continue;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int caseNumber = 1;

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }

            System.out.println("Case #" + caseNumber + ": " + trace + " " + countRows(matrix, n) + " " + countCols(matrix, n));
            caseNumber++;
        }

        sc.close();
    }
}