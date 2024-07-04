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

                int j = 0;
                while (sum < trace) {
                    arr[j]++;
                    sum++;
                    j++;
                }

                int[][] res = new int[size][size];
                int[][] resRev = new int[size][size];

                for (int x = 0; x < size; x++) {
                    for (int y = 0; y < size; y++) {
                        if (y == x) {
                            res[x][y] = arr[x];
                            resRev[size - 1 - x][size - 1 - y] = arr[x];
                        } else if (y > x) {
                            res[x][y] = (arr[x] + y - x) % size;
                            resRev[size - 1 - x][size - 1 - y] = (arr[x] + y - x) % size;
                        } else {
                            int value = (arr[x] - x + y) % size;
                            if (value < 0) {
                                value += size;
                            }
                            res[x][y] = value;
                            resRev[size - 1 - x][size - 1 - y] = value;
                        }
                    }
                }

                boolean flag1 = checkColumns(res, size);
                boolean flag2 = checkColumns(resRev, size);

                if (!flag1 && !flag2) {
                    System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
                } else {
                    System.out.println("Case #" + (i + 1) + ": POSSIBLE");
                    if (flag1) {
                        printMatrix(res, size);
                    } else {
                        printMatrix(resRev, size);
                    }
                }
            } else {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            }
        }
    }

    private static boolean checkColumns(int[][] matrix, int size) {
        for (int j = 0; j < size; j++) {
            int sumCol = 0;
            for (int k = 0; k < size; k++) {
                sumCol += matrix[k][j] == 0 ? size : matrix[k][j];
            }
            if (sumCol != size * (size + 1) / 2) {
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