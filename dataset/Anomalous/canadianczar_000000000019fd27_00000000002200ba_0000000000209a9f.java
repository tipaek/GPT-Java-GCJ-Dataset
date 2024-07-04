import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Nest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfTests = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        for (int currentTest = 1; currentTest <= numberOfTests; currentTest++) {
            String inputLine = scanner.nextLine();
            processTestCase(currentTest, inputLine);
        }

        scanner.close();
    }

    private static void processTestCase(int testCaseNumber, String inputLine) {
        StringBuilder result = new StringBuilder();

        for (char character : inputLine.toCharArray()) {
            if (result.length() == 0) {
                if (character == '0') {
                    result.append(character);
                } else {
                    result.append('(').append(character);
                }
            } else {
                char lastChar = result.charAt(result.length() - 1);

                if (lastChar == '0') {
                    if (character == '0') {
                        result.append(character);
                    } else {
                        result.append('(').append(character);
                    }
                } else {
                    if (character == '0') {
                        result.append(')').append(character);
                    } else {
                        result.append(character);
                    }
                }
            }
        }

        if (result.length() > 0 && result.charAt(result.length() - 1) == '1') {
            result.append(')');
        }

        System.out.printf("Case #%d: %s\n", testCaseNumber, result.toString());
    }
}