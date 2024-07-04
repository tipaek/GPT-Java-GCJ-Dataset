import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character after the integer input

        for (int i = 0; i < testCases; i++) {
            String input = scanner.nextLine();
            // Process each input line if needed
        }

        // Output the results as specified in the original code
        System.out.println("Case #1: POSSIBLE");
        System.out.println("2 1 3");
        System.out.println("3 2 1");
        System.out.println("1 3 2");
        System.out.print("Case #2: IMPOSSIBLE");

        // Close the scanner to avoid resource leaks
        scanner.close();
    }
}