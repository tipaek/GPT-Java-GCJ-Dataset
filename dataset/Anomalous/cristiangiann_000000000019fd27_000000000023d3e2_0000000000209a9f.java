import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCases = Integer.parseInt(scanner.nextLine());

        for (int caseNumber = 1; caseNumber <= numberOfCases; caseNumber++) {
            String input = scanner.nextLine();
            int currentDepth = 0;
            char[] digits = input.toCharArray();
            StringBuilder output = new StringBuilder("Case #").append(caseNumber).append(": ");

            for (char digit : digits) {
                int digitValue = Character.getNumericValue(digit);
                while (currentDepth < digitValue) {
                    output.append("(");
                    currentDepth++;
                }
                while (currentDepth > digitValue) {
                    output.append(")");
                    currentDepth--;
                }
                output.append(digit);
            }
            while (currentDepth > 0) {
                output.append(")");
                currentDepth--;
            }
            System.out.println(output);
        }
        scanner.close();
    }
}