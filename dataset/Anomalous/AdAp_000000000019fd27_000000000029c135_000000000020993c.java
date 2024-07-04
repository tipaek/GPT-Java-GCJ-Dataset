import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = Integer.parseInt(scanner.nextLine());

        String[][][] cases = new String[T][][];

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(scanner.nextLine());
            cases[i] = new String[N][N];
            for (int j = 0; j < N; j++) {
                cases[i][j] = scanner.nextLine().split(" ");
            }
            System.out.println("Case #" + (i + 1) + ": " + findTrace(cases[i]) + "," + countRepeatedRows(cases[i]) + "," + countRepeatedCols(cases[i]));
        }
    }

    public static int findTrace(String[][] matrix) {
        int trace = 0;
        for (int i = 0; i < matrix.length; i++) {
            trace += Integer.parseInt(matrix[i][i]);
        }
        return trace;
    }

    public static int countRepeatedRows(String[][] matrix) {
        int count = 0;
        for (String[] row : matrix) {
            if (hasDuplicates(row)) {
                count++;
            }
        }
        return count;
    }

    public static int countRepeatedCols(String[][] matrix) {
        int count = 0;
        int N = matrix.length;
        for (int col = 0; col < N; col++) {
            String[] column = new String[N];
            for (int row = 0; row < N; row++) {
                column[row] = matrix[row][col];
            }
            if (hasDuplicates(column)) {
                count++;
            }
        }
        return count;
    }

    private static boolean hasDuplicates(String[] array) {
        Set<String> set = new HashSet<>();
        for (String element : array) {
            if (!set.add(element)) {
                return true;
            }
        }
        return false;
    }
}