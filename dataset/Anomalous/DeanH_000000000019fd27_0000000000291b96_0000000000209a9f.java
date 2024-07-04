import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; ++i) {
            String number = scanner.next();
            int length = number.length();
            int openBrackets = 0;
            StringBuilder result = new StringBuilder();

            for (int j = 0; j < length; j++) {
                int digit = number.charAt(j) - '0';
                
                if (digit > openBrackets) {
                    for (int k = 0; k < digit - openBrackets; k++) {
                        result.append("(");
                    }
                } else if (digit < openBrackets) {
                    for (int k = 0; k < openBrackets - digit; k++) {
                        result.append(")");
                    }
                }
                
                result.append(number.charAt(j));
                openBrackets = digit;
            }

            for (int j = 0; j < openBrackets; j++) {
                result.append(")");
            }

            System.out.println("Case #" + i + ": " + result.toString());
        }
    }
}