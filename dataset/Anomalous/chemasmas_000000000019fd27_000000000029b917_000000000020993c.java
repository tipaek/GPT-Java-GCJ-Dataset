import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int i = 1; i <= testCases; i++) {
            System.out.print("Case #");
            System.out.print(i);
            System.out.print(": ");
            solve();
        }
    }

    private static void solve() {
        int n = scanner.nextInt();
        scanner.nextLine();

        int[][] matrix = new int[n][n];
        int[][] transposedMatrix = new int[n][n];
        int trace = 0, rowRepeats = 0, colRepeats = 0;

        for (int i = 0; i < n; i++) {
            int[] row = Arrays.stream(scanner.nextLine().trim().split(" "))
                              .mapToInt(Integer::parseInt)
                              .toArray();

            for (int j = 0; j < n; j++) {
                matrix[i][j] = row[j];
                transposedMatrix[j][i] = row[j];
                if (i == j) {
                    trace += row[j];
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (hasDuplicates(matrix[i])) rowRepeats++;
            if (hasDuplicates(transposedMatrix[i])) colRepeats++;
        }

        System.out.println(trace + " " + rowRepeats + " " + colRepeats);
    }

    private static boolean hasDuplicates(int[] array) {
        return Arrays.stream(array).distinct().count() != array.length;
    }
}