import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numCases = Integer.parseInt(scanner.nextLine());
        StringBuilder result = new StringBuilder();

        for (int currentCase = 1; currentCase <= numCases; currentCase++) {
            result.append("Case #").append(currentCase).append(": ");
            String line = scanner.nextLine();
            int nestingLevel = 0;

            for (int i = 0; i < line.length(); i++) {
                int currentDigit = Character.getNumericValue(line.charAt(i));

                if (currentDigit > nestingLevel) {
                    for (int j = 0; j < currentDigit - nestingLevel; j++) {
                        result.append("(");
                    }
                } else if (currentDigit < nestingLevel) {
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

            if (currentCase < numCases) {
                result.append("\n");
            }
        }

        System.out.print(result.toString());
    }
}