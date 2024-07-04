import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCases = Integer.parseInt(scanner.nextLine());
            for (int caseNum = 1; caseNum <= testCases; caseNum++) {
                String input = scanner.nextLine();
                StringBuilder answer = new StringBuilder();
                int currentDepth = 0;

                for (char ch : input.toCharArray()) {
                    int digit = Character.getNumericValue(ch);
                    while (currentDepth < digit) {
                        answer.append('(');
                        currentDepth++;
                    }
                    while (currentDepth > digit) {
                        answer.append(')');
                        currentDepth--;
                    }
                    answer.append(digit);
                }

                while (currentDepth > 0) {
                    answer.append(')');
                    currentDepth--;
                }

                System.out.println("Case #" + caseNum + ": " + answer.toString());
            }
        }
    }
}