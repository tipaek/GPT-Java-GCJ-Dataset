import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        scan.nextLine();  // Consume the newline character
        
        for (int i = 1; i <= t; i++) {
            String line = scan.nextLine();
            StringBuilder result = new StringBuilder();
            int parenCount = 0;

            for (int j = 0; j < line.length(); j++) {
                int digit = Character.getNumericValue(line.charAt(j));

                while (parenCount < digit) {
                    result.append('(');
                    parenCount++;
                }
                while (parenCount > digit) {
                    result.append(')');
                    parenCount--;
                }

                result.append(digit);
            }

            while (parenCount > 0) {
                result.append(')');
                parenCount--;
            }

            System.out.println("Case #" + i + ": " + result.toString());
        }

        scan.close();
    }
}