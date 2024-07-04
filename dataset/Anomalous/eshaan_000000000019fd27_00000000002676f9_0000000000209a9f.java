import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;

public class Solution {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < testCases; i++) {
            String input = br.readLine();
            int length = input.length();
            int balance = 0;
            StringBuilder result = new StringBuilder();
            
            for (int j = 0; j < length; j++) {
                int currentDigit = Character.getNumericValue(input.charAt(j));
                
                if (currentDigit == balance) {
                    result.append(input.charAt(j));
                } else if (currentDigit > balance) {
                    int openBraces = currentDigit - balance;
                    result.append(repeatCharacter('(', openBraces)).append(input.charAt(j));
                    balance = currentDigit;
                } else {
                    int closeBraces = balance - currentDigit;
                    result.append(repeatCharacter(')', closeBraces)).append(input.charAt(j));
                    balance = currentDigit;
                }
            }
            
            if (balance > 0) {
                result.append(repeatCharacter(')', balance));
            }
            
            System.out.println(result.toString());
        }
    }

    private static String repeatCharacter(char ch, int times) {
        return String.join("", Collections.nCopies(times, String.valueOf(ch)));
    }
}