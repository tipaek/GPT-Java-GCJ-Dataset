import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String tests = br.readLine();
        
        if (tests == null) return;
        
        int t = Integer.parseInt(tests);
        StringBuilder sb = new StringBuilder();
        
        for (int i = 1; i <= t; i++) {
            sb.append("case #").append(i).append(": ");
            String str = br.readLine();
            
            if (str == null) return;
            
            str = str.trim();
            int currentLevel = 0;
            
            int[] digits = new int[str.length()];
            for (int k = 0; k < str.length(); k++) {
                digits[k] = str.charAt(k) - '0';
            }
            
            sb.append(generateBrackets(digits[0], 0)).append(digits[0]);
            currentLevel = digits[0];
            
            for (int k = 1; k < str.length(); k++) {
                if (currentLevel > digits[k]) {
                    sb.append(generateBrackets(digits[k], currentLevel)).append(digits[k]);
                } else if (currentLevel < digits[k]) {
                    sb.append(generateBrackets(digits[k], currentLevel)).append(digits[k]);
                } else {
                    sb.append(digits[k]);
                }
                currentLevel = digits[k];
            }
            
            sb.append(generateBrackets(0, currentLevel)).append("\n");
        }
        
        System.out.print(sb.toString().trim());
    }

    private static String generateBrackets(int targetLevel, int currentLevel) {
        StringBuilder brackets = new StringBuilder();
        int difference = targetLevel - currentLevel;
        
        if (difference > 0) {
            for (int i = 0; i < difference; i++) {
                brackets.append("(");
            }
        } else {
            for (int i = 0; i < -difference; i++) {
                brackets.append(")");
            }
        }
        
        return brackets.toString();
    }
}