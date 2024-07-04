import java.util.Scanner;

public class Solution {

    public static void solve(int testCaseNum, String s) {
        StringBuilder answer = new StringBuilder();
        int lastInt = -1;

        for (int i = 0; i <= s.length(); i++) {
            if (i == s.length()) { // only close parentheses
                answer.append(")".repeat(Math.max(0, lastInt)));
                break;
            }

            int currentInt = Character.getNumericValue(s.charAt(i));
            if (lastInt != -1 && lastInt == currentInt) {
                answer.append(currentInt);
            } else {
                if (lastInt != -1) { // have to close
                    answer.append(")".repeat(Math.max(0, lastInt)));
                }
                answer.append("(".repeat(Math.max(0, currentInt)));
                answer.append(currentInt);
                lastInt = currentInt;
            }
        }
        System.out.println("Case #" + testCaseNum + ": " + answer);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numTestCases = scanner.nextInt();
        scanner.nextLine();
        for (int i = 1; i <= numTestCases; i++) {
            String input = scanner.nextLine();
            solve(i, input);
        }
    }
}