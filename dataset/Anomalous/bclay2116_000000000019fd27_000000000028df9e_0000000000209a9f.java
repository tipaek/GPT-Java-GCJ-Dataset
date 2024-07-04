import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(scanner.nextLine());
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < testCases; i++) {
            StringBuilder caseResult = new StringBuilder();
            String inputLine = scanner.nextLine();
            int currentOpenParens = 0;
            char[] digits = inputLine.toCharArray();

            for (char digit : digits) {
                int number = digit - '0';
                while (number > currentOpenParens) {
                    caseResult.append('(');
                    currentOpenParens++;
                }
                while (number < currentOpenParens) {
                    caseResult.append(')');
                    currentOpenParens--;
                }
                caseResult.append(digit);
            }

            while (currentOpenParens > 0) {
                caseResult.append(')');
                currentOpenParens--;
            }

            result.append("Case #").append(i + 1).append(": ").append(caseResult).append('\n');
        }

        System.out.print(result);
    }
}