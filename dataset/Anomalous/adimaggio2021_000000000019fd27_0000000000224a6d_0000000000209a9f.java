import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine(); // Consume the newline left by nextInt()
        
        for (int k = 0; k < n; k++) {
            String s = in.nextLine();
            StringBuilder str = new StringBuilder(s);
            int offset = 0;

            for (int i = 0; i < s.length(); i++) {
                char digit = s.charAt(i);
                if (digit != '0') {
                    int digitValue = Character.getNumericValue(digit);
                    
                    StringBuilder left = new StringBuilder();
                    StringBuilder right = new StringBuilder();
                    
                    for (int b = 0; b < digitValue; b++) {
                        left.append("(");
                        right.append(")");
                    }
                    
                    str.insert(i + offset, left);
                    offset += left.length();
                    
                    str.insert(i + offset + 1, right);
                    offset += right.length();
                }
            }
            
            System.out.println(str.toString());
        }
        
        in.close();
    }
}