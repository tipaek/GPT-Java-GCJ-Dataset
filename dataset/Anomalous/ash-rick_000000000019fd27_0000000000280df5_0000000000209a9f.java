import java.util.Scanner;

public class NestingDepth {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int i = 1; i <= testCases; i++) {
            String input = scanner.nextLine();
            processInput(input, i);
        }
        scanner.close();
    }

    private static void processInput(String input, int testCaseNumber) {
        StringBuilder result = new StringBuilder("Case #").append(testCaseNumber).append(": ");
        int currentDepth = 0;

        for (char digit : input.toCharArray()) {
            int targetDepth = Character.getNumericValue(digit);

            while (currentDepth < targetDepth) {
                result.append('(');
                currentDepth++;
            }

            while (currentDepth > targetDepth) {
                result.append(')');
                currentDepth--;
            }

            result.append(digit);
        }

        while (currentDepth > 0) {
            result.append(')');
            currentDepth--;
        }

        System.out.println(result.toString());
    }
}