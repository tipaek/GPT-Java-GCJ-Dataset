import java.util.Scanner;

public class Vestigium {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        
        for (int caseNum = 1; caseNum <= T; caseNum++) {
            int N = in.nextInt();
            int[][] matrix = new int[N][N];
            int trace = 0;
            int rowRepeats = 0;
            int colRepeats = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = in.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                if (hasDuplicate(matrix[i])) {
                    rowRepeats++;
                }
            }

            for (int j = 0; j < N; j++) {
                int[] column = new int[N];
                for (int i = 0; i < N; i++) {
                    column[i] = matrix[i][j];
                }
                if (hasDuplicate(column)) {
                    colRepeats++;
                }
            }

            System.out.printf("Case #%d: %d %d %d%n", caseNum, trace, rowRepeats, colRepeats);
        }
    }

    private static boolean hasDuplicate(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int num : array) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }
}