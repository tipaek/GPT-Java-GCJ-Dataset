import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        
        String[] openBrackets = {"", "(", "((", "(((", "((((", "(((((", "((((((", "(((((((", "((((((((", "((((((((("};
        String[] closeBrackets = {"", ")", "))", ")))", "))))", ")))))", "))))))", ")))))))", "))))))))", ")))))))))"};
        
        for (int i = 0; i < t; i++) {
            String s = br.readLine();
            StringBuilder result = new StringBuilder();
            int previousValue = 0;
            
            for (char ch : s.toCharArray()) {
                int currentValue = Character.getNumericValue(ch);
                
                if (currentValue > previousValue) {
                    result.append(openBrackets[currentValue - previousValue]);
                } else if (currentValue < previousValue) {
                    result.append(closeBrackets[previousValue - currentValue]);
                }
                
                result.append(ch);
                previousValue = currentValue;
            }
            
            result.append(closeBrackets[previousValue]);
            System.out.println(result);
        }
    }
}