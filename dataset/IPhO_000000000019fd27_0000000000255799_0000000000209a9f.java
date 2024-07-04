import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T=in.nextInt();
        for(int t=1; t<=T; t++) {
            String s=in.next();
            StringBuilder ans = new StringBuilder();
            int open=0;
            for(char c:s.toCharArray()) {
                int a=c-'0';
                if (open!=a) {
                    if (open<a) {
                        for(int i=open; i<a; i++)
                            ans.append('(');
                    }
                    else {
                        for(int i=a; i<open; i++)
                            ans.append(')');
                    }
                    open=a;
                }
                ans.append(c);
            }
            for(int i=0; i<open; i++)
                ans.append(')');
            System.out.println(String.format("Case #%d: %s", t, ans));
        }

    }

}
