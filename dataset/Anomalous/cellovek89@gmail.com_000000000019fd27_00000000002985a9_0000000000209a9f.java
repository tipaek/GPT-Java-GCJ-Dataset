import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());
        
        for (int test = 1; test <= t; test++) {
            String str = reader.readLine();
            int n = str.length();
            int[] digits = new int[n];
            
            for (int i = 0; i < n; i++) {
                digits[i] = Character.getNumericValue(str.charAt(i));
            }
            
            StringBuilder result = new StringBuilder();
            result.append("Case #").append(test).append(": ");
            
            for (int i = 0; i < digits[0]; i++) {
                result.append("(");
            }
            result.append(digits[0]);
            
            for (int i = 1; i < n; i++) {
                int diff = digits[i] - digits[i - 1];
                if (diff > 0) {
                    for (int j = 0; j < diff; j++) {
                        result.append("(");
                    }
                } else if (diff < 0) {
                    for (int j = 0; j < -diff; j++) {
                        result.append(")");
                    }
                }
                result.append(digits[i]);
            }
            
            for (int i = 0; i < digits[n - 1]; i++) {
                result.append(")");
            }
            
            System.out.println(result);
        }
    }
}