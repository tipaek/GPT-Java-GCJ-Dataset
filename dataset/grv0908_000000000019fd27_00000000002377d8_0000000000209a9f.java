import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        
        for (int test = 1; test <= t; test++) {
            String s = sc.next();
            StringBuilder sb = new StringBuilder();
            
            int currentOpen = 0;
            
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                int digit = (int)(c - '0');
                
                if (currentOpen > digit) {
                    while(currentOpen > digit) {
                        sb.append(')');
                        currentOpen--;
                    }
                } else {
                    while(currentOpen < digit) {
                        sb.append('(');
                        currentOpen++;
                    }
                }
                
                sb.append(c);
            }
            
            while(currentOpen > 0) {
                sb.append(')');
                currentOpen--;
            }
            
            System.out.println("Case #" + test + ":" + " " + sb.toString());
        }
    }
}