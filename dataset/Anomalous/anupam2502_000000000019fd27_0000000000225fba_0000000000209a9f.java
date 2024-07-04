import java.util.Scanner;

public class NestingDepth {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfTestCases = scanner.nextInt();

        for (int testCase = 1; testCase <= numberOfTestCases; testCase++) {
            String input = scanner.next();
            StringBuilder result = new StringBuilder();

            char[] characters = input.toCharArray();

            for (char character : characters) {
                int value = Character.getNumericValue(character);

                result.append("(".repeat(value));
                result.append(value);
                result.append(")".repeat(value));
            }

            System.out.println("Case #" + testCase + ": " + result);
        }

        // scanner.close(); // Uncomment if you want to close the scanner
    }
}