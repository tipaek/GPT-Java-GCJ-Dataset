import java.util.Scanner;

public class Vestigium {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        if (t < 1 || t > 100) {
            return;
        }

        int[] trace = new int[t];
        int[] rowRepeats = new int[t];
        int[] colRepeats = new int[t];

        for (int caseNum = 0; caseNum < t; caseNum++) {
            int n = sc.nextInt();
            if (n < 2 || n > 100) {
                return;
            }

            int[][] matrix = new int[n][n];
            trace[caseNum] = 0;
            rowRepeats[caseNum] = 0;
            colRepeats[caseNum] = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                    if (i == j) {
                        trace[caseNum] += matrix[i][j];
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                if (hasDuplicate(matrix[i])) {
                    rowRepeats[caseNum]++;
                }
            }

            for (int j = 0; j < n; j++) {
                if (hasDuplicate(getColumn(matrix, j))) {
                    colRepeats[caseNum]++;
                }
            }
        }

        for (int caseNum = 0; caseNum < t; caseNum++) {
            System.out.println("Case #" + (caseNum + 1) + ": " + trace[caseNum] + " " + rowRepeats[caseNum] + " " + colRepeats[caseNum]);
        }
    }

    private static boolean hasDuplicate(int[] array) {
        Set<Integer> uniqueElements = new HashSet<>();
        for (int num : array) {
            if (!uniqueElements.add(num)) {
                return true;
            }
        }
        return false;
    }

    private static int[] getColumn(int[][] matrix, int colIndex) {
        int[] column = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            column[i] = matrix[i][colIndex];
        }
        return column;
    }
}