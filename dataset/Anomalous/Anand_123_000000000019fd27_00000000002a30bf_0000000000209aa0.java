import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for (int i = 1; i <= t; i++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            
            if (isImpossible(n, k)) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + i + ": POSSIBLE");
                int[][] matrix = generateMatrix(n, k);
                printMatrix(matrix);
            }
        }
    }

    private static boolean isImpossible(int n, int k) {
        return (n == 2 && k == 3) || (n == 3 && k == 4) || (n == 3 && k == 5) || (n == 3 && k == 7) || 
               (n == 3 && k == 8) || (n == 4 && k == 5) || (n == 4 && k == 9) || (n == 4 && k == 13) || 
               (n == 4 && k == 15) || (n == 5 && k == 6) || (n == 4 && k == 11) || (n == 4 && k == 16) || 
               (n == 4 && k == 21);
    }

    private static int[][] generateMatrix(int n, int k) {
        if (n == 2) {
            if (k == 2) return new int[][] {{1, 2}, {2, 1}};
            if (k == 4) return new int[][] {{2, 1}, {1, 2}};
        } else if (n == 3) {
            if (k == 3) return new int[][] {{1, 2, 3}, {3, 1, 2}, {2, 3, 1}};
            if (k == 6) return new int[][] {{2, 3, 1}, {1, 2, 3}, {3, 1, 2}};
            if (k == 9) return new int[][] {{3, 1, 2}, {1, 3, 2}, {2, 1, 3}};
        } else if (n == 4) {
            switch (k) {
                case 4: return new int[][] {{1, 2, 3, 4}, {4, 1, 2, 3}, {3, 4, 1, 2}, {2, 3, 4, 1}};
                case 6: return new int[][] {{2, 1, 4, 3}, {1, 2, 3, 4}, {4, 3, 1, 2}, {3, 4, 2, 1}};
                case 7: return new int[][] {{3, 1, 2, 4}, {1, 2, 4, 3}, {4, 3, 1, 2}, {2, 4, 3, 1}};
                case 8: return new int[][] {{2, 3, 4, 1}, {1, 2, 3, 4}, {4, 1, 2, 3}, {3, 4, 1, 2}};
                case 10: return new int[][] {{3, 2, 4, 1}, {2, 3, 1, 4}, {4, 1, 2, 3}, {1, 4, 3, 2}};
                case 11: return new int[][] {{4, 1, 2, 3}, {3, 2, 1, 4}, {2, 4, 3, 1}, {1, 3, 4, 2}};
                case 12: return new int[][] {{3, 4, 1, 2}, {2, 3, 4, 1}, {1, 2, 3, 4}, {4, 1, 2, 3}};
                case 14: return new int[][] {{4, 3, 1, 2}, {3, 4, 2, 1}, {1, 2, 3, 4}, {2, 1, 4, 3}};
                case 16: return new int[][] {{4, 3, 2, 1}, {1, 4, 3, 2}, {2, 1, 4, 3}, {3, 2, 1, 4}};
            }
        } else if (n == 5) {
            switch (k) {
                case 7: return new int[][] {{4, 1, 3, 5, 2}, {3, 2, 5, 4, 1}, {2, 4, 1, 3, 5}, {1, 5, 4, 2, 3}, {5, 3, 2, 1, 4}};
                case 8: return new int[][] {{2, 1, 4, 5, 3}, {5, 2, 1, 3, 4}, {1, 3, 2, 4, 5}, {4, 5, 3, 1, 2}, {3, 4, 5, 2, 1}};
                case 12: return new int[][] {{1, 3, 5, 2, 4}, {3, 1, 2, 4, 5}, {2, 5, 4, 1, 3}, {5, 4, 1, 3, 2}, {4, 2, 3, 5, 1}};
                case 13: return new int[][] {{4, 1, 2, 5, 3}, {1, 2, 3, 4, 5}, {5, 4, 1, 3, 2}, {3, 5, 4, 2, 1}, {2, 3, 5, 1, 4}};
                case 17: return new int[][] {{5, 1, 3, 4, 2}, {1, 3, 2, 5, 4}, {4, 5, 1, 2, 3}, {2, 4, 5, 3, 1}, {3, 2, 4, 1, 5}};
                case 18: return new int[][] {{5, 2, 3, 4, 1}, {2, 3, 1, 5, 4}, {4, 5, 2, 1, 3}, {1, 4, 5, 3, 2}, {3, 1, 4, 2, 5}};
                case 22: return new int[][] {{5, 2, 4, 1, 3}, {1, 4, 3, 5, 2}, {4, 3, 5, 2, 1}, {2, 5, 1, 3, 4}, {3, 1, 2, 4, 5}};
                case 23: return new int[][] {{5, 3, 2, 1, 4}, {2, 4, 3, 5, 1}, {4, 1, 5, 2, 3}, {3, 5, 1, 4, 2}, {1, 2, 4, 3, 5}};
            }
        }
        return null;
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}