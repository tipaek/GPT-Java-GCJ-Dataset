import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        solve(scanner);
    }

    public static void solve(Scanner scanner) {
        int numberOfCases = Integer.parseInt(scanner.nextLine().trim());

        for (int caseNumber = 1; caseNumber <= numberOfCases; caseNumber++) {
            String input = scanner.nextLine().trim();
            StringBuilder result = new StringBuilder();

            for (char c : input.toCharArray()) {
                int digit = c - '0';
                for (int i = 0; i < digit; i++) {
                    result.append('(');
                }
                result.append(c);
                for (int i = 0; i < digit; i++) {
                    result.append(')');
                }
            }

            // Remove redundant parentheses
            for (int i = 0; i < result.length() - 1; i++) {
                if (result.charAt(i) == ')' && result.charAt(i + 1) == '(') {
                    result.delete(i, i + 2);
                    i = Math.max(-1, i - 2); // Adjust index to account for deletion
                }
            }

            System.out.println("Case #" + caseNumber + ": " + result.toString());
        }
    }
}