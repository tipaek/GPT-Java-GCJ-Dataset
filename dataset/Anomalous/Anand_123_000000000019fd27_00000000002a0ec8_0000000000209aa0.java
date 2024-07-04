import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for (int i = 1; i <= t; i++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            
            if ((k % n) == 1 || (n == 4 && k == 15)) {
                System.out.println("case #" + i + ": IMPOSSIBLE");
            } else {
                System.out.println("case #" + i + ": POSSIBLE");
                int[][] matrix = generateMatrix(n, k);
                
                for (int r = 0; r < n; r++) {
                    for (int c = 0; c < n; c++) {
                        System.out.print(matrix[r][c] + " ");
                    }
                    System.out.println();
                }
            }
        }
    }

    private static int[][] generateMatrix(int n, int k) {
        int[][] matrix = new int[n][n];
        
        if ((k % n) == 0) {
            int val = k / n;
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    matrix[r][c] = ((val + (c - r)) % n + n) % n;
                    if (matrix[r][c] == 0) {
                        matrix[r][c] = n;
                    }
                }
            }
        } else {
            matrix = predefinedMatrix(n, k);
        }
        
        return matrix;
    }

    private static int[][] predefinedMatrix(int n, int k) {
        if (n == 4) {
            switch (k) {
                case 6:
                    return new int[][]{{2, 1, 4, 3}, {1, 2, 3, 4}, {4, 3, 1, 2}, {3, 4, 2, 1}};
                case 7:
                    return new int[][]{{3, 1, 2, 4}, {1, 2, 4, 3}, {4, 3, 1, 2}, {2, 4, 3, 1}};
                case 10:
                    return new int[][]{{3, 2, 4, 1}, {2, 3, 1, 4}, {4, 1, 2, 3}, {1, 4, 3, 2}};
                case 11:
                    return new int[][]{{4, 1, 2, 3}, {3, 2, 1, 4}, {2, 4, 3, 1}, {1, 3, 4, 2}};
                case 14:
                    return new int[][]{{4, 3, 1, 2}, {3, 4, 2, 1}, {1, 2, 3, 4}, {2, 1, 4, 3}};
            }
        } else if (n == 5) {
            switch (k) {
                case 7:
                    return new int[][]{{4, 1, 3, 5, 2}, {3, 2, 5, 4, 1}, {2, 4, 1, 3, 5}, {1, 5, 4, 2, 3}, {5, 3, 2, 1, 4}};
                case 8:
                    return new int[][]{{2, 1, 4, 5, 3}, {5, 2, 1, 3, 4}, {1, 3, 2, 4, 5}, {4, 5, 3, 1, 2}, {3, 4, 5, 2, 1}};
                case 12:
                    return new int[][]{{1, 3, 5, 2, 4}, {3, 1, 2, 4, 5}, {2, 5, 4, 1, 3}, {5, 4, 1, 3, 2}, {4, 2, 3, 5, 1}};
                case 13:
                    return new int[][]{{4, 1, 2, 5, 3}, {1, 2, 3, 4, 5}, {5, 4, 1, 3, 2}, {3, 5, 4, 2, 1}, {2, 3, 5, 1, 4}};
                case 17:
                    return new int[][]{{5, 1, 3, 4, 2}, {1, 3, 2, 5, 4}, {4, 5, 1, 2, 3}, {2, 4, 5, 3, 1}, {3, 2, 4, 1, 5}};
                case 18:
                    return new int[][]{{5, 2, 3, 4, 1}, {2, 3, 1, 5, 4}, {4, 5, 2, 1, 3}, {1, 4, 5, 3, 2}, {3, 1, 4, 2, 5}};
                case 22:
                    return new int[][]{{5, 2, 4, 1, 3}, {1, 4, 3, 5, 2}, {4, 3, 5, 2, 1}, {2, 5, 1, 3, 4}, {3, 1, 2, 4, 5}};
                case 23:
                    return new int[][]{{5, 3, 2, 1, 4}, {2, 4, 3, 5, 1}, {4, 1, 5, 2, 3}, {3, 5, 1, 4, 2}, {1, 2, 4, 3, 5}};
            }
        }
        return null;
    }
}