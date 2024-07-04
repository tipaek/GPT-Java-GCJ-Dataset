import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        int B = scanner.nextInt();
        scanner.nextLine();
        
        for (int i = 0; i < testCases; i++) {
            String[] response = new String[B];
            
            // First phase of input reading
            for (int j = 1; j <= B; j++) {
                System.out.println(j);
                response[j - 1] = scanner.nextLine();
            }
            
            // Dummy read to synchronize with the system
            System.out.println(1);
            scanner.next();
            
            // Second phase of input reading
            for (int j = 1; j < B; j += 10) {
                System.out.println(j);
                response[j - 1] = scanner.nextLine();
            }
            
            // Output the result for the current test case
            System.out.printf("Case #%d: %s\n", i + 1, String.join("", response));
        }
        
        scanner.close();
    }
}