import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            String s = in.next();
            System.out.println("Case #" + (i + 1) + ": " + createNestedString(s));
        }
        in.close();
    }

    private static String createNestedString(String s) {
        StringBuilder result = new StringBuilder();
        char previousChar = '0';

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            int difference = currentChar - previousChar;

            if (difference > 0) {
                result.append("(".repeat(difference));
            } else if (difference < 0) {
                result.append(")".repeat(-difference));
            }

            result.append(currentChar);
            previousChar = currentChar;
        }

        int closingBrackets = previousChar - '0';
        result.append(")".repeat(closingBrackets));

        return result.toString();
    }
}