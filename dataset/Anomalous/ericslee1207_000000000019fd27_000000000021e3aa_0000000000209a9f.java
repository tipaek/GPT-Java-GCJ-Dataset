import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        
        for (int i = 0; i < t; i++) {
            String s = scanner.next();
            StringBuilder sb = new StringBuilder();
            boolean openParenthesis = false;
            
            for (char c : s.toCharArray()) {
                if (c == '1' && !openParenthesis) {
                    sb.append("(1");
                    openParenthesis = true;
                } else if (c == '1') {
                    sb.append('1');
                } else if (c == '0' && openParenthesis) {
                    sb.append(")0");
                    openParenthesis = false;
                } else {
                    sb.append('0');
                }
            }
            
            if (openParenthesis && sb.charAt(sb.length() - 1) == '1') {
                sb.append(')');
            }
            
            System.out.println("Case #" + (i + 1) + ": " + sb.toString());
        }
        
        scanner.close();
    }
}