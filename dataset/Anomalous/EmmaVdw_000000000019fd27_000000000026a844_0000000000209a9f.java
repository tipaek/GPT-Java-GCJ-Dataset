import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();
        scanner.nextLine();

        for (int i = 1; i <= t; ++i) {
            String input = scanner.nextLine();
            StringBuilder result = new StringBuilder();
            int openCount = 0;

            for (int j = 0; j < input.length(); ++j) {
                int currentDigit = Character.getNumericValue(input.charAt(j));

                while (openCount < currentDigit) {
                    result.append('(');
                    openCount++;
                }

                while (openCount > currentDigit) {
                    result.append(')');
                    openCount--;
                }

                result.append(currentDigit);
            }

            while (openCount > 0) {
                result.append(')');
                openCount--;
            }

            System.out.println("Case #" + i + ": " + result);
        }
    }
}