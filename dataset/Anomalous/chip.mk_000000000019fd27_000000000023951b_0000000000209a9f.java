import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        try (
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            Scanner scanner = new Scanner(reader)
        ) {
            scanner.useLocale(Locale.US);
            int testCases = scanner.nextInt();

            for (int t = 1; t <= testCases; t++) {
                String input = scanner.next();
                StringBuilder result = new StringBuilder();
                int currentDepth = 0;

                for (char ch : input.toCharArray()) {
                    int digit = ch - '0';
                    while (currentDepth < digit) {
                        result.append("(");
                        currentDepth++;
                    }
                    while (currentDepth > digit) {
                        result.append(")");
                        currentDepth--;
                    }
                    result.append(digit);
                }
                while (currentDepth > 0) {
                    result.append(")");
                    currentDepth--;
                }

                System.out.printf("Case #%d: %s%n", t, result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}