import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine();
        String[] results = new String[t];

        for (int i = 0; i < t; i++) {
            String input = scanner.nextLine();
            StringBuilder output = new StringBuilder();
            int previousDigit = 0;

            for (char ch : input.toCharArray()) {
                int currentDigit = Character.getNumericValue(ch);
                while (previousDigit < currentDigit) {
                    output.append('(');
                    previousDigit++;
                }
                while (previousDigit > currentDigit) {
                    output.append(')');
                    previousDigit--;
                }
                output.append(ch);
            }

            while (previousDigit > 0) {
                output.append(')');
                previousDigit--;
            }

            results[i] = "Case #" + (i + 1) + ": " + output.toString();
        }

        for (String result : results) {
            System.out.println(result);
        }
    }
}