import java.util.Scanner;

public class Solution {
    public static boolean isPossible = true;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        for(int cs=1; cs<=T; cs++) {
            int n = input.nextInt();
            int k = input.nextInt();
            int[][] matrix = new int[n][n];
            int currentVal = n;
            int[] chosen = new int[n];
            for(int i=0; i<n; i++) {
                while(k-currentVal < n - i - 1) {
                    currentVal--;
                }
                k -= currentVal;
                matrix[i][i] = currentVal;
                chosen[i] = currentVal;
            }
            for(int j=0; j<n; j++) {
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
                    int dir = 1;
                    int switchI = 1;
                    if (i != 0) {
                        dir = -1;
                        switchI = i - 1;
                    }
                    checkSwitch(j, i, matrix, switchI, dir);
                }
            }
            String s = "POSSIBLE";
            if(!isPossible) {
                s = "IMPOSSIBLE";
            }
            System.out.println("Case #" + cs + ": " + s);
            if(isPossible) {
                printMatrix(matrix);
            }
        }
    }

    public static void checkSwitch(int j, int i, int[][] m, int sI, int d) {
        if(i == j) {
            return;
        }
        if(i == 1 && j == 0) {
            return;
        }
        if(sI == m.length) {
            isPossible = false;
            return;
        }
        if(sI == j) {
            checkSwitch(j, i, m, sI + d, d);
            return;
        }
        boolean copyExists = false;
        for(int l=0; l<m.length; l++) {
            if(l == j) {
                continue;
            }
            if(m[i][l] == m[i][j]) {
                copyExists = true;
                break;
            }
        }
        if(copyExists) {
            int temp = m[i][j];
            m[i][j] = m[sI][j];
            m[sI][j] = temp;
            if(sI > 0) {
                checkSwitch(j, i, m, sI + d, d);
            }
        }
    }

    public static void printMatrix(int[][] m) {
        for(int i=0; i<m.length; i++) {
            for(int j=0; j<m.length; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println("");
        }
    }
}