import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCasesNumber = in.nextInt();
        in.nextLine();
        for (int testCase = 1; testCase <= testCasesNumber; testCase++) {
            String sourceDigits = in.nextLine();
            System.out.println(String.format("Case #%s: %s", testCase, nestingDepth(0, sourceDigits)));
        }
    }

    public static String nestingDepth(int depth, String originalStr) {
        if (originalStr.length() == 1 && Character.getNumericValue(originalStr.charAt(0)) <= depth) {
            return originalStr;
        }

        StringBuilder result = new StringBuilder();

        int leftBoundary = 0;
        int it = 0;
        while (it != originalStr.length()) {
            while (it < originalStr.length() && Character.getNumericValue(originalStr.charAt(it)) != depth) {
                it++;
            }
            String substr = originalStr.substring(leftBoundary, it);
            if (substr.length() != 0) {
                result.append("(").append(nestingDepth(depth + 1, substr)).append(")");
            }
            if (it < originalStr.length()) {
                result.append(originalStr.charAt(it));
                it++;
                leftBoundary = it;
            }
        }
        return result.toString();
    }
}
