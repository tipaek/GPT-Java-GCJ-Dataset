import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            String input = scanner.next();
            StringBuilder output = new StringBuilder();
            int previousDigit = 0;

            for (int j = 0; j < input.length(); j++) {
                int currentDigit = Character.getNumericValue(input.charAt(j));
                int diff = currentDigit - previousDigit;

                if (diff > 0) {
                    output.append("(".repeat(diff));
                } else if (diff < 0) {
                    output.append(")".repeat(-diff));
                }

                output.append(currentDigit);
                previousDigit = currentDigit;
            }

            output.append(")".repeat(previousDigit));
            System.out.println("Case #" + (i + 1) + ": " + output);
        }
    }
}