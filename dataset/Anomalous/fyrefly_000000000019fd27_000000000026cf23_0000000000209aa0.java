import java.util.Scanner;

public class Solution { 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            boolean isPossible = false;
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int[][] matrix = new int[n][n];
            
            for (int startNum = 1; startNum <= n; startNum++) {
                for (int i = 0; i < n; i++) {
                    int num = startNum - i;
                    for (int j = 0; j < n; j++) {
                        if (num <= 0) num = n;
                        matrix[i][j] = num;
                        num--;
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
                System.out.println("Case #" + testCase + ": POSSIBLE");
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        System.out.print(matrix[i][j] + " ");
                    }
                    System.out.println();
                }
            } else {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
            }
        }
        
        scanner.close();
    }
}