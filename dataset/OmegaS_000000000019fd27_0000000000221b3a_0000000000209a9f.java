import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    final static int ASCII_ZERO = 48;

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int t = in.nextInt();

        for(int tc = 1; tc <= t; tc++) {
            int openParentheses = 0;
            StringBuilder stringBuilder = new StringBuilder();

            char[] line = in.next().toCharArray();

            int currentDigit = 0;
            int previousDigit = 0;
            int parenthesesDif = 0;
            for (int i = 0; i < line.length; i++) {
                currentDigit = line[i] - ASCII_ZERO;
                parenthesesDif = currentDigit - previousDigit;

                openParentheses += parenthesesDif;

                String parentheses = parenthesesDif > 0 ? "(" : ")";

                for (int j = 0; j < Math.abs(parenthesesDif); j++) {
                    stringBuilder.append(parentheses);
                }

                stringBuilder.append(currentDigit);
                previousDigit = currentDigit;
            }

            for (int i = 0; i < openParentheses; i++) {
                stringBuilder.append(")");
            }

            System.out.println("Case #" + tc + ": " + stringBuilder.toString());
        }
    }
}
