import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < testCases; i++) {
            String[] inputArray = scanner.nextLine().split(" ");
            int n = Integer.parseInt(inputArray[0]);
            int k = Integer.parseInt(inputArray[1]);

            int[][] matrix = new int[n][n];

            // Fill the diagonal with k/n
            for (int j = 0; j < n; j++) {
                matrix[j][j] = k / n;
            }

            // Distribute the remainder of k%n
            if (k % n > 0) {
                matrix[n - 1][n - 1] += k % n;
            }

            Random random = new Random();
            boolean possible = true;

            // Fill the matrix with unique values
            for (int row = 0; row < n; row++) {
                Set<Integer> usedInRow = new HashSet<>();
                usedInRow.add(matrix[row][row]);

                for (int col = 0; col < n; col++) {
                    if (row != col) {
                        int value;
                        do {
                            value = random.nextInt(n) + 1;
                        } while (usedInRow.contains(value));
                        matrix[row][col] = value;
                        usedInRow.add(value);
                    }
                }
            }

            // Check columns for uniqueness
            for (int col = 0; col < n; col++) {
                Set<Integer> usedInCol = new HashSet<>();
                for (int row = 0; row < n; row++) {
                    if (usedInCol.contains(matrix[row][col])) {
                        possible = false;
                        break;
                    }
                    usedInCol.add(matrix[row][col]);
                }
                if (!possible) {
                    break;
                }
            }

            // Output the result
            if (possible) {
                System.out.println("case #" + i + ": POSSIBLE");
                for (int[] row : matrix) {
                    for (int value : row) {
                        System.out.print(value + " ");
                    }
                    System.out.println();
                }
            } else {
                System.out.println("case #" + i + ": IMPOSSIBLE");
            }
        }
    }
}