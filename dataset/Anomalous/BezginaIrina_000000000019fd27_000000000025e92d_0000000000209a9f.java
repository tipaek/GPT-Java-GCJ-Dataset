import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = Integer.parseInt(scanner.nextLine());

        for (int a = 0; a < T; a++) {
            char[] S = scanner.nextLine().toCharArray();
            StringBuilder result = new StringBuilder();

            int previousDigit = 0;
            for (char c : S) {
                int currentDigit = Character.getNumericValue(c);
                if (currentDigit > previousDigit) {
                    result.append("(".repeat(currentDigit - previousDigit));
                } else if (currentDigit < previousDigit) {
                    result.append(")".repeat(previousDigit - currentDigit));
                }
                result.append(c);
                previousDigit = currentDigit;
            }
            result.append(")".repeat(previousDigit));

            System.out.println("Case #" + (a + 1) + ": " + result.toString());
        }
    }
}