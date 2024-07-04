import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        int caseNumber = 1;
        StringBuilder result = new StringBuilder();

        while (t-- > 0) {
            String[] nk = br.readLine().trim().split("\\s+");
            int n = Integer.parseInt(nk[0]);
            int k = Integer.parseInt(nk[1]);

            if (n > k) {
                result.append("Case #").append(caseNumber).append(": IMPOSSIBLE\n");
                caseNumber++;
                continue;
            }

            int[][] matrix = new int[n][n];
            boolean found = false;

            for (int attempt = 0; attempt < 7000; attempt++) {
                matrix[0] = MatrixOps.createOrderedArray(n, 1);

                for (int i = 0; i < n; i++) {
                    matrix[i] = MatrixOps.createOrderedArray(n, 1);
                    do {
                        MatrixOps.shuffle(matrix[i]);
                    } while (!MatrixOps.isUnique(matrix[i], matrix, 0, i));
                }

                int diagonalSum = 0;
                for (int i = 0; i < n; i++) {
                    diagonalSum += matrix[i][i];
                }

                if (diagonalSum == k) {
                    found = true;
                    break;
                }
            }

            if (found) {
                result.append("Case #").append(caseNumber).append(": POSSIBLE\n");
                for (int[] row : matrix) {
                    for (int value : row) {
                        result.append(value).append(" ");
                    }
                    result.append("\n");
                }
            } else {
                result.append("Case #").append(caseNumber).append(": IMPOSSIBLE\n");
            }

            caseNumber++;
        }

        System.out.print(result);
    }
}

class MatrixOps {

    public static void shuffle(int[] arr) {
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            swap(arr, i, random.nextInt(arr.length));
        }
    }

    public static int[] createOrderedArray(int size, int startValue) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = i + startValue;
        }
        return array;
    }

    public static boolean isUnique(int[] currentRow, int[][] matrix, int start, int end) {
        for (int i = start; i < end; i++) {
            if (!areDistinct(currentRow, matrix[i])) {
                return false;
            }
        }
        return true;
    }

    private static boolean areDistinct(int[] row1, int[] row2) {
        if (row1.length != row2.length) {
            return false;
        }
        for (int i = 0; i < row1.length; i++) {
            if (row1[i] == row2[i]) {
                return false;
            }
        }
        return true;
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}