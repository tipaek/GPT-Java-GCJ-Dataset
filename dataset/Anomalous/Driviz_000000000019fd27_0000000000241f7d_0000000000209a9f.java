import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for (int test = 1; test <= T; test++) {
            String input = br.readLine();
            List<Character> result = new ArrayList<>();
            int openBrackets = 0;
            int length = input.length();
            
            for (int i = 0; i < length; i++) {
                int currentDigit = Character.getNumericValue(input.charAt(i));
                
                if (currentDigit > openBrackets) {
                    for (int j = 0; j < currentDigit - openBrackets; j++) {
                        result.add('(');
                    }
                    openBrackets = currentDigit;
                } else if (currentDigit < openBrackets) {
                    for (int j = 0; j < openBrackets - currentDigit; j++) {
                        result.add(')');
                    }
                    openBrackets = currentDigit;
                }
                
                result.add(input.charAt(i));
            }
            
            while (openBrackets-- > 0) {
                result.add(')');
            }
            
            System.out.print("Case #" + test + ": ");
            for (char ch : result) {
                System.out.print(ch);
            }
            System.out.println();
        }
    }
}