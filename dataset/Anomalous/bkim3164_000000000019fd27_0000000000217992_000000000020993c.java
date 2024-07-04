import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        for (int i = 0; i < t; i++) {
            System.out.print("Case #" + (i + 1) + ": ");
            solve(in);
            System.out.println();
        }
        in.close();
    }

    static void solve(Scanner in) {
        int n = in.nextInt();
        int rowRepeats = 0;
        int colRepeats = 0;
        int diagonalSum = 0;

        int[][] matrix = new int[n][n];
        int[] row = new int[n];
        int[] col = new int[n];
        Set<Integer> uniqueElements = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = in.nextInt();
                if (i == j) {
                    diagonalSum += matrix[i][j];
                }
            }
        }

        for (int i = 0; i < n; i++) {
            Arrays.fill(row, 0);
            Arrays.fill(col, 0);
            for (int j = 0; j < n; j++) {
                row[j] = matrix[i][j];
                col[j] = matrix[j][i];
            }
            if (hasDuplicates(row)) {
                rowRepeats++;
            }
            if (hasDuplicates(col)) {
                colRepeats++;
            }
        }

        System.out.print(diagonalSum + " " + rowRepeats + " " + colRepeats);
    }

    static boolean hasDuplicates(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int value : array) {
            if (!set.add(value)) {
                return true;
            }
        }
        return false;
    }
}