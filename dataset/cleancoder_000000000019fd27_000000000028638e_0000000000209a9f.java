import java.util.Scanner;

public class Solution {

    public static void solve(int testCaseNum, String s) {
        String answer = "";
        String[] chars = s.split("");
        int lastInt = -1;
        for (int i = 0; i <= chars.length; i++) {
            if (i == chars.length) { // only close parentheses
                for (int j = 0; j < lastInt; j++) {
                    answer += ")";
                }
                break;
            }

            int currentInt = Integer.parseInt(chars[i]);
            if (lastInt != -1 && lastInt == currentInt) {
                answer += chars[i];
            } else {
                int currentLevel = 0;
                if (!(lastInt == -1 || lastInt == 0)) { // have to close
                    currentLevel = lastInt;
                    for (int j = currentInt; j < lastInt; j++) {
                        answer += ")";
                        currentLevel++;
                    }
                }
                for (int j = currentLevel; j < currentInt; j++) {
                    answer += "(";
                }
                answer += chars[i];
                lastInt = currentInt;
            }
        }
        System.out.print("Case #" + testCaseNum + ": " + answer);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numTestCases = scanner.nextInt();
        scanner.nextLine();
        for (int i = 1; i <= numTestCases; i++) {
            String input = scanner.nextLine();
            solve(i, input);
            if (i < numTestCases) {
                System.out.print("\n");
            }
        }
    }
}