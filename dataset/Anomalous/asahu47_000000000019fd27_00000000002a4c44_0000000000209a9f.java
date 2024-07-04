import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character after the integer input

        for (int i = 1; i <= t; i++) {
            String line = scanner.nextLine();
            StringBuilder result = new StringBuilder();
            int parCount = 0;

            for (int j = 0; j < line.length(); j++) {
                int digit = Character.getNumericValue(line.charAt(j));

                while (parCount < digit) {
                    result.append('(');
                    parCount++;
                }
                while (parCount > digit) {
                    result.append(')');
                    parCount--;
                }

                result.append(digit);
            }

            while (parCount > 0) {
                result.append(')');
                parCount--;
            }

            System.out.println("Case #" + i + ": " + result.toString());
        }
    }
}