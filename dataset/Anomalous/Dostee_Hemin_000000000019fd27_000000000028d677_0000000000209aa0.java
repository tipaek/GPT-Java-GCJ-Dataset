import java.util.Scanner;

public class Solution {
    public static boolean isPossible = true;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        
        for (int cs = 1; cs <= T; cs++) {
            int n = input.nextInt();
            int k = input.nextInt();
            isPossible = true;
            int[][] matrix = new int[n][n];
            int currentVal = n;
            int[] chosen = new int[n];
            int target = k;

            for (int i = 0; i < n; i++) {
                while (target - currentVal < n - i - 1) {
                    currentVal--;
                }
                target -= currentVal;
                matrix[i][i] = currentVal;
                chosen[i] = currentVal;
            }

            for (int j = 0; j < n; j++) {
                int val = n;
                if (val == chosen[j]) {
                    val--;
                }
                for (int i = 0; i < n; i++) {
                    if (i == j) {
                        if (val == chosen[j]) {
                            val--;
                        }
                        continue;
                    }
                    matrix[i][j] = val;
                    val--;
                }

                for (int i = n - 1; i >= 0; i--) {
                    int dir = (i != 0) ? -1 : 1;
                    int switchI = (i != 0) ? i - 1 : 1;
                    checkSwitch(j, i, matrix, switchI, dir);
                    isPossible = checkIsPossible(matrix);
                }
            }

            String result = isPossible ? "POSSIBLE" : "IMPOSSIBLE";
            System.out.println("Case #" + cs + ": " + result);
            if (isPossible) {
                printMatrix(matrix);
            }
        }
    }

    public static void checkSwitch(int j, int i, int[][] matrix, int switchI, int dir) {
        if (i == j || (i == 1 && j == 0) || switchI == matrix.length) {
            return;
        }

        if (switchI == j) {
            checkSwitch(j, i, matrix, switchI + dir, dir);
            return;
        }

        boolean copyExists = false;
        for (int l = 0; l < matrix.length; l++) {
            if (l == j) continue;
            if (matrix[i][l] == matrix[i][j]) {
                copyExists = true;
                break;
            }
        }

        if (copyExists) {
            int temp = matrix[i][j];
            matrix[i][j] = matrix[switchI][j];
            matrix[switchI][j] = temp;
            if (switchI > 0) {
                checkSwitch(j, i, matrix, switchI + dir, dir);
            }
        }
    }

    public static boolean checkIsPossible(int[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            int[] found = new int[n];
            for (int j = 0; j < n; j++) {
                int val = matrix[i][j];
                if (val == 0 || ++found[val - 1] > 1) {
                    return false;
                }
            }
        }

        for (int j = 0; j < n; j++) {
            int[] found = new int[n];
            for (int i = 0; i < n; i++) {
                int val = matrix[i][j];
                if (++found[val - 1] > 1) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}