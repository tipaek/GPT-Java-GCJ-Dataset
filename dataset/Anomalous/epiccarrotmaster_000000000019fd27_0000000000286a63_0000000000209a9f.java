import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCaseCount = Integer.parseInt(scanner.nextLine());

        for (int testCase = 1; testCase <= testCaseCount; testCase++) {
            String numberString = scanner.nextLine();
            StringBuilder result = new StringBuilder();

            char previousChar = '0';
            for (char currentChar : numberString.toCharArray()) {
                int difference = currentChar - previousChar;

                if (difference > 0) {
                    result.append("(".repeat(difference));
                } else if (difference < 0) {
                    result.append(")".repeat(-difference));
                }

                result.append(currentChar);
                previousChar = currentChar;
            }

            result.append(")".repeat(previousChar - '0'));

            System.out.println("Case #" + testCase + ": " + result);
        }
    }
}