import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numCases = Integer.parseInt(scanner.nextLine());
        StringBuilder result = new StringBuilder();

        for (int caseNum = 1; caseNum <= numCases; caseNum++) {
            result.append("Case #").append(caseNum).append(": ");
            String line = scanner.nextLine();
            int nestingLevel = 0;

            for (int i = 0; i < line.length(); i++) {
                int currentDigit = Character.getNumericValue(line.charAt(i));

                if (nestingLevel < currentDigit) {
                    for (int j = 0; j < currentDigit - nestingLevel; j++) {
                        result.append("(");
                    }
                } else if (nestingLevel > currentDigit) {
                    for (int j = 0; j < nestingLevel - currentDigit; j++) {
                        result.append(")");
                    }
                }

                result.append(currentDigit);
                nestingLevel = currentDigit;
            }

            for (int j = 0; j < nestingLevel; j++) {
                result.append(")");
            }

            result.append("\n");
        }

        System.out.print(result.toString());
    }
}