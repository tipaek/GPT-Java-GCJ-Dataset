import java.util.Scanner;

public class Bomber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // Number of test cases

        for (int k = 0; k < t; k++) {
            int n = sc.nextInt(); // Dimension of the matrix
            int[][] arr = new int[n][n];

            // Read the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            int diagonalSum = 0;
            int rowRepeats = 0;
            int colRepeats = 0;

            // Calculate diagonal sum
            for (int i = 0; i < n; i++) {
                diagonalSum += arr[i][i];
            }

            // Calculate row repeats
            for (int i = 0; i < n; i++) {
                Set<Integer> uniqueElements = new HashSet<>();
                boolean hasRepeat = false;
                for (int j = 0; j < n; j++) {
                    if (!uniqueElements.add(arr[i][j])) {
                        hasRepeat = true;
                    }
                }
                if (hasRepeat) {
                    rowRepeats++;
                }
            }

            // Calculate column repeats
            for (int i = 0; i < n; i++) {
                Set<Integer> uniqueElements = new HashSet<>();
                boolean hasRepeat = false;
                for (int j = 0; j < n; j++) {
                    if (!uniqueElements.add(arr[j][i])) {
                        hasRepeat = true;
                    }
                }
                if (hasRepeat) {
                    colRepeats++;
                }
            }

            // Print results for the current test case
            System.out.printf("Case #%d: %d %d %d%n", k + 1, diagonalSum, rowRepeats, colRepeats);
        }
    }
}