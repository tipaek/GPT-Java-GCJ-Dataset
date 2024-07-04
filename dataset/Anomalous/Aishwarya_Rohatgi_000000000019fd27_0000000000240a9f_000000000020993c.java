import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfTestcases = sc.nextInt();

        for (int i = 0; i < numberOfTestcases; i++) {
            int sizeOfMatrix = sc.nextInt();
            int[][] matrix = new int[sizeOfMatrix][sizeOfMatrix];

            // Reading the matrix
            for (int row = 0; row < sizeOfMatrix; row++) {
                for (int col = 0; col < sizeOfMatrix; col++) {
                    matrix[row][col] = sc.nextInt();
                }
            }

            // Calculating the trace
            int trace = 0;
            for (int j = 0; j < sizeOfMatrix; j++) {
                trace += matrix[j][j];
            }

            // Counting rows with duplicate elements
            int duplicateRows = 0;
            for (int row = 0; row < sizeOfMatrix; row++) {
                Set<Integer> seen = new HashSet<>();
                for (int col = 0; col < sizeOfMatrix; col++) {
                    if (!seen.add(matrix[row][col])) {
                        duplicateRows++;
                        break;
                    }
                }
            }

            // Counting columns with duplicate elements
            int duplicateColumns = 0;
            for (int col = 0; col < sizeOfMatrix; col++) {
                Set<Integer> seen = new HashSet<>();
                for (int row = 0; row < sizeOfMatrix; row++) {
                    if (!seen.add(matrix[row][col])) {
                        duplicateColumns++;
                        break;
                    }
                }
            }

            // Printing the result
            System.out.println("Case #" + (i + 1) + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
        }

        sc.close();
    }
}