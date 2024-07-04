import java.util.Scanner;

public class Main {
    
    public static boolean contains(int[] array, int element) {
        for (int value : array) {
            if (value == element) {
                return true;
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            int N = scanner.nextInt();
            int[][] matrix = new int[N][N];
            int trace = 0;
            
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }
            
            System.out.println("Case #" + t + ": " + trace);
        }
        
        scanner.close();
    }
}