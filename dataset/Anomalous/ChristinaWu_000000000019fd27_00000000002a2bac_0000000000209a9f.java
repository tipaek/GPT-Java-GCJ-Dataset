import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        
        for (int cas = 1; cas <= T; cas++) {
            String s = in.next();
            StringBuilder sb = new StringBuilder();
            
            for (char ch : s.toCharArray()) {
                int number = ch - '0';
                
                for (int i = 0; i < number; i++) {
                    sb.append('(');
                }
                
                sb.append(ch);
                
                for (int i = 0; i < number; i++) {
                    sb.append(')');
                }
            }
            
            int p = 0;
            while (p < sb.length() - 1) {
                if (sb.charAt(p) == ')' && sb.charAt(p + 1) == '(') {
                    sb.deleteCharAt(p);
                    sb.deleteCharAt(p);
                    p = Math.max(0, p - 1);
                } else {
                    p++;
                }
            }
            
            System.out.println("Case #" + cas + ": " + sb);
        }
        
        in.close();
    }
}