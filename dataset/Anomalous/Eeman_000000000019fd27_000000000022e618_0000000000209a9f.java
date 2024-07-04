import java.util.Scanner;

public class GFG {

    // Function to find the maximum depth of nested parentheses in a given expression
    static int maxDepth(String expression) {
        int currentDepth = 0; // Tracks the current depth of nested parentheses
        int maxDepth = 0; // Tracks the maximum depth encountered
        int length = expression.length();

        // Traverse the input string
        for (int i = 0; i < length; i++) {
            char ch = expression.charAt(i);

            if (ch == '(') {
                currentDepth++;

                // Update maxDepth if the currentDepth is greater
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

        // Check for any remaining unbalanced parentheses
        if (currentDepth != 0) {
            return -1;
        }

        return maxDepth;
    }

    // Driver program
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a string:");
        String inputString = scanner.nextLine();

        int result = maxDepth(inputString);
        if (result == -1) {
            System.out.println("The input string has unbalanced parentheses.");
        } else {
            System.out.println("The maximum depth of nested parentheses is: " + result);
        }

        scanner.close();
    }
}