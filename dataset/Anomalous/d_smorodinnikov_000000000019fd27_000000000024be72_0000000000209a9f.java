import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        new Solution().solve();
    }

    private void solve() {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int i = 0; i < testCases; i++) {
            String input = scanner.next();
            processCase(i, input);
        }
    }

    private void processCase(int caseNumber, String input) {
        StringBuilder result = new StringBuilder();
        int openBrackets = 0;

        for (char ch : input.toCharArray()) {
            int digit = Character.getNumericValue(ch);
            while (openBrackets > digit) {
                result.append(')');
                openBrackets--;
            }
            while (openBrackets < digit) {
                result.append('(');
                openBrackets++;
            }
            result.append(digit);
        }

        while (openBrackets > 0) {
            result.append(')');
            openBrackets--;
        }

        System.out.println("Case #" + (caseNumber + 1) + ": " + result);
    }
}