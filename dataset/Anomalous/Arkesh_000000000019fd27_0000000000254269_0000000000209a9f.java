import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        
        if (T < 1 || T > 100) {
            return;
        }
        
        for (int i = 0; i < T; i++) {
            String S = scanner.next();
            StringBuilder output = new StringBuilder();
            int balance = 0;
            
            for (int j = 0; j < S.length(); j++) {
                int currentDigit = Character.getNumericValue(S.charAt(j));
                while (balance < currentDigit) {
                    output.append("(");
                    balance++;
                }
                while (balance > currentDigit) {
                    output.append(")");
                    balance--;
                }
                output.append(currentDigit);
            }
            
            while (balance > 0) {
                output.append(")");
                balance--;
            }
            
            System.out.println("Case #" + (i + 1) + ": " + output.toString());
        }
        
        scanner.close();
    }
}