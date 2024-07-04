import java.util.Scanner;

public class Solution {
    
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for(int i = 0; i < t; i++) {
            String st  = s.next();
            int depth = 0;
            String ans = "";
            for(char ch : st.toCharArray()) {
                int n = ch - '0';
                if(n > depth) {
                    while(n>depth) {
                        ans+=("(");
                        depth++;
                    }
                }
                if(n<depth) {
                    while(n<depth) {
                        ans+=(")");
                        depth--;
                    }
                }
                ans+=(ch);
            }
            while(depth>0) {
                ans+=(")");
                depth--;
            }
            System.out.println(String.format("Case #%d: %s", i+1, ans));
    
        }
    }
    
}