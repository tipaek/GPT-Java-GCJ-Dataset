import java.util.Scanner;
import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCaseCount = Integer.parseInt(scanner.nextLine().trim());
        for (int testCase = 1; testCase <= testCaseCount; testCase++) {
            String[] input = scanner.nextLine().trim().split(" ");
            int matrixSize = Integer.parseInt(input[0]);
            int trace = Integer.parseInt(input[1]);

            System.out.print("Case #" + testCase + ": ");

            if (trace < matrixSize || trace % matrixSize != 0) {
                System.out.println("IMPOSSIBLE");
                continue;
            }

            System.out.println("POSSIBLE");
            int[][] matrix = new int[matrixSize][matrixSize];
            int diagonalValue = trace / matrixSize;

            for (int row = 0; row < matrixSize; row++) {
                int col = row;
                int value = diagonalValue;

                for (int j = 0; j < matrixSize; j++) {
                    matrix[row][col] = value;
                    value = value % matrixSize + 1;
                    col = (col + 1) % matrixSize;
                }
            }

            for (int[] row : matrix) {
                System.out.println(Arrays.stream(row)
                                         .mapToObj(String::valueOf)
                                         .collect(Collectors.joining(" ")));
            }
        }
    }
}