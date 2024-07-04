import java.util.*;
import java.io.*;

class Solution {
    static String generateOpenParentheses(int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append('(');
        }
        return sb.toString();
    }
    
    static String generateCloseParentheses(int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(')');
        }
        return sb.toString();
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());
        int caseNumber = 0;
        
        while (testCases-- > 0) {
            String input = reader.readLine();
            StringBuilder result = new StringBuilder();
            int previous = 0;
            int totalParentheses = 0;
            
            for (int i = 0; i < input.length(); i++) {
                int current = input.charAt(i) - '0';
                if (current == previous) {
                    result.append(current);
                } else if (current > previous) {
                    result.append(generateOpenParentheses(current - previous)).append(current);
                    totalParentheses += (current - previous);
                } else {
                    result.append(generateCloseParentheses(previous - current)).append(current);
                    totalParentheses -= (previous - current);
                }
                previous = current;
            }
            
            result.append(generateCloseParentheses(totalParentheses));
            System.out.println("Case #" + (++caseNumber) + ": " + result);
        }
    }
}