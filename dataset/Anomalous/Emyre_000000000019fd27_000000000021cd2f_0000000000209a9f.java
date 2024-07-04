import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for (int t = 1; t <= T; t++) {
            String S = br.readLine();
            StringBuilder result = new StringBuilder();
            
            int previousDigit = 0;
            for (char c : S.toCharArray()) {
                int currentDigit = Character.getNumericValue(c);
                
                if (currentDigit > previousDigit) {
                    for (int i = 0; i < currentDigit - previousDigit; i++) {
                        result.append('(');
                    }
                } else if (currentDigit < previousDigit) {
                    for (int i = 0; i < previousDigit - currentDigit; i++) {
                        result.append(')');
                    }
                }
                
                result.append(c);
                previousDigit = currentDigit;
            }
            
            for (int i = 0; i < previousDigit; i++) {
                result.append(')');
            }
            
            System.out.println("Case #" + t + ": " + result.toString());
        }
    }
}