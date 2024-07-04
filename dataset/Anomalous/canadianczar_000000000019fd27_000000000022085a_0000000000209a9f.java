import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfTests = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        for (int currentTest = 0; currentTest < numberOfTests; currentTest++) {
            String inputLine = scanner.nextLine();
            processTestCase(currentTest, inputLine);
        }

        scanner.close();
    }

    public static void processTestCase(int testCaseNumber, String inputLine) {
        StringBuilder resultBuilder = new StringBuilder();

        for (char currentChar : inputLine.toCharArray()) {
            if (resultBuilder.length() == 0) {
                if (currentChar == '0') {
                    resultBuilder.append(currentChar);
                } else {
                    resultBuilder.append('(').append(currentChar);
                }
            } else {
                char lastChar = resultBuilder.charAt(resultBuilder.length() - 1);

                if (lastChar == '0') {
                    if (currentChar == '0') {
                        resultBuilder.append(currentChar);
                    } else {
                        resultBuilder.append('(').append(currentChar);
                    }
                } else {
                    if (currentChar == '0') {
                        resultBuilder.append(')').append(currentChar);
                    } else {
                        resultBuilder.append(currentChar);
                    }
                }
            }
        }

        if (resultBuilder.length() > 0 && resultBuilder.charAt(resultBuilder.length() - 1) == '1') {
            resultBuilder.append(')');
        }

        System.out.printf("Case #%d: %s%n", testCaseNumber, resultBuilder.toString());
    }
}