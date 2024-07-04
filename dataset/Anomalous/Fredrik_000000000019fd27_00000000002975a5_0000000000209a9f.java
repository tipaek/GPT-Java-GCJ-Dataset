import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int i = 1; i <= testCases; i++) {
            String inputLine = scanner.nextLine();
            int openBrackets = 0;
            int previousDigit = -1;
            StringBuilder result = new StringBuilder();

            for (char ch : inputLine.toCharArray()) {
                int currentDigit = Character.getNumericValue(ch);

                if (currentDigit == previousDigit) {
                    result.append(currentDigit);
                } else if (currentDigit > previousDigit) {
                    while (openBrackets < currentDigit) {
                        result.append("(");
                        openBrackets++;
                    }
                    result.append(currentDigit);
                } else {
                    while (openBrackets > currentDigit) {
                        result.append(")");
                        openBrackets--;
                    }
                    result.append(currentDigit);
                }
                previousDigit = currentDigit;
            }

            while (openBrackets > 0) {
                result.append(")");
                openBrackets--;
            }

            printSolution(i, result.toString());
        }
    }

    private static void printSolution(int caseNumber, String result) {
        System.out.println("Case #" + caseNumber + ": " + result);
    }
}