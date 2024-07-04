// Java program to find the maximum depth of nested
// parentheses in a given expression

import java.util.Scanner;

class GFG {

    // Function to find the maximum depth of nested parentheses
    static int maxDepth(String S) {
        int currentDepth = 0; // Current depth count
        int maxDepth = 0; // Maximum depth count
        int n = S.length();

        // Traverse the input string
        for (int i = 0; i < n; i++) {
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
        String S = scanner.nextLine();
        System.out.println("Maximum depth of nested parentheses: " + maxDepth(S));
        scanner.close();
    }
}