import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfTests = scanner.nextInt();

        for (int testIndex = 0; testIndex < numberOfTests; testIndex++) {
            String inputLine = scanner.next();
            StringBuilder result = new StringBuilder();

            int currentValue = Character.getNumericValue(inputLine.charAt(0));
            result.append("(".repeat(currentValue)).append(currentValue);

            for (int charIndex = 1; charIndex < inputLine.length(); charIndex++) {
                int nextValue = Character.getNumericValue(inputLine.charAt(charIndex));
                if (nextValue > currentValue) {
                    result.append("(".repeat(nextValue - currentValue));
                } else if (nextValue < currentValue) {
                    result.append(")".repeat(currentValue - nextValue));
                }
                result.append(nextValue);
                currentValue = nextValue;
            }
            result.append(")".repeat(currentValue));

            System.out.printf("Case #%d: %s%n", testIndex + 1, result.toString());
        }
    }
}