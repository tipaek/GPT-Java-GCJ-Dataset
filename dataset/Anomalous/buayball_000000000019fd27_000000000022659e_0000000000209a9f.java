import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        scanner.nextLine();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String input = scanner.nextLine();
            StringBuilder output = new StringBuilder();
            int openParentheses = 0;

            for (int i = 0; i < input.length(); i++) {
                int currentDigit = Character.getNumericValue(input.charAt(i));

                while (currentDigit > openParentheses) {
                    output.append('(');
                    openParentheses++;
                }

                output.append(input.charAt(i));

                if (i == input.length() - 1) {
                    while (openParentheses > 0) {
                        output.append(')');
                        openParentheses--;
                    }
                } else {
                    int nextDigit = Character.getNumericValue(input.charAt(i + 1));

                    while (nextDigit < openParentheses) {
                        output.append(')');
                        openParentheses--;
                    }
                }
            }

            System.out.println("Case #" + caseNumber + ": " + output);
        }
    }
}