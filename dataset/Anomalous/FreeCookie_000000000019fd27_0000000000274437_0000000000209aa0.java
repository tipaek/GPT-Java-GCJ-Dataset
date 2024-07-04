import java.util.Scanner;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int testCaseCount = Integer.parseInt(scanner.nextLine().trim());
        for (int testCaseIndex = 1; testCaseIndex <= testCaseCount; testCaseIndex++) {
            String[] inputs = scanner.nextLine().trim().split(" ");
            int matrixSize = Integer.parseInt(inputs[0]);
            int trace = Integer.parseInt(inputs[1]);

            System.out.print("Case #" + testCaseIndex + ": ");

            if (trace < matrixSize || trace % matrixSize != 0) {
                System.out.println("IMPOSSIBLE");
                continue;
            }

            System.out.println("POSSIBLE");
            int[][] matrix = new int[matrixSize][matrixSize];
            int diagonalValue = trace / matrixSize;

            for (int i = 0; i < matrixSize; i++) {
                int value = diagonalValue;
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][(i + j) % matrixSize] = value;
                    value = (value % matrixSize) + 1;
                }
            }

            for (int[] row : matrix) {
                String rowString = IntStream.of(row)
                                            .mapToObj(String::valueOf)
                                            .collect(Collectors.joining(" "));
                System.out.println(rowString);
            }
        }
    }
}