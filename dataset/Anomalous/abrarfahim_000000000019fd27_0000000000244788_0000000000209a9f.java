import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            String s = sc.next();
            StringBuilder y = new StringBuilder();
            int openParentheses = 0;

            int firstDigit = Character.getNumericValue(s.charAt(0));

            for (int a = 0; a < firstDigit; a++) {
                y.append("(");
                openParentheses++;
            }
            y.append(firstDigit);

            int previousDigit = firstDigit;

            for (int j = 1; j < s.length(); j++) {
                int currentDigit = Character.getNumericValue(s.charAt(j));
                if (currentDigit < previousDigit) {
                    for (int a = 0; a < previousDigit - currentDigit; a++) {
                        y.append(")");
                        openParentheses--;
                    }
                } else if (currentDigit > previousDigit) {
                    for (int a = 0; a < currentDigit - previousDigit; a++) {
                        y.append("(");
                        openParentheses++;
                    }
                }
                y.append(currentDigit);
                previousDigit = currentDigit;
            }

            while (openParentheses > 0) {
                y.append(")");
                openParentheses--;
            }

            System.out.println("Case #" + (i + 1) + ": " + y);
        }

        sc.close();
    }
}