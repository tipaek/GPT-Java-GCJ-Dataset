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
                int n = raw.charAt(i) - '0';
                
                while (nestDepth < n) {
                    newS.append('(');
                    nestDepth++;
                }
                
                while (nestDepth > n) {
                    newS.append(')');
                    nestDepth--;
                }
                
                newS.append(n);
            }
            
            while (nestDepth > 0) {
                newS.append(')');
                nestDepth--;
            }
            
            System.out.println("Case #" + cs + ": " + newS.toString());
        }
        
        input.close();
    }
}