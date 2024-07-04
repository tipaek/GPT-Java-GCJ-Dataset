import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int caseNum = 1; caseNum <= T; caseNum++) {
            int N = sc.nextInt();
            int[][] mat = new int[N][N];

            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    mat[r][c] = sc.nextInt();
                }
            }

            int trace = calculateTrace(mat, N);
            int rowCount = countRowsWithDuplicates(mat, N);
            int colCount = countColsWithDuplicates(mat, N);

            System.out.println("Case #" + caseNum + ": " + trace + " " + rowCount + " " + colCount);
        }
    }

    private static int calculateTrace(int[][] mat, int N) {
        int trace = 0;
        for (int i = 0; i < N; i++) {
            trace += mat[i][i];
        }
        return trace;
    }

    private static int countRowsWithDuplicates(int[][] mat, int N) {
        int rowCount = 0;
        for (int r = 0; r < N; r++) {
            if (hasDuplicates(mat[r])) {
                rowCount++;
            }
        }
        return rowCount;
    }

    private static int countColsWithDuplicates(int[][] mat, int N) {
        int colCount = 0;
        for (int c = 0; c < N; c++) {
            int[] col = new int[N];
            for (int r = 0; r < N; r++) {
                col[r] = mat[r][c];
            }
            if (hasDuplicates(col)) {
                colCount++;
            }
        }
        return colCount;
    }

    private static boolean hasDuplicates(int[] array) {
        Set<Integer> seen = new HashSet<>();
        for (int num : array) {
            if (!seen.add(num)) {
                return true;
            }
        }
        return false;
    }
}