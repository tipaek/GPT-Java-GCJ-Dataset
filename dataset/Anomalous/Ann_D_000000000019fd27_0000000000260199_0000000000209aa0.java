import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int size = sc.nextInt();
            int trace = sc.nextInt();

            if (trace <= size * size) {
                int[] arr = new int[size];
                int sum = 0;
                
                for (int j = 0; j < size; j++) {
                    arr[j] = trace / size;
                    sum += arr[j];
                }

                int j = 0;
                while (sum < trace) {
                    arr[j]++;
                    sum++;
                    j++;
                }

                int[][] res = new int[size][size];
                for (int row = 0; row < size; row++) {
                    for (int col = 0; col < size; col++) {
                        if (col == row) {
                            res[row][col] = arr[row];
                        } else if (col > row) {
                            res[row][col] = (arr[row] + col - row) % size;
                        } else {
                            res[row][col] = (arr[row] - row + col) % size;
                        }
                    }
                }

                if (isValidSolution(res, size)) {
                    System.out.println("Case #" + (i + 1) + ": POSSIBLE");
                    printMatrix(res, size);
                } else {
                    System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
                }
            } else {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            }
        }
    }

    private static boolean isValidSolution(int[][] matrix, int size) {
        for (int col = 0; col < size; col++) {
            int sum = 0;
            for (int row = 0; row < size; row++) {
                sum += (matrix[row][col] == 0) ? size : matrix[row][col];
            }
            if (sum != size * (size + 1) / 2) {
                return false;
            }
        }
        return true;
    }

    private static void printMatrix(int[][] matrix, int size) {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                System.out.print((matrix[row][col] == 0) ? size : matrix[row][col]);
                if (col < size - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}