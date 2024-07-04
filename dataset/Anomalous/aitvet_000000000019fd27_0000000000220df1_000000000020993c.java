public class NestingDepth {
    public static void main(String[] args) {
        String S = "(())"; // Example input, you can replace it with any valid input string
        int result = findNestingDepth(S);
        System.out.println("Maximum nesting depth: " + result);
    }

    public static int findNestingDepth(String S) {
        int currentMax = 0;
        int max = 0;
        int n = S.length();

        for (int i = 0; i < n; i++) {
            if (S.charAt(i) == '(') {
                currentMax++;
                if (currentMax > max)
                    max = currentMax;
            } else if (S.charAt(i) == ')') {
                if (currentMax > 0)
                    currentMax--;
                else {
                    return -1; // Unbalanced parentheses
                }
            }
        }

        if (currentMax != 0) {
            return -1; // Unbalanced parentheses
        }

        return max;
    }
}