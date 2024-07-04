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
                for (int i = 0; i < n; i++) {
                    int value = start - i;
                    for (int j = 0; j < n; j++) {
                        if (value <= 0) value += n;
                        matrix[i][j] = value;
                        value--;
                    }
                }
                
                int trace = 0;
                for (int i = 0; i < n; i++) {
                    trace += matrix[i][i];
                }
                
                if (trace == k) {
                    possible = true;
                    break;
                }
            }
            
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
}