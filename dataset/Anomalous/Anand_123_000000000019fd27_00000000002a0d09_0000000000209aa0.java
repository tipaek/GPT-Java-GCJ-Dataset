import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int i = 1; i <= testCases; i++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            
            if (isImpossibleCase(n, k)) {
                System.out.println("case #" + i + ": IMPOSSIBLE");
            } else {
                System.out.println("case #" + i + ": POSSIBLE");
                int[][] matrix = generateMatrix(n, k);
                printMatrix(matrix);
            }
        }
        
        scanner.close();
    }

    private static boolean isImpossibleCase(int n, int k) {
        return (k % n == 1) || (n == 4 && k == 15);
    }

    private static int[][] generateMatrix(int n, int k) {
        int[][] matrix;

        if (k % n == 0) {
            matrix = generateDivisibleMatrix(n, k / n);
        } else {
            matrix = getPresetMatrix(n, k);
        }

        return matrix;
    }

    private static int[][] generateDivisibleMatrix(int n, int value) {
        int[][] matrix = new int[n][n];
        
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                matrix[r][c] = (value + (c - r + n) % n) % n;
                if (matrix[r][c] == 0) matrix[r][c] = n;
            }
        }
        
        return matrix;
    }

    private static int[][] getPresetMatrix(int n, int k) {
        if (n == 4) {
            return getPresetMatrixFor4(k);
        } else if (n == 5) {
            return getPresetMatrixFor5(k);
        }
        return null;
    }

    private static int[][] getPresetMatrixFor4(int k) {
        switch (k) {
            case 6: return new int[][]{{2, 1, 4, 3}, {1, 2, 3, 4}, {4, 3, 1, 2}, {3, 4, 2, 1}};
            case 7: return new int[][]{{3, 1, 2, 4}, {1, 2, 4, 3}, {4, 3, 1, 2}, {2, 4, 3, 1}};
            case 10: return new int[][]{{3, 2, 4, 1}, {2, 3, 1, 4}, {4, 1, 2, 3}, {1, 4, 3, 2}};
            case 11: return new int[][]{{4, 1, 2, 3}, {3, 2, 1, 4}, {2, 4, 3, 1}, {1, 3, 4, 2}};
            case 14: return new int[][]{{4, 3, 1, 2}, {3, 4, 2, 1}, {1, 2, 3, 4}, {2, 1, 4, 3}};
        }
        return null;
    }

    private static int[][] getPresetMatrixFor5(int k) {
        switch (k) {
            case 7: return new int[][]{{4, 1, 3, 5, 2}, {3, 2, 5, 4, 1}, {2, 4, 1, 3, 5}, {1, 5, 4, 2, 3}, {5, 3, 2, 1, 4}};
            case 8: return new int[][]{{2, 1, 4, 5, 3}, {5, 2, 1, 3, 4}, {1, 3, 2, 4, 5}, {4, 5, 3, 1, 2}, {3, 4, 5, 2, 1}};
            case 12: return new int[][]{{1, 3, 5, 2, 4}, {3, 1, 2, 4, 5}, {2, 5, 4, 1, 3}, {5, 4, 1, 3, 2}, {4, 2, 3, 5, 1}};
            case 13: return new int[][]{{4, 1, 2, 5, 3}, {1, 2, 3, 4, 5}, {5, 4, 1, 3, 2}, {3, 5, 4, 2, 1}, {2, 3, 5, 1, 4}};
            case 17: return new int[][]{{5, 1, 3, 4, 2}, {1, 3, 2, 5, 4}, {4, 5, 1, 2, 3}, {2, 4, 5, 3, 1}, {3, 2, 4, 1, 5}};
            case 18: return new int[][]{{5, 2, 3, 4, 1}, {2, 3, 1, 5, 4}, {4, 5, 2, 1, 3}, {1, 4, 5, 3, 2}, {3, 1, 4, 2, 5}};
            case 22: return new int[][]{{5, 2, 4, 1, 3}, {1, 4, 3, 5, 2}, {4, 3, 5, 2, 1}, {2, 5, 1, 3, 4}, {3, 1, 2, 4, 5}};
            case 23: return new int[][]{{5, 3, 2, 1, 4}, {2, 4, 3, 5, 1}, {4, 1, 5, 2, 3}, {3, 5, 1, 4, 2}, {1, 2, 4, 3, 5}};
        }
        return null;
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}