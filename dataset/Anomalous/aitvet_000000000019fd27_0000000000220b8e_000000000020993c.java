public class NestingDepth {
    public static int calculateNestingDepth(String S) {
        int currentMax = 0;
        int max = 0;
        int n = S.length();
        
        for (int i = 0; i < n; i++) {
            if (S.charAt(i) == '(') {
                currentMax++;
                if (currentMax > max) {
                    max = currentMax;
                }
            } else if (S.charAt(i) == ')') {
                if (currentMax > 0) {
                    currentMax--;
                } else {
                    return -1;
                }
            }
        }
        
        if (currentMax != 0) {
            return -1;
        }
        
        return max;
    }

    public static void main(String[] args) {
        String S = "(())((()))"; // Example input
        int result = calculateNestingDepth(S);
        System.out.println("Maximum Nesting Depth: " + result);
    }
}