import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        
        int T = Integer.parseInt(scanner.nextLine());
        
        for (int i = 0; i < T; i++) {
            String N = scanner.nextLine();
            List<String> result = new ArrayList<>();
            int openParenCount = 0;

            for (int j = 0; j < N.length(); j++) {
                int currentDigit = Character.getNumericValue(N.charAt(j));
                int neededParens = currentDigit - openParenCount;

                // Add necessary opening parentheses
                for (int k = 0; k < neededParens; k++) {
                    result.add("(");
                }
                // Add the current digit
                result.add(String.valueOf(currentDigit));
                openParenCount = currentDigit;

                // Determine if closing parentheses are needed
                if (j < N.length() - 1) {
                    int nextDigit = Character.getNumericValue(N.charAt(j + 1));
                    int closingParens = currentDigit - nextDigit;
                    for (int k = 0; k < closingParens; k++) {
                        result.add(")");
                    }
                    openParenCount -= closingParens;
                }
            }

            // Add remaining closing parentheses
            for (int j = 0; j < openParenCount; j++) {
                result.add(")");
            }

            // Construct the final answer string
            StringBuilder answer = new StringBuilder();
            for (String str : result) {
                answer.append(str);
            }

            out.println("Case #" + (i + 1) + ": " + answer.toString());
        }
        
        out.close();
        scanner.close();
    }
}