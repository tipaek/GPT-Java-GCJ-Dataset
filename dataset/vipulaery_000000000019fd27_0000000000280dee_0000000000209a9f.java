import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testcases = Integer.parseInt(bufferedReader.readLine());
        for (int testcaseNumber = 0; testcaseNumber < testcases; testcaseNumber++) {
            String digits = bufferedReader.readLine().trim();
            StringBuilder output = new StringBuilder();
            int previousDigit = 0, currentDigit = 0, difference;
            for (int digitIndex = 0; digitIndex < digits.length(); digitIndex++) {
                currentDigit = digits.charAt(digitIndex) - '0';
                difference = currentDigit - previousDigit;
                if(difference > 0){
                    appendHalfParenthesis(output, difference, '(');
                }else{
                    appendHalfParenthesis(output, -difference, ')');
                }
                output.append(digits.charAt(digitIndex));
                previousDigit = currentDigit;
            }
            appendHalfParenthesis(output, currentDigit, ')');
            System.out.println("Case #"+(testcaseNumber+1)+": "+ output);
        }
    }

    private static void appendHalfParenthesis(StringBuilder output, int halfParenthesisCount, char parenthesis) {
        for (int count = 0; count < halfParenthesisCount; count++) {
            output.append(parenthesis);
        }
    }
}
