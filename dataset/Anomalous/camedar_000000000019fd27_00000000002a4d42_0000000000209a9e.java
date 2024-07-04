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
            
            // First phase: read every position from 1 to B
            for (int j = 1; j <= B; j++) {
                System.out.println(j);
                response[j - 1] = scanner.nextLine();
            }
            
            // Dummy read for synchronization
            System.out.println(1);
            scanner.next();
            
            // Second phase: read every 10th position
            for (int j = 1; j < B; j += 10) {
                System.out.println(j);
                response[j - 1] = scanner.nextLine();
            }
            
            // Print the final response
            System.out.println(String.join("", response));
            scanner.nextLine();
        }
    }
}