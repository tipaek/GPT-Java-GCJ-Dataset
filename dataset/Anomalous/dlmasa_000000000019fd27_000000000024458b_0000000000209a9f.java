import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        new Solution().solve();
    }

    public void solve() {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            String input = scanner.next();
            char[] digits = input.toCharArray();
            StringBuilder result = new StringBuilder();
            int previousDigit = 0;

            for (char digit : digits) {
                int currentDigit = digit - '0';
                if (currentDigit > previousDigit) {
                    result.append("(".repeat(currentDigit - previousDigit));
                } else if (currentDigit < previousDigit) {
                    result.append(")".repeat(previousDigit - currentDigit));
                }
                result.append(digit);
                previousDigit = currentDigit;
            }
            result.append(")".repeat(previousDigit));
            System.out.println(result);
        }
        
        scanner.close();
    }
}