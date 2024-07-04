import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for (int i = 1; i <= t; i++) {
            int N = sc.nextInt();
            int K = sc.nextInt();
            int[][] matrix = new int[N][N];
            
            // Fill the matrix with the required pattern
            for (int row = 0; row < N; row++) {
                for (int col = 0; col < N; col++) {
                    matrix[row][col] = (row + col) % N + 1;
                }
            }
            
            // Calculate the trace of the matrix
            int trace = 0;
            for (int j = 0; j < N; j++) {
                trace += matrix[j][j];
            }
            
            String answer = "IMPOSSIBLE";
            
            // Check if we can achieve the desired trace by swapping
            for (int j = 0; j < N - 1; j++) {
                for (int k = j + 1; k < N; k++) {
                    int newTrace = trace - matrix[j][j] - matrix[k][k] + matrix[j][k] + matrix[k][j];
                    if (newTrace == K) {
                        answer = "POSSIBLE";
                        break;
                    }
                }
                if (answer.equals("POSSIBLE")) {
                    break;
                }
            }
            
            // Check if the initial trace is already equal to K
            if (trace == K) {
                answer = "POSSIBLE";
            }
            
            System.out.println("Case #" + i + ": " + answer);
        }
        
        sc.close();
    }
}