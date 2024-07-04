import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();

        while (testCases > 0) {
            String input = scanner.nextLine();
            StringBuilder output = new StringBuilder();

            for (int i = 0; i < input.length(); i++) {
                int currentDigit = Character.getNumericValue(input.charAt(i));

                if (i == 0) {
                    output.append("(".repeat(currentDigit));
                }

                output.append(input.charAt(i));

                if (i + 1 < input.length()) {
                    int nextDigit = Character.getNumericValue(input.charAt(i + 1));
                    if (currentDigit < nextDigit) {
                        output.append("(".repeat(nextDigit - currentDigit));
                    } else if (currentDigit > nextDigit) {
                        output.append(")".repeat(currentDigit - nextDigit));
                    }
                } else {
                    output.append(")".repeat(currentDigit));
                }
            }

            System.out.println(output.toString());
            testCases--;
        }

        scanner.close();
    }
}