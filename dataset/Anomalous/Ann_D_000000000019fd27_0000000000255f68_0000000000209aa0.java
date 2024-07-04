import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int matrixSize = scanner.nextInt();
            int trace = scanner.nextInt();

            if (trace % matrixSize == 0 && trace % matrixSize <= matrixSize) {
                System.out.println("Case #" + testCase + ": POSSIBLE");
                int diagonalValue = trace / matrixSize;

                for (int row = 1; row <= matrixSize; row++) {
                    for (int col = 1; col <= matrixSize; col++) {
                        int value = (col + diagonalValue - 2) % matrixSize + 1;
                        System.out.print(value + " ");
                    }
                    System.out.println();
                }
            } else {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
            }
        }

        scanner.close();
    }
}