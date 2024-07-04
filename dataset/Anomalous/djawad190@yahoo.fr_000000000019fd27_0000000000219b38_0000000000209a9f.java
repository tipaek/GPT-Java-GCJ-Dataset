import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            String number = scanner.next("[0-9]+");
            StringBuilder result = new StringBuilder();

            int previousDigit = 0;
            int openBrackets = 0;

            for (char c : number.toCharArray()) {
                int currentDigit = Character.getNumericValue(c);
                int difference = currentDigit - previousDigit;

                if (difference > 0) {
                    result.append("(".repeat(difference));
                } else if (difference < 0) {
                    result.append(")".repeat(-difference));
                }

                result.append(c);
                previousDigit = currentDigit;
                openBrackets += difference;
            }

            result.append(")".repeat(openBrackets));

            System.out.println("Case #" + t + ": " + result);
        }
    }
}