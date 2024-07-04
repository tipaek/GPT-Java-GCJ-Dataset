import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        new Solution().execute();
    }

    private Scanner scanner;

    public void execute() {
        scanner = new Scanner(System.in);
        int numberOfTests = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < numberOfTests; i++) {
            String result = processTestCase();
            System.out.println("Test #" + (i + 1) + ": " + result);
        }
    }

    private String processTestCase() {
        String input = scanner.nextLine();
        char[] characters = input.toCharArray();
        int currentDepth = 0;
        StringBuilder output = new StringBuilder();

        for (char character : characters) {
            int targetDepth = character - '0';
            while (currentDepth < targetDepth) {
                output.append("(");
                currentDepth++;
            }
            while (currentDepth > targetDepth) {
                output.append(")");
                currentDepth--;
            }
            output.append(character);
        }

        while (currentDepth > 0) {
            output.append(")");
            currentDepth--;
        }

        return output.toString();
    }
}