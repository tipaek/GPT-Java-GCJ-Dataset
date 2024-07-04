import java.util.*;
import java.io.*;

public class EN2018Q2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        try {
            int T = Integer.parseInt(scanner.nextLine());

            for (int t = 0; t < T; t++) {
                String S = scanner.nextLine();
                StringBuilder caseAnswer = new StringBuilder();
                int[] digits = new int[S.length()];

                for (int i = 0; i < S.length(); i++) {
                    digits[i] = S.charAt(i) - '0';
                }

                int openParentheses = 0;

                for (int digit : digits) {
                    if (digit > openParentheses) {
                        for (int j = 0; j < (digit - openParentheses); j++) {
                            caseAnswer.append("(");
                        }
                        openParentheses = digit;
                    } else if (digit < openParentheses) {
                        for (int j = 0; j < (openParentheses - digit); j++) {
                            caseAnswer.append(")");
                        }
                        openParentheses = digit;
                    }
                    caseAnswer.append(digit);
                }

                for (int j = 0; j < openParentheses; j++) {
                    caseAnswer.append(")");
                }

                System.out.println("Case #" + (t + 1) + ": " + caseAnswer.toString());
            }
        } finally {
            scanner.close();
        }
    }
}