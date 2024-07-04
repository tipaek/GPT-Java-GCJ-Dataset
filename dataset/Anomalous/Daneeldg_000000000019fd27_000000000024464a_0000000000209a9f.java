import java.io.PrintStream;
import java.util.Scanner;

public class Solution {
    private final Scanner input;
    private final PrintStream output;

    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in); 
             PrintStream output = System.out) {
            
            int numCases = input.nextInt();
            for (int t = 0; t < numCases; t++) {
                output.printf("Case #%d: ", t + 1);
                output.println(new Solution(input, output).solve());
            }
        }
    }

    public Solution(Scanner input, PrintStream output) {
        this.input = input;
        this.output = output;
    }

    public String solve() {
        String s = input.next();
        StringBuilder result = new StringBuilder();
        int openParentheses = 0;

        for (int i = 0; i < s.length(); i++) {
            int currentDigit = Character.getNumericValue(s.charAt(i));

            while (openParentheses < currentDigit) {
                result.append("(");
                openParentheses++;
            }
            while (openParentheses > currentDigit) {
                result.append(")");
                openParentheses--;
            }
            result.append(currentDigit);
        }

        while (openParentheses > 0) {
            result.append(")");
            openParentheses--;
        }

        return result.toString();
    }
}