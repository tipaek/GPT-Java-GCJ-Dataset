import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfLines = scanner.nextInt();

        for (int i = 0; i < numberOfLines; i++) {
            String line = scanner.next();
            StringBuilder result = new StringBuilder();
            int openParentheses = 0;

            for (char ch : line.toCharArray()) {
                int digit = Character.getNumericValue(ch);
                while (openParentheses < digit) {
                    result.append("(");
                    openParentheses++;
                }
                while (openParentheses > digit) {
                    result.append(")");
                    openParentheses--;
                }
                result.append(ch);
            }

            while (openParentheses > 0) {
                result.append(")");
                openParentheses--;
            }

            System.out.println(result);
        }
    }
}