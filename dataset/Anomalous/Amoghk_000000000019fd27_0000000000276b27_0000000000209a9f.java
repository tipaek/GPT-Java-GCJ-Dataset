import java.util.*;
import java.io.*;

public class Solution {

    static String generateParentheses(String str) {
        StringBuilder result = new StringBuilder();
        
        if (str.length() == 1) {
            int n = Character.getNumericValue(str.charAt(0));
            result.append("(".repeat(n)).append(n).append(")".repeat(n));
            return result.toString();
        }
        
        boolean[] visited = new boolean[str.length()];
        for (int i = 0; i < str.length() - 1; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            int currentDigit = Character.getNumericValue(str.charAt(i));
            if (currentDigit == 0) {
                result.append(0);
                continue;
            }
            
            int till = i;
            for (int j = i + 1; j < str.length(); j++) {
                if (Character.getNumericValue(str.charAt(j)) != currentDigit) {
                    till = j - 1;
                    break;
                }
                visited[j] = true;
            }
            
            if (till == i) {
                result.append("(".repeat(currentDigit)).append(currentDigit).append(")".repeat(currentDigit));
                return result.toString();
            }
            
            if (i == 0 || currentDigit > Character.getNumericValue(str.charAt(i - 1))) {
                result.append("(".repeat(currentDigit));
            }
            result.append(String.valueOf(currentDigit).repeat(till - i + 1));
            
            int nextDigit = Character.getNumericValue(str.charAt(till + 1));
            if (nextDigit < currentDigit) {
                result.append(")".repeat(currentDigit - nextDigit));
            }
        }
        
        if (!visited[str.length() - 1]) {
            int lastDigit = Character.getNumericValue(str.charAt(str.length() - 1));
            if (lastDigit == 0) {
                result.append(0);
            } else {
                if (lastDigit > Character.getNumericValue(str.charAt(str.length() - 2))) {
                    result.append("(".repeat(lastDigit));
                }
                result.append(lastDigit);
                result.append(")".repeat(lastDigit));
            }
        }
        
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            String str = scanner.next();
            String result = generateParentheses(str);
            System.out.println("Case #" + (i + 1) + ": " + result);
        }
        scanner.close();
    }
}