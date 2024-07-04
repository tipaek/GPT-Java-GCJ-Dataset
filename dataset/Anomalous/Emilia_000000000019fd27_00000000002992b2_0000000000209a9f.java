import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static String checkString(String s) {
        int openBraces = 0;
        int prev = 0;
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            int cur = Character.getNumericValue(s.charAt(i));

            if (cur == prev) {
                result.append(cur);
            } else if (cur < prev) {
                result.append(")".repeat(prev - cur));
                result.append(cur);
                openBraces -= (prev - cur);
            } else {
                result.append("(".repeat(cur - openBraces));
                result.append(cur);
                openBraces = cur;
            }

            prev = cur;
        }

        if (openBraces > 0) {
            result.append(")".repeat(openBraces));
        }

        return result.toString();
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int i = 1; i <= testCases; i++) {
            String inputString = scanner.nextLine();
            System.out.println("Case #" + i + ": " + checkString(inputString));
        }
    }
}