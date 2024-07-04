import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();

        for (int p = 1; p <= t; p++) {
            int size = in.nextInt();
            int sum = in.nextInt();
            System.out.print("Case #" + p + ": ");

            if (isPossible(size, sum)) {
                System.out.println("POSSIBLE");
                printMatrix(size, sum);
            } else {
                System.out.println("IMPOSSIBLE");
            }
        }
    }

    private static boolean isPossible(int size, int sum) {
        if (size == 2) {
            return sum == 2 || sum == 4;
        } else if (size == 3) {
            return sum == 3 || sum == 6 || sum == 9;
        } else if (size == 4) {
            return sum == 4 || sum == 8 || sum == 12 || sum == 16;
        } else if (size == 5) {
            return sum == 5 || sum == 10 || sum == 15 || sum == 20 || sum == 25;
        }
        return false;
    }

    private static void printMatrix(int size, int sum) {
        int[][] matrices = getMatrix(size, sum);
        for (int[] row : matrices) {
            for (int i = 0; i < row.length; i++) {
                System.out.print(row[i]);
                if (i < row.length - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    private static int[][] getMatrix(int size, int sum) {
        int[][] matrix = new int[size][size];

        if (size == 2) {
            if (sum == 2) {
                matrix = new int[][]{{1, 2}, {2, 1}};
            } else if (sum == 4) {
                matrix = new int[][]{{2, 1}, {1, 2}};
            }
        } else if (size == 3) {
            if (sum == 3) {
                matrix = new int[][]{{1, 2, 3}, {3, 1, 2}, {2, 3, 1}};
            } else if (sum == 6) {
                matrix = new int[][]{{2, 3, 1}, {1, 2, 3}, {3, 1, 2}};
            } else if (sum == 9) {
                matrix = new int[][]{{3, 1, 2}, {2, 3, 1}, {1, 2, 3}};
            }
        } else if (size == 4) {
            if (sum == 4) {
                matrix = new int[][]{{1, 2, 3, 4}, {4, 1, 2, 3}, {3, 4, 1, 2}, {2, 3, 4, 1}};
            } else if (sum == 8) {
                matrix = new int[][]{{2, 3, 4, 1}, {1, 2, 3, 4}, {4, 1, 2, 3}, {3, 4, 1, 2}};
            } else if (sum == 12) {
                matrix = new int[][]{{3, 4, 1, 2}, {2, 3, 4, 1}, {1, 2, 3, 4}, {4, 1, 2, 3}};
            } else if (sum == 16) {
                matrix = new int[][]{{4, 1, 2, 3}, {3, 4, 1, 2}, {2, 3, 4, 1}, {1, 2, 3, 4}};
            }
        } else if (size == 5) {
            if (sum == 5) {
                matrix = new int[][]{{1, 2, 3, 4, 5}, {5, 1, 2, 3, 4}, {4, 5, 1, 2, 3}, {3, 4, 5, 1, 2}, {2, 3, 4, 5, 1}};
            } else if (sum == 10) {
                matrix = new int[][]{{2, 3, 4, 5, 1}, {1, 2, 3, 4, 5}, {5, 1, 2, 3, 4}, {4, 5, 1, 2, 3}, {3, 4, 5, 1, 2}};
            } else if (sum == 15) {
                matrix = new int[][]{{3, 4, 5, 1, 2}, {2, 3, 4, 5, 1}, {1, 2, 3, 4, 5}, {5, 1, 2, 3, 4}, {4, 5, 1, 2, 3}};
            } else if (sum == 20) {
                matrix = new int[][]{{4, 5, 1, 2, 3}, {3, 4, 5, 1, 2}, {2, 3, 4, 5, 1}, {1, 2, 3, 4, 5}, {5, 1, 2, 3, 4}};
            } else if (sum == 25) {
                matrix = new int[][]{{5, 1, 2, 3, 4}, {4, 5, 1, 2, 3}, {3, 4, 5, 1, 2}, {2, 3, 4, 5, 1}, {1, 2, 3, 4, 5}};
            }
        }

        return matrix;
    }
}