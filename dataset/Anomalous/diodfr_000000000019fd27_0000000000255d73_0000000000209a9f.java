import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCases = scanner.nextInt();
            scanner.nextLine();

            for (int t = 1; t <= testCases; t++) {
                String inputLine = scanner.nextLine();
                StringBuilder resultBuilder = new StringBuilder();

                int currentLevel = 0;
                for (int i = 0; i < inputLine.length(); i++) {
                    int digit = inputLine.charAt(i) - '0';
                    if (currentLevel < digit) {
                        resultBuilder.append("(".repeat(digit - currentLevel));
                    } else if (currentLevel > digit) {
                        resultBuilder.append(")".repeat(currentLevel - digit));
                    }
                    resultBuilder.append(digit);
                    currentLevel = digit;
                }

                if (currentLevel > 0) {
                    resultBuilder.append(")".repeat(currentLevel));
                }

                System.out.println("Case #" + t + ": " + resultBuilder.toString());
            }
        }
    }
}