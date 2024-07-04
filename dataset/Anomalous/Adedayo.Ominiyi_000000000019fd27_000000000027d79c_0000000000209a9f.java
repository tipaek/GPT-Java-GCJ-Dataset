import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws Exception {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int numberOfTestCases = Integer.parseInt(scanner.nextLine());

            for (int testCase = 1; testCase <= numberOfTestCases; testCase++) {
                String line = scanner.nextLine();
                char[] lineChars = line.toCharArray();
                StringBuilder builder = new StringBuilder();

                int firstNumber = Character.getNumericValue(lineChars[0]);
                appendChars(builder, '(', firstNumber);
                builder.append(firstNumber);

                int prevNumber = firstNumber;
                for (int i = 1; i < lineChars.length; i++) {
                    int currentNumber = Character.getNumericValue(lineChars[i]);

                    if (currentNumber > prevNumber) {
                        appendChars(builder, '(', currentNumber - prevNumber);
                    } else if (currentNumber < prevNumber) {
                        appendChars(builder, ')', prevNumber - currentNumber);
                    }

                    builder.append(currentNumber);
                    prevNumber = currentNumber;
                }

                appendChars(builder, ')', prevNumber);
                System.out.printf("Case #%d: %s%n", testCase, builder.toString());
            }
        }
    }

    private static void appendChars(StringBuilder builder, char ch, int count) {
        for (int i = 0; i < count; i++) {
            builder.append(ch);
        }
    }
}