import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        ScanWrapper input = new ScanWrapper();
        int testsNum = input.nextInt();
        for (int testIndex = 0; testIndex < testsNum; testIndex++) {
            int[] testData = input.readRow();
            int matrixSize = testData[0];
            int desiredTrace = testData[1];
            if (desiredTrace < matrixSize || desiredTrace > matrixSize * matrixSize || desiredTrace % matrixSize != 0) {
                System.out.println("Case #" + (testIndex + 1) + ": IMPOSSIBLE");
                continue;
            }
            System.out.println("Case #" + (testIndex + 1) + ": POSSIBLE");
            int diagonal = desiredTrace / matrixSize;
            for (int i = 0; i < matrixSize; i++) {
                for (int j = matrixSize - 1; j > 0; j--) {
                    System.out.print((diagonal + i + j) % matrixSize + 1 + " ");
                }
                System.out.print((diagonal + i + matrixSize) % matrixSize + 1);
                System.out.print('\n');
            }
        }
    }

    private static class ScanWrapper {
        private final Scanner scanner;

        ScanWrapper() {
            scanner = new Scanner(System.in);
        }

        int nextInt() {
            return Integer.parseInt(scanner.nextLine());
        }

        int[] readRow() {
            String[] strings = scanner.nextLine().split(" ");
            return new int[]{
                    Integer.parseInt(strings[0]),
                    Integer.parseInt(strings[1])
            };
        }
    }
}