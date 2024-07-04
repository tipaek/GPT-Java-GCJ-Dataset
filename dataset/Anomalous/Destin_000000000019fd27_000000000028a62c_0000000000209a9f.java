import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int t = 1; t <= testCases; t++) {
            StringBuilder result = new StringBuilder();
            String inputLine = scanner.nextLine();
            char[] characters = inputLine.toCharArray();
            int length = characters.length;
            int previousDigit = 0;
            int currentDigit;

            for (int i = 0; i < length; i++) {
                currentDigit = characters[i] - '0';
                if (i > 0) {
                    previousDigit = characters[i - 1] - '0';
                }

                if (previousDigit < currentDigit) {
                    for (int j = 0; j < currentDigit - previousDigit; j++) {
                        result.append("(");
                    }
                } else if (previousDigit > currentDigit) {
                    for (int j = 0; j < previousDigit - currentDigit; j++) {
                        result.append(")");
                    }
                }

                result.append(characters[i]);
            }

            for (int j = 0; j < currentDigit; j++) {
                result.append(")");
            }

            System.out.println("Case #" + t + ": " + result);
        }
    }
}