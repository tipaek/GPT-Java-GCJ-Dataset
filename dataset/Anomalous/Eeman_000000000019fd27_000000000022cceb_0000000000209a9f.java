// Java program to find the maximum depth of nested 
// parentheses in a given expression

public class GFG {

    // Function to find the maximum depth of nested parentheses in a string
    static int maxDepth(String expression) {
        int currentDepth = 0; // Current depth of nested parentheses
        int maxDepth = 0; // Maximum depth of nested parentheses
        int length = expression.length();

        // Traverse the input string
        for (int i = 0; i < length; i++) {
            char ch = expression.charAt(i);
            if (ch == '(') {
                currentDepth++;
                // Update maxDepth if currentDepth is greater
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

        // Check for unbalanced parentheses
        if (currentDepth != 0) {
            return -1; // Unbalanced parentheses
        }

        return maxDepth;
    }

    // Driver program
    public static void main(String[] args) {
        String expression = "( ((X)) (((Y))) )";
        int result = maxDepth(expression);
        System.out.println("Maximum depth of nested parentheses: " + result);
    }
}