import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        int B = scanner.nextInt();
        scanner.nextLine();

        for (int t = 0; t < testCases; t++) {
            String[] response = new String[B];
            
            // Initial read loop
            for (int i = 1; i <= B; i++) {
                System.out.println(i);
                response[i - 1] = scanner.nextLine();
            }
            
            // Dummy read to synchronize
            System.out.println(1);
            scanner.nextLine();
            
            // Subsequent read loop
            for (int i = 1; i < B; i += 10) {
                System.out.println(i);
                response[i - 1] = scanner.nextLine();
            }
            
            // Output the final response
            System.out.println(String.join("", response));
        }
    }
}