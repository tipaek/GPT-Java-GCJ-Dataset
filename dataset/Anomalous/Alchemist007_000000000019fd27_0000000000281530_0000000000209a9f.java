import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            String inputString = scanner.next();
            System.out.println("Case #" + i + ": " + addParentheses(inputString, 0));
        }
        scanner.close();
    }

    public static String addParentheses(String s, int baseCount) {
        if (s.isEmpty()) {
            return "";
        }
        
        int minDigit = findMinDigit(s);
        StringBuilder result = new StringBuilder();
        int start = 0;
        
        for (int i = 0; i < s.length(); i++) {
            int currentDigit = Character.getNumericValue(s.charAt(i));
            if (currentDigit == minDigit) {
                result.append(addParentheses(s.substring(start, i), baseCount + minDigit)).append(s.charAt(i));
                start = i + 1;
            }
        }
        
        result.append(addParentheses(s.substring(start), baseCount + minDigit));
        
        for (int i = baseCount; i < minDigit; i++) {
            result.insert(0, '(');
        }
        
        for (int i = baseCount; i < minDigit; i++) {
            result.append(')');
        }
        
        return result.toString();
    }

    public static int findMinDigit(String s) {
        int minDigit = Character.getNumericValue(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            int currentDigit = Character.getNumericValue(s.charAt(i));
            if (currentDigit < minDigit) {
                minDigit = currentDigit;
            }
        }
        return minDigit;
    }
}