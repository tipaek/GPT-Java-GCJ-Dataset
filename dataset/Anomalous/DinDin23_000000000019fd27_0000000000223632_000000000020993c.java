import java.util.*;

public class Test {
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
        int rowRepeats = 0, colRepeats = 0, diagonalSum = 0;

        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = in.nextInt();
            }
        }

        // Calculate diagonal sum
        for (int i = 0; i < n; i++) {
            diagonalSum += matrix[i][i];
        }

        // Check for row repeats
        for (int i = 0; i < n; i++) {
            if (hasRepeats(matrix[i])) {
                rowRepeats++;
            }
        }

        // Check for column repeats
        for (int j = 0; j < n; j++) {
            if (hasColumnRepeats(matrix, j)) {
                colRepeats++;
            }
        }

        // Output results
        System.out.println(diagonalSum + " " + rowRepeats + " " + colRepeats);
    }

    static boolean hasRepeats(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int num : array) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }

    static boolean hasColumnRepeats(int[][] matrix, int col) {
        Set<Integer> set = new HashSet<>();
        for (int[] row : matrix) {
            if (!set.add(row[col])) {
                return true;
            }
        }
        return false;
    }
}