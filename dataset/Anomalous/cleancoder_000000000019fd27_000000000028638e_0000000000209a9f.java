import java.util.Scanner;

public class Solution {

    public static void solve(int testCaseNum, String s) {
        StringBuilder answer = new StringBuilder();
        int lastInt = -1;

        for (int i = 0; i <= s.length(); i++) {
            if (i == s.length()) {
                // Close remaining open parentheses
                for (int j = 0; j < lastInt; j++) {
                    answer.append(")");
                }
                break;
            }

            int currentInt = Character.getNumericValue(s.charAt(i));
            if (lastInt != -1 && lastInt == currentInt) {
                answer.append(s.charAt(i));
            } else {
                // Close parentheses if needed
                if (lastInt != -1) {
                    for (int j = lastInt; j > currentInt; j--) {
                        answer.append(")");
                    }
                }
                // Open parentheses if needed
                for (int j = lastInt; j < currentInt; j++) {
                    answer.append("(");
                }
                answer.append(s.charAt(i));
                lastInt = currentInt;
            }
        }
        System.out.print("Case #" + testCaseNum + ": " + answer.toString());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numTestCases = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (int i = 1; i <= numTestCases; i++) {
            String input = scanner.nextLine();
            solve(i, input);
            if (i < numTestCases) {
                System.out.print("\n");
            }
        }
        scanner.close();
    }
}