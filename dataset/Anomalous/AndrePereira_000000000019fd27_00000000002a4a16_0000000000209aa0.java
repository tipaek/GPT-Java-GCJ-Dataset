import java.util.Scanner;

public class Solution {

    private static void indicium(int caseNumber, int matrixSize, int trace) {
        boolean isPossible = (trace % matrixSize == 0);
        System.out.printf("Case #%d: %s%n", caseNumber, isPossible ? "POSSIBLE" : "IMPOSSIBLE");

        if (isPossible) {
            int diagonalValue = trace / matrixSize;
            int[] values = new int[matrixSize];
            int index = 1;
            values[0] = diagonalValue;

            for (int i = 1; i <= matrixSize; i++) {
                if (i != diagonalValue) {
                    values[index++] = i;
                }
            }

            index = 0;
            for (int i = 1; i <= matrixSize; i++) {
                for (int j = 1; j <= matrixSize; j++) {
                    if (i == j) {
                        System.out.print(diagonalValue + " ");
                    } else {
                        System.out.print(values[index] + " ");
                        index = (index + 1) % matrixSize;
                    }
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < testCases; i++) {
            String[] input = scanner.nextLine().split(" ");
            int matrixSize = Integer.parseInt(input[0]);
            int trace = Integer.parseInt(input[1]);
            indicium(i + 1, matrixSize, trace);
        }
    }
}