import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine(); // Consume the newline character after the integer input
        
        for (int t = 0; t < T; t++) {
            String s = sc.nextLine();
            StringBuilder res = new StringBuilder();
            int open = 0;
            
            for (int i = 0; i < s.length(); i++) {
                int currentDigit = Character.getNumericValue(s.charAt(i));
                int difference = currentDigit - open;
                
                if (difference > 0) {
                    for (int j = 0; j < difference; j++) {
                        res.append('(');
                    }
                } else if (difference < 0) {
                    for (int j = 0; j < -difference; j++) {
                        res.append(')');
                    }
                }
                
                open = currentDigit;
                res.append(s.charAt(i));
            }
            
            for (int i = 0; i < open; i++) {
                res.append(')');
            }
            
            System.out.println("Case #" + (t + 1) + ": " + res.toString());
        }
        
        sc.close();
    }
}