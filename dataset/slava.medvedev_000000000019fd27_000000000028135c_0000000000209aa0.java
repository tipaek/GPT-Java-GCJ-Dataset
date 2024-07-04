import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Function;

public class Solution {

    public static void main(String[] args) {
        ScanWrapper input = new ScanWrapper();
        int testsNum = input.nextInt();
        for (int testIndex = 0; testIndex < testsNum; testIndex++) {
            int[] testData = input.readRow();
            int matrixSize = testData[0];
            int desiredTrace = testData[1];
            if (desiredTrace < matrixSize || desiredTrace > matrixSize * matrixSize) {
                System.out.println("Case #" + (testIndex + 1) + ": IMPOSSIBLE");
                continue;
            }
            int[][] matrix = createMatrix(matrixSize);

            int[] columnIndexes = new int[matrixSize];
            for (int i=0; i< matrixSize; i++) {
                columnIndexes[i] = i;
            }

            final int finalTestIndex = testIndex;
            AtomicBoolean possible = new AtomicBoolean(false);
            Function<int[], Boolean> checkCallback = permutation -> {
                int sum = 0;
                for (int i=0; i< matrixSize; i++) {
                    sum += matrix[permutation[i]][i];
                }
                if (sum == desiredTrace) {
                    System.out.println("Case #" + (finalTestIndex + 1) + ": POSSIBLE");
                    for (int i=0; i< matrixSize; i++) {
                        int[] row = matrix[permutation[i]];
                        for (int j=0; j< matrixSize; j++) {
                            System.out.print(row[j]);
                            if (j != matrixSize - 1) {
                                System.out.print(' ');
                            }
                        }
                        System.out.print('\n');
                    }
                    possible.set(true);
                    return true;
                }
                return false;
            };
            permuteHelper(columnIndexes, 0, checkCallback);

            if (!possible.get()) {
                System.out.println("Case #" + (testIndex + 1) + ": IMPOSSIBLE");
            }
        }

    }

    // return true if should stop;
    private static boolean permuteHelper(int[] arr, int index, Function<int[], Boolean> callback) {
        if (index >= arr.length - 1) { //If we are at the last element - nothing left to permute
            return callback.apply(arr);
        }

        for (int i = index; i < arr.length; i++) { //For each index in the sub array arr[index...end]

            //Swap the elements at indices index and i
            int t = arr[index];
            arr[index] = arr[i];
            arr[i] = t;

            //Recurse on the sub array arr[index+1...end]
            if (permuteHelper(arr, index + 1, callback)) {
                return true;
            }

            //Swap the elements back
            t = arr[index];
            arr[index] = arr[i];
            arr[i] = t;
        }
        return false;
    }

    private static int[][] createMatrix(int matrixSize) {
        int[][] matrix = new int[matrixSize][matrixSize];
        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0, k = i; j < matrixSize; j++, k = (k + 1) % matrixSize) {
                matrix[i][j] = k + 1;
            }
        }
        return matrix;
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