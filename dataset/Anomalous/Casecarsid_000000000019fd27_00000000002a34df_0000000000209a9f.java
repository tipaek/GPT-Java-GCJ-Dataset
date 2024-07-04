import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = Integer.parseInt(sc.nextLine());

        for (int i = 1; i <= testCases; i++) {
            String input = sc.nextLine();
            System.out.println("Case #" + i + ": " + generateNestedDepth(input));
        }
    }

    public static String generateNestedDepth(String s) {
        StringBuilder result = new StringBuilder();
        int previousDepth = 0;

        for (char c : s.toCharArray()) {
            int currentDepth = Character.getNumericValue(c);

            while (previousDepth < currentDepth) {
                result.append('(');
                previousDepth++;
            }
            while (previousDepth > currentDepth) {
                result.append(')');
                previousDepth--;
            }

            result.append(c);
        }

        while (previousDepth > 0) {
            result.append(')');
            previousDepth--;
        }

        return result.toString();
    }
}