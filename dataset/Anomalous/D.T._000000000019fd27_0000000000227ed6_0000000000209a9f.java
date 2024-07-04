import java.util.Scanner;

public class Solution {

    public static void solve(int caseNumber, String inputString) {
        int length = inputString.length();
        int[] digits = new int[length];
        int totalBrackets = 0;

        // Parse the input string and calculate the total number of brackets needed
        for (int i = 0; i < length; i++) {
            digits[i] = Character.getNumericValue(inputString.charAt(i));
            totalBrackets += digits[i];
        }

        // Create a character array to hold the formatted string with brackets
        char[] formattedString = new char[totalBrackets * 2 + length];
        int index = 0;

        // Build the formatted string with brackets
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < digits[i]; j++) {
                formattedString[index++] = '(';
            }
            formattedString[index++] = inputString.charAt(i);
            for (int j = 0; j < digits[i]; j++) {
                formattedString[index++] = ')';
            }
        }

        // Reduce unnecessary brackets
        boolean shouldReduce = true;
        while (shouldReduce) {
            shouldReduce = false;
            for (int i = 0; i < formattedString.length - 1; i++) {
                if (formattedString[i] == ')' && formattedString[i + 1] == '(') {
                    formattedString[i] = '-';
                    formattedString[i + 1] = '-';
                    shouldReduce = true;
                }
            }
        }

        // Convert the character array to a string and remove the '-' characters
        String result = new String(formattedString).replace("-", "");

        // Print the result
        System.out.println("Case #" + caseNumber + ": " + result);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String inputString = scanner.next();
            solve(caseNumber, inputString);
        }
    }
}