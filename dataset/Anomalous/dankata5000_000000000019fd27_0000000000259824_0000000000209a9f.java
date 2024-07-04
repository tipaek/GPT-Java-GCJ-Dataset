import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        new Solution().run();
    }

    void run() {
        try (Scanner scanner = new Scanner(System.in)) {
            int testCases = scanner.nextInt();
            scanner.nextLine();

            for (int t = 1; t <= testCases; t++) {
                String input = scanner.nextLine();
                String output = processInput(input);
                System.out.println("Case #" + t + ": " + output);
            }
        }
    }

    String processInput(String input) {
        StringBuilder result = new StringBuilder();
        int currentOpenBrackets = 0;

        for (char digitChar : input.toCharArray()) {
            int digit = Character.getNumericValue(digitChar);
            while (currentOpenBrackets < digit) {
                result.append("(");
                currentOpenBrackets++;
            }
            while (currentOpenBrackets > digit) {
                result.append(")");
                currentOpenBrackets--;
            }
            result.append(digitChar);
        }

        while (currentOpenBrackets > 0) {
            result.append(")");
            currentOpenBrackets--;
        }

        return result.toString();
    }
}