package problem2;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            StringBuilder result = new StringBuilder();
            String input = scanner.nextLine();
            int currentOpenBrackets = 0;

            for (char digitChar : input.toCharArray()) {
                int digit = digitChar - '0';

                if (digit > currentOpenBrackets) {
                    result.append("(".repeat(digit - currentOpenBrackets));
                } else if (digit < currentOpenBrackets) {
                    result.append(")".repeat(currentOpenBrackets - digit));
                }

                result.append(digitChar);
                currentOpenBrackets = digit;
            }

            result.append(")".repeat(currentOpenBrackets));
            System.out.println("Case #" + caseNumber + ": " + result.toString());
        }
    }
}