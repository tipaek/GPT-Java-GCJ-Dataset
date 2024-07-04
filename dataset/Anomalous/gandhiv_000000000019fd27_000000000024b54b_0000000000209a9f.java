import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            String input = sc.next();
            StringBuilder result = new StringBuilder();
            char previousChar = '0';

            for (char currentChar : input.toCharArray()) {
                int currentDigit = Character.getNumericValue(currentChar);
                int previousDigit = Character.getNumericValue(previousChar);

                if (currentDigit > previousDigit) {
                    for (int j = 0; j < currentDigit - previousDigit; j++) {
                        result.append('(');
                    }
                } else if (currentDigit < previousDigit) {
                    for (int j = 0; j < previousDigit - currentDigit; j++) {
                        result.append(')');
                    }
                }

                result.append(currentChar);
                previousChar = currentChar;
            }

            int finalDigit = Character.getNumericValue(previousChar);
            for (int j = 0; j < finalDigit; j++) {
                result.append(')');
            }

            System.out.println("Case #" + testCase + ": " + result.toString());
        }

        sc.close();
    }
}