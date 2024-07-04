import java.io.*;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws FileNotFoundException {
        final boolean DEBUG = false;

        InputStream inputStream = DEBUG ? new FileInputStream("test1.in") : System.in;
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(inputStream)));

        int testCases = scanner.nextInt();
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String inputLine = scanner.next();
            StringBuilder resultBuilder = new StringBuilder();
            char previousChar = '0';

            for (int index = 0; index < inputLine.length(); index++) {
                char currentChar = inputLine.charAt(index);
                int currentDigit = Character.getNumericValue(currentChar);
                int previousDigit = Character.getNumericValue(previousChar);

                if (index == 0) {
                    resultBuilder.append("(".repeat(currentDigit)).append(currentChar);
                } else if (currentDigit == previousDigit) {
                    resultBuilder.append(currentChar);
                } else if (currentDigit < previousDigit) {
                    resultBuilder.append(")".repeat(previousDigit - currentDigit)).append(currentChar);
                } else {
                    resultBuilder.append("(".repeat(currentDigit - previousDigit)).append(currentChar);
                }
                previousChar = currentChar;
            }
            resultBuilder.append(")".repeat(Character.getNumericValue(previousChar)));

            System.out.println("Case #" + caseNumber + ": " + resultBuilder.toString());
        }

        scanner.close();
    }
}