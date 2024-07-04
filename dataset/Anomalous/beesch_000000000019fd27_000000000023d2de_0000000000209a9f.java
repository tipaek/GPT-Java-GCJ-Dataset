import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCases = scanner.nextInt();

            for (int i = 1; i <= testCases; i++) {
                String numberString = scanner.next();
                StringBuilder result = new StringBuilder();
                int previousDigit = 0;

                for (char digitChar : numberString.toCharArray()) {
                    int currentDigit = Character.getNumericValue(digitChar);
                    int difference = currentDigit - previousDigit;

                    if (difference > 0) {
                        result.append("(".repeat(difference));
                    } else if (difference < 0) {
                        result.append(")".repeat(-difference));
                    }

                    result.append(currentDigit);
                    previousDigit = currentDigit;
                }

                result.append(")".repeat(previousDigit));
                System.out.println("Case #" + i + ": " + result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}