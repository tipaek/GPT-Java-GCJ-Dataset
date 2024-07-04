import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numCases = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= numCases; i++) {
            String inputCase = scanner.nextLine();
            System.out.println("Case #" + i + ": " + processCase(inputCase));
        }
    }

    private static String processCase(String input) {
        StringBuilder result = new StringBuilder();
        int currentDepth = 0;

        for (char ch : input.toCharArray()) {
            int targetDepth = Character.getNumericValue(ch);
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

        return result.toString();
    }
}