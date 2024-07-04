import java.io.*;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int testCases = scanner.nextInt();
        for (int testCase = 0; testCase < testCases; testCase++) {
            StringBuilder result = new StringBuilder();
            String input = scanner.next();
            int previousDigit = 0;

            for (char ch : input.toCharArray()) {
                int currentDigit = Character.getNumericValue(ch);
                int difference = currentDigit - previousDigit;

                if (difference > 0) {
                    result.append("(".repeat(difference));
                } else if (difference < 0) {
                    result.append(")".repeat(-difference));
                }

                result.append(ch);
                previousDigit = currentDigit;
            }

            result.append(")".repeat(previousDigit));
            System.out.println(result);
        }
    }
}