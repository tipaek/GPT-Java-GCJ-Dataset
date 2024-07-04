// Java program to find the maximum depth of nested parentheses in a given expression

class GFG {

    // Function to find the maximum depth of nested parentheses in a string
    static int maxDepth(String S) {
        int currentDepth = 0; // Current depth of nested parentheses
        int maxDepth = 0; // Maximum depth encountered

        // Traverse the input string
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);

            if (ch == '(') {
                currentDepth++; // Increase current depth
                if (currentDepth > maxDepth) {
                    maxDepth = currentDepth; // Update maximum depth if current depth is greater
                }
            } else if (ch == ')') {
                if (currentDepth > 0) {
                    currentDepth--; // Decrease current depth
                } else {
                    return -1; // Unbalanced parentheses
                }
            }
        }

        // Check for remaining unbalanced parentheses
        if (currentDepth != 0) {
            return -1; // Unbalanced parentheses
        }

        return maxDepth; // Return the maximum depth
    }

    // Driver program
    public static void main(String[] args) {
        if (args.length > 0) {
            String S = args[0];
            System.out.println("You entered String: " + S);
            int result = maxDepth(S);
            if (result != -1) {
                System.out.println("Maximum depth of nested parentheses: " + result);
            } else {
                System.out.println("The input string has unbalanced parentheses.");
            }
        } else {
            System.out.println("Please provide an input string as a command line argument.");
        }
    }
}