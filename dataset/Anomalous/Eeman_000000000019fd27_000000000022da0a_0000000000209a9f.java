// Java program to find the maximum depth of nested
// parentheses in a given expression

import java.util.Scanner;

class ParenthesisDepth {

    // Function to take a string and return the maximum depth of nested parentheses
    static int maxDepth(String S) {
        int currentDepth = 0; // current depth count
        int maxDepth = 0; // maximum depth count
        int length = S.length();

        // Traverse the input string
        for (int i = 0; i < length; i++) {
            char ch = S.charAt(i);
            if (ch == '(') {
                currentDepth++;
                // Update maxDepth if required
                if (currentDepth > maxDepth) {
                    maxDepth = currentDepth;
                }
            } else if (ch == ')') {
                if (currentDepth > 0) {
                    currentDepth--;
                } else {
                    return -1; // Unbalanced parentheses
                }
            }
        }

        // Check for unbalanced string
        if (currentDepth != 0) {
            return -1;
        }

        return maxDepth;
    }

    // Driver program
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string:");
        String input = scanner.nextLine();
        scanner.close();
        
        int result = maxDepth(input);
        if (result == -1) {
            System.out.println("The string has unbalanced parentheses.");
        } else {
            System.out.println("The maximum depth of nested parentheses is: " + result);
        }
    }
}