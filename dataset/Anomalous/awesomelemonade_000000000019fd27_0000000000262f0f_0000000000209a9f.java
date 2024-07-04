import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Solution {

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             PrintWriter writer = new PrintWriter(System.out)) {
            
            int testCases = Integer.parseInt(reader.readLine());
            
            for (int t = 0; t < testCases; t++) {
                String input = reader.readLine();
                StringBuilder result = new StringBuilder();
                int currentDepth = 0;
                
                for (char ch : input.toCharArray()) {
                    int digit = ch - '0';
                    
                    while (currentDepth < digit) {
                        result.append('(');
                        currentDepth++;
                    }
                    
                    while (currentDepth > digit) {
                        result.append(')');
                        currentDepth--;
                    }
                    
                    result.append(ch);
                }
                
                while (currentDepth > 0) {
                    result.append(')');
                    currentDepth--;
                }
                
                writer.printf("Case #%d: %s\n", t + 1, result.toString());
            }
        }
    }
}