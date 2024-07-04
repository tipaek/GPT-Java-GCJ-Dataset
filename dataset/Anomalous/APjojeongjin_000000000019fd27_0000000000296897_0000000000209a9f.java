import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            String number = scanner.next();
            StringBuilder answer = new StringBuilder();
            int currentDepth = 0;

            for (int j = 0; j < number.length(); j++) {
                int digit = number.charAt(j) - '0';
                if (currentDepth < digit) {
                    for (int k = 0; k < digit - currentDepth; k++) {
                        answer.append('(');
                    }
                } else if (currentDepth > digit) {
                    for (int k = 0; k < currentDepth - digit; k++) {
                        answer.append(')');
                    }
                }
                answer.append(digit);
                currentDepth = digit;
            }

            while (currentDepth > 0) {
                answer.append(')');
                currentDepth--;
            }

            System.out.println("Case #" + (i + 1) + ": " + answer.toString());
        }
    }
}