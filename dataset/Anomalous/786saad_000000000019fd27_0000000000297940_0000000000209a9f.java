import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfCases = Integer.parseInt(scanner.nextLine());
        String[] output = new String[numberOfCases];

        for (int i = 0; i < numberOfCases; i++) {
            String input = scanner.nextLine();
            output[i] = "Case #" + (i + 1) + ": " + addParenthesis(input);
        }

        for (String result : output) {
            System.out.println(result);
        }
    }

    public static String addParenthesis(String input) {
        int currentlyOpenParas = 0;
        StringBuilder outputString = new StringBuilder();

        for (int stringIndex = 0; stringIndex < input.length(); stringIndex++) {
            int currentNumber = Character.getNumericValue(input.charAt(stringIndex));
            int openParaNeeded = Math.max(0, currentNumber - currentlyOpenParas);
            int closedParaNeeded = Math.max(0, currentlyOpenParas - currentNumber);

            outputString.append("(".repeat(openParaNeeded));
            currentlyOpenParas += openParaNeeded;

            outputString.append(")".repeat(closedParaNeeded));
            currentlyOpenParas -= closedParaNeeded;

            outputString.append(currentNumber);
        }

        outputString.append(")".repeat(currentlyOpenParas));

        return outputString.toString();
    }
}