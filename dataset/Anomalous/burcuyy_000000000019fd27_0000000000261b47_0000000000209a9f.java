import java.io.*;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            String input = scanner.nextLine();
            StringBuilder result = new StringBuilder();
            int openParens = 0;

            for (char ch : input.toCharArray()) {
                int digit = Character.getNumericValue(ch);
                while (openParens < digit) {
                    result.append('(');
                    openParens++;
                }
                while (openParens > digit) {
                    result.append(')');
                    openParens--;
                }
                result.append(ch);
            }

            while (openParens > 0) {
                result.append(')');
                openParens--;
            }

            System.out.println("Case #" + caseNum + ": " + result.toString());
        }
    }
}