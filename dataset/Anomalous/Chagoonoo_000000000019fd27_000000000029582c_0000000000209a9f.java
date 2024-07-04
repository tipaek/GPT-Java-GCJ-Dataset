import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int i = 0; i < testCases; i++) {
            String input = scanner.next();
            StringBuilder output = new StringBuilder();
            int currentLevel = 0;

            for (char ch : input.toCharArray()) {
                int digit = ch - '0';

                while (currentLevel < digit) {
                    output.append('(');
                    currentLevel++;
                }
                while (currentLevel > digit) {
                    output.append(')');
                    currentLevel--;
                }

                output.append(digit);
            }

            while (currentLevel > 0) {
                output.append(')');
                currentLevel--;
            }

            System.out.println("Case #" + (i + 1) + ": " + output);
        }

        scanner.close();
    }
}