import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        scan.nextLine(); // Consume the newline character

        for (int i = 1; i <= t; i++) { // Start from 1 to match the "Case #i" format
            String line = scan.nextLine();
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

            System.out.println("Case #" + i + ": " + result);
        }
    }
}