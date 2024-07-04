import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = readInt(scanner);
        for (int i = 0; i < rows; i++) {
            String input = scanner.nextLine();
            System.out.println("Case #" + (i + 1) + ": " + formatDepth(input));
        }
    }

    private static int readInt(Scanner scanner) {
        int number = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        return number;
    }

    private static String formatDepth(String input) {
        StringBuilder output = new StringBuilder();
        int currentDepth = 0;

        for (int i = 0; i < input.length(); i++) {
            int targetDepth = Character.getNumericValue(input.charAt(i));
            while (currentDepth < targetDepth) {
                output.append('(');
                currentDepth++;
            }
            while (currentDepth > targetDepth) {
                output.append(')');
                currentDepth--;
            }
            output.append(input.charAt(i));
        }

        while (currentDepth > 0) {
            output.append(')');
            currentDepth--;
        }

        return output.toString();
    }
}