import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    private void processInput() {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfCases = scanner.nextInt();
        for (int caseNumber = 1; caseNumber <= numberOfCases; caseNumber++) {
            char[] inputString = ("0" + scanner.next() + "0").toCharArray();
            StringBuilder resultBuilder = new StringBuilder();
            int openParentheses = 0;
            
            for (char currentChar : inputString) {
                int currentValue = currentChar - '0';
                while (openParentheses < currentValue) {
                    resultBuilder.append('(');
                    openParentheses++;
                }
                while (openParentheses > currentValue) {
                    resultBuilder.append(')');
                    openParentheses--;
                }
                resultBuilder.append(currentChar);
            }

            String result = resultBuilder.toString();
            System.out.printf("Case #%d: %s\n", caseNumber, result.substring(1, result.length() - 1));
        }
        scanner.close();
    }

    public static void main(String[] args) {
        new Solution().processInput();
    }
}