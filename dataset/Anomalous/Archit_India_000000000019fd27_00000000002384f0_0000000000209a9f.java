import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        
        for (int i = 1; i <= t; i++) {
            String s = sc.nextLine();
            StringBuilder result = new StringBuilder();
            int currentDepth = 0;

            for (char ch : s.toCharArray()) {
                int num = Character.getNumericValue(ch);
                
                // Add opening brackets if necessary
                while (currentDepth < num) {
                    result.append('(');
                    currentDepth++;
                }
                
                // Add closing brackets if necessary
                while (currentDepth > num) {
                    result.append(')');
                    currentDepth--;
                }
                
                // Append the current number
                result.append(ch);
            }
            
            // Close any remaining open brackets
            while (currentDepth > 0) {
                result.append(')');
                currentDepth--;
            }
            
            System.out.println("Case #" + i + ": " + result.toString());
        }
        
        sc.close();
    }
}