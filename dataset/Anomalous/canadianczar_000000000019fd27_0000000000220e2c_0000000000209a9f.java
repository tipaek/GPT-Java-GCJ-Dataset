import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfTests = Integer.parseInt(scanner.nextLine());

        for (int testNumber = 1; testNumber <= numberOfTests; testNumber++) {
            String inputLine = scanner.nextLine();
            processTestCase(testNumber, inputLine);
        }
        scanner.close();
    }

    private static void processTestCase(int testNumber, String inputLine) {
        StringBuilder result = new StringBuilder();

        for (char currentChar : inputLine.toCharArray()) {
            if (result.length() == 0) {
                if (currentChar == '0') {
                    result.append(currentChar); // Add 0
                } else {
                    result.append('(').append(currentChar); // Add ( and 1
                }
            } else {
                char lastChar = result.charAt(result.length() - 1);
                if (lastChar == '0') {
                    if (currentChar == '0') {
                        result.append(currentChar); // Add 0
                    } else {
                        result.append('(').append(currentChar); // Add ( and 1
                    }
                } else { // Last char is 1
                    if (currentChar == '0') {
                        result.append(')').append(currentChar); // Add ) and 0
                    } else {
                        result.append(currentChar); // Add 1
                    }
                }
            }
        }

        if (result.length() > 0 && result.charAt(result.length() - 1) == '1') {
            result.append(')');
        }

        System.out.printf("Case #%d: %s\n", testNumber, result.toString());
    }
}