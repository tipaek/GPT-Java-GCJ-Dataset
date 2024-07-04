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

            for (char c : s.toCharArray()) {
                int num = c - '0';
                
                while (currentDepth < num) {
                    result.append('(');
                    currentDepth++;
                }
                
                while (currentDepth > num) {
                    result.append(')');
                    currentDepth--;
                }
                
                result.append(c);
            }
            
            while (currentDepth > 0) {
                result.append(')');
                currentDepth--;
            }
            
            System.out.println("Case #" + i + ": " + result.toString());
        }
        
        sc.close();
    }
}