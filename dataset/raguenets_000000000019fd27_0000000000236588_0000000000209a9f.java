import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int t=1; t <= T; t++) {
            String S = scanner.next();
            StringBuilder sb = new StringBuilder();
            boolean openParen = false;
            for (char c : S.toCharArray()) {
                if (c == '0') {
                    if (openParen == true) {
                        sb.append(')');
                        openParen = false;
                    }
                    sb.append('0');
                } else {
                    if (openParen == true) {
                        sb.append('1');
                    } else {
                        sb.append('(');
                        sb.append('1');
                        openParen = true;
                    }
                }
            }
            if (openParen == true) {
                sb.append(')');
            }
            System.out.println("Case #"+t+": "+sb.toString());
        }
        
    }
}