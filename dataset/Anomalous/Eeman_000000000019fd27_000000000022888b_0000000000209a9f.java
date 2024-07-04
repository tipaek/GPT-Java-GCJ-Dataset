// Java program to find the maximum depth of nested
// parentheses in a given expression

public class GFG {

    // Function to find the maximum depth of nested parentheses
    public static int maxDepth(String expression) {
        int currentDepth = 0;  // Current depth of nested parentheses
        int maxDepth = 0;      // Maximum depth encountered
        int length = expression.length();

        // Traverse the input string
        for (int i = 0; i < length; i++) {
            char ch = expression.charAt(i);

            if (ch == '(') {
                currentDepth++;  // Increase current depth

                // Update maxDepth if currentDepth is greater
                if (currentDepth > maxDepth) {
                    maxDepth = currentDepth;
                }
            } else if (ch == ')') {
                if (currentDepth > 0) {
                    currentDepth--;  // Decrease current depth
                } else {
                    return -1;  // Unbalanced parentheses
                }
            }
        }

        // Check for unbalanced parentheses at the end
        if (currentDepth != 0) {
            return -1;
        }

        return maxDepth;
    }

    // Driver program
    public static void main(String[] args) {
        String expression = "( ((X)) (((Y))) )";
        System.out.println(maxDepth(expression));
    }
}