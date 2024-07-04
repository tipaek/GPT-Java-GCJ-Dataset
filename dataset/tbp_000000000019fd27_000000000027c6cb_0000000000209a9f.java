import java.util.*;

class Solution {
    
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int N = Integer.parseInt(scr.nextLine());
        
        for (int x = 1; x <= N; x++) {
            char[] s = scr.nextLine().toCharArray();
            StringBuilder ans = new StringBuilder();
            int depth = 0;
            
            for (int charNo = 0; charNo <= s.length; charNo++){
                char c;
                if (charNo == s.length) {
                    c = '0';
                } else {
                    c = s[charNo];
                }
                int n = c - '0';
                if (n > depth) {
                    for (int i = 0; i < n - depth; i++) {
                        ans.append('(');
                    }
                } else if (n < depth) {
                    for (int i = 0; i < depth - n; i++) {
                        ans.append(')');
                    }
                }
                depth = n;

                if (charNo != s.length) {
                    ans.append(c);
                }
            }
            
            System.out.println("Case #" + x + ": " + ans.toString());
        }
        
    }
}