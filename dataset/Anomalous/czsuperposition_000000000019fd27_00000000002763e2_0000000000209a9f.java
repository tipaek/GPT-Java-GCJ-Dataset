import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        String[] answers = new String[T];
        
        for (int i = 0; i < T; i++) {
            String S = scanner.next();
            StringBuilder result = new StringBuilder();
            
            for (int j = 0; j < S.length(); j++) {
                int digit = Character.getNumericValue(S.charAt(j));
                result.append("(".repeat(digit))
                      .append(digit)
                      .append(")".repeat(digit));
            }
            
            String temp = result.toString();
            while (temp.contains(")(")) {
                temp = temp.replace(")(", "");
            }
            
            answers[i] = temp;
        }
        
        for (int i = 0; i < T; i++) {
            System.out.println("Case #" + (i + 1) + ": " + answers[i]);
        }
    }
}