import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());
        StringBuilder finalResult = new StringBuilder();

        for (int i = 0; i < testCases; i++) {
            String input = scanner.nextLine();
            String paddedInput = "0" + input + "0";
            StringBuilder result = new StringBuilder();

            for (int j = 1; j < paddedInput.length() - 1; j++) {
                int currentDigit = paddedInput.charAt(j) - '0';
                int previousDigit = paddedInput.charAt(j - 1) - '0';
                int nextDigit = paddedInput.charAt(j + 1) - '0';

                if (currentDigit > previousDigit) {
                    result.append("(".repeat(currentDigit - previousDigit));
                }

                result.append(currentDigit);

                if (currentDigit > nextDigit) {
                    result.append(")".repeat(currentDigit - nextDigit));
                }
            }

            finalResult.append("Case #").append(i + 1).append(": ").append(result).append("\n");
        }

        System.out.print(finalResult);
    }
}