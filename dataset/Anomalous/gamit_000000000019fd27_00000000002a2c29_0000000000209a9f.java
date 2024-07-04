import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class EN2018Q2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        try {
            int testCases = Integer.parseInt(scanner.nextLine());
            long caseIndex = 1;

            for (int t = 0; t < testCases; t++) {
                String inputString = scanner.nextLine();
                int[] digits = new int[inputString.length()];

                for (int i = 0; i < inputString.length(); i++) {
                    digits[i] = inputString.charAt(i) - '0';
                }

                StringBuilder caseAnswer = new StringBuilder();
                int currentDepth = 0;

                for (int digit : digits) {
                    while (currentDepth < digit) {
                        caseAnswer.append("(");
                        currentDepth++;
                    }
                    while (currentDepth > digit) {
                        caseAnswer.append(")");
                        currentDepth--;
                    }
                    caseAnswer.append(digit);
                }

                while (currentDepth > 0) {
                    caseAnswer.append(")");
                    currentDepth--;
                }

                System.out.println("Case #" + caseIndex + ": " + caseAnswer);
                caseIndex++;
            }
        } finally {
            scanner.close();
        }
    }
}