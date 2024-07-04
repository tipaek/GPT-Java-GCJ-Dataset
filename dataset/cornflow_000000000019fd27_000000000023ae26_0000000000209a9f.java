import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Scanner s = new Scanner(System.in);
        // nextInt() here loses the next line during the nextLine() read
        int testCount = Integer.parseInt(s.nextLine());
        for (int t = 0; t < testCount; t++) {
            String input = s.nextLine();
            String result = solution.solveTestCase(input);
            System.out.printf("Case #%d: %s\n", t + 1, result);
        }
    }
    
    private String solveTestCase(String input) {
        int nestingLevel = 0;
        StringBuilder result = new StringBuilder();
        for (char c : input.toCharArray()) {
            int value = c - '0';
            int nestingLevelChange = value - nestingLevel;
            addParentheses(nestingLevelChange, result);
            result.append(c);
            nestingLevel = value;
        }
        addParentheses(-nestingLevel, result);
        return result.toString();
    }
    
    /**
     * E.g.
     * 
     *  2 -> "(("
     * -3 -> ")))"
     *  0 -> ""
     */
    private void addParentheses(int count, StringBuilder holder) {
        char parenthesesType = count > 0 ? '(' : ')';
        count = Math.abs(count);
        for (int i = 0; i < count; i++) {
            holder.append(parenthesesType);
        }
    }
}