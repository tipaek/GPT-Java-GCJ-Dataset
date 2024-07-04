import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            String input = scanner.nextLine();
            StringBuilder modifiedInput = new StringBuilder("0").append(input).append("0");
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < modifiedInput.length(); i++) {
                char currentChar = modifiedInput.charAt(i);
                char nextChar = i < modifiedInput.length() - 1 ? modifiedInput.charAt(i + 1) : currentChar;

                int difference = currentChar - nextChar;
                result.append(currentChar);

                if (difference < 0) {
                    for (int j = 0; j < Math.abs(difference); j++) {
                        result.append("(");
                    }
                } else if (difference > 0) {
                    for (int j = 0; j < Math.abs(difference); j++) {
                        result.append(")");
                    }
                }
            }

            System.out.println("Case #" + testCase + ": " + result.substring(1, result.length() - 1));
        }
    }
}