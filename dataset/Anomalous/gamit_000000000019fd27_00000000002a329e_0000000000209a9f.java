import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int testCases = Integer.parseInt(scanner.nextLine());
        long caseNumber = 1;

        for (int t = 0; t < testCases; t++) {
            String input = scanner.nextLine();
            StringBuilder caseAnswer = new StringBuilder();

            int[] digits = input.chars().map(c -> c - '0').toArray();
            int depth = 0;

            for (int digit : digits) {
                while (depth < digit) {
                    caseAnswer.append('(');
                    depth++;
                }
                while (depth > digit) {
                    caseAnswer.append(')');
                    depth--;
                }
                caseAnswer.append(digit);
            }

            while (depth > 0) {
                caseAnswer.append(')');
                depth--;
            }

            System.out.println("Case #" + caseNumber + ": " + caseAnswer);
            caseNumber++;
        }
    }
}