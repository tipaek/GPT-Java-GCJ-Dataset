import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int numberOfLines = scanner.nextInt();

        for (int i = 0; i < numberOfLines; i++) {
            String line = scanner.next();

            StringBuilder result = new StringBuilder();
            int openParentheses = 0;

            for (char c : line.toCharArray()) {
                int digit = Character.getNumericValue(c);

                while (openParentheses < digit) {
                    result.append("(");
                    openParentheses++;
                }

                while (openParentheses > digit) {
                    result.append(")");
                    openParentheses--;
                }

                result.append(c);
            }

            while (openParentheses > 0) {
                result.append(")");
                openParentheses--;
            }

            System.out.println("Case #" + (i + 1) + ": " + result);
        }
    }
}