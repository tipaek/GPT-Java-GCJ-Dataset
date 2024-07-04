import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Vestigium {
    private static boolean checkDuplicatesWithinK(int[] arr, int k) {
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            if (set.contains(arr[i]))
                return true;
            set.add(arr[i]);
            if (i >= k)
                set.remove(arr[i - k]);
        }
        return false;
    }

    private static int[][] swapMatrix(int[][] pField) {
        int originalTotalRows = pField.length;
        int originalTotalColumns = pField[0].length;

        int[][] newMatrix = new int[originalTotalColumns][originalTotalRows];

        for (int i = 0; i < originalTotalRows; i++) {
            for (int j = 0; j < originalTotalColumns; j++) {
                newMatrix[j][i] = pField[i][j];
            }
        }
        return newMatrix;
    }

    /**
     * Assumption: well formatted input
     */

    public static class Triplet<T, U, V> {

        private final T first;
        private final U second;
        private final V third;

        Triplet(T first, U second, V third) {
            this.first = first;
            this.second = second;
            this.third = third;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int numberOfTestCases = in.nextInt();
        List<Triplet> results = new ArrayList<>();
        int testCase = 1;
        while (numberOfTestCases >= testCase) {
            int trace = 0;
            int rowRepeatCount = 0;
            int colRepeatCount = 0;
            int valueOfN = in.nextInt();
            int[][] matrix = new int[valueOfN][valueOfN];

            for (int c = 0; c < valueOfN; c++) {
                boolean match;

                for (int r = 0; r < valueOfN; r++) {
                    matrix[c][r] = in.nextInt();

                    if (c == r) {
                        trace += matrix[c][r];
                    }
                }

                match = checkDuplicatesWithinK(matrix[c], valueOfN);
                rowRepeatCount += match ? 1 : 0;
            }

            int[][] swapped = swapMatrix(matrix);
            for (int j = 0; j < valueOfN; j++) {
                boolean match;
                match = checkDuplicatesWithinK(swapped[j], valueOfN);
                colRepeatCount += match ? 1 : 0;
            }
            results.add(new Triplet<>(trace, rowRepeatCount, colRepeatCount));

            testCase++;
        }
        for (Triplet result : results) {
            System.out.println("Case #" + results.indexOf(result) + ": " + result.first + " " + result.second + " "
                    + result.third);
        }
    }
}
