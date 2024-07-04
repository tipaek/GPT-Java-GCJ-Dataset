import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        
        for (int cs = 1; cs <= T; cs++) {
            String raw = input.next();
            StringBuilder newS = new StringBuilder();
            int nestDepth = 0;
            
            for (int i = 0; i < raw.length(); i++) {
                char c = raw.charAt(i);
                int n = c - '0';
                
                // Add opening brackets if current depth is less than required
                if (nestDepth < n) {
                    for (int j = 0; j < n - nestDepth; j++) {
                        newS.append("(");
                    }
                } 
                // Add closing brackets if current depth is more than required
                else {
                    for (int j = 0; j < nestDepth - n; j++) {
                        newS.append(")");
                    }
                }
                
                newS.append(n);
                nestDepth = n;
            }
            
            // Close any remaining open brackets
            for (int i = 0; i < nestDepth; i++) {
                newS.append(")");
            }
            
            System.out.println("Case #" + cs + ": " + newS);
        }
        
        input.close();
    }
}