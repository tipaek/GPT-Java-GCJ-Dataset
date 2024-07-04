import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int currentDepth = 0;
            StringBuilder result = new StringBuilder();
            char[] inputLine = scanner.nextLine().toCharArray();

            for (char ch : inputLine) {
                int digit = ch - '0';

                while (digit > currentDepth) {
                    result.append("(");
                    currentDepth++;
                }
                while (digit < currentDepth) {
                    result.append(")");
                    currentDepth--;
                }
                result.append(digit);
            }

            while (currentDepth > 0) {
                result.append(")");
                currentDepth--;
            }

            System.out.printf("Case #%d: %s%n", caseNumber, result);
        }
    }
}