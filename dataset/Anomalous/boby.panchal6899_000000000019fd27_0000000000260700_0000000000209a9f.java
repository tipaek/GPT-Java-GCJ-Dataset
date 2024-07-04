import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        for (int i = 1; i <= n; i++) {
            String s = sc.next();
            StringBuilder newStr = new StringBuilder();
            
            for (int x = 0; x < s.length(); x++) {
                int var = Character.getNumericValue(s.charAt(x));
                
                if (var == 0) {
                    newStr.append("0");
                } else {
                    int y = x;
                    int tmp = x - 1;
                    
                    if (x != s.length() - 1) {
                        while (y + 1 < s.length() && var == Character.getNumericValue(s.charAt(y + 1))) {
                            y++;
                        }
                        tmp = x;
                        x = y;
                    }
                    
                    for (int a = 0; a < var; a++) {
                        newStr.append("(");
                    }
                    
                    for (int a = 0; a <= y - tmp; a++) {
                        newStr.append(var);
                    }
                    
                    for (int a = 0; a < var; a++) {
                        newStr.append(")");
                    }
                }
            }
            
            System.out.println("Case #" + i + ": " + newStr.toString());
        }
    }
}