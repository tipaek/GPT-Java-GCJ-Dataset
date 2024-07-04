import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileNotFoundException;

public class Solution {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String input = scanner.nextLine();
            StringBuilder result = new StringBuilder();
            int openParentheses = 0;

            for (int i = 0; i < input.length(); i++) {
                int digit = input.charAt(i) - '0';

                while (openParentheses > digit) {
                    result.append(')');
                    openParentheses--;
                }
                while (openParentheses < digit) {
                    result.append('(');
                    openParentheses++;
                }

                result.append(digit);
            }

            while (openParentheses > 0) {
                result.append(')');
                openParentheses--;
            }

            System.out.println("Case #" + caseNumber + ": " + result.toString());
        }
    }
}