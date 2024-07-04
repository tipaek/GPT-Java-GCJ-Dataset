import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt(); 
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            String input = scanner.next();
            StringBuilder output = new StringBuilder();

            int openParentheses = 0;
            
            for (int index = 0; index < input.length(); index++) {
                int digit = Character.getNumericValue(input.charAt(index));
                
                while (openParentheses < digit) {
                    output.append("(");
                    openParentheses++;
                }
                while (openParentheses > digit) {
                    output.append(")");
                    openParentheses--;
                }
                
                output.append(digit);
            }

            while (openParentheses > 0) {
                output.append(")");
                openParentheses--;
            }
            
            System.out.println("Case #" + caseNum + ": " + output.toString());
        }
    }
}