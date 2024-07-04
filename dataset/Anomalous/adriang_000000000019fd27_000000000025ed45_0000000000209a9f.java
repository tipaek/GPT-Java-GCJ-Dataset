import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int i = 1; i <= testCases; ++i) {
            StringBuilder result = new StringBuilder();
            String inputLine = scanner.nextLine();
            int previousLevel = 0;

            for (int j = 0; j < inputLine.length(); j++) {
                int currentDigit = Character.getNumericValue(inputLine.charAt(j));
                int levelDifference = currentDigit - previousLevel;

                if (levelDifference > 0) {
                    result.append("(".repeat(levelDifference));
                } else {
                    result.append(")".repeat(-levelDifference));
                }

                result.append(currentDigit);
                previousLevel = currentDigit;
            }

            result.append(")".repeat(previousLevel));
            System.out.println("Case #" + i + ": " + result.toString());
        }
    }
}