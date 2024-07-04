import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            boolean isPossible = false;
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int[][] matrix = new int[n][n];
            
            for (int start = 1; start <= n; start++) {
                for (int row = 0; row < n; row++) {
                    int value = start + row;
                    for (int col = 0; col < n; col++) {
                        if (value > n) value = 1;
                        matrix[row][col] = value;
                        value++;
                    }
                }
                
                int trace = 0;
                for (int i = 0; i < n; i++) {
                    trace += matrix[i][i];
                }
                
                if (trace == k) {
                    isPossible = true;
                    break;
                }
            }
            
            if (isPossible) {
                System.out.println("Case #" + caseNumber + ": POSSIBLE");
                for (int[] row : matrix) {
                    for (int element : row) {
                        System.out.print(element + " ");
                    }
                    System.out.println();
                }
            } else {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            }
        }
        
        scanner.close();
    }
}