import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        String output = processInput(scanner);
        System.out.println(output);
    }

    public static String processInput(Scanner scanner) {
        StringBuilder resultBuilder = new StringBuilder();
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            String inputString = scanner.next();
            resultBuilder.append("Case #").append(i).append(": ").append(processCase(inputString)).append("\n");
        }
        return resultBuilder.toString();
    }

    public static String processCase(String inputString) {
        StringBuilder caseResult = new StringBuilder();
        int openBrackets = 0;

        for (int i = 0; i < inputString.length(); i++) {
            int currentDigit = Character.getNumericValue(inputString.charAt(i));

            while (openBrackets < currentDigit) {
                caseResult.append("(");
                openBrackets++;
            }

            while (openBrackets > currentDigit) {
                caseResult.append(")");
                openBrackets--;
            }

            caseResult.append(currentDigit);
        }

        while (openBrackets > 0) {
            caseResult.append(")");
            openBrackets--;
        }

        return caseResult.toString();
    }
}