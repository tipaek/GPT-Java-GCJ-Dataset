import java.util.Scanner;

public class NestedParentheses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        for (int t = 1; t <= testCases; t++) {
            String input = sc.next();
            StringBuilder result = new StringBuilder();
            char[] chars = input.toCharArray();
            int currentDepth = 0;

            for (char ch : chars) {
                int targetDepth = ch - '0';
                
                while (currentDepth < targetDepth) {
                    result.append('(');
                    currentDepth++;
                }
                while (currentDepth > targetDepth) {
                    result.append(')');
                    currentDepth--;
                }
                result.append(ch);
            }

            while (currentDepth > 0) {
                result.append(')');
                currentDepth--;
            }

            System.out.println("Case #" + t + ": " + result.toString());
        }
    }
}