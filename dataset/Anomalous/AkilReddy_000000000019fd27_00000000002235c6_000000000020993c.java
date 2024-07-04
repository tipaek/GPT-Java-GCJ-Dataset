import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class One {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt();
            int[][] array = new int[n][n];
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    array[i][j] = scanner.nextInt();
                }
            }
            
            // Placeholder for future logic
            System.out.println(1 + " " + 1 + " " + 1);
        }
        
        scanner.close();
    }
}