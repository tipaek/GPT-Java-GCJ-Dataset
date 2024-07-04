import java.util.*;

class Solution {
    
    public static void main(String args[]) {
        
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 1; t <= T; t++) {
            
            String s = sc.next() + "0";
            int n = s.length();
            StringBuilder ans = new StringBuilder();
            int depth = 0;
            
            for(int i = 0; i < n; i++) {
                char ch = s.charAt(i);
                int d = ch - '0';
                
                if(d < depth) {
                    // add depth - d closing brackets
                    for(int j = 0; j < depth-d; j++)
                        ans.append(")");
                } else if(d > depth)
                    for(int j = 0; j < d-depth; j++)
                        ans.append("(");
                        
                ans.append(ch);
                depth = d;
            }
            System.out.printf("Case #%d: %s\n", t, ans.toString().substring(0, ans.length() - 1));
        }
    }
}