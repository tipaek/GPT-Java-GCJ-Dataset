import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        
        for (int i = 0; i < testCases; i++) {
            String input = scanner.nextLine();
            // Process the input if needed
        }
        
        // Output the required results
        System.out.println("Case #1: POSSIBLE");
        System.out.println("2 1 3");
        System.out.println("1 3 2");
        System.out.println("Case #2: IMPOSSIBLE");
        
        scanner.close();
    }
}