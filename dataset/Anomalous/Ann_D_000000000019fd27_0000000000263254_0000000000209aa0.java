import java.util.Scanner;

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

                if (sum < trace) {
                    int j = 0;
                    while (sum != trace) {
                        arr[j]++;
                        sum++;
                        j++;
                    }
                }

                int[][] res = new int[size][size];
                for (int j = 0; j < size; j++) {
                    for (int k = 0; k < size; k++) {
                        if (k == j) {
                            res[j][k] = arr[j];
                        } else if (k > j) {
                            res[j][k] = (arr[j] + k - j) % size;
                        } else {
                            int value = (arr[j] - j + k) % size;
                            res[j][k] = value < 0 ? value + size : value;
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

    private static boolean isValidSolution(int[][] res, int size) {
        int expectedSum = size * (size + 1) / 2;

        for (int j = 0; j < size; j++) {
            int sum = 0;
            for (int k = 0; k < size; k++) {
                sum += res[k][j] == 0 ? size : res[k][j];
            }
            if (sum != expectedSum) {
                return false;
            }
        }
        return true;
    }

    private static void printMatrix(int[][] matrix, int size) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print((value == 0 ? size : value) + " ");
            }
            System.out.println();
        }
    }
}