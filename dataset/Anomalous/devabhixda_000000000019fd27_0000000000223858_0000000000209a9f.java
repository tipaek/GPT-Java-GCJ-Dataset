import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; ++i) {
            String input = scanner.next();
            char currentChar = input.charAt(0);
            int start = 0, end = 2, adjustments = 0;
            StringBuilder result = new StringBuilder(input);

            for (int j = 1; j < input.length(); j++) {
                if (input.charAt(j) == currentChar) {
                    end++;
                } else if (currentChar != '0') {
                    result.insert(start, '(');
                    result.insert(end, ')');
                    adjustments++;
                    currentChar = input.charAt(j);
                    if (currentChar != '0') {
                        start = end + 1;
                        end = start + 2;
                    } else {
                        start = j + 1 + 2 * adjustments;
                        end = start + 2;
                    }
                }
            }

            currentChar = input.charAt(input.length() - 1);
            if (end <= result.length() + 1 && currentChar != '0') {
                result.insert(start, '(');
                result.insert(end, ')');
            }

            System.out.println("Case #" + i + ": " + result.toString());
        }
    }
}