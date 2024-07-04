public class NestingDepth {
    public static int calculateNestingDepth(String S) {
        int current_max = 0;
        int max = 0;
        int n = S.length();

        for (int i = 0; i < n; i++) {
            if (S.charAt(i) == '(') {
                current_max++;
                if (current_max > max) {
                    max = current_max;
                }
            } else if (S.charAt(i) == ')') {
                if (current_max > 0) {
                    current_max--;
                } else {
                    return -1;
                }
            }
        }

        if (current_max != 0) {
            return -1;
        }

        return max;
    }

    public static void main(String[] args) {
        String S = "((()))"; // Example input
        int result = calculateNestingDepth(S);
        System.out.println("The maximum nesting depth is: " + result);
    }
}