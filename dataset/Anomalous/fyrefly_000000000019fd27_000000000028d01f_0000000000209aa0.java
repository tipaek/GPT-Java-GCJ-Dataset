import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        
        for (int tn = 1; tn <= t; tn++) {
            boolean possible = false;
            int n = scan.nextInt();
            int k = scan.nextInt();
            int[][] matrix = new int[n][n];
            
            for (int start = 1; start <= n; start++) {
                fillMatrix(matrix, start, n, true);
                
                if (calculateTrace(matrix, n) == k) {
                    possible = true;
                    break;
                }
            }
            
            if (!possible) {
                for (int start = 1; start <= n; start++) {
                    fillMatrix(matrix, start, n, false);
                    
                    if (calculateTrace(matrix, n) == k) {
                        possible = true;
                        break;
                    }
                }
            }
            
            printResult(tn, possible, matrix, n);
        }
    }

    private static void fillMatrix(int[][] matrix, int start, int n, boolean increment) {
        for (int i = 0; i < n; i++) {
            int num = start;
            for (int j = 0; j < n; j++) {
                if (increment) {
                    if (num > n) num = 1;
                    matrix[i][j] = num++;
                } else {
                    if (num == 0) num = n;
                    matrix[i][j] = num--;
                }
            }
            if (increment) {
                start++;
            } else {
                start--;
            }
        }
    }

    private static int calculateTrace(int[][] matrix, int n) {
        int trace = 0;
        for (int i = 0; i < n; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static void printResult(int tn, boolean possible, int[][] matrix, int n) {
        if (possible) {
            System.out.println("Case #" + tn + ": POSSIBLE");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("Case #" + tn + ": IMPOSSIBLE");
        }
    }
}