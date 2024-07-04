import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    private static final String LEFT_PARENTHESIS = "(";
    private static final String RIGHT_PARENTHESIS = ")";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int testCase = 0; testCase < testCases; testCase++) {
            String inputString = scanner.next();
            StringBuilder resultBuilder = new StringBuilder();
            char[] characters = inputString.toCharArray();
            int index = 0;

            while (index < characters.length) {
                if (characters[index] == '1') {
                    resultBuilder.append(LEFT_PARENTHESIS).append(characters[index]);
                    int nextIndex = index + 1;
                    while (nextIndex < characters.length && characters[nextIndex] == '1') {
                        resultBuilder.append(characters[nextIndex]);
                        nextIndex++;
                    }
                    resultBuilder.append(RIGHT_PARENTHESIS);
                    index = nextIndex;
                } else {
                    resultBuilder.append(characters[index]);
                    index++;
                }
            }

            System.out.println("Case #" + (testCase + 1) + ": " + resultBuilder.toString());
        }
    }
}